package com.korai.study.ch03;

import java.time.LocalDate;

public class StaticCompany {
    public static void main(String[] args) {
        System.out.println("main 시작");
        사원 e1 = 회사.입사("김준일", "개발");
        사원 e2 = 회사.입사("김준이", "디자인");
        사원 e3 = 회사.입사("김준삼", "개발");
        System.out.println(e1.사번 + " " + e1.이름 + " " + e1.부서);
        System.out.println(e3.사번 + " " + e3.이름 + " " + e3.부서);
        System.out.println(회사.회사명 + " 사원 수: " + 회사.사원수);
    }
}

class 사원 {
    String 사번;
    String 이름;
    String 부서;
    int 연봉 = 3000;

    사원(String 사번, String 이름, String 부서) {
        System.out.println("사원 생성자 호출");
        this.사번 = 사번;
        this.이름 = 이름;
        this.부서 = 부서;
    }
}

class 회사 {
    static final String 회사명 = "코라이소프트";
    static int 입사년도 = LocalDate.now().getYear() % 100;
    static int 사원수;

    static {
        System.out.println("회사 클래스 로딩");
    }

    static 사원 입사(String 이름, String 부서) {
        사원수++;
        String 사번 = 입사년도 + (부서.equals("개발") ? "D" : "X") + 사원수;
        return new 사원(사번, 이름, 부서);
    }
}