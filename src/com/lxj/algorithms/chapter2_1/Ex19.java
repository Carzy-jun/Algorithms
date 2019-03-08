package com.lxj.algorithms.chapter2_1;

public class Ex19 {
    public static void main(String[] args){
        Comparable[] b;
        b = ShellSortWorstCase.GetWorst(100);

        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i] + " ");
        }
        System.out.println();
        Shell.sort(b);
    }
}
