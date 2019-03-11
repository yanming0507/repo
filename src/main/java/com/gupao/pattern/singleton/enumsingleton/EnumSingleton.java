package com.gupao.pattern.singleton.enumsingleton;

/**
 * Created by Yan on 2019/3/11.
 */
public enum  EnumSingleton {
    SINGLETON;
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public static EnumSingleton getInstance(){
        return SINGLETON;
    }
}
