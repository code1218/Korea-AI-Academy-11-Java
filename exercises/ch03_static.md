# ch03-1. static과 클래스 로딩

> 복습 대상: `ch03/MethodArea.java`, `StaticBasic`, `StaticBank`, `StaticCafe`, `StaticCompany`, `StaticDelivery`, `StaticGame`, `StaticHospital`, `StaticLibrary`, `StaticParking`
> 핵심 키워드: 메서드 영역(클래스 영역), 클래스 로딩, `static` 블록, `static` 변수/메서드, 인스턴스 변수, 생성자, `this`, 전위/후위 증가, 참조, `null`

---

## 1. 개념 확인

### 문제 1-1 ⭐
빈칸을 채우세요.

- `static` 변수는 클래스가 ( ① )될 때 ( ② ) 영역에 **딱 하나** 만들어지고, 모든 객체가 공유한다.
- `static`이 없는 필드(인스턴스 변수)는 `new`로 객체를 만들 때마다 ( ③ ) 영역에 **객체마다 따로** 만들어진다.
- `static { ... }` 블록은 클래스가 처음 사용되는 순간 ( ④ )번 실행된다.
- 생성자는 ( ⑤ ) 할 때마다 실행된다.

<details><summary>정답 보기</summary>

① 로딩 ② 메서드(클래스) ③ 힙 ④ 한 ⑤ `new`(객체 생성)
</details>

### 문제 1-2 ⭐
`StaticBank`의 `은행.총예금`과 `계좌.잔액` 중 어떤 것이 `static`이어야 하고, 왜 그런지 설명하세요.

<details><summary>정답 보기</summary>

- `총예금`은 **은행 전체에 하나만** 있으면 되는 값이므로 `static`.
- `잔액`은 **계좌마다 다른** 값이므로 인스턴스 변수(`static` 없음).
- 만약 `잔액`을 `static`으로 만들면 김준일과 김준이의 잔액이 하나의 값을 공유해 버립니다.
</details>

### 문제 1-3 ⭐⭐
생성자 안의 `this.예금주 = 예금주;` 에서 `this`가 필요한 이유는 무엇일까요?
`this`를 지우고 `예금주 = 예금주;`라고 쓰면 어떻게 될까요?

<details><summary>정답 보기</summary>

매개변수 이름과 필드 이름이 같아서, 그냥 `예금주`라고 쓰면 **매개변수**를 가리킵니다.
`this.예금주`는 "지금 만들어지고 있는 **이 객체의 필드**"를 뜻합니다.
`this` 없이 쓰면 매개변수에 자기 자신을 대입하는 의미 없는 코드가 되어, 필드 `예금주`는 `null`로 남습니다.
(`StaticBasic`의 `나이 = 10;`처럼 이름이 겹치지 않을 때는 `this`를 생략해도 됩니다.)
</details>

---

## 2. 출력 결과 예측

> 각 문제는 **실행 전에 먼저 답을 쓰고**, 수업 코드를 실행해서 확인해 보세요.

### 문제 2-1 ⭐ 클래스 로딩 vs 생성자
`MethodArea`의 `main`을 아래처럼 바꾸면 출력은?

```java
public static void main(String[] args) {
    System.out.println("main 시작");
    TestObject.name = "김준일";
    new TestObject();
    new TestObject();
    System.out.println(TestObject.name);
}
```

<details><summary>정답 보기</summary>

```
main 시작
스태틱 호출
생성자 호출
생성자 호출
김준일
```
- `static` 블록은 `TestObject`를 **처음 사용할 때 딱 한 번**.
- 생성자는 `new` 할 때마다 → 두 번.
- 원래 수업 코드처럼 `new` 없이 static 변수만 쓰면 생성자는 **한 번도** 호출되지 않습니다.
</details>

### 문제 2-2 ⭐⭐ 전위 증가 vs 후위 증가
`StaticCafe`의 `카페.주문하기`에서 `++번호`를 `번호++`로 바꾸면 출력이 어떻게 달라질까요?

```java
static 주문 주문하기(String 메뉴) {
    return new 주문(번호++, 메뉴);   // ++번호 → 번호++
}
```

<details><summary>정답 보기</summary>

| | 원래 (`++번호`) | 변경 후 (`번호++`) |
|---|---|---|
| o1 | 101 | 100 |
| o2 | 102 | 101 |
| o3 | 103 | 102 |
| 마지막 번호 | 103 | 103 |

