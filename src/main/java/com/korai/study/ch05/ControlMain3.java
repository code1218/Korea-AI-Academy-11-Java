package com.korai.study.ch05;

public class ControlMain3 {
    public static void main(String[] args) {
        System.out.print("김\n");
        System.out.print("준\n");
        System.out.print("일\n");
        System.out.print("""
                김
                준
                일
                """);
        System.out.print("김\n준\n일");

        System.out.println("*");
        System.out.println("**");
        System.out.println("***");
        System.out.println("****");
        System.out.println("*****");

        System.out.print("*");
        System.out.println();
        System.out.print("*");
        System.out.print("*");
        System.out.println();
        System.out.print("*");
        System.out.print("*");
        System.out.print("*");
        System.out.println();
        System.out.print("*");
        System.out.print("*");
        System.out.print("*");
        System.out.print("*");
        System.out.println();
        System.out.print("*");
        System.out.print("*");
        System.out.print("*");
        System.out.print("*");
        System.out.print("*");
        System.out.println();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            String star = "";
            for (int j = 0; j < i + 1; j++) {
                star += "*";
            }
            System.out.println(star);
        }

        String star = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                star += "*";
            }
            star += "\n";
        }
        System.out.println(star);

        for (int i = 0; i < 5; i++) {
            System.out.println(5 - i);
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 1 + i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
