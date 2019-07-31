package com.yqg.braavos.sdk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yqg.braavos.sdk.client.UnifiedOpenApiClient;

/**
 * 本地测试app
 */
public class ExampleApp {

    // 测试环境默认APP_ID，调试请申请正式APP_ID
    private static final String APP_ID = "3020000";

    // 默认为测试环境host，上线需要更换为  https://openapi.digitforest.cn/
    private static final String OPEN_API_HOST = "https://openapi-test.digitforest.cn/";

    // 默认私钥，上线需要本地生成密钥对，并提交公钥给平台方
    private static final String PRIVATE_KEY = "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";


    public static void main(String[] args) throws JsonProcessingException {

        UnifiedOpenApiClient openApiClient = new UnifiedOpenApiClient(APP_ID, OPEN_API_HOST, PRIVATE_KEY);

        SimpleUser user = new SimpleUser();
        user.name = "john";
        user.sex = "boy";
        user.birth_time = System.currentTimeMillis();

        // 将Object 序列化为json
        String jsonData = new ObjectMapper().writeValueAsString(user);

        // 请求具体的接口，并获取返回的json  response
        String responseData = openApiClient.remoteCall(jsonData, "/api/sample/hello");

        System.out.println("response is : " + responseData);

    }


    private static class SimpleUser {

        private String name;

        private String sex;

        private Long birth_time;

        public String getName() {
            return name;
        }

        public String getSex() {
            return sex;
        }

        public Long getBirth_time() {
            return birth_time;
        }
    }

}
