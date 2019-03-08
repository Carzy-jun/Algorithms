package com.lxj.algorithms.chapter2_1;

import java.util.Random;

public class Ex12 {
    public static void main(String[] args){
        Random random = new Random();
        int size = 100;
        for (int i = 0; i < 5; i++){
            Double[] a = new Double[size];
            for (int j = 0; j < size; j++){
                a[j] = random.nextDouble() * 100;
            }
            System.out.println("ArraySize:"+size);
            Shell.sort(a);
            size *= 10;
        }
    }
}
