package com.korai.study.ch03.access;

class 선생 {
    private String name;

    void 이름설정하기(String name) {
        this.name = name;
    }

    // Setter
    void setName(String name) {
        this.name = name;
    }

    // Getter
    String getName() {
        return name;
    }
}

public class AccessMain {

    static class 학생 {
        String name;
        private int age;
    }

    public static void main(String[] args) {
        학생 s1 = new 학생();
        s1.name = "김준일";
        s1.age = 33;
        System.out.println(s1.age);
    }

    static void run1() {
        학생 s1 = new 학생();
        s1.name = "김준일";
        s1.age = 33;

        선생 s2 = new 선생();
//        s2.name = "김준이";
        s2.이름설정하기("김준이");
        System.out.println(s2.getName());
    }
}
