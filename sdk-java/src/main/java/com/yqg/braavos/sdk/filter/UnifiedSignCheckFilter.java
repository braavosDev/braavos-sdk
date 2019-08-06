package com.yqg.braavos.sdk.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yqg.braavos.sdk.util.UnifiedResponse;
import com.yqg.braavos.sdk.util.UnifiedRsaUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 统一前置签名校验filter
 */
public class UnifiedSignCheckFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnifiedSignCheckFilter.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final String HEADER_SIGNATURE = "B-SIGNATURE";

    private static final String HEADER_TIMESTAMP = "B-TIMESTAMP";

    private static final String HEADER_REQUEST_ID = "B-REQUEST-ID";

    private String platformPublicKey;

    public UnifiedSignCheckFilter(String platformPublicKey) {
        this.platformPublicKey = platformPublicKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        request = new ReReadableRequestWrapper(request);
        String rawContent = generateRawContent(request);
        String signature = request.getHeader(HEADER_SIGNATURE);
        String timestamp = request.getHeader(HEADER_TIMESTAMP);
        String requestId = request.getHeader(HEADER_REQUEST_ID);
        LOGGER.info("request header, B-SIGNATURE={}, HEADER_TIMESTAMP={}, HEADER_REQUEST_ID={}", signature, timestamp, requestId);
        LOGGER.info("request body:{}", rawContent);
        if (StringUtils.isEmpty(signature)) {
            LOGGER.warn("sign is empty");
            writeToResponse(response, OBJECT_MAPPER.writeValueAsString(new UnifiedResponse(20000, "签名为空")));
            return;
        }
        boolean checkSign = doCheckSign(signature, rawContent);
        if (checkSign) {
            LOGGER.debug("sign check success");
            filterChain.doFilter(request, response);
            return;
        }
        LOGGER.error("sign check fail");
        writeToResponse(response, OBJECT_MAPPER.writeValueAsString(new UnifiedResponse(20000, "签名验证失败")));
    }


    private void writeToResponse(HttpServletResponse response, String jsonData) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonData);
        out.flush();
    }

    private boolean doCheckSign(String signature, String rawContent) {

        return UnifiedRsaUtils.verifyWithPubKey(rawContent, signature, platformPublicKey);
    }

    @SuppressWarnings("Duplicates")
    private String generateRawContent(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;

        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }


    // 支持request 可重复读
    private class ReReadableRequestWrapper extends HttpServletRequestWrapper {

        private final byte[] body;

        private ReReadableRequestWrapper(HttpServletRequest request) throws IOException {
            super(request);
            body = IOUtils.toByteArray(request.getInputStream());
        }

        @Override
        public BufferedReader getReader() throws IOException {
            return new BufferedReader(new InputStreamReader(this.getInputStream()));
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            return new ReReadableServletInputStream(body);
        }

        private class ReReadableServletInputStream extends ServletInputStream {

            private final ByteArrayInputStream in;

            private ReReadableServletInputStream(byte[] bytes) {
                this.in = new ByteArrayInputStream(bytes);
            }

            @Override
            public boolean isFinished() {
                return in.available() == 0;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
                throw new RuntimeException("Not implemented");
            }

            @Override
            public int read() throws IOException {
                return this.in.read();
            }
        }
    }

}
