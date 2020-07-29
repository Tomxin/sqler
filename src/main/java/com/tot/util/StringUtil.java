package com.tot.util;

public class StringUtil {
    public static boolean isBlank(String str){
        return str == null || "".equals(str.trim());
    }

    public static boolean isNotBlank(String str){
        return !isBlank(str);
    }
}
