package com.gupao.pattern.singleton.enumsingleton;

import java.io.*;

/**
 * Created by Yan on 2019/3/11.
 */
public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton enumSingleton=null;
        EnumSingleton writeEnumSingleton=EnumSingleton.getInstance();
        try {
            FileOutputStream outputStream=new FileOutputStream("EnumSingleton.obj");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(writeEnumSingleton);
            objectOutputStream.flush();

            FileInputStream inputStream=new FileInputStream("EnumSingleton.obj");
            ObjectInputStream in=new ObjectInputStream(inputStream);
            enumSingleton= (EnumSingleton) in.readObject();
            System.out.println(enumSingleton);
            System.out.println(writeEnumSingleton);
            System.out.println(enumSingleton==writeEnumSingleton);
            in.close();
            /*
            *
            SINGLETON
            SINGLETON
            true

            */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
