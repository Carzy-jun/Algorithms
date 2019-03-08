package com.lxj.algorithms.chapter2_1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class Shell {
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1; //动态设置间隔h
        while (h >= 1){
            int compareTime = 0; //记录每个h比较次数
            for (int i = h; i < N; i++){
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h){
                    compareTime++;
                    exch(a, j, j-h);
                }
            }
//            System.out.println("h:"+h);
//            System.out.println("compareTime/ArraySize:"+ compareTime/a.length);
            h = h/3;
        }
    }

    private static boolean less(Comparable v ,Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++ ){
            StdOut.print(a[i]+" ");
            StdOut.println();
        }
    }
    public static boolean isSorted(Comparable[] a){//测试数组元素是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i],a[i-1]))return false;
        return true;
    }
    public static void main(String[] args){
        String a[] = {"1","2","2","1","5"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
