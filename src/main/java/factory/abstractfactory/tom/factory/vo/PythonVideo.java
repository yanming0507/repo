package factory.abstractfactory.tom.factory.vo;

/**
 * Created by Yan on 2019/3/7.
 */
public class PythonVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("python video ");
    }
}
