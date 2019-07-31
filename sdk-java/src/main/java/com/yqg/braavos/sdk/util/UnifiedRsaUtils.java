package com.yqg.braavos.sdk.util;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 *
 * 生成密钥对: ssh-keygen -m PEM -t rsa -b 4096 -f id_rsa
 * 进行PKCS#8编码：openssl pkcs8 -topk8 -inform PEM -in id_rsa -outform pem -nocrypt -out private_key.pem
 * 根据私钥生成公钥：openssl rsa -in private_key.pem -pubout -out public_key.pem
 *
 * 得到私钥文件  private_key.pem
 * 得到公钥文件  public_key.pem
 *
 */
public class UnifiedRsaUtils {

    private static final String RSA_ALGORITHM = "RSA";

    private static final String DEFAULT_ENCODING = "UTF-8";

    private static final String DEFAULT_SIGN_ALGORITHM = "SHA256withRSA";

    public static boolean verifyWithPubKey(String plainText, String signature, String publicKeyStr) {
        try {
            Signature publicSignature = Signature.getInstance(DEFAULT_SIGN_ALGORITHM);
            publicSignature.initVerify(loadRsaPublicKey(publicKeyStr));
            publicSignature.update(plainText.getBytes(DEFAULT_ENCODING));
            byte[] signatureBytes = Base64.getDecoder().decode(signature);
            return publicSignature.verify(signatureBytes);
        } catch (Exception e) {
            throw new RuntimeException("rsa verify error", e);
        }
    }

    public static String signWithPriKey(String plainText, String privateKeyStr) {

        try {
            Signature privateSignature = Signature.getInstance(DEFAULT_SIGN_ALGORITHM);
            privateSignature.initSign(loadRsaPrivateKey(privateKeyStr));
            privateSignature.update(plainText.getBytes(DEFAULT_ENCODING));
            byte[] signature = privateSignature.sign();
            return Base64.getEncoder().encodeToString(signature);

        } catch (Exception e) {
            throw new RuntimeException("rsa sign error", e);
        }
    }

    private static RSAPrivateKey loadRsaPrivateKey(String priKeyText) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = Base64.getDecoder().decode(priKeyText);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        return (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
    }


    private static RSAPublicKey loadRsaPublicKey(String pubKeyText) throws InvalidKeySpecException, NoSuchAlgorithmException {
        byte[] keyBytes = Base64.getMimeDecoder().decode(pubKeyText);
        KeyFactory kf = KeyFactory.getInstance(RSA_ALGORITHM);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        return (RSAPublicKey) kf.generatePublic(keySpec);
    }

}
