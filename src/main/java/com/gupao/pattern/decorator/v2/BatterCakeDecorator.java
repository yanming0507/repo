package com.gupao.pattern.decorator.v2;

/**
 * Created by Yan on 2019/3/19.
 */
public class BatterCakeDecorator extends BatterCake{
    private BatterCake batterCake;

    public BatterCakeDecorator(BatterCake batterCake) {
        this.batterCake = batterCake;
    }

    @Override
    protected String getMsg() {
        return this.batterCake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.batterCake.getPrice();
    }

}
