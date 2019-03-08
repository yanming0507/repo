package factory.abstractfactory.gp017528.yanming.factory.factorymethod;

import factory.abstractfactory.gp017528.yanming.factory.vo.IFood;
import factory.abstractfactory.gp017528.yanming.factory.vo.Fruit;

/**
 * Created by Yan on 2019/3/8.
 */
public class FruitFactory implements IFactory {
    @Override
    public IFood create() {
        return new Fruit();
    }
}
