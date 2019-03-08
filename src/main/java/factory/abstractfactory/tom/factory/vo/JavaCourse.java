package factory.abstractfactory.tom.factory.vo;

/**
 * Created by Yan on 2019/3/6.
 */
public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("java course");
    }
}
