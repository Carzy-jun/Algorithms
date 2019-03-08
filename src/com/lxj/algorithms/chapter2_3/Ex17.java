package com.lxj.algorithms.chapter2_3;

import com.lxj.algorithms.chapter2_1.SortCompare;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
 * 哨兵。修改算法 2.5，去掉内循环 while 中的边界检查。
 * 由于切分元素本身就是一个哨兵（v 不可能小于 a[lo]），左侧边界检查是多余的。
 * 要去掉另一个检查，可以在打乱数组后将数组的最大元素方法 a[length - 1] 中。
 * 该元素永远不会移动（除非和相等的元素交换），可以在所有包含它的子数组中成为哨兵。
 * 注意：在处理内部子数组时，右子数组中最左侧的元素可以作为左子数组右边界的哨兵。
 */
public class Ex17 {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a); //消除对输入的依赖
        //找到最大元素，作为右边界哨兵，不用再判断 i == hi
        int maxIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (less(a[maxIndex], a[i]))
                maxIndex = i;
        }
        exch(a, maxIndex, a.length -1);
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
            while (less(a[++i], v)) ; //从左边开始扫描找到比v大的，下标i

            while (less(v, a[--j])) ; //从右边开始扫描找到比v小的，下表j

            if (i >= j)break;//若两指针相遇，则说明该轮扫描结束
            exch(a, i, j);
        }
        exch(a, lo, j);//将v = a[j]放入正确的位置
        return j;  //a[lo..j-1] <= a[j] <= a[j+1..hi] 达成
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
        Comparable<Integer>[] a = new Comparable[]{11,10,9,8,7,6,5,4,3,2,1,3,5,7,1,0,2,2,1,2,3};
        show(a);
        System.out.println();
        sort(a);
        show(a);
        String alg = "Quick", alg1 = "XQuick";
        int N = 1000;
        int T = 1000;
        double t1 = SortCompare.timeRandomInput(alg, N, T);
        double t2 = SortCompare.timeRandomInput(alg1, N, T);
        System.out.println();
        StdOut.printf("For %d random Doubles\n    %s is ",N, alg);
        StdOut.printf("%.1f times faster than %s\n",t2/t1,alg1);

    }
}
