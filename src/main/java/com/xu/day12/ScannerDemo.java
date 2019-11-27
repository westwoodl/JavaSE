package com.xu.day12;


import org.junit.Test;

import java.util.Scanner;

public class ScannerDemo {

    @Test public void exe(){
        //基本的键盘输入流System.in
        Scanner sc = new Scanner(System.in);
        int x;
        if(sc.hasNextInt())
            x = sc.nextInt();
    }

}
