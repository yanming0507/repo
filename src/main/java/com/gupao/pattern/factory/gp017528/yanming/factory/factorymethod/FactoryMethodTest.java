package com.gupao.pattern.factory.gp017528.yanming.factory.factorymethod;

import com.gupao.pattern.factory.gp017528.yanming.factory.vo.IFood;

/**
 * Created by Yan on 2019/3/8.
 * 客户端使用依然不是很方便，因为客户端需要手动去new指定的工厂才能得到对应的食物，
 * 应该让客户端直接调用
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        IFactory factory=new FruitFactory();
        IFood food=factory.create();
        food.create();
        IFactory factory1=new RiceFactory();
        IFood food1=factory1.create();
        food1.create();
        IFactory factory2=new VegetablesFactory();
        IFood food2=factory2.create();
        food2.create();
    }
}
