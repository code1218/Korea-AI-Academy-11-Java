package com.korai.study.practice.ch02;

// 연습문제: exercises/ch02_함수.md 의 "4. 코드 작성"
public class Practice02 {
    public static void main(String[] args) {

        class 변환도구 {
            // 수업 코드와 같은 함수 (완성되어 있음)
            String 날짜표기변환(String date) {
                String[] splitDate = date.split("-");
                return splitDate[0] + "년 " + splitDate[1] + "월 " + splitDate[2] + "일";
            }

            // [문제 4-1] "14:30" -> "14시 30분"
            String 시간표기변환(String time) {
                // TODO
                return "";
            }

            // [문제 4-2] "010-1234-5678" -> "010-****-5678"
            String 전화번호마스킹(String phone) {
                // TODO
                return "";
            }

            // [문제 4-3] "2026-09-29" -> {2026, 9, 29}
            int[] 날짜분리(String date) {
                // TODO (힌트: Integer.parseInt("09") 는 숫자 9)
                return new int[] {0, 0, 0};
            }

            // [문제 4-4] ("2026-09-29", "14:30") -> "2026년 09월 29일 14시 30분"
            // 직접 split 하지 말고 위의 함수들을 호출해서 만드세요.
            String 일시표기(String date, String time) {
                // TODO
                return "";
            }
        }

        변환도구 tool = new 변환도구();

        // 아래 코드는 수정하지 말고 실행 결과로 정답을 확인하세요.
        System.out.println(tool.시간표기변환("14:30"));           // 14시 30분
        System.out.println(tool.전화번호마스킹("010-1234-5678"));  // 010-****-5678

        int[] d = tool.날짜분리("2026-09-29");
        System.out.println(d[0] + " / " + d[1] + " / " + d[2]);   // 2026 / 9 / 29

        System.out.println(tool.일시표기("2026-09-29", "14:30"));  // 2026년 09월 29일 14시 30분
    }
}
