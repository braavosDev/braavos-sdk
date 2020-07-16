package com.yqg.braavos.sdk.demo;

import com.yqg.braavos.sdk.util.UnifiedRsaUtils;

/**
 * Created by pengbo on 2019/8/6 20:22.
 */
public class LocalSignTest {

    private static final String PRIVATE_KEY =
        "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJDpSviZ7SuP1zQ8XRIB4ObN7x/hfZrUzYFNkzwPNoVVQ8ISeS2Yzy/bsP2gyGUTddk/HWeOcy2V8szvTYzW+JA0ZNn1pWDYCKSsROcPjlWHEG1/YUh5RgbzideokHrangyDKmf/Uko6BroijxbMgrlBgk1eLPfootYRvVHQg2OrAgMBAAECgYAugA4ktBAdGG0wP+aFrsCij5aaHluV4Y+IXIJQlXkjU/cIQbFM5molq1OiL4Pem14Htm8TGezvxdxB0tCJzzm3YNRIeWxTiUUTvYclS56IRCGyEaU5oyg3YdjN0syPNDhFw749KCwiXm46vBCfIjJN8ptifPUGrHachypB9zLfUQJBAMTrgPSWvOX9Al0JuIrTamLd/wk2i86/obgJqYXgG9fPvtEo0mYkqQYzeb6HvPsvCYLsrYCbcnyVCa/RBgQLzW8CQQC8Yz/0m0bNTLL0dTaE4NnrqmgwNGME06OnvdQoKYSE2FvQ4Ikgy4hKGDwBPWJ/0qAtGZFA7luNieD1Lvdr5meFAkBI5n6ZDezkn+PuGZkuG9J4w4KVIJJleeAex8TwgOUN4iTcPeaWVeAVIZ1igdHek61LwN8Ci4m4wVwSsKkvekcVAkAObKMG/aSsL4U8RoVII1dMPh4AIuK6CeJsA5LtCFDHQzG0ipy1UCA9XCGsDqEuHFh7W4vNpvKHodkBrPjw4BFpAkAfa/MitQkea9K/kuN+kzcjb+Kolyunf9/JZbqsiKEMC12qwKvNEugmIrpZS81uzOy8D8fwwlQ9R2v+k7eooee7";

    private static final String PUBLIC_KEY =
        "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCQ6Ur4me0rj9c0PF0SAeDmze8f4X2a1M2BTZM8DzaFVUPCEnktmM8v27D9oMhlE3XZPx1njnMtlfLM702M1viQNGTZ9aVg2AikrETnD45VhxBtf2FIeUYG84nXqJB62p4Mgypn/1JKOga6Io8WzIK5QYJNXiz36KLWEb1R0INjqwIDAQAB";


    public static void main(String[] args) {

        String message = "{\"order_no\":\"188176820195\",\"status\":1,\"process_time\":1565090790467,\"term_unit\":2,\"approval_term\":3,\"approval_amount\":5500.0,\"pay_amount\":1944.41,\"receive_amount\":5500.0,\"service_fee\":0.0,\"period_amount\":61111.0,\"remark\":\"总本金1833.33元，总服务费0.00，总期数3\"}";

        String signature = UnifiedRsaUtils.signWithPriKey(message, PRIVATE_KEY);
        System.out.println("signature: " + signature);

        System.out.println("check sign: " + UnifiedRsaUtils.verifyWithPubKey(message, signature, PUBLIC_KEY));
    }

}
