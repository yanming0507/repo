package factory.abstractfactory.yanming.factory.simple;

import factory.abstractfactory.yanming.factory.vo.Fruit;
import factory.abstractfactory.yanming.factory.vo.IFood;
import factory.abstractfactory.yanming.factory.vo.Rice;
import factory.abstractfactory.yanming.factory.vo.Vegetables;

/**
 * Created by Yan on 2019/3/8.
 */
public class SimpleTest {
    public static void main(String[] args) {
        IFood food=new Rice();
        food.create();
        IFood food1=new Vegetables();
        food1.create();
        IFood food2=new Fruit();
        food2.create();
    }
}
