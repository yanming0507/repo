package com.gupao.pattern.proxy.dynamicproxy.cglibproxy;

import com.gupao.pattern.proxy.staticproxy.Person;
import net.sf.cglib.core.DebuggingClassWriter;


/**
 * Created by Yan on 2019/3/13.
 */
public class CglibTest {
    public static void main(String[] args) {
        try {
            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"E://yanming_cglib_proxy_classes");
            Person person = (Customer) new CglibMeiPo().getInstance(Customer.class);
            person.findLove();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
