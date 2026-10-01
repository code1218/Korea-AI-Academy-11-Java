package com.korai.study.ch05.practice;

import java.util.Scanner;

public class Practice02_02copy {
    public static void main(String[] args) {
        /*
            몇명의 이름을 입력하실건가요? 2
            이름: 김준일
            이름: 김준이
            입력한 이름 정보
            1: 김준일
            2: 김준이
         */
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.print("몇명의 이름을 입력하실건가요? ");
        n = scanner.nextInt();
        scanner.nextLine();

        String[] names = new String[n];
        for (int i = 0; i < names.length; i++) {
            System.out.print("이름: ");
            names[i] = scanner.nextLine();
        }

        System.out.println("입력한 이름 정보");
        for (int i = 0; i < names.length; i++) {
            System.out.println(String.format("%d: %s", i + 1, names[i]));
        }
    }
}
