package com.xu.day13__SB_Arrays;

import org.junit.Test;

public class 选择排序 {

    /**
     * 选个最小的，放在最前面
     * @param A
     * @return
     */
    public int[] SelectSort(int[] A){
        int key;
        for (int i =0;i<A.length-1;i++){
            for (int j=i+1;j<A.length;j++){
                if(A[j]<A[i]){
                    key = A[j];
                    A[j] = A[i];
                    A[i] = key;
                }
            }
        }
        return A;
    }
    @Test
    public void exe(){
        for(int x:SelectSort(new int[]{2,3,1,1,1,0,9,9,6,4,7}))
            System.out.print(x);
    }
}
