package com.korai.study.ch03;

public class StaticTest {
    public static void main(String[] args) {
        System.out.println("프로그램 시작");
        System.out.println(TestClass.value);
        System.out.println(TestClass.value);
        System.out.println(TestClass.value);
        System.out.println(TestClass.value);
        System.out.println("프로그램 종료");
    }
}

class TestClass {
    static String value = "테스트 데이터";

    static {
        System.out.println("테스트 클래스 1");
    }

}

class TestClass2 {
    static {
        System.out.println("테스트 클래스 2");
    }
}