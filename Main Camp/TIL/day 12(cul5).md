[본캠프 12일차] 계산기 프로젝트 5

# 1. 오늘의 학습 내용
`키워드` - enum 열거형

### 1. 공부
1. Enum
- 상수를 관리하기 위한 클래스
    - final 등으로 상수를 표현할 수 있지만 가독성이 떨어지는 등의 문제가 있음
    (ex)private final int a = 1;
- 클래스이기 때문에 열거형의 독립된 파일을 생성할 수 있음
- 선언 방법
    - enum 클래스명 { 열거 상수 }
    ```java
    enum Week {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
    ```
    - 클래스명은 대문자
    - 열거 상수는 모두 대문자로 작성, 스네이크 케이스 사용(SUN_DAY)
- 참조 방법
    - 열거타입 변수명 = 열거타입.열거상수
    Week monday = Week.MONDAY;
---
### 2. 계산기 프로젝트
1. 열거형을 사용해 연산자 타입 관리
- enum클래스 만들기
```java
public enum OperatorType {
    //속성
    ADD('+'),
    SUB('-'),
    MUL('*'),
    DIV('/');
}
```
- OperatorType의 생성자 작성
```java
    OperatorType(char mark) {
        this.mark = mark;
    }
```
- OperatorType의 기능 작성
```java
public char getMarkl() {
        return mark;
    }
```
- 받아온 mark가 enum에 선언된 상수와 일치하는지 판단하기
```java
    public static OperatorType setMark(char mark) {
        for (OperatorType op : OperatorType.values()) {
            //values() : 모든 열거 객체 배열로 만들어 리턴
            //선언된 상수와 입력받은 기호가 일치하면 op 리턴
            if (op.getMarkl() == mark) {
                return op;
            }
        }
        throw new IllegalArgumentException("잘못된 연산 기호입니다: " + mark);
    }
```
---
- OperatorType을 사용하기 위한 코드 main에 추가
```java
//OperatorType symbol = new OperatorType(mark);
//열거형 생성자는 직접 호출하는 것이 불가능
//이미 정의된 인스턴스를 사용해야함
//fromMark(정적메소드)를 사용하여 상수집합 호출
OperatorType symbol = OperatorType.setMark(mark);
```


# 2. 내일 할 것
- 계산기 과제 제출

