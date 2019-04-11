package com.gupao.pattern.factory.gp017528.yanming.factory.abstractfactory;

import com.gupao.pattern.factory.gp017528.yanming.factory.vo.IFood;
import com.gupao.pattern.factory.gp017528.yanming.factory.vo.Pumpkin;
import com.gupao.pattern.factory.gp017528.yanming.factory.vo.AcidVegetables;

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
