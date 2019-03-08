package factory.abstractfactory.tom.factory.abstractfactory;


import factory.abstractfactory.tom.factory.vo.*;

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
