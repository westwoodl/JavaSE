package com.xu.day22__;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 配置文件的读取和修改{@link #test2()}
 *
 * 继承自Hashtable（虽然Hashtable没用，但是有个争气的儿子）
 * 为什么不加泛型：只能是String类型
 *
 * {@link #test()}
 * 使用propertyNames()将Properties的key转换为枚举类型，达到迭代的效果（和Hashtable一样）
 *
 * @see java.util.Properties
 */
public class Demo8_Properties {

    @Test
    public void test2() throws IOException {
        Properties prop = new Properties();

        prop.load(new FileReader("file.properties"));
        System.out.println(prop);

        prop.setProperty("qq", "22222");
        //""为对此次修改的描述
        prop.store(new FileOutputStream("file.properties"), "修改了qq");
        System.out.println(prop);
    }

    @Test
    public void test() {
        Properties prop = new Properties();
        prop.put("xu", "100");
        prop.put("xx", "200");
        prop.put("xo", "300");

        Enumeration<String> e = (Enumeration<String>) prop.propertyNames();
        while (e.hasMoreElements()) {
            String key = e.nextElement();
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }

        System.out.println(prop);

    }
}
