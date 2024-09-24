package com.yqg.braavos.sdk2.response;

public class CommonResponse {

    private String encryption;

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }

    public String getEncryption() {
        return encryption;
    }

    public static class SignData {

        private String sign;

        private String data;

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getSign() {
            return sign;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }

}
