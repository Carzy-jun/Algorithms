package com.lxj.algorithms.chapter2_2;

import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;
/*
 * 自底向上的有序队列归并排序。用下面的方法编写一个自底向上的归并排序：
 * 给定 N 个元素，创建 N 个队列，每个队列包含其中一个元素。
 * 创建一个由这 N 个队列组成的队列，
 * 然后不断用练习 2.2.14 中的方法将队列的头两个元素归并，并将结果重新加入到队列结尾，
 * 直到队列的队列只剩下一个元素为止。
 */
public class Ex15 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8};
        sort(a);
        for (int anA : a) {
            StdOut.print(anA);
            System.out.println();
        }
    }
    private static void sort(int[] a){
        LinkedList<LinkedList<Integer>> queue = new LinkedList<>();
        for (int anA : a) {
            LinkedList<Integer> queue1 = new LinkedList<>();   //这条语句放在循环内 因为 相同的queue1 ，queue1变化，queue 中的所有queue1 都会变化
            queue1.addLast(anA);
            queue.addLast(queue1);
        }
        while (queue.size()!=1){
            queue.addLast(Ex14.merge(queue.pollFirst(), queue.pollFirst()));
        }
        int N = queue.peekFirst().size();
        for (int i = 0; i < N; i++){
           a[i] = queue.peekFirst().pollFirst();//不能写作 pollFirst().pollFirst()
        }
    }
}