- `++번호` : **먼저 1 증가**시키고 그 값을 사용
- `번호++` : **현재 값을 먼저 사용**하고 나중에 1 증가
- 어느 쪽이든 세 번 증가했으므로 마지막 `카페.번호`는 103으로 같습니다.
</details>

### 문제 2-3 ⭐⭐ 필드 초기화 순서
`StaticGame`을 실행하면 생성자에서 `"캐릭터 생성자 호출, 레벨=?"`이 출력됩니다. `?`는 얼마이고, 그 이유는?
또 `p1`, `p2`의 최종 출력 결과를 쓰세요.

<details><summary>정답 보기</summary>

```
main 시작
게임서버 클래스 로딩: 아시아-7
캐릭터 생성자 호출, 레벨=1
캐릭터 생성자 호출, 레벨=1
준일 Lv.3 아시아-7
준이 Lv.1 아시아-7
```
- 필드 선언부의 초기값(`int 레벨 = 1;`, `String 서버 = 게임서버.서버이름;`)은 **생성자 본문보다 먼저** 적용됩니다. 그래서 생성자 안에서 레벨은 이미 1입니다.
- `레벨업()`은 **인스턴스 메서드**라서 호출한 객체(p1)의 레벨만 올라갑니다.
</details>

### 문제 2-4 ⭐⭐ 참조 공유
`StaticLibrary`에서 `b3.대출가능 = false;`만 했는데 왜 `b1`의 대출가능도 `false`가 될까요?
`b3 = b1;` 대신 `b3 = 도서관.도서등록("자바의 정석");`으로 바꾸면 출력은?

<details><summary>정답 보기</summary>

- `b3 = b1`은 새 책을 만드는 것이 아니라 **같은 객체의 주소를 복사**한 것입니다. b1, b3는 같은 책을 가리킵니다.
- 바꾼 경우:
```
도서관 클래스 로딩
도서 생성자 호출
도서 생성자 호출
도서 생성자 호출
B2026-1 자바의 정석 true
B2026-2 클린 코드 true
```
  b3는 **새로운 객체**(B2026-3)이므로 b1은 영향을 받지 않습니다. (연도는 실행한 해에 따라 달라집니다.)
</details>

### 문제 2-5 ⭐⭐ static 변수 추적
`StaticHospital`의 실행 결과를 예측하세요. 특히 `대기 인원`이 몇 명인지 줄마다 추적해 보세요.

<details><summary>정답 보기</summary>

```
병원 클래스 로딩
1번 김준일 접수
2번 김준이 접수
3번 김준삼 접수
대기 인원: 1
김준일 true
김준삼 false
```
접수 3번 → 대기인원 3, 진료 2번 → 대기인원 1.
`boolean` 필드는 기본값이 `false`이므로 진료받지 않은 p3는 `false`입니다.
</details>

### 문제 2-6 ⭐⭐⭐ null과 NullPointerException
`StaticParking`의 실행 결과를 예측하세요. 프로그램은 끝까지 정상 종료될까요?

<details><summary>정답 보기</summary>

```
주차장 클래스 로딩
차량 생성자 호출
차량 생성자 호출
56다7890 만차
남은 자리: 0
null
Exception in thread "main" java.lang.NullPointerException ...
```
- 남은 자리가 2개뿐이라 세 번째 차량은 `return null;` → `c3`는 **아무 객체도 가리키지 않습니다**.
- `System.out.println(c3)`는 `null`을 출력할 뿐이지만,
- `c3.차번호`처럼 **null에서 필드를 꺼내려고 하면** `NullPointerException`이 발생해 프로그램이 멈춥니다.
- 해결: `if (c3 != null) { System.out.println(c3.차번호); }`
</details>

### 문제 2-7 ⭐⭐⭐ 상수는 클래스 로딩을 일으킬까?
`StaticCompany`의 `회사` 클래스를 그대로 두고 `main`만 아래처럼 바꾸면 출력은?

```java
public static void main(String[] args) {
    System.out.println(회사.회사명);
    System.out.println("---");
    System.out.println(회사.사원수);
}
```

<details><summary>정답 보기</summary>

