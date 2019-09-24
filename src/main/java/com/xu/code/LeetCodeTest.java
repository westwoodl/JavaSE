package com.xu.code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCodeTest {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> max = new HashMap();
        int max_num = 0;

        for (int n = 0; n < arr.length; n++) {
            char a = arr[n];
            if (max.size() > 0 && max.containsKey(a)) {
                if (max_num < max.size())
                    max_num = max.size();
                n = n - 1;
                max.clear();
            } else
                max.put(a, 0);
        }
        if (max_num < max.size())
            max_num = max.size();
        return max_num;
    }

    private int lengthOfLongestSubstring2(String s) {

        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    @Test
    public void testdadad() {
        System.out.println(lengthOfLongestSubstring2("dvddfx"));
    }

    /**
     * 脑子不太好使
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        if(sum % 2 == 0) {
            ArrayList<Integer> list = new ArrayList();
            for (int n1 : nums1) {
                for (int n2 : nums2) {
                    list.add(n1 < n2 ? n1 : n2);
                    if (list.size() > sum/2) {
                        return (list.get(list.size()-1) + list.get(list.size() -2))/2;
                    }
                }
            }
        } else {
            ArrayList<Integer> list = new ArrayList();
            for (int n1 : nums1) {
                for (int n2 : nums2) {
                    list.add(n1 < n2 ? n1 : n2);
                    if (list.size() == (int) (sum/2) + 1) {
                        return list.get(list.size() - 1);
                    }
                }
            }
        }
        return 0;
    }

    public int guibing(int[] l1, int[] l2){
        ArrayList<Integer> list = new ArrayList();
        int sum = l1.length + l2.length;
        for(int i = 0;i<l1.length;i++) {
            for (int j = 0;j<l2.length;j++) {
                if(list.size() > 0)
                if(l1[i] < l2[j]) {
                    list.add(l1[i]);
                    j--;
                } else {
                    list.add(l2[i]);
                    i--;
                }
            }
        }
        return 0;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        int[] arr = null;
        if(nums1 == null || nums1.length < 0) {
            arr = nums2;
        }
        if(nums1 == null || nums2.length < 0) {
            arr = nums1;
        } else {
            arr = new int[sum];
            int x1 = 0, x2 = 0;
            for (int i = 0; i < sum; i++) {
                if(x1 < nums1.length && x2 >= nums2.length) {
                    arr[i] = nums1[x1++];
                    continue;
                }
                if(x1 >= nums1.length && x2 < nums2.length) {
                    arr[i] = nums2[x2++];
                    continue;
                }
                if(x1 < nums1.length && x2 < nums2.length) {
                    arr[i] = nums1[x1] < nums2[x2] ? nums1[x1++] : nums2[x2++];
                }
            }
        }
        //System.out.println(Arrays.toString(arr));
        if(sum % 2 ==0){
            return (arr[(sum >> 1) -1] +  arr[sum >> 1])/2.0;
        } else {
            return arr[(int) (sum >> 1)];
        }
    }


    @Test
    public void testfindMedianSortedArrays() {
        System.out.println(findMedianSortedArrays2(new int[]{1, 2}, new int[]{4}));
    }


    /**
     * 动态规划法解决最长回文子串
     * 我们首先初始化一字母和二字母的回文，然后找到所有三字母回文，并依此类推
     * which we first initialize the one and two letters palindromes,
     * and work our way up finding all three letters palindromes, and so on...
     */
    public String longestPalindrome(String s) {
        ArrayList<Character> list = new ArrayList();
        for (;;) {
            list.add(s.charAt(0));
        }
    }

    @Test
    public void testlongestPalindrome(){

    }

}
