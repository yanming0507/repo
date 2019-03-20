package com.gupao.pattern.decorator.v2;

/**
 * Created by Yan on 2019/3/19.
 */
public class EggDecorator extends  BatterCakeDecorator{
    public EggDecorator(BatterCake batterCake) {
        super(batterCake);
    }
    protected  void doSomething(){

    }

    @Override
    protected String getMsg() {
        return super.getMsg()+"加一个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+1;
    }
}
