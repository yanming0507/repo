package factory.abstractfactory.yanming.factory.abstractfactory;

import factory.abstractfactory.yanming.factory.vo.IFood;
import factory.abstractfactory.yanming.factory.vo.Lemon;
import factory.abstractfactory.yanming.factory.vo.Watermelon;

/**
 * Created by Yan on 2019/3/8.
 */
public class FruitFactory implements AbstractFoodFactory {
    @Override
    public IFood createSweetFood() {
        return new Watermelon();
    }

    @Override
    public IFood createAcidFood() {
        return new Lemon();
    }


}
