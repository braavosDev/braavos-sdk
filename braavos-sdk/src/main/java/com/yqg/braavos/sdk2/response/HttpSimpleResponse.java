package com.yqg.braavos.sdk2.response;

import java.util.Map;

public class HttpSimpleResponse {

    private Map<String, String> headers;

    private String body;

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}
