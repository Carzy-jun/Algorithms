package com.lxj.algorithms.chapter2_1;

public class ShellSortWorstCase {
    public static Comparable[] GetWorst(int n) {
        int l = 0;
        int[] a = new int[n + 1];
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
        int P = 40;
        int PAddition = P;
        for (int i = 0; l < 100; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[j] == 0 && IsVisible(j, P)) {
                    l++;
                    a[j] = l;
                }
            }
            P += PAddition;
        }
        Comparable[] b = new Comparable[n];
        for (int i = 0; i < n; i++) {
            b[i] = a[i + 1];
        }
        return b;
    }

    public static boolean IsVisible(int i, int j) {
        int k = 0;
        while (k <= 100) {
            if (j - i >= k * 40 && j - i <= k * 41)
                return true;
            k++;
        }
        return false;
    }
}
