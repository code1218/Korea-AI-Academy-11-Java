package com.korai.study.ch05;

import java.util.Scanner;

public class ScannerMain02 {
    // 이름 next  김준일
    // 연락처 nextLine 010-1234-5678
    // 주소 next  부산진구 부암동 123길

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String phone = scanner.next();
        String address = scanner.nextLine();

        System.out.println("이름: " + name);
        System.out.println("연락처: " + phone);
        System.out.println("주소: " + address);
    }
}
