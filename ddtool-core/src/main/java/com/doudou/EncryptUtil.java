package com.doudou;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: EncryptUtil
 * @Author: doudou
 * @Datetime: 2019/7/11-17:33
 * @Description: 加密工具类
 */
public class EncryptUtil {
    private EncryptUtil(){}

    private static final String MD5 = "MD5";
    private static final String SHA256 = "SHA-256";

    /**
     * 用于建立十六进制字符的输出的小写字符数组
     */
    private static final char[] DIGITS_LOWER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };


    /**
     * @Author doudou
     * @Date 9:47 2019/7/23
     * @Description 根据入参的加密类型，进行MD5加密，生成16进制md5字符串或者SHA256加密，生成16进制sha256字符串
     **/
    public static String encrypt(String sourceStr, String encryptType) {
        try {
            MessageDigest md = MessageDigest.getInstance(encryptType);
            md.update(sourceStr.getBytes(Charset.forName("utf-8")));
            return byteToHexString(md.digest(), DIGITS_LOWER);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**     * @Author doudou
     * @Date 10:50 2019/7/23
     * @Description 将字节数组转换成16进制字符串
     **/
    private static String byteToHexString(byte[] bytes, char[] digits) {
        final int length = bytes.length;
        char[] out = new char[length << 1];
        for (int i=0,j=0; i<bytes.length; i++) {
            out[j++] = digits[0xf0 & bytes[i] >>> 4];//高位补0
            out[j++] = digits[0x0f & bytes[i]];//低位
        }
        return new String(out);
    }

}
