package com.korai.study.ch03;

import java.time.LocalDate;

public class StaticDelivery {
    public static void main(String[] args) {
        택배 t1 = 택배회사.접수("부산", 3);
        택배 t2 = 택배회사.접수("서울", 12);
        System.out.println(t1.운송장번호 + " " + t1.도착지 + " " + t1.요금);
        System.out.println(t2.운송장번호 + " " + t2.도착지 + " " + t2.요금);
    }
}

class 택배 {
    long 운송장번호;
    String 도착지;
    int 요금;

    택배(long 운송장번호, String 도착지, int 요금) {
        System.out.println("택배 생성자 호출");
        this.운송장번호 = 운송장번호;
        this.도착지 = 도착지;
        this.요금 = 요금;
    }
}

class 택배회사 {
    static int 월 = LocalDate.now().getMonthValue();
    static int 일 = LocalDate.now().getDayOfMonth();
    static int 순번 = 1;

    static {
        System.out.println("택배회사 클래스 로딩");
    }

    static int 요금계산(int 무게) {
        if (무게 > 10) {
            return 6000;
        }
        return 4000;
    }

    static 택배 접수(String 도착지, int 무게) {
        long 번호 = (월 * 100 + 일) * 1000L + 순번++;
        return new 택배(번호, 도착지, 요금계산(무게));
    }
}