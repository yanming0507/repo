package com.gupao.pattern.decorator.v2;

/**
 * Created by Yan on 2019/3/19.
 */
public class Test {
    public static void main(String[] args) {
        BatterCake batterCake=new BaseBatterCake();
        System.out.println(batterCake.getMsg()+"价格为="+batterCake.getPrice()+" 元");
        batterCake=new EggDecorator(batterCake);
        System.out.println(batterCake.getMsg()+"价格为="+batterCake.getPrice()+" 元");
        batterCake=new SausageDecorator(batterCake);
        System.out.println(batterCake.getMsg()+"价格为="+batterCake.getPrice()+" 元");
        batterCake=new EggDecorator(batterCake);
        System.out.println(batterCake.getMsg()+"价格为="+batterCake.getPrice()+" 元");
    }
}
