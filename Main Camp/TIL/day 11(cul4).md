[본캠프 11일차] 계산기 프로젝트 4

# 1. 오늘의 학습 내용
`키워드` - try-catch 예외처리

## 1. 공부
### 1. try-catch 예외처리
- 프로그램 실행 중 일어날 수 있는 오류를 처리하여 비정상적인 종료 방지
- 기본 구조
```java
try {
    // 예외가 발생할 수 있는 코드
} catch (예외타입 e) {
    // 예외가 발생했을 때 실행될 코드
}
```
- 의도적인 예외
    - throw : 특정 조건을 통해 의도적으로 예외를 만들 수 있음
```java
if(조건) {
    throw new 예외타입 ("에러 메세지");
}
```
- 예외 타입 종류
    - 체크 예외(Checked Exception)  
        : 컴파일러가 예외처리를 강제하는 예외 -> 예외처리하지 않으면 컴파일 오류 발생
        - Exception 클래스를 직접 상속받는 모든 예외
        - IOException : 입력 또는 출력 작업 중 발생하는 예외  
        - SQLException : 데이터베이스 관련 작업 중 발생하는 예외
        - ClassNotFoundException : 클래스 로딩 중 해당 클래스를 찾을 수 없는 경우
    - 언체크 예외(Unchecked Exception)  
        : 컴파일러가 예외처리를 강제하지 않는 예외 -> 예외처리를 하지 않아도 컴파일 오류가 발생하지 않음(논리 오류 등으로 발생)
        - RuntimeException 을 상속받는 모든 예외
        - NullPointerException : null 객체에 접근하려고 할 때 발생
        - ArrayIndexOutOfBoundsException : 배열의 유효 범위를 초과하는 인덱스에 접근할 때 발생
        - ArithmeticException : 수학적 연산 중 오류가 발생할 때 (예: 0으로 나누기)
        - ClassCastException : 잘못된 타입으로 객체를 캐스팅하려 할 때 발생
        - IllegalArgumentException : 메소드에 전달된 인자가 올바르지 않을 때 발생
        - InputMismatchException : 사용자가 입력한 데이터가 예상한 타입과 일치하지 않을 때 발생


### 2. 계산기 프로젝트
> 휴일 간 index 클래스 추가, try-catch를 통한 예외처리를 진행했으나 예상치 못한 충돌로 인한 롤백...  
> lv 2 마무리

1. Index 클래스 추가
- Index 클래스 작성
    - 저장된 결과 목록을 보거나 삭제하는 기능
    - main에 있던 코드 수정
```java
//Index
package level2;

import java.util.Scanner;

public class Index {
    private Calculator cal;
    private Scanner input;

    public Index(Calculator calculator, Scanner input) {
        this.cal = calculator;
        this.input = input;
    }

    public void resultdisplay() {
        while (true) {
            System.out.println("현재 저장된 결과 목록을 보려면 view, 넘어가려면 enter를 눌러주세요.");
            String index = input.nextLine();

            if (index.equals("view")) {
                System.out.println("현재 저장된 결과 목록: " + cal.getResults());

                // 결과 삭제 여부 확인
                resultDelete();
                break; // 결과를 본 후 루프 종료
            } else if (index.isEmpty()) {
                System.out.println("넘어갑니다.");
                break; // 빈 입력 시 루프 종료
            } else {
                System.out.println("view 혹은 enter를 입력해주세요");
            }
        }
    }

    private void resultDelete() {
        while (true) {
            System.out.println("가장 먼저 저장된 결과를 삭제하시겠습니까? (yes/no)");
            String delete = input.nextLine();

            if (delete.equals("yes")) {
                cal.removeResult(); // 첫 번째 결과 삭제
                System.out.println("가장 먼저 저장된 결과가 삭제되었습니다.");
                break; // 삭제 후 루프 종료
            } else if (delete.equals("no")) {
                System.out.println("넘어갑니다.");
                break; // 삭제하지 않음
            } else {
                System.out.println("yes 혹은 no를 입력해주세요");
            }
        }
    }
}

```
- 생성한 메서드에 맞게 main 수정
```java
//Main
index.resultdisplay();
```

2. 예외처리
- try-catch를 사용한 예외처리
```java
//Main
while (!end.equals("exit")) {
    int a = 0, b = 0;
    int result;
    while (true){
        try {
            //... 두 양의 정수 입력받기...
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
            input.nextLine(); // 잘못된 입력을 소비
        }
    }
}
```
```java
//Calculator
public int calculate() {
        try {
            switch (mark) {
                //...사칙연산...
            }
            results.add(result); // 결과를 리스트에 추가
            return result; // 결과 반환
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 예외 메시지 출력
            return 0; // 오류 발생 시 0 반환
        }
    }
```
```java
//Index
public void resultdisplay() {
        while (true) {
            try {
                //...결과 확인...
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                input.nextLine(); // 잘못된 입력을 소비
            }
        }
    }

    private void resultDelete() {
        while (true) {
            try {
                //...결과삭제...
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                input.nextLine(); // 잘못된 입력을 소비
            }
        }
    }
```


# 2. 내일 할 것
- 계산기 과제 lv 3 완료

