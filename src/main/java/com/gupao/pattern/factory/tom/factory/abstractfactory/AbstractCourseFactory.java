package com.gupao.pattern.factory.tom.factory.abstractfactory;


import com.gupao.pattern.factory.tom.factory.vo.INode;
import com.gupao.pattern.factory.tom.factory.vo.ISource;
import com.gupao.pattern.factory.tom.factory.vo.IVideo;

/**
 * Created by Yan on 2019/3/7.
 */
public abstract class AbstractCourseFactory {
    abstract IVideo createVideo();
    abstract INode createNode();
    abstract ISource createSource();
}
