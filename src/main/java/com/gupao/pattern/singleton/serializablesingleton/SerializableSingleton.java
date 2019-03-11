package com.gupao.pattern.singleton.serializablesingleton;

import java.io.Serializable;

/**
 * Created by Yan on 2019/3/11.
 */
public class SerializableSingleton implements Serializable {
    private  static final SerializableSingleton SINGLETON=new SerializableSingleton();
    private SerializableSingleton(){}
    public static SerializableSingleton getInstance(){
        return SINGLETON;
    }
}
