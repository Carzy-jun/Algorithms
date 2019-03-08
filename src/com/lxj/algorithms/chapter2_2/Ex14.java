package com.lxj.algorithms.chapter2_2;

import java.util.LinkedList;
/*
 * 归并有序的队列。
 * 编写一个静态方法，
 * 将两个有序的队列作为参数，
 * 返回一个归并后的有序队列。
 */
public class Ex14 {
    public static LinkedList<Integer> merge(LinkedList<Integer> queue1, LinkedList<Integer> queue2){
         LinkedList<Integer> queue = new LinkedList<>();
         while (!queue1.isEmpty() || !queue2.isEmpty()){
             if (queue1.isEmpty()){
                 queue.addLast(queue2.pollFirst());
             }else if (queue2.isEmpty()){
                 queue.addLast(queue1.pollFirst());
             } else if (queue1.peek() < queue2.peek()){
                 queue.addLast(queue1.pollFirst());
             }
             else {
                 queue.addLast(queue2.pollFirst());
             }
         }
         return queue;
    }

    public static void main(String[] args){
        LinkedList<Integer> queue1 = new LinkedList<>();
        LinkedList<Integer> queue2 = new LinkedList<>();
//        for (int i = 1; i < 10; i += 2){
            queue1.addLast(1);
            queue2.addLast( 2);
//        }
        LinkedList<Integer> queue = merge(queue1, queue2);
        int N  = queue.size();//注意size是会变化的
        for (int i = 0; i < N; i++){
            System.out.println(queue.pollFirst());
        }
    }
}
