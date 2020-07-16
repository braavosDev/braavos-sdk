package com.yqg.braavos.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AdditionalInfoRequest {
    /**
     * 订单基本信息
     */
    @JsonProperty("order_info")
    private OrderInfo orderInfo;
    /**
     * 补充信息
     */
    @JsonProperty("add_info")
    private AddInfo addInfo;
    /**
     * 身份证信息
     */
    @JsonProperty("id_info")
    private IdInfo idInfo;
    /**
     * 活体信息
     */
    @JsonProperty("living_info")
    private LivingInfo livingInfo;
    /**
     * 设备信息
     */
    @JsonProperty("device_info")
    private DeviceInfo deviceInfo;

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public AddInfo getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(AddInfo addInfo) {
        this.addInfo = addInfo;
    }

    public IdInfo getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(IdInfo idInfo) {
        this.idInfo = idInfo;
    }

    public LivingInfo getLivingInfo() {
        return livingInfo;
    }

    public void setLivingInfo(LivingInfo livingInfo) {
        this.livingInfo = livingInfo;
    }

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public static class OrderInfo {
        /**
         * 订单编号
         */
        @JsonProperty("order_no")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long orderNo;
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
        /**
         * 是否同意所有协议
         */
        @JsonProperty("contract_agree")
        private Integer contractAgree;

        public Long getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(Long orderNo) {
            this.orderNo = orderNo;
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

        public Integer getContractAgree() {
            return contractAgree;
        }

        public void setContractAgree(Integer contractAgree) {
            this.contractAgree = contractAgree;
        }
    }

    public static class AddInfo {
        /**
         * 居住省份
         */
        @JsonProperty("address_province")
        private String addressProvince;
        /**
         * 居住城市
         */
        @JsonProperty("address_city")
        private String addressCity;
        /**
         * 居住区
         */
        @JsonProperty("address_district")
        private String addressDistrict;
        /**
         * 居住详细地址
         */
        @JsonProperty("address_detail")
        private String addressDetail;
        /**
         * 居住时长年份
         */
        @JsonProperty("year_of_residence")
        private Integer yearOfResidence;
        /**
         * 居住时长月份
         */
        @JsonProperty("month_of_residence")
        private Integer monthOfResidence;
        /**
         * gps定位省份
         */
        @JsonProperty("gps_province")
        private String gpsProvince;
        /**
         * gps定位城市
         */
        @JsonProperty("gps_city")
        private String gpsCity;
        /**
         * gps定位区
         */
        @JsonProperty("gps_district")
        private String gpsDistrict;
        /**
         * gps定位详细地址
         */
        @JsonProperty("gps_address")
        private String gpsAddress;
        /**
         * 经度
         */
        @JsonProperty("longitude")
        private String longitude;
        /**
         * 纬度
         */
        @JsonProperty("latitude")
        private String latitude;
        /**
         * 紧急联系人
         */
        @JsonProperty("immediate_contact")
        private Contact immediateContact;
        /**
         * 第二紧急联系人
         */
        @JsonProperty("second_immediate_contact")
        private Contact secondImmediateContact;
        /**
         * 借款用途
         */
        @JsonProperty("loan_use")
        private Integer loanUse;
        /**
         * 额外信息
         */
        @JsonProperty("option_info")
        private OptionInfo optionInfo;

        public String getAddressProvince() {
            return addressProvince;
        }

        public void setAddressProvince(String addressProvince) {
            this.addressProvince = addressProvince;
        }

        public String getAddressCity() {
            return addressCity;
        }

        public void setAddressCity(String addressCity) {
            this.addressCity = addressCity;
        }

        public String getAddressDistrict() {
            return addressDistrict;
        }

        public void setAddressDistrict(String addressDistrict) {
            this.addressDistrict = addressDistrict;
        }

        public String getAddressDetail() {
            return addressDetail;
        }

        public void setAddressDetail(String addressDetail) {
            this.addressDetail = addressDetail;
        }

        public Integer getYearOfResidence() {
            return yearOfResidence;
        }

        public void setYearOfResidence(Integer yearOfResidence) {
            this.yearOfResidence = yearOfResidence;
        }

        public Integer getMonthOfResidence() {
            return monthOfResidence;
        }

        public void setMonthOfResidence(Integer monthOfResidence) {
            this.monthOfResidence = monthOfResidence;
        }

        public String getGpsProvince() {
            return gpsProvince;
        }

        public void setGpsProvince(String gpsProvince) {
            this.gpsProvince = gpsProvince;
        }

        public String getGpsCity() {
            return gpsCity;
        }

        public void setGpsCity(String gpsCity) {
            this.gpsCity = gpsCity;
        }

        public String getGpsDistrict() {
            return gpsDistrict;
        }

        public void setGpsDistrict(String gpsDistrict) {
            this.gpsDistrict = gpsDistrict;
        }

        public String getGpsAddress() {
            return gpsAddress;
        }

        public void setGpsAddress(String gpsAddress) {
            this.gpsAddress = gpsAddress;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Contact getImmediateContact() {
            return immediateContact;
        }

        public void setImmediateContact(Contact immediateContact) {
            this.immediateContact = immediateContact;
        }

        public Contact getSecondImmediateContact() {
            return secondImmediateContact;
        }

        public void setSecondImmediateContact(Contact secondImmediateContact) {
            this.secondImmediateContact = secondImmediateContact;
        }

        public Integer getLoanUse() {
            return loanUse;
        }

        public void setLoanUse(Integer loanUse) {
            this.loanUse = loanUse;
        }

        public OptionInfo getOptionInfo() {
            return optionInfo;
        }

        public void setOptionInfo(OptionInfo optionInfo) {
            this.optionInfo = optionInfo;
        }
    }

    public static class Contact {
        /**
         * 姓名
         */
        @JsonProperty("name")
        private String name;
        /**
         * 手机号码
         */
        @JsonProperty("mobile_phone_no")
        private String mobilePhoneNo;
        /**
         * 关系
         */
        @JsonProperty("relationship")
        private String relationship;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobilePhoneNo() {
            return mobilePhoneNo;
        }

        public void setMobilePhoneNo(String mobilePhoneNo) {
            this.mobilePhoneNo = mobilePhoneNo;
        }

        public String getRelationship() {
            return relationship;
        }

        public void setRelationship(String relationship) {
            this.relationship = relationship;
        }
    }

    public static class OptionInfo {

        @JsonProperty("email")
        private String email;

        @JsonProperty("marital_status")
        private Integer maritalStatus;

        @JsonProperty("income_source")
        private Integer incomeSource;

        @JsonProperty("housing_situation")
        private Integer housingSituation;

        @JsonProperty("loan_situation")
        private Integer loanSituation;

        @JsonProperty("company_name")
        private String companyName;

        @JsonProperty("office_phone")
        private String officePhone;

        @JsonProperty("office_address_province")
        private String officeAddressProvince;

        @JsonProperty("office_address_city")
        private String officeAddressCity;

        @JsonProperty("office_address_district")
        private String officeAddressDistrict;

        @JsonProperty("office_address_detail")
        private String officeAddressDetail;

        @JsonProperty("office_property")
        private Integer officeProperty;

        @JsonProperty("credit_card_number")
        private String creditCardNumber;

        @JsonProperty("credit_card_mobile")
        private String creditCardMobile;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Integer getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(Integer maritalStatus) {
            this.maritalStatus = maritalStatus;
        }

        public Integer getIncomeSource() {
            return incomeSource;
        }

        public void setIncomeSource(Integer incomeSource) {
            this.incomeSource = incomeSource;
        }

        public Integer getHousingSituation() {
            return housingSituation;
        }

        public void setHousingSituation(Integer housingSituation) {
            this.housingSituation = housingSituation;
        }

        public Integer getLoanSituation() {
            return loanSituation;
        }

        public void setLoanSituation(Integer loanSituation) {
            this.loanSituation = loanSituation;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getOfficePhone() {
            return officePhone;
        }

        public void setOfficePhone(String officePhone) {
            this.officePhone = officePhone;
        }

        public String getOfficeAddressProvince() {
            return officeAddressProvince;
        }

        public void setOfficeAddressProvince(String officeAddressProvince) {
            this.officeAddressProvince = officeAddressProvince;
        }

        public String getOfficeAddressCity() {
            return officeAddressCity;
        }

        public void setOfficeAddressCity(String officeAddressCity) {
            this.officeAddressCity = officeAddressCity;
        }

        public String getOfficeAddressDistrict() {
            return officeAddressDistrict;
        }

        public void setOfficeAddressDistrict(String officeAddressDistrict) {
            this.officeAddressDistrict = officeAddressDistrict;
        }

        public String getOfficeAddressDetail() {
            return officeAddressDetail;
        }

        public void setOfficeAddressDetail(String officeAddressDetail) {
            this.officeAddressDetail = officeAddressDetail;
        }

        public Integer getOfficeProperty() {
            return officeProperty;
        }

        public void setOfficeProperty(Integer officeProperty) {
            this.officeProperty = officeProperty;
        }

        public String getCreditCardNumber() {
            return creditCardNumber;
        }

        public void setCreditCardNumber(String creditCardNumber) {
            this.creditCardNumber = creditCardNumber;
        }

        public String getCreditCardMobile() {
            return creditCardMobile;
        }

        public void setCreditCardMobile(String creditCardMobile) {
            this.creditCardMobile = creditCardMobile;
        }
    }

    public static class IdInfo {

        @JsonProperty("name")
        private String name;

        @JsonProperty("id_no")
        private String idNo;

        @JsonProperty("sex")
        private String sex;

        @JsonProperty("nation")
        private String nation;

        @JsonProperty("address")
        private String address;

        @JsonProperty("issue_agency")
        private String issueAgency;

        @JsonProperty("issue_date")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long issueDate;

        @JsonProperty("expire_date")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long expireDate;

        @JsonProperty("front_image")
        private String frontImage;

        @JsonProperty("back_image")
        private String backImage;

        public String getEffectiveDate() {
            try {
                if (issueDate == null || expireDate == null) {
                    return null;
                }

                LocalDate startDate = Instant.ofEpochMilli(issueDate).atZone(ZoneOffset.ofHours(8)).toLocalDate();
                String startString = startDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));

                String endString;
                if (expireDate == 0) {
                    endString = "长期";
                } else {
                    LocalDate endDate = Instant.ofEpochMilli(expireDate).atZone(ZoneOffset.ofHours(8)).toLocalDate();
                    endString = endDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
                }
                return startString + "-" + endString;
            } catch (Exception e) {
                return null;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdNo() {
            return idNo;
        }

        public void setIdNo(String idNo) {
            this.idNo = idNo;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getIssueAgency() {
            return issueAgency;
        }

        public void setIssueAgency(String issueAgency) {
            this.issueAgency = issueAgency;
        }

        public Long getIssueDate() {
            return issueDate;
        }

        public void setIssueDate(Long issueDate) {
            this.issueDate = issueDate;
        }

        public Long getExpireDate() {
            return expireDate;
        }

        public void setExpireDate(Long expireDate) {
            this.expireDate = expireDate;
        }

        public String getFrontImage() {
            return frontImage;
        }

        public void setFrontImage(String frontImage) {
            this.frontImage = frontImage;
        }

        public String getBackImage() {
            return backImage;
        }

        public void setBackImage(String backImage) {
            this.backImage = backImage;
        }
    }

    public static class LivingInfo {

        @JsonProperty("image_best")
        private String imageBest;

        @JsonProperty("image_env")
        private String imageEnv;

        @JsonProperty("result_faceid")
        private ResultFaceid resultFaceid;

        public String getImageBest() {
            return imageBest;
        }

        public void setImageBest(String imageBest) {
            this.imageBest = imageBest;
        }

        public String getImageEnv() {
            return imageEnv;
        }

        public void setImageEnv(String imageEnv) {
            this.imageEnv = imageEnv;
        }

        public ResultFaceid getResultFaceid() {
            return resultFaceid;
        }

        public void setResultFaceid(ResultFaceid resultFaceid) {
            this.resultFaceid = resultFaceid;
        }
    }

    public static class ResultFaceid {

        @JsonProperty("confidence")
        private Double confidence;

        @JsonProperty("thresholds")
        private Thresholds thresholds;

        @JsonProperty("id_exceptions")
        private IdExceptions idExceptions;

        @JsonProperty("face_genuineness")
        private FaceGenuineness faceGenuineness;

        public Double getConfidence() {
            return confidence;
        }

        public void setConfidence(Double confidence) {
            this.confidence = confidence;
        }

        public Thresholds getThresholds() {
            return thresholds;
        }

        public void setThresholds(Thresholds thresholds) {
            this.thresholds = thresholds;
        }

        public IdExceptions getIdExceptions() {
            return idExceptions;
        }

        public void setIdExceptions(IdExceptions idExceptions) {
            this.idExceptions = idExceptions;
        }

        public FaceGenuineness getFaceGenuineness() {
            return faceGenuineness;
        }

        public void setFaceGenuineness(FaceGenuineness faceGenuineness) {
            this.faceGenuineness = faceGenuineness;
        }
    }

    public static class Thresholds {

        @JsonProperty("1e-3")
        private Double threshold1e3;

        @JsonProperty("1e-4")
        private Double threshold1e4;

        @JsonProperty("1e-5")
        private Double threshold1e5;

        @JsonProperty("1e-6")
        private Double threshold1e6;

        public Double getThreshold1e3() {
            return threshold1e3;
        }

        public void setThreshold1e3(Double threshold1e3) {
            this.threshold1e3 = threshold1e3;
        }

        public Double getThreshold1e4() {
            return threshold1e4;
        }

        public void setThreshold1e4(Double threshold1e4) {
            this.threshold1e4 = threshold1e4;
        }

        public Double getThreshold1e5() {
            return threshold1e5;
        }

        public void setThreshold1e5(Double threshold1e5) {
            this.threshold1e5 = threshold1e5;
        }

        public Double getThreshold1e6() {
            return threshold1e6;
        }

        public void setThreshold1e6(Double threshold1e6) {
            this.threshold1e6 = threshold1e6;
        }
    }

    public static class IdExceptions {

        @JsonProperty("id_attacked")
        private Integer idAttacked;

        @JsonProperty("id_photo_monochrome")
        private Integer idPhotoMonochrome;

        public Integer getIdAttacked() {
            return idAttacked;
        }

        public void setIdAttacked(Integer idAttacked) {
            this.idAttacked = idAttacked;
        }

        public Integer getIdPhotoMonochrome() {
            return idPhotoMonochrome;
        }

        public void setIdPhotoMonochrome(Integer idPhotoMonochrome) {
            this.idPhotoMonochrome = idPhotoMonochrome;
        }
    }

    public static class FaceGenuineness {

        @JsonProperty("synthetic_face_confidence")
        private Double syntheticFaceConfidence;

        @JsonProperty("synthetic_face_threshold")
        private Double syntheticFaceThreshold;

        @JsonProperty("mask_confidence")
        private Double maskConfidence;

        @JsonProperty("mask_threshold")
        private Double maskThreshold;

        @JsonProperty("screen_replay_confidence")
        private Double screenReplayConfidence;

        @JsonProperty("screen_replay_threshold")
        private Double screenReplayThreshold;

        @JsonProperty("face_replaced")
        private Integer faceReplaced;

        public Double getSyntheticFaceConfidence() {
            return syntheticFaceConfidence;
        }

        public void setSyntheticFaceConfidence(Double syntheticFaceConfidence) {
            this.syntheticFaceConfidence = syntheticFaceConfidence;
        }

        public Double getSyntheticFaceThreshold() {
            return syntheticFaceThreshold;
        }

        public void setSyntheticFaceThreshold(Double syntheticFaceThreshold) {
            this.syntheticFaceThreshold = syntheticFaceThreshold;
        }

        public Double getMaskConfidence() {
            return maskConfidence;
        }

        public void setMaskConfidence(Double maskConfidence) {
            this.maskConfidence = maskConfidence;
        }

        public Double getMaskThreshold() {
            return maskThreshold;
        }

        public void setMaskThreshold(Double maskThreshold) {
            this.maskThreshold = maskThreshold;
        }

        public Double getScreenReplayConfidence() {
            return screenReplayConfidence;
        }

        public void setScreenReplayConfidence(Double screenReplayConfidence) {
            this.screenReplayConfidence = screenReplayConfidence;
        }

        public Double getScreenReplayThreshold() {
            return screenReplayThreshold;
        }

        public void setScreenReplayThreshold(Double screenReplayThreshold) {
            this.screenReplayThreshold = screenReplayThreshold;
        }

        public Integer getFaceReplaced() {
            return faceReplaced;
        }

        public void setFaceReplaced(Integer faceReplaced) {
            this.faceReplaced = faceReplaced;
        }
    }

    public static class DeviceInfo {
        /**
         * ip地址
         */
        @JsonProperty("ip")
        private String ip;
        /**
         * 设备型号
         */
        @JsonProperty("device_model")
        private String deviceModel;
        /**
         * 设备类型
         */
        @JsonProperty("os_type")
        private String osType;
        /**
         * 系统版本号
         */
        @JsonProperty("os_version")
        private String osVersion;
        /**
         * 设备的唯一设备识别符
         */
        @JsonProperty("udid")
        private String udid;
        /**
         * ios的设备识别符
         */
        @JsonProperty("idfa")
        private String idfa;
        /**
         * imei
         */
        @JsonProperty("imei")
        private String imei;
        /**
         * APP列表
         */
        @JsonProperty("app_list")
        private List<AppInfo> appList;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getDeviceModel() {
            return deviceModel;
        }

        public void setDeviceModel(String deviceModel) {
            this.deviceModel = deviceModel;
        }

        public String getOsType() {
            return osType;
        }

        public void setOsType(String osType) {
            this.osType = osType;
        }

        public String getOsVersion() {
            return osVersion;
        }

        public void setOsVersion(String osVersion) {
            this.osVersion = osVersion;
        }

        public String getUdid() {
            return udid;
        }

        public void setUdid(String udid) {
            this.udid = udid;
        }

        public String getIdfa() {
            return idfa;
        }

        public void setIdfa(String idfa) {
            this.idfa = idfa;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public List<AppInfo> getAppList() {
            return appList;
        }

        public void setAppList(List<AppInfo> appList) {
            this.appList = appList;
        }
    }

    public static class AppInfo {

        @JsonProperty("app_name")
        private String appName;

        @JsonProperty("app_package")
        private String appPackage;

        @JsonProperty("app_version")
        private String appVersion;

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public String getAppPackage() {
            return appPackage;
        }

        public void setAppPackage(String appPackage) {
            this.appPackage = appPackage;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }
    }

}
