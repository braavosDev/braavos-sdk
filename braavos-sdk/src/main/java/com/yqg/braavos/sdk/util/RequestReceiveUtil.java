package com.yqg.braavos.sdk.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class RequestReceiveUtil {

    public static <T> T convert(String bodyString, Class<T> clazz) throws JsonProcessingException {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
        return objectMapper.readValue(bodyString, clazz);
    }

    public static <T> T read(HttpServletRequest request, Class<T> clazz) throws IOException {

        if (!isJsonContent(request)) {
            throw new RuntimeException("contentType is not json");
        }

        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        return convert(sb.toString(), clazz);

    }

    private static boolean isJsonContent(HttpServletRequest request) {
        return MediaType.APPLICATION_JSON_VALUE.equalsIgnoreCase(request.getContentType()) ||
            MediaType.APPLICATION_JSON_UTF8_VALUE.equalsIgnoreCase(request.getContentType());
    }

}
