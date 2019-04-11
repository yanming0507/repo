package com.gupao.pattern.factory.tom.factory.factorymethod;


import com.gupao.pattern.factory.tom.factory.vo.ICourse;
import com.gupao.pattern.factory.tom.factory.vo.PythonCourse;

/**
 * Created by Yan on 2019/3/7.
 */
public class PythonCourseFactory implements IFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
