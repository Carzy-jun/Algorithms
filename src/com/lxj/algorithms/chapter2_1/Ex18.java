package com.lxj.algorithms.chapter2_1;

import edu.princeton.cs.algs4.In;

public class Ex18 {

    public static void main(String[] args) {
        String[] a = new String[]{"2","3","1","3","4","5"};
        String sort = "insertion";
        if (sort.equals("selection")) {
            Selection.drawSort(a);
        } else if (sort.equals("insertion")) {
            Insertion.drawSort(a);
        }
    }
}
