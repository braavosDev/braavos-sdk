package com.yqg.braavos.sdk2.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class CheckUserRequest {

    @JsonProperty("phone_md5")
    private String phoneMd5;

    @JsonProperty("identity_number_md5")
    private String identityNumberMd5;

    @JsonProperty("product_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long productId;

    public void setPhoneMd5(String phoneMd5) {
        this.phoneMd5 = phoneMd5;
    }

    public String getPhoneMd5() {
        return phoneMd5;
    }

    public void setIdentityNumberMd5(String identityNumberMd5) {
        this.identityNumberMd5 = identityNumberMd5;
    }

    public String getIdentityNumberMd5() {
        return identityNumberMd5;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }
}
