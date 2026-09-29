package com.korai.study.ch03;

import java.time.LocalDate;

public class StaticLibrary {
    public static void main(String[] args) {
        도서 b1 = 도서관.도서등록("자바의 정석");
        도서 b2 = 도서관.도서등록("클린 코드");
        도서 b3 = b1;
        b3.대출가능 = false;
        System.out.println(b1.등록번호 + " " + b1.제목 + " " + b1.대출가능);
        System.out.println(b2.등록번호 + " " + b2.제목 + " " + b2.대출가능);
    }
}

class 도서 {
    String 등록번호;
    String 제목;
    boolean 대출가능;

    도서(String 등록번호, String 제목) {
        System.out.println("도서 생성자 호출");
        this.등록번호 = 등록번호;
        this.제목 = 제목;
        대출가능 = true;
    }
}

class 도서관 {
    static int 년도 = LocalDate.now().getYear();
    static int 번호 = 1;

    static {
        System.out.println("도서관 클래스 로딩");
    }

    static 도서 도서등록(String 제목) {
        return new 도서("B" + 년도 + "-" + 번호++, 제목);
    }
}