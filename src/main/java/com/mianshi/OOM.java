package com.mianshi;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xu rongchao
 * @date 2021/1/3 23:42
 */
public class OOM {

    /**
     * 1. stack over flow
     * 2. oom: Java heap space
     * 3. oom: GC overhead limit exceeded
     * 4. oom: Direct buffer memory
     * 5. oom: unable to create new native thread
     * 6. oom: Metaspace
     * @param args
     */
    public static void main(String[] args) {
/*2
        byte[] x = new byte[7 * 1024 * 1024];
        System.out.println("1");
 */

/*3        int i = 0;
        List<String> s = new ArrayList<>();
        try {
            while (true) {
                s.add(String.valueOf(i++));
                System.err.println(i);
            }
        } finally {
        }
 */
/*5        while (true) {
            new Thread(()-> {
                while (true) {

                }
            }).start();

        }
 */
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OOM.class);
        enhancer.setUseCache(false);
        enhancer.setCallback(new MethodInterceptor() {

            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("1");
                return methodProxy.invokeSuper(o, objects);
            }
        });
        OOM o = (OOM)enhancer.create();
        o.s();

        Enhancer enhancer2 = new Enhancer();
        enhancer2.setSuperclass(OOM.class);
        enhancer2.setUseCache(false);
        enhancer2.setCallback(new InvocationHandler() {

            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("invoke");

                return method.invoke(o, objects);
            }

        });
        OOM o2 = (OOM)enhancer2.create();
        o2.s();

    }


    public void s() {
        System.err.println("s");
    }
}
