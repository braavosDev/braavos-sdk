package com.yqg.braavos.sdk.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yqg.braavos.sdk.request.AdditionalInfoRequest;
import com.yqg.braavos.sdk.request.BaseInfoRequest;
import com.yqg.braavos.sdk.util.RequestReceiveUtil;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;

import java.io.IOException;

public class RequestReceiveTest {

    private final static String baseInfoBodyString = "{\"order_info\":{\"order_no\":\"165548830105\",\"user_id\":\"16402474\",\"product_id\":\"320\",\"order_time\":1562826883000,\"application_amount\":20000,\"application_term\":3,\"term_unit\":2},\"apply_info\":{\"mobile\":\"13812341234\",\"user_name\":\"张三丰\",\"identity_number\":\"11010119900307803X\",\"user_education\":4,\"industry\":\"房地产中介服务业\",\"career\":\"店长\",\"work_period_year\":1,\"work_period_month\":1}}";

    private final static String additionalInfoBodyString = "{\"order_info\":{\"order_no\":\"165548830105\",\"application_amount\":\"2000.00\",\"application_term\":1,\"term_unit\":1,\"contract_agree\":1},\"add_info\":{\"address_province\":\"北京市\",\"address_city\":\"朝阳区\",\"address_district\":\"中纺里社区\",\"address_detail\":\"中纺里社区23号楼\",\"year_of_residence\":3,\"month_of_residence\":2,\"gps_province\":\"\",\"gps_city\":\"北京市\",\"gps_district\":\"朝阳区\",\"gps_address\":\"中纺里社区\",\"longitude\":\"121.31\",\"latitude\":\"3333.08\",\"immediate_contact\":{\"name\":\"妈妈\",\"mobile_phone_no\":\"18765757675\",\"relationship\":\"父母\"},\"second_immediate_contact\":{\"name\":\"姐姐\",\"mobile_phone_no\":\"13121925755\",\"relationship\":\"姐妹\"},\"loan_use\":1,\"option_info\":{\"email\":\"12345678@qq.com\",\"marital_status\":1,\"company_name\":\"xxx有限公司\",\"office_phone\":\"18315243987\"}},\"id_info\":{\"name\":\"张三丰\",\"id_no\":\"340122199010240000\",\"sex\":\"男\",\"nation\":\"汉\",\"address\":\"北京市海淀区某小区某单元\",\"issue_agency\":\"北京市海淀区公安局\",\"issue_date\":1487692800000,\"expire_date\":1803225600000,\"front_image\":\"token://UFU5ifBQBr6nb9E1NZ76yeRBFrUrnJ0VflSHENKg\",\"back_image\":\"token://UFU5ifBQBr6nb9E1NZ76yeRBFrUrnJ0VflSHENKg\"},\"living_info\":{\"image_best\":\"token://UFU5ifBQBr6nb9E1NZ76yeRBFrUrnJ0VflSHENKg\",\"image_env\":\"token://UFU5ifBQBr6nb9E1NZ76yeRBFrUrnJ0VflSHENKg\",\"result_faceid\":{\"confidence\":83.298,\"thresholds\":{\"1e-3\":62.169,\"1e-4\":69.315,\"1e-5\":74.399,\"1e-6\":78.038},\"id_exceptions\":{\"id_attacked\":0,\"id_photo_monochrome\":0},\"face_genuineness\":{\"synthetic_face_confidence\":0.88,\"synthetic_face_threshold\":0.5,\"mask_confidence\":0.32,\"mask_threshold\":0.5,\"screen_replay_confidence\":0.0,\"screen_replay_threshold\":0.5,\"face_replaced\":0}}},\"device_info\":{\"ip\":\"127.11.11.11\",\"device_model\":\"iPhone\",\"os_type\":\"iOS\",\"os_version\":\"11.3\",\"udid\":\"26858606-E87E-4B6C-B681-372F78442FE4\",\"idfa\":\"0F0AF07E-1D27-49EE-AA84-1C196B28CCD7\",\"imei\":\"\",\"app_list\":[{\"app_name\":\"洋钱罐\",\"app_package\":\"com.yangqianguan\",\"app_version\":\"1.0.0\"}]}}";

    public static void main(String[] args) throws IOException {

        testConvert();

        testRead();

    }

    private static void testConvert() throws JsonProcessingException {

        BaseInfoRequest baseInfoRequest = RequestReceiveUtil.convert(baseInfoBodyString, BaseInfoRequest.class);

        assert baseInfoRequest.getApplyInfo().getUserName().equals("张三丰");
        assert baseInfoRequest.getOrderInfo().getOrderNo().equals(165548830105L);

    }

    private static void testRead() throws IOException {

        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletRequest.setContent(additionalInfoBodyString.getBytes());

        AdditionalInfoRequest additionalInfoRequest = RequestReceiveUtil.read(httpServletRequest, AdditionalInfoRequest.class);

        assert additionalInfoRequest.getIdInfo().getName().equals("张三丰");
        assert additionalInfoRequest.getOrderInfo().getOrderNo().equals(165548830105L);

    }

}
