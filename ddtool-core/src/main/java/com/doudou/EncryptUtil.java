package com.doudou;

import sun.security.provider.MD5;
import sun.security.rsa.RSASignature;

import static com.doudou.tool.MD5.digestHex;

/**
 * @ClassName: EncryptUtil
 * @Author: doudou
 * @Datetime: 2019/7/11-17:33
 * @Description: 加密工具类
 */
public class EncryptUtil {
    private static final String[] hexDigits = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    public static String md5(String sourceStr) {
        return digestHex(sourceStr);
    }

}
