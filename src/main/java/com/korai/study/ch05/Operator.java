package com.korai.study.ch05;

public class Operator {
    public static void main(String[] args) {
        // 논리연산자
        // T = 1 = 흐른다
        // F = 0 = 흐르지 않는다
        // 곱 = 그리고 = AND = &&
        // 합 = 또는 = OR = ||
        // 부정 = 반전 = NOT = !

        // 합 => 1 + 1 = 2,   1 + 0 = 1,   0 + 1 = 1,    0 + 0 = 0
        // 합 => 흐 + 흐 = 흐, 흐 + 않 = 흐, 않 + 흐 = 흐,  않 + 않 = 0
        // 합 => T || T = T,  T || F = T,  F || T = T,   F || F = F

        // 곱 => 1 * 1 = 1,   1 * 0 = 0,   0 * 1 = 0,    0 * 0 = 0
        // 곱 => T && T = T,  T && F = F,  F && T = F,   F && F = F
        boolean open1 = true;
        boolean open2 = false;
        System.out.println(open1);
        System.out.println(open2);
        System.out.println(10 * 2 + 10);
        System.out.println(false && true || true);

        int n = -3;
        System.out.println(n % 2 == 0 ? "짝수" : "홀수");
        if (n % 2 == 1) {
            System.out.println("홀수");
        } else {
            System.out.println("짝수");
        }

        System.out.println(n % 2);
        System.out.println(2026 % 4 == 0 && 2026 % 100 != 0 || 2026 % 400 == 0);

        int a = 0;
        int b = 0;
        int c = 0;
        int maxValue = 0;

        if (a < b) {
            if (b < c) {
                maxValue = c;
            } else {
                maxValue = b;
            }
        } else {
            if (a < c) {
                maxValue = c;
            } else {
                maxValue = a;
            }
        }

        if (a < b) {
            maxValue = b;
            if (maxValue < c) {
                maxValue = c;
            }
        } else {
            maxValue = a;
            if (maxValue < c) {
                maxValue = c;
            }
        }

        maxValue = a;
        if (maxValue < b) {
            maxValue = b;
        }
        if (maxValue < c) {
            maxValue = c;
        }
    }
}
