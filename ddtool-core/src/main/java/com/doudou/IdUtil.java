package com.doudou;

import java.util.UUID;

/**
 * @ClassName: IdUtil
 * @Author: doudou
 * @Datetime: 2019/8/16-9:24
 * @Description: ID生成器工具类
 */
public class IdUtil {
    
    /**
     * @Author doudou
     * @Description 获取随机UUID
     **/
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }
}
