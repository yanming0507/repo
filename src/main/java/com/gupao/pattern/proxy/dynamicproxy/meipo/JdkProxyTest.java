package com.gupao.pattern.proxy.dynamicproxy.meipo;

import com.gupao.pattern.proxy.staticproxy.Person;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Yan on 2019/3/13.
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        Person person= (Person) new JDKMeiPo().getInstance(new Customer());
        try {
            byte[]bytes= ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
            FileOutputStream fileOutputStream=new FileOutputStream("E://$Proxy0.class");
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        person.findLove();
    }
}
