package com.chen.util;

import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NotNullHelps {

    /** Object  **/
    public static boolean isNotNull(Object object) {
        boolean flag = false ;
        if (object != null) {
            flag = true ;
        }
        return flag;
    }

    /** String **/
    public static boolean isNotNull(String string) {
        boolean flag = false ;
        if (string != null && ("".equals(string.trim()) == false)) {
            flag = true;
        }
        return flag ;
    }

    /** String[]   **/
    public static boolean isNotNull(String[] strs) {
        boolean flag = false ;
        if (strs != null && strs.length > 0) {
            flag = true;
        }
        return flag ;
    }

    /** List **/
    public static boolean isNotNull(List list){
        boolean flag = false ;
        if (list != null && list.size() > 0) {
            flag = true;
        }
        return flag ;
    }

    /** Map **/
    public static boolean isNotNull(Map map){
        boolean flag = false ;
        if (map != null && map.size() > 0) {
            flag = true;
        }
        return flag ;
    }

    /** Set **/
    public static boolean isNotNull(Set set) {
        boolean flag = false ;
        if (set != null && set.size() > 0) {
            flag = true;
        }
        return flag ;
    }

    /** hashTable **/
    public static boolean isNotNull(Hashtable<String, String> hashtable) {
        boolean flag = false ;
        if (hashtable != null && hashtable.size() > 0) {
            flag = true;
        }
        return flag ;
    }

    /** Long **/
    public static boolean isNotNull(Long Id) {
        boolean flag = false ;
        if (null != Id  && 0L != Id ) {
            flag = true;
        }
        return flag ;
    }

    public static boolean isNotNull(Integer Id) {
        boolean flag = false ;
        if (null != Id  && 0 != Id ) {
            flag = true;
        }
        return flag ;
    }


    /**	不定长度参数	**/
    public static boolean checkNotNull(Object...objects){
        boolean flag = true ;
        for(Object object :objects){
            if (null == object) {
                flag = false ;
                break ;
            }
        }
        return flag ;
    }

    /**	不定长度参数	**/
    public static boolean checkNotNull(List...paramList){
        boolean flag = true ;
        for (List list : paramList) {
            flag = isNotNull(list);
            if (flag == false) {
                break;
            }
        }
        return flag ;
    }


    public static boolean isNotNull(Integer...integers){
        boolean flag = true ;
        for(Integer integer : integers){
            if (isNotNull(integer) == false) {
                flag = false ;
                break ;
            }
        }
        return flag ;
    }

    public static boolean isNotNull(Long...longs){
        boolean flag = true ;
        for(Long object : longs){
            if (isNotNull(object) == false) {
                flag = false ;
                break ;
            }
        }
        return flag ;
    }

    /**	不定长度参数	**/
    public static boolean checkHaveNotNull(Object...objects){
        boolean flag = true ;
        for(Object object : objects){
            if (null == object) {
                flag = false ;
                break ;
            }
        }
        return flag ;
    }

    /**	不定长度参数	**/
    public static boolean checkHaveOneNotNull(Object...objects){
        boolean flag = false ;
        for(Object object : objects){
            if (null != object) {
                flag = true ;
                break ;
            }
        }
        return flag ;
    }

    /**	不定长度参数	**/
    public static boolean checkStringsHaveNotNull(String...strings){
        boolean flag = true ;
        for (String string : strings) {
            if (null == string) {
                continue;
            } else {
                if ("".equals(string.trim())) {
                    flag = false;
                    break;
                }
            }
        }
        return flag ;
    }

    /** Object  **/
    public static boolean propertyAllNotNull(Object object) {
        boolean flag = true ;
        if (object != null) {
            Field[] fields = object.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                try {
                    fields[i].setAccessible(true);
                    Object value = fields[i].get(object);
                    if (null == value) {
                        flag = false ;
                        break;
                    }
                    fields[i].setAccessible(false);
                } catch (Exception e) {
                    new RuntimeException(e);
                }
            }
        }
        return flag;
    }

}
