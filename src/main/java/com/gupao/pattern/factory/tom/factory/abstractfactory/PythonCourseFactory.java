package com.gupao.pattern.factory.tom.factory.abstractfactory;


import com.gupao.pattern.factory.tom.factory.vo.*;

/**
 * Created by Yan on 2019/3/7.
 */
public class PythonCourseFactory extends AbstractCourseFactory {
    @Override
    IVideo createVideo() {
        return new PythonVideo();
    }

    @Override
    INode createNode() {
        return new PythonNode();
    }

    @Override
    ISource createSource() {
        return new PythonSource();
    }
}
