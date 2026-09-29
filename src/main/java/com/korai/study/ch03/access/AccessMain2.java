package com.korai.study.ch03.access;

public class AccessMain2 {
    static int age = 10;

    class School {
        String name;
    }

    public static void main(String[] args) {
        AccessMain2 am2 = new AccessMain2();
        School s1 = am2.new School();
        s1.name = "부경대";

        System.out.println(s1);
        System.out.println(s1.name);
    }

    public static void run() {
        age = 10;
    }
}

class AccessMain3 {
    static void run() {
        AccessMain2 am2 = new AccessMain2();
        AccessMain2.School s1 = am2.new School();
    }

}














