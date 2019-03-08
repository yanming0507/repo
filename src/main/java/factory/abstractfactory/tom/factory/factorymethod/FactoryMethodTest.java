package factory.abstractfactory.tom.factory.factorymethod;


import factory.abstractfactory.tom.factory.vo.ICourse;

/**
 * Created by Yan on 2019/3/7.
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        IFactory factory=new JavaCourseFactory();
        ICourse course=factory.create();
        course.record();
        IFactory factory1=new PythonCourseFactory();
        ICourse iCourse=factory1.create();
        iCourse.record();
    }
}
