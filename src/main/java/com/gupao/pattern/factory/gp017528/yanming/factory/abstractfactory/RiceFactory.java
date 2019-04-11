package com.gupao.pattern.factory.gp017528.yanming.factory.abstractfactory;

import com.gupao.pattern.factory.gp017528.yanming.factory.vo.AcidRice;
import com.gupao.pattern.factory.gp017528.yanming.factory.vo.IFood;
import com.gupao.pattern.factory.gp017528.yanming.factory.vo.SweetRice;

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
