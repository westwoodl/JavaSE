package com.xu.day20__IO;

import org.junit.Test;

import java.io.*;

/**
 * 实现了装饰者模式的BufferIOS
 * 装饰者模式存在意义就在此处,相比继承,没有这么多繁杂的类,而且类与类的之间的耦合性降低,
 * 具体做法就是将提出一个类FilterInputStream.而其子类就是各个功能的实现类.如果想要基础
 * 输入流要某个功能,那么就可以将对应的基础输入流传到对应的子类构造方法中.代码也是来源于
 * 生活,这个装饰者模式跟生活中很多实例相似,比如每家有可乐,要想喝冰可乐,怎么办.不是每家
 * 去买一个冰箱,而是大家凑钱买一个公共的冰箱,然后要想喝冰颗可乐,就直接放在公共的冰箱里面
 * ,就实现了"冰"这个功能(好吧这个例子有点牵强)
 * @see BufferedInputStream
 * @see BufferedOutputStream
 */
public class Demo3_BufferedIOS {

    @Test
    public void test() throws IOException {
        BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream("file.txt"));
        BufferedOutputStream bos =
                new BufferedOutputStream(new FileOutputStream("file2.txt"));

        int x;
        int readCount = 0;
        while((x=bis.read())!=-1){
            bos.write(x);
            System.out.println(x);
            System.out.println(++readCount);
        }

    }
}
