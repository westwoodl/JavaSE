package com.xu.day13__SB_Arrays;

import org.junit.Test;

/**
 * 更多的排序方法参见 Introduction-to-algorithms
 */
public class 冒泡排序 {
    @Test
    public void exe(){
        for(int x:BubbleSort(new int[]{2,3,1,1,1,0,9,9,6,4,7}))
            System.out.print(x);
    }

    public int[] BubbleSort(int[] A){
        int key;
        for (int j=0;j<A.length-1;j++){
            for(int i=0;i<A.length-1-j;i++){
                if(A[i]>A[i+1]){
                    key = A[i];
                    A[i] = A[i+1];
                    A[i+1] = key;
                }
            }
        }
        return A;
    }
}
