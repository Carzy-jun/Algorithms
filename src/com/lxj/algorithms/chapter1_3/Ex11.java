package com.lxj.algorithms.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Ex11 {
    public static void main(String[] args) {
        Stack<Double> stack = new Stack<>();
            String s = StdIn.readString();
            double result;
            String[] s1 = s.split("");
            for (String a : s1){
                switch (a) {
                    case "+":
                        result = stack.pop() + stack.pop();
                        stack.push(result);
                        break;
                    case "-":
                        result = -stack.pop() + stack.pop();
                        stack.push(result);
                        break;
                    case "*":
                        result = stack.pop() * stack.pop();
                        stack.push(result);
                        break;
                    case "/":
                        result = 1 / stack.pop() * stack.pop();
                        stack.push(result);
                        break;
                    default:
                        double d = new Double(a);
                        stack.push(d);
                }
            }
        StdOut.println(stack.pop());
    }
}
