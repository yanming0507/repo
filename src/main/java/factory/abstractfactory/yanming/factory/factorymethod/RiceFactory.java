package factory.abstractfactory.yanming.factory.factorymethod;

import factory.abstractfactory.yanming.factory.vo.IFood;
import factory.abstractfactory.yanming.factory.vo.Rice;

/**
 * Created by Yan on 2019/3/8.
 */
public class RiceFactory implements IFactory {
    @Override
    public IFood create() {
        return new Rice();
    }
}
