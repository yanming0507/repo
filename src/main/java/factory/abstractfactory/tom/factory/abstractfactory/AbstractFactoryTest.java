package factory.abstractfactory.tom.factory.abstractfactory;

/**
 * Created by Yan on 2019/3/7.
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractCourseFactory javaFactory=new JavaCourseFactory();
        javaFactory.createNode().editNode();
        javaFactory.createVideo().record();
        javaFactory.createSource().getSource();
        AbstractCourseFactory pythonFactory=new PythonCourseFactory();
        pythonFactory.createVideo().record();
        pythonFactory.createNode().editNode();
        pythonFactory.createSource().getSource();
    }
}
