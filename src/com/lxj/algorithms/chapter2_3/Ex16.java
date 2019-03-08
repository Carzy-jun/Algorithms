package com.lxj.algorithms.chapter2_3;

import edu.princeton.cs.algs4.StdIn;

/*
 * 最佳情况。编写一段程序来生成使算法 2.5 中的 sort() 方法表现最佳的数组（无重复元素）：
 * 数组大小为 N 且不包含重复元素，每次切分后两个子数组的大小最多差 1
 * （子数组的大小与含有 N 个相同元素的数组的切分情况相同）。
 * （对于这道练习，我们不需要在排序开始时打乱数组。）
 */
public class Ex16 {

    //最好情况是 QuickSort 递归log2 N 次，取的基准值刚好等半切分数组
    public static int[] best(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        best(a, 0, n - 1);
        return a;
    }
    private static int[] best(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return a;
        }
        int mid = lo + (hi - lo) / 2;
        a = best(a, lo, mid - 1);
        a = best(a, mid + 1, hi);
        exch(a, lo, mid);
        return a;
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[] a = best(n);
         for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
