package com.gupao.pattern.singleton.serializablesingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Yan on 2019/3/11.
 */
public class SafeSerializableSingletonTest {
    public static void main(String[] args) {
        SafeSerializableSingleton readSerializableSingleton = null;
        SafeSerializableSingleton writeSerializableSingleton = SafeSerializableSingleton.getInstance();
        System.out.println(writeSerializableSingleton);
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("SeralizableSingleton.obj");
            ObjectOutputStream outputStream=new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(writeSerializableSingleton);
            outputStream.flush();
            outputStream.close();
            FileInputStream fileInputStream=new FileInputStream("SeralizableSingleton.obj");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            //此处迫坏了单例，底层调用了newInstance方法，只是没有没回新的实例，依然会浪费内存。
            // readObject->readObject0->readOrdinaryObject-->obj = desc.isInstantiable() ? desc.newInstance() : null;
            readSerializableSingleton= (SafeSerializableSingleton) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println(readSerializableSingleton);
            System.out.println(writeSerializableSingleton);
            System.out.println(writeSerializableSingleton==readSerializableSingleton    );
            /*
            com.gupao.pattern.singleton.serializablesingleton.SafeSerializableSingleton@14ae5a5
            com.gupao.pattern.singleton.serializablesingleton.SafeSerializableSingleton@14ae5a5
            true
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
