package com.gupao.pattern.proxy.staticproxy.v2;

/**
 * Created by Yan on 2019/3/12.
 */
public class DynamicDataSourceEntry {
    private static final String DATA_SOURCE=null;
    private static final ThreadLocal<String >LOCAL=new ThreadLocal<String>();
    public static void set(String source){
        LOCAL.set(source);
    }
    public static void set(int year){
        LOCAL.set("DB_"+year);
    }
    public  static void clear(){
        LOCAL.remove();
    }
    public static String  get(){
        return LOCAL.get();
    }
    public static void restore(){
        LOCAL.set(DATA_SOURCE);
    }
}
