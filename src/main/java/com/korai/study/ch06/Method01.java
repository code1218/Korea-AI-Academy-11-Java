package com.korai.study.ch06;

public class Method01 {
    public static void main(String[] args) {
        Method0102.run("1");
        new Method0101().run(new Method0101());
    }
}

class Method0101 {
    void run(Method0101 bbb) {
        System.out.println("10");
    }
}

class Method0102 {

    static void run(String a) {
        System.out.println(a);
        System.out.println("2");
    }

}
