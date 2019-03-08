package factory.abstractfactory.tom.factory.vo;

/**
 * Created by Yan on 2019/3/7.
 */
public class PythonSource implements ISource {
    @Override
    public void getSource() {
        System.out.println("python source");
    }
}
