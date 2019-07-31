package com.yqg.braavos.sdk.client;

import com.yqg.braavos.sdk.util.UnifiedRsaUtils;
import okhttp3.*;

import java.io.IOException;

/**
 * 统一OpenApi请求Client，使用OkHttpClient 处理请求
 *
 * 需要联系平台获取appId ，各个环境openApiHost，已经生成自己的密钥对，其中将私钥作为UnifiedOpenApiClient 的参数
 */
public class UnifiedOpenApiClient {

    private static final String HEADER_APP_ID = "B-APP-ID";

    private static final String HEADER_SIGNATURE = "B-SIGNATURE";

    private static final String HEADER_TIMESTAMP = "B-TIMESTAMP";


    private String privateKey;

    private String appId;

    private String openApiHost;

    private OkHttpClient httpClient;

    public UnifiedOpenApiClient(String appId, String openApiHost, String privateKey) {
        this.appId = appId;
        this.openApiHost = openApiHost;
        this.privateKey = privateKey;
        this.httpClient = new OkHttpClient().newBuilder().build();
    }

    public String remoteCall(String jsonData, String path) {

        String signature = UnifiedRsaUtils.signWithPriKey(jsonData, this.privateKey);
        Request request =
            new Request.Builder()
                .url(this.openApiHost + path)
                .post(RequestBody.create(MediaType.parse("application/json"), jsonData))
                .addHeader(HEADER_APP_ID, appId)
                .addHeader(HEADER_SIGNATURE, signature)
                .addHeader(HEADER_TIMESTAMP, String.valueOf(System.currentTimeMillis()))
                .build();

        try (Response response = httpClient.newBuilder().build().newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            }
            throw new RuntimeException("call failed, httpCode:" + response.code() + ", body:" + response.body().string());
        } catch (IOException e) {
            throw new RuntimeException("call error", e);
        }
    }

}
