package factory.abstractfactory.tom.factory.abstractfactory;


import factory.abstractfactory.tom.factory.vo.*;

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
