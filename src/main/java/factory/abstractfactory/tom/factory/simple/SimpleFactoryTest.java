package factory.abstractfactory.tom.factory.simple;


import factory.abstractfactory.tom.factory.vo.ICourse;
import factory.abstractfactory.tom.factory.vo.PythonCourse;

/**
 * Created by Yan on 2019/3/7.
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        CourseFactory factory=new CourseFactory();
//        ICourse course=factory.create("cn.qcom.hiveview.mediaapi.module.test.gupao.pattern.factory.abstractfactory.tom.factory.vo.JavaCourse");
//        ICourse course=factory.create(JavaCourse.class);
        ICourse course=factory.create(PythonCourse.class);
        course.record();
//        course=factory.create("fafd");
//        course.record();

    }
}
