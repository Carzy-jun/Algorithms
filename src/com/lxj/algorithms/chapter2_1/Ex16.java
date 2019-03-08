package com.lxj.algorithms.chapter2_1;

import java.util.Arrays;

public class Ex16 {
    public static void main(String[] args){
        String[] test = new String[]{"a","b","d","c","e"};
        System.out.println(checkArraySort(test));
        for (int i =0 ; i<test.length;i++){
            System.out.println(test[i]);
        }
        System.out.println(checkSelectionSort(test));
        for (int i =0 ; i<test.length;i++){
            System.out.println(test[i]);
        }
    }
    private static boolean checkArraySort(String[] a){
        String[] backup = new String[a.length];
        int i = 0;
        for (String a1:a){
            backup[i++] = a1;
        }
        Arrays.sort(a);
        for (String n: a){
            boolean isFind = false;
            for (int j = 0; i < a.length; j++){
                if (n.equals(backup[j])){
                    isFind = true;
                    break;
                }
            }
            if (!isFind)return false;
        }
        return true;
    }

    private static boolean checkSelectionSort(String[] b){
        String[] backup = new String[b.length];
        int i = 0;
        for (String a1: b){
            backup[i++] = a1;
        }
        selectionSort(b);
        for (String n :b){
            boolean isFind = false;
            for (int j = 0; j<b.length;j++){
                if (n.equals(backup[j])){
                    isFind = true;
                    break;
                }
            }
            if (!isFind)return false;
        }
        return true;
    }

    private static void selectionSort(String[] s){
        for (int i = 0; i < s.length; i++){
            int min = i;
            for (int j = i+1; j< s.length; j++){
                if (s[j].compareTo(s[i])<0)min = j;
                String t = s[i];
                s[i] = s[min];
                s[min] = t;
            }
        }
    }
}
