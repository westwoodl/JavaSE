package com.xu.day13__SB_Arrays;

import org.junit.Test;

public class 二分查找 {

    /**
     * 查找出A中content的下标
     * @param A
     * @param content
     * @return
     */
    public int serch(int[] A, int content){
        int index=(int)((A.length-1)/2);
        int min=0,max=A.length-1;
        while (A[index]!=content){
//            if(min==max&&A[max]!=content){
//                return -1;
//            }
            if(A[max]==content)
                return max;
            if(index==min)
                return -1;
            if(A[index]>content){
                max = index;
            }
            if (A[index]<content){
                min = index;
            }
            index = (int)((max+min)/2);
        }
        return index;
    }

    @Test public void  exe(){

        System.out.println(serch(new int[]{0,1,2,4,5,6}, 6));
        System.out.println(serch(new int[]{0,1,2,4,5,6}, 2));
        System.out.println(serch(new int[]{0,1,2,4,5,6}, 5));
    }
}
