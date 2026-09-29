package com.korai.study.ch03;

// 클래스영역(클래스 로딩에 대한 이해)
public class MethodArea {

    public static void main(String[] args) {
        TestObject.name = "김준일";
        System.out.println(TestObject.name);
    }

}

class TestObject {

    static String name;
    int age;

    public TestObject() {
        System.out.println("생성자 호출");
    }

    static {
        System.out.println("스태틱 호출");
    }

}