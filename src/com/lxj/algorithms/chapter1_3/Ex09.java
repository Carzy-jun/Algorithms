package com.lxj.algorithms.chapter1_3;

import java.util.Stack;

public class Ex09 {
    private static String getCompleteExpression(String exp)
    {
        String[] params = exp.split(" ");
        Stack<String> oprStack = new Stack<>();
        Stack<String> dataStack = new Stack<>();
        for (String param : params) {
            if (isOperator(param)) { //如果为运算符，则压入栈opr
                oprStack.push(param);
            } else if (param.equals(")")) {
                String d1 = dataStack.pop();
                String d2 = dataStack.pop();
                String op = oprStack.pop();
                dataStack.push("( " + d2 + " " + op + " " + d1 + " )");
            } else { //如果为常数，则压入栈data
                dataStack.push(param);
            }
        }
        return dataStack.pop();
    }

    //判断是否为运算符
    private static boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }

    public static void main(String[] args)
    {
        String expression = " 2 + 1 + 2 + 3 ) * 4 * 5 ) ) )";
        String result = getCompleteExpression(expression);
        System.out.println(result);
    }
}
