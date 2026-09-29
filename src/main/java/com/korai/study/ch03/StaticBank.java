package com.korai.study.ch03;

public class StaticBank {
    public static void main(String[] args) {
        계좌 a1 = 은행.계좌개설("김준일", 5000);
        계좌 a2 = 은행.계좌개설("김준이", 3000);
        a1.입금(2000);
        System.out.println(a1.예금주 + " " + a1.계좌번호 + " " + a1.잔액);
        System.out.println(a2.예금주 + " " + a2.계좌번호 + " " + a2.잔액);
        System.out.println("은행 총예금: " + 은행.총예금);
    }
}

class 계좌 {
    int 계좌번호;
    String 예금주;
    int 잔액;

    계좌(int 계좌번호, String 예금주, int 잔액) {
        System.out.println("계좌 생성자 호출");
        this.계좌번호 = 계좌번호;
        this.예금주 = 예금주;
        this.잔액 = 잔액;
    }

    void 입금(int 금액) {
        잔액 += 금액;
        은행.총예금 += 금액;
    }
}

class 은행 {
    static int 다음번호 = 1000;
    static int 총예금;

    static {
        System.out.println("은행 클래스 로딩");
    }

    static 계좌 계좌개설(String 예금주, int 첫입금) {
        총예금 += 첫입금;
        return new 계좌(다음번호++, 예금주, 첫입금);
    }
}