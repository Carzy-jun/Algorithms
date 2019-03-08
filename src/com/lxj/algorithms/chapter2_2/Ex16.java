package com.lxj.algorithms.chapter2_2;

import edu.princeton.cs.algs4.StdOut;

/*
 * 自然的归并排序。
 * 编写一个自底向上的归并排序，当需要将两个子数组排序时能够利用数组中已经有序的部分。
 * 首先找到一个有序的子数组（移动指针直到当前元素比上一个元素小为止），
 * 然后再找出另一个并将它们归并。
 * 根据数组大小和数组中递增子数组的最大长度分析算法的运行时间。
 */
public class Ex16 {
    public static void main(String[] args){
        int[] a = new int[]{1,3,4,5,3,4,5,1,2,3,1,2,3,4,5,6,1,2,3,-1};
        normalMergeSort(a);
        for (int anA : a) {
            StdOut.print(anA);
            System.out.println();
        }
    }
    private static void normalMergeSort(int[] a){
        int[] aux = new int[a.length]; //辅助数组
        int N = a.length;
        while (true){
            //第一个子数组
            int lo = 0;
            int mid = fndBlock(lo, a) - 1;
            //循环结束条件
            if (mid == N - 1) break;
            //找到每个子数组的lo,mid,hi
            while (mid < N - 1){
                int hi = fndBlock(mid + 1, a) + mid;
                merge(a, lo, mid, hi, aux);
                lo = hi + 1;
                mid = fndBlock(lo, a) + lo - 1;
            }
        }
    }

    private static int fndBlock(int lo, int[] a) {
        int size = 1;
        for (int i = lo; i < a.length - 1; i++) {
            if (a[i] <= a[i + 1])
                size++;
            else
                break;
        }
        return size;
    }
    private static void merge(int[] a, int lo, int mid, int hi,int[] aux){//原地归并

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
    private static boolean less(int v ,int w){
        return v < w ;
    }
}
