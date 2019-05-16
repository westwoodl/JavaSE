package com.xu.day19__Exception_File;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取路径
 * @see File
 * @see File#File(URI)
 * @see File#File(String)
 * @see File#File(String, String)
 * @see File#File(File, String)
 * 创建文件、文件夹
 * @see File#createNewFile()
 * @see File#mkdir()
 * @see File#mkdirs()
 * 删除、重命名文件、文件夹
 * @see File#renameTo(File) 路径名相同则改名，路径名不同则剪切并改名
 * @see File#delete() 若删除文件夹，该文件夹必须为空
 * 获取、设置文件、文件夹属性
 * @see File#isDirectory()
 * @see File#isFile()
 * @see File#exists()
 * @see File#canRead()
 * @see File#setReadable(boolean) windows认为所有文件都可读
 * @see File#canWrite()
 * @see File#setWritable(boolean)
 * @see File#isHidden()
 * @see File#
 *
 * @see File#getAbsolutePath()
 * @see File#getPath() 构造方法传入的路径
 * @see File#getName()
 * @see File#length() 字节数
 * @see File#lastModified() 最后修改时间
 * @see File#list() 返回文件名字 String[]
 * @see File#listFiles() 返回文件对象 File[]
 */
public class Demo4_File {

    @Test
    public void test(){
        File f = new File("file.txt");
        System.out.println(f.exists());

        File f2 = new File("file2.txt");
        try {
            System.out.println(f2.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        File f3 = new File("file");
        System.out.println(f3.mkdir());

        File f4 = new File("file/com/xu");
        System.out.println(f4.mkdirs());


        System.out.println(
                new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(f3.lastModified())));
    }
}
