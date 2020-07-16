package com.yqg.braavos.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BaseInfoRequest {
    /**
     * 订单基本信息
     */
    @JsonProperty("order_info")
    private OrderInfo orderInfo;
    /**
     * 申请人填写的基本信息
     */
    @JsonProperty("apply_info")
    private ApplyInfo applyInfo;

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public ApplyInfo getApplyInfo() {
        return applyInfo;
    }

    public void setApplyInfo(ApplyInfo applyInfo) {
        this.applyInfo = applyInfo;
    }


    public static class OrderInfo {
        /**
         * 订单编号
         */
        @JsonProperty("order_no")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long orderNo;
        /**
         * 用户ID
         */
        @JsonProperty("user_id")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long userId;
        /**
         * 产品ID
         */
        @JsonProperty("product_id")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long productId;
        /**
         * 订单创建时间
         */
        @JsonProperty("order_time")
        private Long orderTime;
        /**
         * 申请金额
         */
        @JsonProperty("application_amount")
        private BigDecimal applicationAmount;
        /**
         * 申请期限
         */
        @JsonProperty("application_term")
        private Integer applicationTerm;
        /**
         * 期限单位
         */
        @JsonProperty("term_unit")
        private Integer termUnit;

        public Long getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(Long orderNo) {
            this.orderNo = orderNo;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public Long getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(Long orderTime) {
            this.orderTime = orderTime;
        }

        public BigDecimal getApplicationAmount() {
            return applicationAmount;
        }

        public void setApplicationAmount(BigDecimal applicationAmount) {
            this.applicationAmount = applicationAmount;
        }

        public Integer getApplicationTerm() {
            return applicationTerm;
        }

        public void setApplicationTerm(Integer applicationTerm) {
            this.applicationTerm = applicationTerm;
        }

        public Integer getTermUnit() {
            return termUnit;
        }

        public void setTermUnit(Integer termUnit) {
            this.termUnit = termUnit;
        }
    }

    public static class ApplyInfo {
        /**
         * 手机号码
         */
        @JsonProperty("mobile")
        private String mobile;
        /**
         * 用户姓名
         */
        @JsonProperty("user_name")
        private String userName;
        /**
         * 身份证号
         */
        @JsonProperty("identity_number")
        private String identityNumber;
        /**
         * 可接受最高月还款额度(元)
         */
        @JsonProperty("max_monthly_repayment")
        private BigDecimal maxMonthlyRepayment;
        /**
         * 教育程度
         */
        @JsonProperty("user_education")
        private Integer userEducation;
        /**
         * 行业
         */
        @JsonProperty("industry")
        private String industry;
        /**
         * 职位
         */
        @JsonProperty("career")
        private String career;
        /**
         * 现工作年限
         */
        @JsonProperty("work_period_year")
        private Integer workPeriodYear;
        /**
         * 现工作月份
         */
        @JsonProperty("work_period_month")
        private Integer workPeriodMonth;
        /**
         * 月收入(元)
         */
        @JsonProperty("monthly_income")
        private BigDecimal monthlyIncome;

        public String getBirthday() {
            try {
                if (StringUtils.isEmpty(identityNumber)) {
                    return null;
                }
                if (identityNumber.length() == 18) {
                    return LocalDate.parse(identityNumber.substring(6, 14), DateTimeFormatter.BASIC_ISO_DATE).format(DateTimeFormatter.ISO_LOCAL_DATE);
                }
                if (identityNumber.length() == 15) {
                    return LocalDate.parse("19" + identityNumber.substring(6, 12), DateTimeFormatter.BASIC_ISO_DATE).format(DateTimeFormatter.ISO_LOCAL_DATE);
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getIdentityNumber() {
            return identityNumber;
        }

        public void setIdentityNumber(String identityNumber) {
            this.identityNumber = identityNumber;
        }

        public BigDecimal getMaxMonthlyRepayment() {
            return maxMonthlyRepayment;
        }

        public void setMaxMonthlyRepayment(BigDecimal maxMonthlyRepayment) {
            this.maxMonthlyRepayment = maxMonthlyRepayment;
        }

        public Integer getUserEducation() {
            return userEducation;
        }

        public void setUserEducation(Integer userEducation) {
            this.userEducation = userEducation;
        }

        public String getIndustry() {
            return industry;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }

        public String getCareer() {
            return career;
        }

        public void setCareer(String career) {
            this.career = career;
        }

        public Integer getWorkPeriodYear() {
            return workPeriodYear;
        }

        public void setWorkPeriodYear(Integer workPeriodYear) {
            this.workPeriodYear = workPeriodYear;
        }

        public Integer getWorkPeriodMonth() {
            return workPeriodMonth;
        }

        public void setWorkPeriodMonth(Integer workPeriodMonth) {
            this.workPeriodMonth = workPeriodMonth;
        }

        public BigDecimal getMonthlyIncome() {
            return monthlyIncome;
        }

        public void setMonthlyIncome(BigDecimal monthlyIncome) {
            this.monthlyIncome = monthlyIncome;
        }
    }

}
