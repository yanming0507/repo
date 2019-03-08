package factory.abstractfactory.tom.factory.factorymethod;


import factory.abstractfactory.tom.factory.vo.ICourse;
import factory.abstractfactory.tom.factory.vo.JavaCourse;

/**
 * Created by Yan on 2019/3/7.
 */
public class JavaCourseFactory implements IFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
