package com.yqg.braavos.sdk2.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CheckUserResponse {

    @JsonProperty("can_loan")
    private Integer canLoan;

    @JsonProperty("reject_reason")
    private Integer rejectReason;

    public void setCanLoan(Integer canLoan) {
        this.canLoan = canLoan;
    }

    public Integer getCanLoan() {
        return canLoan;
    }

    public void setRejectReason(Integer rejectReason) {
        this.rejectReason = rejectReason;
    }

    public Integer getRejectReason() {
        return rejectReason;
    }
}
