package com.lxj.algorithms.chapter2_2;

import edu.princeton.cs.algs4.StdOut;

public class Ex10 {
    private static Comparable[] aux = null;
    private static void merge(Comparable[] a, int lo, int mid, int hi){//原地归并
        int i = lo,j = hi;
        for (int k = lo; k <= mid; k++){
            aux[k] = a[k];
        }
        for (int k = mid + 1; k <= hi; k++){
            aux[k] = a[hi + mid + 1 - k];
        }
        for (int k = lo; k <= hi; k++){
            if (less(aux[j],aux[i]))    a[k] = aux[j--];
            else                        a[k] = aux[i++];
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
        String a[] = new String[]{"1","3","2","4","6","5"};
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
