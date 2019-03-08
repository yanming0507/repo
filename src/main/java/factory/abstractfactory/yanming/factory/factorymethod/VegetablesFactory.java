package factory.abstractfactory.yanming.factory.factorymethod;

import factory.abstractfactory.yanming.factory.vo.IFood;
import factory.abstractfactory.yanming.factory.vo.Vegetables;

/**
 * Created by Yan on 2019/3/8.
 */
public class VegetablesFactory implements IFactory {
    public IFood create() {
        return new Vegetables();
    }
}
