package com.gupao.pattern.singleton.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Yan on 2019/3/11.
 */
public class ContainerSingleton {
    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getObject(String name) {
        synchronized (ioc){//此处不加关键字会出现问题，为了安全只好牺牲性能
            if (!ioc.containsKey(name)) {
                Object object = null;
                try {
                    object = Class.forName(name).newInstance();
                    ioc.put(name, object);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return object;
            } else {
                return ioc.get(name);
            }
        }}
}
