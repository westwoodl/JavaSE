package com.xu.day13__SB_Arrays;

import org.junit.Test;

import java.util.Arrays;

public class ArraysDemo {
    Arrays arrays;

    @Test public void exe(){
        int[] nums = new int[]{1,5,2,0,6,9};
        System.out.println(Arrays.toString(nums));

        Arrays.sort(nums);//快排
        System.out.println(Arrays.toString(nums));

        System.out.println(Arrays.binarySearch(nums, 6));
    }
}
