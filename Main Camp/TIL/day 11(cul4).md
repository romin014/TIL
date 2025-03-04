[본캠프 11일차] 계산기 프로젝트 4

# 1. 오늘의 학습 내용
`키워드` - try-catch 예외처리

### 1. 계산기 프로젝트
> 휴일 간 index 클래스 추가, try-catch를 통한 예외처리를 진행했으나 예상치 못한 충돌로 인한 롤백...
> lv 2 마무리

1. Index 클래스 추가
- Index 클래스 작성
    - 저장된 결과 목록을 보거나 삭제하는 기능
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

