[본캠프 8일차] java 기초 chapter 3, 계산기 프로젝트

# 1. 오늘의 학습 내용
`키워드` - 강의 챕터 3(예외처리, Optional-null, 컬렉션, 제네릭, 람다), 프로젝트 1단계
### 1. java
*  

### 2. 계산기 프로젝트
> lv 1 start
---
1. 양의 정수(0 포함)를 입력받기
- 계산에 사용할 양의 정수 2개 입력받기
   - **공백**을 통해 두 정수 저장

```java
Scanner input = new Scanner(System.in);
System.out.println("양의 정수 2개를 입력하세요.(0 포함)\n(공백을 통해 두 숫자를 나눌 수 있습니다.)");
System.out.print("입력 : ");
int a = input.nextInt();
int b = input.nextInt();
```

- 양의 정수인지 판단하기 위한 if문
   - 입력 오류 확인을 위한 `System.out.println("입력된 숫자 : " + a + " " + b);`  
   *-> 오류 확인 후 삭제*
```java
if (a >= 0 && b >= 0) {
   //System.out.println("입력된 숫자 : " + a + " " + b);
} else {
   System.out.println("양의 정수를 입력해주세요.(0 포함)");
   }
```
---

2. 사칙연산 기호(➕,➖,✖️,➗)를 입력받기
- 입력받을 기호를 Sting으로 저장
   - 입력 오류 확인을 위한 `System.out.println("입력된 기호 : " + mark);`  
   *-> 오류 확인 후 삭제*

```java
System.out.println("필요한 연산의 기호를 입력해주세요.(+, -, *, /)");
System.out.print("입력 : ");
char mark = input.nextLine().charAt(0);
//System.out.println("입력된 기호 : " + mark);
```
- 에러 발생 : `String mark = input.nextLine();`을 통한 입력 불가
   - 이유 : nextInt() 메소드는 입력한 정수 뒤에 남아있는 줄바꿈 문자를 소비하지 않음.  
   -> nextInt()를 통해 정수를 입력 받은 후 입력 버퍼에 줄바꿈 문자가 남아있어 nextLine() 메소드에 따로 입력하지 않았음에도 아무것도 입력받지 못한채 빈문자열이 반환됨.
   - 해결방안 : mark를 입력받기 전 `input.nextLine();` 을 사용해 줄바꿈 문자 소비
   ---

3. 위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기
- 입력받은 기호를 통해 사칙연산 수행
   - switch문을 활용해 입력받은 기호에 대한 결과값 출력
```java
switch (mark) {
   case '+':
      System.out.println("결과 : " + (a + b));
      break;
   case '-':
      System.out.println("결과 : " + (a - b));
      break;
   case '*':
      System.out.println("결과 : " + (a * b));
      break;
   case '/':
      if (b != 0) {
         System.out.println("몫 : " + (a / b));
         System.out.println("나머지 : " + (a % b));
      } else {
         System.out.println("0으로 나눌 수 없습니다.");
      }
      break;
   default:
      System.out.println("잘못된 연산 기호입니다.");
      break;
}
```
---
4. 반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기
- exit문자열을 입력하기 전에 무한으로 반복하기 위해 while문 사용

```java
String end = "";
while (!end.equals("exit")){

   ...위의 과정
         
   System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
   end = input.nextLine();
   if(end.equals("exit")){
      System.out.println("계산을 종료합니다.");
   } else {
      System.out.println("다음 계산을 진행합니다.");
   }
}

```
---
5. lv 1 코드 전체
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //3. "exit"가 입력될 때까지 반복
        String end = "";
        while (!end.equals("exit")) {

            //1. 정수 입력받기
            System.out.println("양의 정수 2개를 입력하세요.(0 포함)\n(공백을 통해 두 숫자를 나눌 수 있습니다.)");
            System.out.print("입력 : ");
            int a = input.nextInt();
            int b = input.nextInt();

            //줄바꿈 문자 소비
            input.nextLine();

            if (a >= 0 && b >= 0) {
                //2. 사칙연산 기호 입력받기
                System.out.println("필요한 연산의 기호를 입력해주세요.(+, -, *, /)");
                System.out.print("입력 : ");
                char mark = input.nextLine().charAt(0);

                //입력된 기호에 맞는 연산 진행
                switch (mark) {
                    case '+':
                        System.out.println("결과 : " + (a + b));
                        break;
                    case '-':
                        System.out.println("결과 : " + (a - b));
                        break;
                    case '*':
                        System.out.println("결과 : " + (a * b));
                        break;
                    case '/':
                        if (b != 0) {
                            System.out.println("몫 : " + (a / b));
                            System.out.println("나머지 : " + (a % b));
                        } else {
                            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.“");
                        }
                        break;
                    default:
                        System.out.println("잘못된 연산 기호입니다.");
                        break;
                }

            } else {
                System.out.println("양의 정수를 입력해주세요.(0 포함)");
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            end = input.nextLine();
            if (end.equals("exit")) {
                System.out.println("계산을 종료합니다.");
            } else {
                System.out.println("다음 계산을 진행합니다.");
            }
        }


    }
}

```

# 2. 내일 할 것
- java 챕터 2강의 복습 끝내기
- 계산기 과제 lv 2 해보기

