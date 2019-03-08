package factory.abstractfactory.yanming.factory.abstractfactory;

import factory.abstractfactory.yanming.factory.vo.IFood;

/**
 * Created by Yan on 2019/3/8.
 */
public interface AbstractFoodFactory {
    //甜的
    IFood createSweetFood();
    //酸的
    IFood createAcidFood();
}
