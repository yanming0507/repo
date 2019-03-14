package com.gupao.pattern.proxy.dynamicproxy.imitateproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by Yan on 2019/3/13.
 */
public class YanMingProxy {
    public static final String ln = "\r\n";

    public static Object newInstance(YanMingClassLoader classLoader, Class<?>[] interfaces, YanMingInvocationHandler h) {
        try {
            //1、生成java源文件
            String javaSourceFile = generateJavaSourceFile(interfaces);
            //2 java 文件输出到磁盘
            String filePath = YanMingProxy.class.getResource("").getPath();
            System.out.println("生成的文件路径=" + filePath);
            File file = new File(filePath + "$Proxy0.java");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(javaSourceFile);
            fileWriter.flush();
            fileWriter.close();

            // 3 把java文件编译成class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // 4 把编译的class文件加载到jvm中
            Class proxyClazz = classLoader.findClass("$Proxy0");
            Constructor constructor = proxyClazz.getConstructor(YanMingInvocationHandler.class);
            file.delete();
            // 5返回字节码重组之后的代理对象
            return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateJavaSourceFile(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        sb.append("package com.gupao.pattern.proxy.dynamicproxy.imitateproxy;" + ln);
        sb.append("import com.gupao.pattern.proxy.staticproxy.Person;" + ln);
        sb.append("import java.lang.reflect.Method;" + ln);
        sb.append("import java.lang.reflect.Proxy;" + ln);
        sb.append("import java.lang.reflect.UndeclaredThrowableException;" + ln);
        StringBuilder stringBuilder = new StringBuilder();
        int size = interfaces.length;
        for (int n = 0; n < size; n++) {
            stringBuilder.append(interfaces[n].getName());
            if (n != size - 1) {
                stringBuilder.append(", ");
            }
        }
        sb.append("public  class $Proxy0  implements " + stringBuilder.toString()).append(" {" + ln);
        sb.append(" YanMingInvocationHandler h;" + ln);
        sb.append("public $Proxy0 ( YanMingInvocationHandler h ) { " + ln);
        sb.append("this.h=h;" );
        sb.append("}" + ln);
        for (Class clazz : interfaces) {
            for (Method method : clazz.getMethods()) {
                sb.append("public ").append(" final ")
                        .append(method.getReturnType().getName()+" ")
                        .append(method.getName()).append("(){" + ln);
                sb.append("try {" + ln);
                sb.append("Method m= ").append(clazz.getName()).append(".class.getMethod(\"" + method.getName() + "\",new Class[]{});" + ln);
                sb.append("this.h.invoke(this,m,null);" + ln);
                sb.append("}catch(Exception e){" + ln);
                sb.append("e.printStackTrace();" + ln);
                sb.append("}catch(Throwable throwable){" + ln);
                sb.append("throw new UndeclaredThrowableException(throwable);" + ln);
                sb.append("}" + ln);
            }
        }
        sb.append("}" + ln);
        sb.append("}" + ln);
        System.out.println(sb.toString());
        return sb.toString();
    }

}
