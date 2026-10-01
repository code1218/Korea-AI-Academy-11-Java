package com.korai.study.ch06;


import java.util.Scanner;

public class Method02 {
    public static void main(String[] args) {
        System.out.println("100");
        System.out.println(100);
        System.out.println(new Scanner(System.in));
    }
}

/*
    public void println(Object x) {
        String s = String.valueOf(x);
        if (getClass() == PrintStream.class) {
            // need to apply String.valueOf again since first invocation
            // might return null
            writeln(String.valueOf(s));
        } else {
            synchronized (this) {
                print(s);
                newLine();
            }
        }
    }

 */

/*
    public void println(String x) {
        if (getClass() == PrintStream.class) {
            writeln(String.valueOf(x));
        } else {
            synchronized (this) {
                print(x);
                newLine();
            }
        }
    }

    public void println(int x) {
        if (getClass() == PrintStream.class) {
            writeln(String.valueOf(x));
        } else {
            synchronized (this) {
                print(x);
                newLine();
            }
        }
    }

 */

// Parameter => 매개변수
// Parameter Overloading
class Parameter01 {
    static void 세탁하기() {

    }

    static void 세탁하기(int 세제) {

    }

    static void 세탁하기(double 세제) {

    }

    static void 세탁하기(int 세제, int 섬유유연제) {

    }
}