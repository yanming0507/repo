package factory.abstractfactory.tom.factory.simple;


import factory.abstractfactory.tom.factory.vo.ICourse;
import factory.abstractfactory.tom.factory.vo.JavaCourse;
import factory.abstractfactory.tom.factory.vo.PythonCourse;

/**
 * Created by Yan on 2019/3/6.
 */
public class SimpleTest {
    public static void main(String[] args) {

    ICourse course=new JavaCourse();
    course.record();
    ICourse course1=new PythonCourse();
    course1.record();
    /*
    简单工厂需要自己维护实体类，需要什么样的课程必须自己new，同时调用对应类提供的方法，
    一旦参数出现错误则无法正确使用对应类的方法。
    * */
}
    }
