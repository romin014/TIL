[본캠프 9일차] 계산기 프로젝트 2

# 1. 오늘의 학습 내용
`키워드` - 복습(메서드, 캡슐화, 컬렉션), 프로젝트 2단계

### 1. 계산기 프로젝트
> lv 2 start
---
1. 사칙연산을 수행 후, 결과값 반환 메서드 구현 & 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
- 기존 코드를 수정해 사칙연산 부분을 메서드로 생성
    - 양의 정수 2개와 연산기호를 매개변수로 받고 결과값 반환
```java
public class Culculator {
    int result, a, b;
    char mark;
    public Culculator(int a, int b, char mark) {
        this.a = a;
        this.b = b;
        this.mark = mark;
    }

    int calculate(){
        switch (mark) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b != 0) {
                    result = a / b;
                    //result = a % b;
                } else {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.“");
                }
                break;
            default:
                System.out.println("잘못된 연산 기호입니다.");
                break;
        }
        return result;
    }
}
```
---
2. Lv 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정
- Calculator 객체 생성
    - 메서드를 호출해 결과를 계산하고 출력
```java
if (a >= 0 && b >= 0) {
    System.out.println("필요한 연산의 기호를 입력해주세요.(+, -,*, /)");
    System.out.print("입력 : ");

    //Calculator 객체 생성
    char mark = input.nextLine().charAt(0);
    //calculator 메서드를 호출하여 결과 계산
    result = cal.calculate();
    //결과 출력
    System.out.println(result);

} else {
    System.out.println("양의 정수를 입력해주세요.(0 포함)");
}
```
---
3. main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)
- 캡슐화를 통해 간접 접근
    - 접근제어자 사용
```java
private int result, a, b;
private char mark;
```
---
# 2. 내일 할 것
- 계산기 과제 lv 2 완료(컬랙션을 통한 저장된 데이터 삭제 기능)
    - 세부규격에 맞춰 프로젝트 수정하기
        (1. 연산결과 저장하는 메서드  
        2. getter 메서드와 setter 메서드를 사용해 캡슐화  
        3. lv 1의 기능(나머지) 구현)

