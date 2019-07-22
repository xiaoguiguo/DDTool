package com.doudou.tool;

/**
 * @ClassName: Hex
 * @Author: doudou
 * @Datetime: 2019/7/22-17:47
 * @Description: 16进制类
 */
public class Hex {

    /**
     * 用于建立十六进制字符的输出的小写字符数组
     */
    private static final char[] DIGITS_LOWER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    /**
     * @Author doudou
     * @Date 17:52 2019/7/22
     * @Description 将字节数组转换为16进制字符数组
     **/
    public static String encodeHexStr(byte[] digest) {
        final int length = digest.length;
        final char[] out = new char[length << 1];
        for (int i = 0, j = 0; i < length; i++) {
            out[j++] = DIGITS_LOWER[(0xF0 & digest[i]) >>> 4];// 高位
            out[j++] = DIGITS_LOWER[0x0F & digest[i]];// 低位
        }
        return out.toString();
    }
}
