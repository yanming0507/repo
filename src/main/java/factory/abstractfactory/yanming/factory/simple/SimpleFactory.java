package factory.abstractfactory.yanming.factory.simple;

import factory.abstractfactory.yanming.factory.vo.Fruit;
import factory.abstractfactory.yanming.factory.vo.IFood;
import factory.abstractfactory.yanming.factory.vo.Rice;
import factory.abstractfactory.yanming.factory.vo.Vegetables;

/**
 * Created by Yan on 2019/3/8.
 *  客户端想要得到对应的食物则需要传入对应的字符串，
 * 一旦字符串记错则发生异常，
 * 进行扩展时也需要重新修改就得工厂逻辑代码
 */
public class SimpleFactory {
    public IFood create(String type){
        if("vegetable".equals(type)){
            return new Vegetables();
        }else if("fruit".equals(type)){
            return new Fruit();
        }else if("rice".equals(type)){
            return new Rice();
        }else{
            return null;
        }
    }
    public IFood createByType(String clazzString){
        if(null!=clazzString && !"".equals(clazzString)){
            try {
                return (IFood)Class.forName(clazzString).newInstance();
            } catch (InstantiationException e) {
                System.out.println("实例化异常");
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                System.out.println("非法进入异常");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("没有找到对应的类异常");
                e.printStackTrace();
            }
        }
            return null;
    }
    public IFood createFood(Class<?extends IFood>clazz){
        if(null!=clazz){
            try {
                return (IFood)clazz.newInstance();
            } catch (InstantiationException e) {
                System.out.println("实例化失败");
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                System.out.println("非法进入");
                e.printStackTrace();
            }
        }
        return null;
    }
}
