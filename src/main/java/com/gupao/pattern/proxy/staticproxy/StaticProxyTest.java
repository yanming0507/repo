package com.gupao.pattern.proxy.staticproxy;

/**
 * Created by Yan on 2019/3/12.
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        Son son=new Son();
        Father father=new Father(son);
        father.findLove();
    }
}
