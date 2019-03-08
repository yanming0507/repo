package factory.abstractfactory.yanming.factory.vo;

/**
 * Created by Yan on 2019/3/8.
 */
public class Fruit implements IFood {
    @Override
    public void create() {
        System.out.println(" create an apple");
    }
}
