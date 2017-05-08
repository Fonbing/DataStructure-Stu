package com.lonxt.arithmetic;

import java.util.Stack;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ChenFengJY on 2017/3/28.
 */
public class Test {
    /**
     * 双栈法求算术表达式( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )的值
     *
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(1 + 1.0);
        Stack<String> stringStack = new Stack<>();
        Stack<Double> doubleStack = new Stack<>();
        while (!StdIn.isEmpty()) {  //要按Ctrl+D才能为空
            String str = StdIn.readString();
            switch (str) {
                case "(":
                    break;
                case "+":
                    stringStack.push("+");
                    break;
                case "-":
                    stringStack.push("-");
                    break;
                case "*":
                    stringStack.push("*");
                    break;
                case "/":
                    stringStack.push("/");
                    break;
                case ")":
                    double v = doubleStack.pop();
                    switch (stringStack.pop()) {
                        case "+":
                            v = doubleStack.pop() + v;
                            break;
                        case "-":
                            v = doubleStack.pop() - v;
                            break;
                        case "*":
                            v = doubleStack.pop() * v;
                            break;
                        case "/":
                            v = doubleStack.pop() / v;
                            break;
                        case "sqrt":
                            v = Math.sqrt(v);
                            break;
                    }
                    doubleStack.push(v);
                    break;
                default:
                    doubleStack.push(Double.parseDouble(str));
                    break;
            }
        }
        StdOut.println(doubleStack.pop());
    }

    private static void test() {
        int N = 1000;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N * N);
        StdDraw.setPenRadius(.01);
        for (int i = 0; i <= N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));
        }
    }
}
