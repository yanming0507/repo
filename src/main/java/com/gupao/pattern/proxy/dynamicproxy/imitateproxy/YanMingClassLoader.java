package com.gupao.pattern.proxy.dynamicproxy.imitateproxy;

import java.io.*;

/**
 * Created by Yan on 2019/3/13.
 */
public class YanMingClassLoader extends ClassLoader {
    private File classPathFile;

    public YanMingClassLoader() {
        String classPath = YanMingClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    protected Class<?> findClass(String name) {
        String className = YanMingClassLoader.class.getPackage().getName() + "." + name;
        if(classPathFile!=null){
        File classFile = new File(classPathFile, name.replace("\\.", "/") + ".class");
        if (classFile.exists()) {
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(classFile);
                out = new ByteArrayOutputStream();
                byte[] byteBuffer = new byte[1024];
                int len;
                while ((len = in.read(byteBuffer)) != -1) {
                    out.write(byteBuffer, 0, len);
                }
                return defineClass(className, out.toByteArray(), 0, out.size());
            } catch (Exception e) {
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }}
        return null;
    }
}
