package com.doudou.tool;

import com.doudou.StringUtil;

import java.nio.charset.Charset;

/**
 * @ClassName: MD5
 * @Author: doudou
 * @Datetime: 2019/7/22-17:20
 * @Description: TODO
 */
public class MD5 {

    public static final String CHARSET_UTF8 = "UTF-8";

    public static String digestHex(String data) {
        return Hex.encodeHexStr(digest(StringUtil.bytes(data, Charset.forName(CHARSET_UTF8))));
    }

    private static byte[] digest(byte[] bytes) {
        //加盐 TODO
        return bytes;
    }


}
