package com.korai.study.ch01;

public class ClassMain {
    public static void main(String[] args) {
        // [ 변수와 자료형 ]
        int num = 10;
        final String name = "김준일"; // 상수

        class Student {
            String name;
            int age;
        }

        Student jun = new Student();
        jun.name = "김준일";
        jun.age = 33;

        class Student2 {
            String name;
            Object age;
        }

        Student2 jun2 = new Student2();
        jun2.name = "김준이";
        jun2.age = jun;

        Student2 jun22 = new Student2();
        jun22.name = "김준이이";
        jun22.age = "33";

        class Student3<A> {
            String name;
            A age;
        }

        Student3<String> jun3 = new Student3<String>();
        Student3<Integer> jun33 = new Student3<>();
        jun3.age = "33";
        jun33.age = 33;

        int num2 = num;
        Student3<?> jun333 = jun33; // 제네릭의 와일드카드

    }
}









