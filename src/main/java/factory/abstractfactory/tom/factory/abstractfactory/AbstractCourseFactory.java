package factory.abstractfactory.tom.factory.abstractfactory;


import factory.abstractfactory.tom.factory.vo.INode;
import factory.abstractfactory.tom.factory.vo.ISource;
import factory.abstractfactory.tom.factory.vo.IVideo;

/**
 * Created by Yan on 2019/3/7.
 */
public abstract class AbstractCourseFactory {
    abstract IVideo createVideo();
    abstract INode createNode();
    abstract ISource createSource();
}
