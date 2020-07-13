package com.bf.d2_cas;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author xu rongchao
 * @date 2020-07-13 9:29
 */
public class OptionalTest {
    /**
     * 使用ofElseGet传入方法 设置默认值
     */
    public static void main(String[] args) {

        List l = Arrays.asList(1, 2);
        System.out.println(Optional.ofNullable(l).orElse(new ArrayList<>()));
        System.out.println(Optional.ofNullable(l).orElseGet(ArrayList::new));
        System.out.println(Optional.ofNullable(l).orElseGet(() -> {
            List ll = new ArrayList();
            ll.add(1);
            return ll;
        }));




    }




}
