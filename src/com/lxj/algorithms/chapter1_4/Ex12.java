package com.lxj.algorithms.chapter1_4;

import java.io.Console;
//要求：最坏情况所需时间应和N成正比
public class Ex12 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,4,5,23};
        int[] b = new int[]{1,2,3,4,5,23};
        for (int i = 0 ,j = 0 ;i<a.length && j<b.length;){
            if (a[i]<b[j])i++;
            else if (a[i]>b[j])j++;
            else {
                System.out.println(a[i]);
                i++;
                j++;
            }
        }
    }
}
