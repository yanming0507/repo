package com.gupao.pattern.factory.gp017528.yanming.factory.abstractfactory;

import com.gupao.pattern.factory.gp017528.yanming.factory.vo.IFood;
import com.gupao.pattern.factory.gp017528.yanming.factory.vo.Lemon;
import com.gupao.pattern.factory.gp017528.yanming.factory.vo.Watermelon;

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
