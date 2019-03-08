package com.lxj.algorithms.chapter2_1;

import com.lxj.algorithms.chapter2_3.*;
import com.lxj.algorithms.chapter2_3.Ex18;
import com.lxj.algorithms.chapter2_3.Ex19;
import com.lxj.algorithms.chapter2_3.Quick;
import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;

public class SortCompare {
    private static double time(String alg, Comparable[] a){
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("Quick")) Quick.sort(a);
        if (alg.equals("Heap")) Heap.sort(a);
        if (alg.equals("XQuick")) Ex17.sort(a);
        if (alg.equals("3KQuick")) Ex18.sort(a);
        if (alg.equals("5KQuick")) Ex19.sort(a);
        return timer.elapsedTime();
    }
    public static double timeRandomInput(String alg, int N, int T){//使用算法alg 将T个长度为N的数组排序
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++){//进行一次测试(生成一个数组并排序)
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
                total += time(alg, a);
        }
        return total;
    }
    public static void main(String[] args){
        String alg1 = "3KQuick";
        String alg2 = "5KQuick";
        int N = 10000;
        int T = 10000;
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        System.out.println("The time of "+alg1+" is:"+t1);
        System.out.println("The time of "+alg2+" is:"+t2);
        System.out.println("For "+N+"   random Doubles\n ");
        System.out.print(alg1+"/"+alg2+"=" + t1/t2);
    }
}
