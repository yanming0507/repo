package com.gupao.pattern.proxy.dynamicproxy.cglibproxy;

import com.gupao.pattern.proxy.staticproxy.Person;

/**
 * Created by Yan on 2019/3/13.
 */
public class Customer implements Person {
    @Override
    public void findLove() {
        System.out.println("儿子准备找对象。。。");
        System.out.println("    白富美。。。");
        System.out.println("    大长腿。。。");
    }
}
