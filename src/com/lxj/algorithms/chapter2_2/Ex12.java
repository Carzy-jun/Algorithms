package com.lxj.algorithms.chapter2_2;

import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex12 {
    public static void main(String[] args){
        int M = StdIn.readInt();
        Comparable[] a = new Comparable[]{"C","B","D","A","F","E","H","G","h"};
        int N = a.length;
        int n = 0;
        for (int i = 0; i < N; i += M){
            Comparable[] b = new Comparable[M];
            for (int j = i,k = 0; k < M; j++,k++){
                b[k] = a[j];
            }
            Selection.sort(b);
            for (int k = 0; k < M; k++,n++){
                a[n] = b[k];
            }
        }
        for (int lo = 0; lo < N/M; lo++){
            merge(a, 0, lo * M-1,lo * M + 1);
        }
        for (int i = 0; i < N; i++ ){
            StdOut.print(a[i]+" ");
            StdOut.println();
        }
    }


    private static void merge(Comparable[] a, int lo, int mid, int hi){//原地归并
         Comparable[] aux = new Comparable[a.length];
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
    private static boolean less(Comparable v ,Comparable w){
        return v.compareTo(w) < 0;
    }
}
