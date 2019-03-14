package com.gupao.pattern.proxy.dynamicproxy.meipo;

import com.gupao.pattern.proxy.staticproxy.Person;

/**
 * Created by Yan on 2019/3/12.
 */
public class Test {
    public static void main(String[] args) {
        Person person=(Person) new JDKMeiPo().getInstance(new Customer());
        System.out.println(person);
        person.findLove();

    }
}
