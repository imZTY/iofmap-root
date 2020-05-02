package com.zhihao.common.util;

/**
 * 类型判断工具类
 * @author tianyi
 * @date 2019-07-03 10:50
 */
public class KindUtil {

    public static boolean isInteger(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static boolean isDouble(String str){
        try{
            Double.parseDouble(str);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
