package com.gupao.pattern.singleton.serializablesingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Yan on 2019/3/11.
 */
public class SerializableSingletonTest {
    public static void main(String[] args) {
        SerializableSingleton readSerializableSingleton = null;
        SerializableSingleton writeSerializableSingleton = SerializableSingleton.getInstance();
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("SeralizableSingleton.obj");
            ObjectOutputStream outputStream=new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(writeSerializableSingleton);
            outputStream.flush();
            outputStream.close();
            FileInputStream fileInputStream=new FileInputStream("SeralizableSingleton.obj");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            readSerializableSingleton= (SerializableSingleton) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println(readSerializableSingleton);
            System.out.println(writeSerializableSingleton);
            System.out.println(writeSerializableSingleton==readSerializableSingleton    );
            /*
            com.gupao.pattern.singleton.serializablesingleton.SerializableSingleton@58372a00
            com.gupao.pattern.singleton.serializablesingleton.SerializableSingleton@14ae5a5
            false
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
