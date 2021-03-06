package com.lxj.algorithms.chapter2_2;

import edu.princeton.cs.algs4.StdOut;


public class Merge {
    private static Comparable[] aux = null;
    private static void merge(Comparable[] a, int lo, int mid, int hi){//原地归并
        int i = lo,j = mid +1;
        for (int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++){
            if (i > mid)                  a[k] = aux[j++];//左半边用尽，取右半边元素
            else if (j > hi)              a[k] = aux[i++];//右半边用尽，去左半边元素
            else if (less(aux[j],aux[i])) a[k] = aux[j++];
            else                          a[k] = aux[i++];
        }
    }

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];  //一次性分配空间
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo)return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);//讲左半边排序；
        sort(a, mid+1, hi);//将右半边排序
        merge(a, lo, mid, hi);
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
        for (Comparable anA : a) {
            StdOut.print(anA + " ");
            StdOut.println();
        }
    }
    private static boolean isSorted(Comparable[] a){//测试数组元素是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i],a[i-1]))return false;
        return true;
    }

    public static void main(String[] args){
        String a[] = new String[]{"1","3","2","4","6","5"};
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
