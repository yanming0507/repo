package com.gupao.pattern.factory.gp017528.yanming.factory.factorymethod;

import com.gupao.pattern.factory.gp017528.yanming.factory.vo.IFood;
import com.gupao.pattern.factory.gp017528.yanming.factory.vo.Fruit;

/**
 * Created by Yan on 2019/3/8.
 */
public class FruitFactory implements IFactory {
    @Override
    public IFood create() {
        return new Fruit();
    }
}
