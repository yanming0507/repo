package factory.abstractfactory.yanming.factory.abstractfactory;

import factory.abstractfactory.yanming.factory.vo.AcidVegetables;
import factory.abstractfactory.yanming.factory.vo.IFood;
import factory.abstractfactory.yanming.factory.vo.Pumpkin;

/**
 * Created by Yan on 2019/3/8.
 */
public class VegetablesFactory implements AbstractFoodFactory {
    @Override
    public IFood createSweetFood() {
        return new Pumpkin();
    }

    @Override
    public IFood createAcidFood() {
        return new AcidVegetables();
    }

}
