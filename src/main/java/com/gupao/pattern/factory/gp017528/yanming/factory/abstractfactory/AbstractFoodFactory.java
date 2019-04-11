package com.gupao.pattern.factory.gp017528.yanming.factory.abstractfactory;

import com.gupao.pattern.factory.gp017528.yanming.factory.vo.IFood;

/**
 * Created by Yan on 2019/3/8.
 */
public interface AbstractFoodFactory {
    //甜的
    IFood createSweetFood();
    //酸的
    IFood createAcidFood();
}
