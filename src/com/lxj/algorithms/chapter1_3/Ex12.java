package com.lxj.algorithms.chapter1_3;

import edu.princeton.cs.algs4.Stack;

import java.util.Iterator;

public class Ex12 {
    public static void main(String[] args) {
        Stack<String> s1 = new Stack<String>();
        s1.push("first");
        s1.push("second");
        s1.push("third");
        Stack<String> s2 = copy(s1);
        while (!s2.isEmpty()) {
            System.out.println(s2.pop());
        }
    }
    private static <T> Stack<T> copy(Stack<T> s) {
        Iterator<T> it = s.iterator();
        Stack<T> result = new Stack<>();
        Stack<T> temp = new Stack<>();
        while (it.hasNext()) {
            temp.push(it.next());
        }
        it = temp.iterator();
        while (it.hasNext()) {
            result.push(it.next());
        }
        return result;
    }

}
