package com.lxj.algorithms.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Ex10 {
    public static void main(String[] args) {
        Stack<String> operatorStack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (str.equals("("))
                operatorStack.push(str);
            else if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                boolean isEmpty;
                boolean isLeftParen;
                boolean isLowerOperator;
                isEmpty = operatorStack.isEmpty();
                isLeftParen = false;
                isLowerOperator = false;
                if (!isEmpty) {
                    String stackTop = operatorStack.peek();
                    isLeftParen = operatorStack.peek().equals("(");
                    if ((stackTop.equals("+") || stackTop.equals("-")) && (str.equals("*") || str.equals("/"))) {
                        isLowerOperator = true;
                    }
                }
                if (!(isEmpty || isLeftParen || isLowerOperator)) {
                    for (int i = 0; i < operatorStack.size(); i++) {
                        StdOut.print(operatorStack.pop());
                    }
                }
                operatorStack.push(str);
            } else if (str.equals(")")) {
                String pop = operatorStack.pop();
                while (!pop.equals("(")) {
                    StdOut.print(pop);
                    pop = operatorStack.pop();
                }
            } else {
                StdOut.print(str);
            }
        }
        for (String str : operatorStack) {
            StdOut.print(str);
        }
    }
}
