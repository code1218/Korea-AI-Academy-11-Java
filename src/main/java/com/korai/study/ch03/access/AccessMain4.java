package com.korai.study.ch03.access;

public class AccessMain4 {
    public static void main(String[] args) {
        School2 s = new School2();
//        s.name = "부경대";
        s.setName("부경대");
    }
}

class AccessMain5 {
    static void run() {
        School2 s = new School2();

    }
}

class School2 {
    private String name;

    //setter
    void setName(String name) {
        this.name = name;
    }

    //getter
    private String getName() {
        return name;
    }

}








