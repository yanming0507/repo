package com.gupao.pattern.proxy.staticproxy.v1;

/**
 * Created by Yan on 2019/3/12.
 */
public class DynamicDataSourceEntry {
    private static final String DATA_SOURCE = null;
    private static final ThreadLocal<String> local = new ThreadLocal<String>();

    private DynamicDataSourceEntry() {
    }

    public static void clear() {
        local.remove();
    }

    public static String get() {
        return local.get();
    }

    public static void restore() {
        local.set(DATA_SOURCE);
    }

    public static void set(String source) {
        local.set(source);
    }
    public static void set(int year){
        local.set("DB_"+year);
    }
}
