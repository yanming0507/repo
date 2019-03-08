package factory.abstractfactory.yanming.factory.abstractfactory;

import factory.abstractfactory.yanming.factory.vo.AcidRice;
import factory.abstractfactory.yanming.factory.vo.IFood;
import factory.abstractfactory.yanming.factory.vo.SweetRice;

/**
 * Created by Yan on 2019/3/8.
 */
public class RiceFactory implements AbstractFoodFactory {
    @Override
    public IFood createSweetFood() {
        return new SweetRice();
    }

    @Override
    public IFood createAcidFood() {
        return new AcidRice();
    }


}
