package com.gupao.pattern.decorator.v2;

/**
 * Created by Yan on 2019/3/19.
 */
public class SausageDecorator extends BatterCakeDecorator {
    public SausageDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "加一个香肠";
    }

    protected void doSomething() {
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
