package com.xu.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        try {
            System.out.println("开始链接...");
            Process p = runtime.exec("rasdial 宽带连接 15797863002 147703");

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "gbk"));
            String readLine = br.readLine();
            while (readLine != null) {
                readLine = br.readLine();
                System.out.println(readLine);
            }
            if(br!=null){
                br.close();
            }
            p.destroy();
            p=null;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
