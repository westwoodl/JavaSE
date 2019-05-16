package com.xu.day16__List;

import com.xu.day15__Collection.bean.S;
import com.xu.day15__Collection.bean.Student;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 泛型：
 *     将运行期的错误提升到编译期
 */
public class Demo3_Generic {
    /**
     * 1.7新特性，菱形泛型
     */
    ArrayList<String> arrayList = new ArrayList<>();
    //ArrayList<> arrayList = new ArrayList<String>(); 编译错误

    @Test
    public void test(){
        new GenericDemo().generic(new Student("xu"));

        GenericExtends<S> g = new GenericExtends<>();
    }

    class A{}
    static class B{}
    interface C{}

}
class GenericDemo<Q>{
    /**
     * 泛型方法
     * @param t
     * @param <T>
     */
    public <T> void generic(T t){
        System.out.println(t);
    }

    public static <S> void staticGeneric(S s){//静态方法必须声明自己的泛型

    }
}
interface GenericInterface<T>{
}
//推荐的
class GenericInterfaceImpl implements GenericInterface<String>{

}
/**
 * 泛型高级
 */
class GenericExtends <E extends S> {//E只能传入S自身或其子类

    //形如Collection的addAll()
    /**
     * @param g 传入的是E的子类或E
     */
    private  void ha(GenericExtends<? extends E> g){ //？只能传入E自身或其子类
        System.out.println(g);
    }

    void hh(GenericDemo<? super E> genericDemo){

    }
}