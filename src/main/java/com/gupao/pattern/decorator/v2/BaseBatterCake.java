package com.gupao.pattern.decorator.v2;

/**
 * Created by Yan on 2019/3/19.
 */
public class BaseBatterCake extends BatterCake {
    @Override
    protected String getMsg() {
        return "一个煎饼";
    }


    @Override
    protected int getPrice() {
        return 5;
    }
}
