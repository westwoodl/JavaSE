package com.xu.day23__recursion;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 约瑟夫环
 */
public class Test4 {
    /**
     * @param x 个人，编号分别为1，2，3，4，。。。x
     * @return 存活的那个人
     */
    int joseph(int x) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int n = 1; n <= x; n++)
            list.add(n);

        int count = 1;
        for (int n = 0; list.size() != 1; n++) {//list剩下一个时跳出循环
            if (n == list.size())
                n = 0;
            if (count % 3 == 0)
                list.remove(n--);//list的size减一，索引也减一
            count++;
        }
        return list.get(0);
    }

    @Test
    public void test() {
        System.out.println(joseph(8));
    }
}
