package com.designpatterns.proxy;


/**
 * @author xu rongchao
 * @date 2020/10/19 20:24
 */
public class ProxyDemo {

    /**
     * 优点： 1、职责清晰。 2、高扩展性。 3、智能化。
     * 缺点： 1、由于在客户端和真实主题之间增加了代理对象，因此有些类型的代理模式可能会造成请求的处理速度变慢。
     * 2、实现代理模式需要额外的工作，有些代理模式的实现非常复杂。
     * 使用场景：按职责来划分，通常有以下使用场景： 1、远程代理。 2、虚拟代理。
     * 3、Copy-on-Write 代理。 4、保护（Protect or Access）代理。
     * 5、Cache代理。 6、防火墙（Firewall）代理。 7、同步化（Synchronization）代理。
     * 8、智能引用（Smart Reference）代理。
     */
    public static void main(String[] args) {
        SomeService someService = new SomeServiceProxy();

        someService.doSome();
    }

    static class SomeServiceProxy implements SomeService {
        RealService realService;

        @Override
        public void doSome() {
            realService.doSome();
        }
    }

    interface SomeService {
        void doSome();
    }

    static class RealService implements SomeService {

        @Override
        public void doSome() {
            System.out.println("do some");
        }
    }


}
