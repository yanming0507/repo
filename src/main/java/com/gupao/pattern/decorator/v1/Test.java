package com.gupao.pattern.decorator.v1;

/**
 * Created by Yan on 2019/3/19.
 */
public class Test {
    public static void main(String[] args) {
        BatterCake cake=new BatterCake();
        System.out.println("购买的煎饼为= "+cake.getMsg()+" 价格为 "+cake.getPrice()+" 元");
        BatterCakeWithEgg batterCakeWithEgg=new BatterCakeWithEgg();
        System.out.println("购买的煎饼为= "+batterCakeWithEgg.getMsg()+" 价格为 "+batterCakeWithEgg.getPrice()+" 元");
        BatterCakeWithSausage batterCakeWithSausage=new BatterCakeWithSausage();
        System.out.println("购买的煎饼为= "+batterCakeWithSausage.getMsg()+" 价格为 "+batterCakeWithSausage.getPrice()+" 元");
        BatterCakeWithEggAndSausage batterCakeWithEggAndSausage=new BatterCakeWithEggAndSausage();
        System.out.println("购买的煎饼为= "+batterCakeWithEggAndSausage.getMsg()+" 价格为 "+batterCakeWithEggAndSausage.getPrice()+" 元");
    }
}
