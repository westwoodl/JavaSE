package com.mianshi;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xu rongchao
 * @date 2020-12-02 14:00
 */
public class ClassLoadDemo {

    /**
     * 类的隔离加载
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(Thread.currentThread().getContextClassLoader());
        Thread.currentThread().setContextClassLoader(new MyClassLoaderCustom(ClassLoader.getSystemClassLoader().getParent()));
        System.out.println(Thread.currentThread().getContextClassLoader());
        new Thread(()-> {
            System.out.println(Thread.currentThread().getContextClassLoader());
        }).start();
    }


    static class MyClassLoaderCustom extends ClassLoader {

        private ClassLoader jdkClassLoader;

        private Map<String, String> classPathMap = new HashMap<>();

        public MyClassLoaderCustom(ClassLoader jdkClassLoader) {
            this.jdkClassLoader = jdkClassLoader;
            classPathMap.put("com.java.loader.TestA", "/Users/hansong/IdeaProjects/OhMyJava/CodeRepository/target/classes/com/java/loader/TestA.class");
            classPathMap.put("com.java.loader.TestB", "/Users/hansong/IdeaProjects/OhMyJava/CodeRepository/target/classes/com/java/loader/TestB.class");
        }

        @Override
        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            Class result = null;
            try {
                //这里要使用 JDK 的类加载器加载 java.lang 包里面的类
                result = jdkClassLoader.loadClass(name);
            } catch (Exception e) {
                //忽略
            }
            if (result != null) {
                return result;
            }
            String classPath = classPathMap.get(name);
            File file = new File(classPath);
            if (!file.exists()) {
                throw new ClassNotFoundException();
            }

            byte[] classBytes = getClassData(file);
            if (classBytes == null || classBytes.length == 0) {
                throw new ClassNotFoundException();
            }
            return defineClass(classBytes, 0, classBytes.length);
        }

        private byte[] getClassData(File file) {
            return null;
        }
    }
}
