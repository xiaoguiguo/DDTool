package com.doudou;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

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



    /**
     * 生成含有随机盐的密码
     */
    public static String generate(String password) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }
    /**
     * 校验密码是否正确
     */
    public static boolean verify(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(new String(cs1));
    }
    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        // 加密+加盐
        String password1 = generate("admin");
        System.out.println("结果：" + password1 + "   长度："+ password1.length());
        // 解码
        System.out.println(verify("admin", password1));
        // 加密+加盐
        String password2= generate("admin");
        System.out.println("结果：" + password2 + "   长度："+ password2.length());
        // 解码
        System.out.println(verify("admin", password2));
    }

}