```
코라이소프트
---
회사 클래스 로딩
0
```
- `static final String 회사명 = "코라이소프트";`처럼 **값이 확정된 상수**는 컴파일할 때 사용하는 곳에 값이 **직접 복사**됩니다. 그래서 `회사.회사명`만 읽을 때는 클래스가 로딩되지 않습니다.
- `사원수`는 일반 static 변수이므로 이때 처음 클래스가 로딩되고 static 블록이 실행됩니다.
- `int` static 변수는 따로 값을 넣지 않으면 기본값 0입니다.
</details>

---

## 3. 오류 찾기

### 문제 3-1 ⭐⭐
`은행` 클래스에 아래 메서드를 추가하면 컴파일 에러가 납니다. 이유는?

```java
static void 잔액출력() {
    System.out.println(잔액);
}
```

<details><summary>정답 보기</summary>

`static` 메서드는 **객체 없이** `은행.잔액출력()`으로 호출됩니다. 그런데 `잔액`은 계좌 **객체마다 있는** 인스턴스 변수라서, 어느 계좌의 잔액인지 알 수 없습니다.
→ static 메서드에서는 인스턴스 변수/`this`를 직접 사용할 수 없습니다.
해결: 매개변수로 객체를 받는다. (`병원.진료(환자 p)`처럼)

```java
static void 잔액출력(계좌 a) {
    System.out.println(a.잔액);
}
```
</details>

### 문제 3-2 ⭐⭐
반대로 인스턴스 메서드인 `계좌.입금()` 안에서 `은행.총예금 += 금액;`은 왜 문제없이 동작할까요?

<details><summary>정답 보기</summary>

static 변수는 클래스 로딩 시점에 이미 메서드 영역에 존재하므로 **언제 어디서든** `클래스명.변수명`으로 접근할 수 있습니다.
정리: **인스턴스 → static 접근 O**, **static → 인스턴스 직접 접근 X**
</details>

---

## 4. 코드 작성

> 실습 파일: `src/main/java/com/korai/study/practice/ch03/PracticeStatic.java`

### 문제 4-1 ⭐⭐⭐ 영화관 예매 시스템
수업의 `Static*` 예제들과 같은 구조로 영화관 예매 시스템을 완성하세요.

**`티켓` 클래스**
- 필드: `int 좌석번호`, `String 영화제목`, `int 가격`
- 생성자: 세 값을 받아 `this`로 저장하고 `"티켓 생성자 호출"` 출력

**`영화관` 클래스**
- `static int 좌석번호 = 1;` / `static int 남은좌석 = 3;` / `static int 총매출;`
- `static` 블록: `"영화관 오픈"` 출력
- `static int 가격계산(int 나이)` : 나이가 20 미만이면 8000, 아니면 12000
- `static 티켓 예매(String 영화제목, int 나이)`
  - 남은좌석이 0이면 `"<영화제목> 매진"` 출력 후 `null` 반환
  - 아니면 남은좌석 1 감소, 총매출에 가격 추가, 좌석번호를 1씩 증가시키며 티켓 생성해 반환

**기대 출력** (실습 파일의 main 그대로 실행 시)
```
main 시작
영화관 오픈
티켓 생성자 호출
티켓 생성자 호출
티켓 생성자 호출
인터스텔라 매진
1번 좌석 인터스텔라 12000원
3번 좌석 인터스텔라 8000원
남은 좌석: 0
총매출: 32000
t4는 예매 실패
```

<details><summary>정답 보기</summary>

```java
class 티켓 {
    int 좌석번호;
    String 영화제목;
    int 가격;

    티켓(int 좌석번호, String 영화제목, int 가격) {
        System.out.println("티켓 생성자 호출");
        this.좌석번호 = 좌석번호;
        this.영화제목 = 영화제목;
        this.가격 = 가격;
    }
}

class 영화관 {
    static int 좌석번호 = 1;
    static int 남은좌석 = 3;
    static int 총매출;

    static {
        System.out.println("영화관 오픈");
    }

    static int 가격계산(int 나이) {
        if (나이 < 20) {
            return 8000;
        }
        return 12000;
    }

    static 티켓 예매(String 영화제목, int 나이) {
        if (남은좌석 == 0) {
            System.out.println(영화제목 + " 매진");
            return null;
        }
        남은좌석--;
        int 가격 = 가격계산(나이);
        총매출 += 가격;
        return new 티켓(좌석번호++, 영화제목, 가격);
    }
}
```
</details>
