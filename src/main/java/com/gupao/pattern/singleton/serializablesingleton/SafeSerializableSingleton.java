package com.gupao.pattern.singleton.serializablesingleton;

import java.io.Serializable;

/**
 * Created by Yan on 2019/3/11.
 */
public class SafeSerializableSingleton implements Serializable {
    private  static final SafeSerializableSingleton SINGLETON=new SafeSerializableSingleton();
    private SafeSerializableSingleton(){}
    public static SafeSerializableSingleton getInstance(){
        return SINGLETON;
    }
    private Object readResolve(){
        return SINGLETON;
    }
}
