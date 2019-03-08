package com.lxj.algorithms.chapter2_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class Ex18 {

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a); //消除对输入的依赖
        int index1 = (int) (Math.random()*a.length);
        int index2 = (int) (Math.random()*a.length);
        int index3 = (int) (Math.random()*a.length);
        Comparable i = a[index1], j = a[index2], k = a[index3];
        Comparable median = median(i, j, k);
        if (median.equals(i)) {
            exch(a, index1, 0);
        }else if ((median.equals(j))){
            exch(a, index2, 0);
        }else if (median.equals(k)){
            exch(a, index3, 0);
        }
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo)return;
        int j = partition(a, lo, hi); //切分
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi + 1;  //左右扫描指针
        Comparable v = a[lo];  //切分的元素
        while (true){  //扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)){  //从左边开始扫描找到比v大的，下标i
                if (i == hi) break;
            }
            while (less(v, a[--j])){  //从右边开始扫描找到比v小的，下表j
                if (j == lo) break;
            }
            if (i >= j)break;//若两指针相遇，则说明该轮扫描结束
            exch(a, i, j);
        }
        exch(a, lo, j);//将v = a[j]放入正确的位置
        return j;  //a[lo..j-1] <= a[j] <= a[j+1..hi] 达成
    }
    private static Comparable median(Comparable i, Comparable j, Comparable k){
        Comparable[] a = new Comparable[]{i, j, k};
        Arrays.sort(a);
        return a[1];
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
        }
    }
    public static void main(String[] args){
        Comparable<Integer>[] a = new Comparable[]{11,10,9,8,7,6,5,4,3,2,1};
        show(a);
        System.out.println();
        sort(a);
        show(a);
    }

}
