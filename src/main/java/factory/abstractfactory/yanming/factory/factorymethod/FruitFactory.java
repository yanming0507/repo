package factory.abstractfactory.yanming.factory.factorymethod;

import factory.abstractfactory.yanming.factory.vo.Fruit;
import factory.abstractfactory.yanming.factory.vo.IFood;

/**
 * Created by Yan on 2019/3/8.
 */
public class FruitFactory implements IFactory {
    @Override
    public IFood create() {
        return new Fruit();
    }
}
