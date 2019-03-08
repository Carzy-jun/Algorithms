package com.lxj.algorithms.chapter1_3;

import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

public class Ex04 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String string = StdIn.readString();
        String[] inputs = string.split("");
        for (String input : inputs) {
            if (input.equals("{") || input.equals("[") || input.equals("(")) {
                stack.push(input);
            } else if (!stack.isEmpty()) {
                switch (input) {
                    case "}":
                        if (!stack.pop().equals("{")) {
                            System.out.println(false);
                            return;
                        }
                        break;
                    case "]":
                        if (!stack.pop().equals("[")) {
                            System.out.println(false);
                            return;
                        }
                        break;
                    case ")":
                        if (!stack.pop().equals("(")) {
                            System.out.println(false);
                            return;
                        }
                        break;
                }
            }
        }
        System.out.println(stack.isEmpty());
    }
}
