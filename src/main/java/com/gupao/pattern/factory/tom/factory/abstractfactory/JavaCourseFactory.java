package com.gupao.pattern.factory.tom.factory.abstractfactory;


import com.gupao.pattern.factory.tom.factory.vo.*;

/**
 * Created by Yan on 2019/3/7.
 */
public class JavaCourseFactory extends AbstractCourseFactory {
    @Override
    IVideo createVideo() {
        return new JavaVideo();
    }

    @Override
    INode createNode() {
        return new JavaNode();
    }

    @Override
    ISource createSource() {
        return new JavaSource();
    }
}
