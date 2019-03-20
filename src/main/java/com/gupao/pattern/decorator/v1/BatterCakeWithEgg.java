package com.gupao.pattern.decorator.v1;

/**
 * Created by Yan on 2019/3/19.
 */
public class BatterCakeWithEgg extends BatterCake {
    protected  String getMsg(){
        return super.getMsg()+"加一个鸡蛋";
    }
    public int getPrice(){
        return super.getPrice()+1;
    }
}
