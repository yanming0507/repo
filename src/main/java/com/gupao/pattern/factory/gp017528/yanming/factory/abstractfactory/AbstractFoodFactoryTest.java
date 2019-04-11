package com.gupao.pattern.factory.gp017528.yanming.factory.abstractfactory;

import com.gupao.pattern.factory.gp017528.yanming.factory.vo.IFood;

/**
 * Created by Yan on 2019/3/8.
 */
public class AbstractFoodFactoryTest {
    public static void main(String[] args) {
        AbstractFoodFactory factory = new FruitFactory();
        IFood food = factory.createAcidFood();
        food.create();
        AbstractFoodFactory factory1=new RiceFactory();
        IFood food1=factory1.createSweetFood();
        food1.create();
        AbstractFoodFactory factory2=new VegetablesFactory();
        IFood food2=factory2.createSweetFood();
        food2.create();
        //当需要提供一种辣的食物时，这三个工厂都需要提供对应的方法实现

    }
}
