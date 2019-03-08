package com.lxj.algorithms.chapter2_2;

import edu.princeton.cs.algs4.StdOut;

public class Ex11 {
    private static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux){//原地归并
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
        Comparable[] aux = a.clone();  //一次性分配空间
        sort(aux, 0, a.length-1,a);
    }

    private static void sort(Comparable[] a, int lo, int hi, Comparable[] aux){
        if (hi - lo < 10){
            insertionSort(aux, lo, hi);
            return;
        }
        int mid = lo + (hi - lo)/2;
        sort(aux, lo, mid,a);//讲左半边排序；
        sort(aux, mid+1, hi, a);//将右半边排序
        if (less(mid+1,mid)){  //测试数组是否有序
            merge(a, lo, mid, hi, aux);
        }
    }
    public static void insertionSort(Comparable[] a, int lo, int hi){
        for (int i = 1; i <= hi; i++){
            for (int j = i; j > lo && less(a[j],a[j - 1]); j--){
                exch(a, j, j-1);
            }
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
    private static boolean isSorted(Comparable[] a){//测试数组元素是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i],a[i-1]))return false;
        return true;
    }

    public static void main(String[] args){
        String a[] = new String[]{"j","i","h","g","f","e","d","c","b","a"};
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
