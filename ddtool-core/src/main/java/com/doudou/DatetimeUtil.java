package com.doudou;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName: DatetimeUtil
 * @Author: doudou
 * @Datetime: 2019/6/26-11:37
 * @Description: 时间处理类 jdk8+
 */
public class DatetimeUtil {
    private DatetimeUtil(){}

    public final static String SIMPLE_PATTERN_HHMMSS = "HHmmss";
    public final static String SIMPLE_PATTERN_COMMON_HHMMSS = "HH:mm:ss";
    public final static String SIMPLE_PATTERN_YYYYMMDD = "yyyyMMdd";
    public final static String SIMPLE_PATTERN_COMMON_YYYYMMDD = "yyyy-MM-dd";
    public final static String SIMPLE_PATTERN_COMMON_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";

    /**
     * @Author doudou
     * @Date 12:54 2019/6/27
     * @Description 获取当前时间格式为HHmmss的时间字符串
     **/
    public static String getHHMMSS() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern(SIMPLE_PATTERN_HHMMSS));
    }

    /**
     * @Author doudou
     * @Date 17:52 2019/6/26
     * @Description 获取传入时间格式为HHmmss的时间字符串
     **/
    public static String getHHMMSS(LocalTime var1) {
        return var1.format(DateTimeFormatter.ofPattern(SIMPLE_PATTERN_HHMMSS));
    }

    /**
     * @Author doudou
     * @Date 18:32 2019/6/26
     * @Description 获取当前时间格式为HH:mm:ss的时间字符串
     **/
    public static String getCommonHHMMSS() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern(SIMPLE_PATTERN_COMMON_HHMMSS));
    }

    /**
     * @Author doudou
     * @Date 18:23 2019/6/26
     * @Description 获取传入时间格式为HH:mm:ss的时间字符串
     **/
    public static String getCommonHHMMSS(LocalTime val) {
        return val.format(DateTimeFormatter.ofPattern(SIMPLE_PATTERN_COMMON_HHMMSS));
    }

    /**
     * @Author doudou
     * @Date 15:03 2019/6/26
     * @Description 获取当前日期格式为yyyyMMdd的日期字符串
     **/
    public static String getYYYYMMDD() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(SIMPLE_PATTERN_YYYYMMDD));
    }

    /**
     * @Author doudou
     * @Date 15:09 2019/6/26
     * @Description 获取传入日期格式为yyyyMMdd的日期字符串
     **/
    public static String getYYYYMMDD(LocalDate val) {
        return val.format(DateTimeFormatter.ofPattern(SIMPLE_PATTERN_YYYYMMDD));
    }

    /**
     * @Author doudou
     * @Date 13:04 2019/6/27
     * @Description 获取当前日期格式为yyyy-MM-dd的日期字符串
     **/
    public static String getCommonYYYYMMDD() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(SIMPLE_PATTERN_COMMON_YYYYMMDD));
    }

    /**
     * @Author doudou
     * @Date 13:06 2019/6/27
     * @Description 获取传入日期格式为yyyy-MM-dd的日期字符串
     **/
    public static String getCommonYYYYMMDD(LocalDate var1) {
        return var1.format(DateTimeFormatter.ofPattern(SIMPLE_PATTERN_COMMON_YYYYMMDD));
    }

    /**
     * @Author doudou
     * @Date 13:10 2019/6/27
     * @Description 获取当前日期时间格式为yyyy-MM-dd HH:mm:ss的字符串
     **/
    public static String getYYYYMMDDHHMMSS() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(SIMPLE_PATTERN_COMMON_YYYYMMDD_HHMMSS));
    }

    /**
     * @Author doudou
     * @Date 13:11 2019/6/27
     * @Description 获取传入日期时间格式为yyyy-MM-dd HH:mm:ss的字符串
     **/
    public static String getYYYYMMDDHHMMSS(LocalDateTime var1) {
        return var1.format(DateTimeFormatter.ofPattern(SIMPLE_PATTERN_COMMON_YYYYMMDD_HHMMSS));
    }

}