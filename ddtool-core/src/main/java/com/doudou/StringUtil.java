package com.doudou;

import java.nio.charset.Charset;

/**
 * @ClassName: StringUtil
 * @Author: doudou
 * @Datetime: 2019/6/25 22:47
 * @Description: String Tool Class
 */
public class StringUtil {

    private StringUtil(){}

    /**
     * 检查字符串是否为null，或者为“”，“   ”
     * @param val
     * @return
     */
    public static boolean isEmpty(String val) {
        if (val == null || val.length() == 0) return true;
        for (int i = 0; i < val.length(); i++) {
            if (!Character.isWhitespace(val.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查字符串对象是否为数字
     * @param val
     * @return
     */
    public static boolean isNumber(String val) {
        if (isEmpty(val)) return false;
        char[] var1 = val.toCharArray();
        int length = var1.length;
        if (length < 1) return false;
        int var2 = 0;
        if (length > 1 && var1[0] == '-') var2 = 1;
        for (; var2 < length; var2++) {
            if (!Character.isDigit(var1[var2])) return false;
        }
        return true;
    }

    /**
     * 检查指定的字符串列表是否不为空。
     * @param vals 入参为字符串或字符串数组
     * @return
     */
    public static boolean areNotEmpty(String... vals) {
        boolean var1 = true;
        if (vals == null || vals.length == 0) {
            var1 = false;
        } else {
            for (String var2 : vals) {
                var1 &= !isEmpty(var2);
            }
        }
        return var1;
    }

    /**
     * @Author doudou
     * @Date 17:41 2019/7/22
     * @Description 根据传入的字符串和编码得到字节数组
     **/
    public static byte[] bytes(CharSequence str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (null == charset) {
            return str.toString().getBytes();
        }
        return str.toString().getBytes(charset);
    }

}