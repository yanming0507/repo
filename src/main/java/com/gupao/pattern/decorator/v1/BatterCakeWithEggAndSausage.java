package com.gupao.pattern.decorator.v1;

/**
 * Created by Yan on 2019/3/19.
 */
public class BatterCakeWithEggAndSausage extends BatterCakeWithEgg {
    protected String getMsg(){
        return super.getMsg()+" 加一个香肠";
    }
    public int getPrice(){
        return super.getPrice()+2;
    }
}
