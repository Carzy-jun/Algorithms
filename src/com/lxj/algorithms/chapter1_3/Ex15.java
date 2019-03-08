package com.lxj.algorithms.chapter1_3;

import java.util.Scanner;

public class Ex15 {
    public static void main(String args[]){
        Scanner s1 = new Scanner(System.in);
        String s = s1.nextLine();
        int k = s1.nextInt();
        Queue<String> queue = new Queue<>();
        String[] ss = s.split("");
        for (String a : ss){
            queue.enqueue(a);
        }
        int size = queue.size();
        for (int i = 0 ; i < size - k ; i++){
            queue.dequeue();
        }
        System.out.println(queue.dequeue());
    }
}
