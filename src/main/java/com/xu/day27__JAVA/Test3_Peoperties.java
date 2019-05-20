package com.xu.day27__JAVA;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 读取properties文件，并通过反射加载类
 */
public class Test3_Peoperties {
    @Test
    public void test() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("file.properties"));
        String clazzStr = properties.getProperty("class");
        System.out.println(clazzStr);

        //通过反射运行run
        Class clazz = Class.forName(clazzStr);
        Method method = clazz.getMethod("run");
        method.invoke(clazz.newInstance());
    }
}

class Run {
    public void run(){
        System.out.println("runrurnurnunrunnurnunrnn");
    }
}
