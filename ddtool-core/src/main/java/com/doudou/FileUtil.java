package com.doudou;

import java.io.File;

/**
 * @ClassName: FileUtil
 * @Author: doudou
 * @Datetime: 2019/6/27-17:59
 * @Description: 文件处理类
 */
public class FileUtil {

    private FileUtil(){}

    /**
     * @Author doudou
     * @Date 18:02 2019/6/27
     * @Description 判断目录或者文件是否为空
     **/
    public static boolean isEmptyFile(File file) {
        if (file == null) return true;
        if (file.isDirectory()) {
            String[] var1 = file.list();
            if (var1 == null || var1.length == 0) return true;
        } else if (file.isFile()) {
            return file.length() <= 0;
        }
        return false;
    }

}