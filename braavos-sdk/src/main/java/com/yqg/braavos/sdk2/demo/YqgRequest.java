package com.yqg.braavos.sdk2.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yqg.braavos.sdk2.request.CheckUserRequest;
import com.yqg.braavos.sdk2.request.CommonRequest;
import com.yqg.braavos.sdk2.request.HttpSimpleRequest;
import com.yqg.braavos.sdk2.response.BusinessResponse;
import com.yqg.braavos.sdk2.response.CheckUserResponse;
import com.yqg.braavos.sdk2.response.CommonResponse;
import com.yqg.braavos.sdk2.response.HttpSimpleResponse;
import com.yqg.braavos.sdk2.util.RsaUtils;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class YqgRequest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final String YQG_PRIVATE_KEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJDpSviZ7SuP1zQ8XRIB4ObN7x/hfZrUzYFNkzwPNoVVQ8ISeS2Yzy/bsP2gyGUTddk/HWeOcy2V8szvTYzW+JA0ZNn1pWDYCKSsROcPjlWHEG1/YUh5RgbzideokHrangyDKmf/Uko6BroijxbMgrlBgk1eLPfootYRvVHQg2OrAgMBAAECgYAugA4ktBAdGG0wP+aFrsCij5aaHluV4Y+IXIJQlXkjU/cIQbFM5molq1OiL4Pem14Htm8TGezvxdxB0tCJzzm3YNRIeWxTiUUTvYclS56IRCGyEaU5oyg3YdjN0syPNDhFw749KCwiXm46vBCfIjJN8ptifPUGrHachypB9zLfUQJBAMTrgPSWvOX9Al0JuIrTamLd/wk2i86/obgJqYXgG9fPvtEo0mYkqQYzeb6HvPsvCYLsrYCbcnyVCa/RBgQLzW8CQQC8Yz/0m0bNTLL0dTaE4NnrqmgwNGME06OnvdQoKYSE2FvQ4Ikgy4hKGDwBPWJ/0qAtGZFA7luNieD1Lvdr5meFAkBI5n6ZDezkn+PuGZkuG9J4w4KVIJJleeAex8TwgOUN4iTcPeaWVeAVIZ1igdHek61LwN8Ci4m4wVwSsKkvekcVAkAObKMG/aSsL4U8RoVII1dMPh4AIuK6CeJsA5LtCFDHQzG0ipy1UCA9XCGsDqEuHFh7W4vNpvKHodkBrPjw4BFpAkAfa/MitQkea9K/kuN+kzcjb+Kolyunf9/JZbqsiKEMC12qwKvNEugmIrpZS81uzOy8D8fwwlQ9R2v+k7eooee7";

    private static final String YQG_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCQ6Ur4me0rj9c0PF0SAeDmze8f4X2a1M2BTZM8DzaFVUPCEnktmM8v27D9oMhlE3XZPx1njnMtlfLM702M1viQNGTZ9aVg2AikrETnD45VhxBtf2FIeUYG84nXqJB62p4Mgypn/1JKOga6Io8WzIK5QYJNXiz36KLWEb1R0INjqwIDAQAB";

    private static final String AGENCY_PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAL+CB4dpRqSTaQOvv24NWI2iK7v0x695ECm+6eLiywYYKYpMBdiLBbGGpFyryKNrDjlMPY98eCPOWaV8XNCOcZVgfa4Ag23vQwykHWuWr9knJaWHNcc9dONiTDx/D5E8SFjSEZFzZGU7sKRvbOcYC53TOAbjw8BzjriBV60M3GDNAgMBAAECgYBgbXGrDihC3/Klp42lNVUcY8bPqi4NvdCUpIuR8Y42sF3iQ+tBoKaqP9hszRaGqnYMBcaNhCfeJ53eBKObY83ufwGIRpbCmWsBdJkwdb4X6gPXHxH/zFmZf0a83JaqYFILuAeZYitAUs5Eu1BZluuybgxdq3IGC6lm50WYANiCIQJBAP4czU0Ah8NpVuQRWUVMH6B0QZ3L/d24//M1ZI2PA3dRVi7DRyq+CnB7KmzLRS7r+HaZs7RfYbPaiuXxRHkpWxUCQQDA7i8fvYIGOmWDo8xhvRzlJWw8kXoCQ8aBixHqOqAKBYpWQrJhQK9KmmLTTt91gbmof8rZz26Nz1N7sqB58HzZAkEAw7YVHKg65/L6nB8MfUW62g6P9uOEu77fSkamEizCg6QeV1fJOQ8y5RzHORF5UEEnlNieQl5v1mCMN7sRfKuwXQJAG25CGPsyz3viDxNs7cCbqSDnAL2WYVgNk0GYrHrlYkdjYdxdzGIMCkllH7IpJ2XoZcK1rr5Fc7g0oHPHSU8eEQJAINpK+hg8bBkGrQdd5nNCdj0L5DGXokk6yehfiW/AETtGGkAy2x8F6/dPsNWb9m+IbwbRxym7p74LoWl0uedKjA==";

    private static final String AGENCY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/ggeHaUakk2kDr79uDViNoiu79MeveRApvuni4ssGGCmKTAXYiwWxhqRcq8ijaw45TD2PfHgjzlmlfFzQjnGVYH2uAINt70MMpB1rlq/ZJyWlhzXHPXTjYkw8fw+RPEhY0hGRc2RlO7Ckb2znGAud0zgG48PAc464gVetDNxgzQIDAQAB";

    private static final String HEADER_APP_ID = "B-APP-ID";

    private static final String HEADER_TIMESTAMP = "B-TIMESTAMP";

    public static void main(String[] args) throws JsonProcessingException {
        HttpSimpleRequest checkUserRequest = yqgSendCheckUserRequest();
        agencyReceiveCheckUserRequest(checkUserRequest);

        HttpSimpleResponse checkUserResponse = agencySendCheckUserResponse();
        yqgReceiveCheckUserResponse(checkUserResponse);
    }

    private static HttpSimpleRequest yqgSendCheckUserRequest() throws JsonProcessingException {
        // 撞库请求
        CheckUserRequest checkUserRequest = new CheckUserRequest();
        checkUserRequest.setProductId(1L);
        checkUserRequest.setPhoneMd5("06768eeab0eb211696d7c76d5b96f523");
        checkUserRequest.setIdentityNumberMd5("060a84d9a1748a17f7a731f43fa6fa18");

        // 撞库请求加签
        String data = objectMapper.writeValueAsString(checkUserRequest);
        CommonRequest.SignData signData = new CommonRequest.SignData();
        signData.setData(data);
        signData.setSign(RsaUtils.signWithPriKey(data, YQG_PRIVATE_KEY));

        // 撞库请求加密
        CommonRequest commonRequest = new CommonRequest();
        commonRequest.setEncryption(RsaUtils.encryptWithPubKey(objectMapper.writeValueAsString(signData), AGENCY_PUBLIC_KEY));

        // Http请求
        HttpSimpleRequest httpSimpleRequest = new HttpSimpleRequest();
        httpSimpleRequest.setUrl("host/yqg/api/v1/user/check");
        httpSimpleRequest.setMethod("POST");
        httpSimpleRequest.setBody(objectMapper.writeValueAsString(commonRequest));
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put(HEADER_APP_ID, "APP_ID");// 目前洋钱罐侧不会传输
        headers.put(HEADER_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
        httpSimpleRequest.setHeaders(headers);
        return httpSimpleRequest;
    }

    private static void agencyReceiveCheckUserRequest(HttpSimpleRequest checkUserRequest) throws JsonProcessingException {
        // 解密
        CommonRequest commonRequest = objectMapper.readValue(checkUserRequest.getBody(), CommonRequest.class);
        String decryption = RsaUtils.decryptWithPriKey(commonRequest.getEncryption(), AGENCY_PRIVATE_KEY);

        // 验签
        CommonRequest.SignData signData = objectMapper.readValue(decryption, CommonRequest.SignData.class);
        if (!RsaUtils.verifyWithPubKey(signData.getData(), signData.getSign(), YQG_PUBLIC_KEY)) {
            throw new RuntimeException("check sign error");
        }
        
        // 撞库参数
        CheckUserRequest request = objectMapper.readValue(signData.getData(), CheckUserRequest.class);
    }

    private static HttpSimpleResponse agencySendCheckUserResponse() throws JsonProcessingException {
        // 撞库响应
        CheckUserResponse checkUserResponse = new CheckUserResponse();
        checkUserResponse.setCanLoan(1);

        // 撞库响应包装
        BusinessResponse businessResponse = new BusinessResponse();
        businessResponse.setCode(0);
        businessResponse.setData(checkUserResponse);

        // 撞库响应加签
        String data = objectMapper.writeValueAsString(businessResponse);
        CommonResponse.SignData signData = new CommonResponse.SignData();
        signData.setData(data);
        signData.setSign(RsaUtils.signWithPriKey(data, AGENCY_PRIVATE_KEY));

        // 撞库响应加密
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setEncryption(RsaUtils.encryptWithPubKey(objectMapper.writeValueAsString(signData), YQG_PUBLIC_KEY));

        // Http响应
        HttpSimpleResponse httpSimpleResponse = new HttpSimpleResponse();
        httpSimpleResponse.setBody(objectMapper.writeValueAsString(commonResponse));
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put(HEADER_APP_ID, "APP_ID");
        httpSimpleResponse.setHeaders(headers);
        return httpSimpleResponse;
    }

    private static void yqgReceiveCheckUserResponse(HttpSimpleResponse httpSimpleResponse) throws JsonProcessingException {
        // 机构响应需要传B-APP-ID
        if (httpSimpleResponse.getHeaders() == null || StringUtils.isEmpty(httpSimpleResponse.getHeaders().get(HEADER_APP_ID))) {
            throw new RuntimeException("app id is empty");
        }

        // 解密
        CommonResponse commonResponse = objectMapper.readValue(httpSimpleResponse.getBody(), CommonResponse.class);
        String decryption = RsaUtils.decryptWithPriKey(commonResponse.getEncryption(), YQG_PRIVATE_KEY);

        // 验签
        CommonResponse.SignData signData = objectMapper.readValue(decryption, CommonResponse.SignData.class);
        if (!RsaUtils.verifyWithPubKey(signData.getData(), signData.getSign(), AGENCY_PUBLIC_KEY)) {
            throw new RuntimeException("check sign error");
        }
    }
}
