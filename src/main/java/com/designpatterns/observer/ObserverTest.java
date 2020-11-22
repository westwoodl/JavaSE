package com.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xu rongchao
 * @date 2020/10/18 18:00
 */
public class ObserverTest {

    /**
     * spring事件驱动 观察者模式
     * 优点：1、观察者和被观察者是抽象耦合的。 2、建立一套触发机制。
     * 缺点：1、如果一个被观察者对象有很多的直接和间接的观察者的话，将所有的观察者都通知到会花费很多时间。
     *     2、如果在观察者和观察目标之间有循环依赖的话，观察目标会触发它们之间进行循环调用，可能导致系统崩溃。
     *     3、观察者模式没有相应的机制让观察者知道所观察的目标对象是怎么发生变化的，而仅仅只是知道观察目标发生了变化。
     *
     * 角色：Subject, Observer, Client
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.registerOb(new AObserver());

        subject.publish();
    }


    interface Observer {
        /**
         * 观察者
         */
        void ob();
    }

    static class AObserver implements Observer {

        @Override
        public void ob() {
            System.out.println("A");
        }
    }

    static class Subject {
        List<Observer> observerList = new ArrayList<>();

        public void registerOb(Observer observer) {
            observerList.add(observer);
        }

        public void publish() {
            multicasAll();
        }

        private void multicasAll() {
            for (Observer observer : observerList) {
                observer.ob();
            }
        }

    }
}
