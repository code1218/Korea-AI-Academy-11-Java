package com.korai.study.ch05;

import java.util.Scanner;

public class ScannerMain01 {
    public static void main(String[] args) {
        // 키보드의 입력을 1번 받는 코드를 작성하시오.
//        String a = new Scanner(System.in).nextLine();

        Scanner aaaa = new Scanner(System.in);

        String a2 = aaaa.next();
        String a3 = aaaa.next();
        String a4 = aaaa.next();
        String a5 = aaaa.nextLine();
        String a6 = aaaa.nextLine();

        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);
        System.out.println(a6);


    }
}
