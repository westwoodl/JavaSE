package com.xu.day27__JAVA;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * java动态代理
 *
 * @see java.lang.reflect.Proxy
 */
public class Demo2_动态代理 {

    @Test
    public void test() {
        UserImp ui = new UserImp();

        ClassLoader c = ui.getClass().getClassLoader();

        User user = (User) Proxy.newProxyInstance(
                ui.getClass().getClassLoader(),
                ui.getClass().getInterfaces(),
                new MyInvocationHandler(ui));

        user.add();
        user.delete();
    }

    class MyInvocationHandler implements InvocationHandler {
        private Object target;

        /**
         * @param target 接收被代理的对象
         */
        public MyInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("权限校验");
            method.invoke(target, args);
            System.out.println("日志记录");
            return null;
        }
    }

    interface User {
        public void add();

        public void delete();
    }

    /**
     * 被代理类
     */
    class UserImp implements User {

        @Override
        public void add() {
            System.out.println("ADD!");
        }

        @Override
        public void delete() {
            System.out.println("DELETE");
        }
    }
}
