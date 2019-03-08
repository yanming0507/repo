package factory.abstractfactory.yanming.factory.simple;

import factory.abstractfactory.yanming.factory.vo.Fruit;
import factory.abstractfactory.yanming.factory.vo.IFood;
import factory.abstractfactory.yanming.factory.vo.Rice;

/**
 * Created by Yan on 2019/3/8.
 * 该测试类相当于客户端，客户端想要得到对应的食物则需要传入对应的字符串,不易于使用
 */
public class SimpleFactoryTest {
    /*public static void main(String[] args) {
        SimpleFactory factory=new SimpleFactory();
        IFood food=factory.create("fruit");
        food.create();
        IFood food1=factory.create("rice");
        food1.create();
        IFood food2=factory.create("banana");
        //此时由于无法生产该类水果，则会返回null，发生异常。
        // 为了支持该类型食物，进行扩展时需要修改简单工厂的代码逻辑
        food2.create();
    }*/
    /* //完整类名称不易记忆，更容易出错
    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        *//*
        正常
        IFood food = factory.createByType("factory.abstractfactory.yanming.factory.vo.Fruit");
        food.create();*//*
        //完整类名称没写正确
        IFood food1 = factory.createByType("factory.abstractfactory.yanming.factory.vo.Fruits");
        //发生异常
        food1.create();
    }*/
    //依然需要客户端传入参数，一旦客户端未记住参数，则会导致使用不当
    public static void main(String[] args) {
        SimpleFactory factory=new SimpleFactory();
        IFood food=factory.createFood(Fruit.class);
        food.create();
        IFood food1=factory.createFood(Rice.class);
        food1.create();
    }
}
