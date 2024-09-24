package com.yqg.braavos.sdk2.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
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
 * 生成密钥对: ssh-keygen -m PEM -t rsa -b 4096 -f id_rsa
 * 进行PKCS#8编码：openssl pkcs8 -topk8 -inform PEM -in id_rsa -outform pem -nocrypt -out private_key.pem
 * 根据私钥生成公钥：openssl rsa -in private_key.pem -pubout -out public_key.pem
 * <p>
 * 得到私钥文件  private_key.pem
 * 得到公钥文件  public_key.pem
 */
public class RsaUtils {
    private RsaUtils() {
    }

    private static final String RSA_ALGORITHM = "RSA";

    private static final String DEFAULT_SIGN_ALGORITHM = "SHA256withRSA";

    private static final String DEFAULT_CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";

    public static boolean verifyWithPubKey(String plainText, String signature, String publicKeyStr) {
        try {
            Signature publicSignature = Signature.getInstance(DEFAULT_SIGN_ALGORITHM);
            publicSignature.initVerify(loadRsaPublicKey(publicKeyStr));
            publicSignature.update(plainText.getBytes(StandardCharsets.UTF_8));
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
            privateSignature.update(plainText.getBytes(StandardCharsets.UTF_8));
            byte[] signature = privateSignature.sign();
            return Base64.getEncoder().encodeToString(signature);

        } catch (Exception e) {
            throw new RuntimeException("rsa sign error", e);
        }
    }

    public static String decryptWithPriKey(String encryptedText, String privateKeyStr) {
        try {
            byte[] bytes = doDecrypt(Base64.getDecoder().decode(encryptedText), loadRsaPrivateKey(privateKeyStr), DEFAULT_CIPHER_ALGORITHM);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("rsa decrypt error", e);
        }
    }

    public static String encryptWithPubKey(String plainText, String publicKeyStr) {

        try {
            byte[] bytes = doEncrypt(plainText.getBytes(), loadRsaPublicKey(publicKeyStr), DEFAULT_CIPHER_ALGORITHM);
            return Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            throw new RuntimeException("rsa encrypt error", e);
        }
    }

    private static byte[] doEncrypt(byte[] data, RSAPublicKey publicKey, String cipherAlgorithm)
        throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        int blockSize = publicKey.getModulus().bitLength() / 8 - 11;
        return cipherFinalWithBlock(cipher, data, blockSize);
    }

    private static byte[] doDecrypt(byte[] data, RSAPrivateKey privateKey, String cipherAlgorithm)
        throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        int blockSize = privateKey.getModulus().bitLength() / 8;
        return cipherFinalWithBlock(cipher, data, blockSize);

    }

    private static byte[] cipherFinalWithBlock(Cipher cipher, byte[] data, int blockSize) throws IOException, BadPaddingException, IllegalBlockSizeException {

        int inputLen = data.length;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            int offSet = 0;
            byte[] cache;
            int i = 0;
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > blockSize) {
                    cache = cipher.doFinal(data, offSet, blockSize);
                } else {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * blockSize;
            }
            return out.toByteArray();
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
