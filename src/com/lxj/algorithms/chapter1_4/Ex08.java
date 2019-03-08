package com.lxj.algorithms.chapter1_4;


import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;



public class Ex08 {

    public static int countTwoSum(int[] a){
        int count = 0 ;
        for (int i=0 ; i <a.length ; i++){
            for (int j=i+1; j <a.length ; j++){
                if (a[i]==a[j])count++;
            }
        }
        return count;
    }

    public static int fastCountTwoSum(int[] a){
        Arrays.sort(a);
        int count = 0;
        for (int i = 1;i<a.length; i++ ){
            if (BinarySearch.rank(-a[i], a) > i) {//二分查找
                count++;
            }
        }
        return count;
    }
    public static void main(String []args){
        int []a = new int[]{1,1,2,2,2};
        int count = countTwoSum(a);
        int count1 = fastCountTwoSum(a);
        System.out.println(count);
        System.out.println(count1);
    }
}
