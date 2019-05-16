package com.xu.day19__Exception_File;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @see FilenameFilter
 * @see File#list(FilenameFilter)
 */
public class Demo5_FileFilter {

    @Test
    public void test(){
        File dir = new File("E:");
        String[] arr = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                return file.isFile() && file.getName().endsWith(".jpg");
            }
        });

        for (String s : arr)
            System.out.println(s);
    }
}
