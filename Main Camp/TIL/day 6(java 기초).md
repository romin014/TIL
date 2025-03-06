[본캠프 6일차] git, java 기초 chapter 1

# 1. 오늘의 학습 내용
`키워드` - 강의 챕터 1(java란, 컴퓨터의 기억방식, 프로젝트 관리, 변수, 입출력, 연산자, 조건문, 반복문, 배열, 메서드), git 기초
### 1. Git 협업
* Git이란?  
   - 복습 후 추가

### 2. java 기초
---
1. java란
* JDK - 개발 도구 모음
   * Javac(Java Compiler) - 자바코드를 바이코드로 변환
   * JVM - java 프로그램을 실행하는 가상 머신
   * 바이트코드(.class) - Javac가 변환한 파일
* Java의 특징
   * 객체지향 언어(클래스)
   * 플랫폼 독립성 -> 많은 사람이 사용  
   ---
2. 바이트와 비트
* RAM
   * 컴퓨터의 주기억장치 중 한 종류
   * 휘발성 - 전원 공급이 중단되면 저장된 데이터가 사라짐
* 보조기억장치(HDD, SDD)
   * 전원을 끄더라도 저장된 데이터가 사라지지 않고 영구적으로 보관 가능
   * 비교적 느림
* 메모리 단위
   * 바이트(Byte) - 8bit의 데이터 단위
   * 비트(Bit) - 컴퓨터에서 데이터를 표현하는 가장 작은 단위, 0또는 1의 값을 가짐
   ---
3. 이름규칙
* 이름 규칙의 종류
   * 카멜 케이스(camelCase) ex. firstName 
   * 스네이크 케이스(snake_case) ex. first_name
* 패키지 이름 규칙
   * 소문자만 활용
   * 숫자로 시작 금지
   * 특수문자 사용 금지
   * 예약어 사용 금지
   * ex. firstname1
* 클래스
   * 대문자로 시작
   * 카멜케이스
   * 숫자로 시작 금지
   * 특수문자 사용 금지
   * 예약어 사용 금지
   *  ex. FirstName1
   ---
4. 변수
* 변수
   * 변수의 구조 - [자료형] [변수이름];
      * ex. int a;
   * 변수의 이름 규칙
      * 숫자로 시작할 수 없음
      * 공백 사용 불가
      * 예약어 사용 불가
      * 특수문자 사용가능(_, $)
   * 변수 선언
      * 데이터 저장공간 할당
      * ex. int a = 3; -> 변수 선언 후 값 할당
* 자료형
   * 논리형 : boolean -> 1bite
   * 문자형 : char -> 2bite
   * 정수형
      * byte -> 1bite
      * short -> 2bite
      * int -> 4bite
      * long -> 8bite
   * 실수형
      * float -> 4bite
      * double -> 8bite
* 참조 자료형
   * string - 문자열 저장
      * " "를 통해 데이터 표현
      * ex. String str = "Hello"
* 형변환
   * 다운캐스팅
      * 명시적 변환
      * 데이터 손실 발생
      * ex. 
      ```
      double first = 2.222;
      int second = `(int)` first;// 명시적 변환
      -> 출력값 : 10
      ```
   * 업캐스팅
      * 묵시적 변환
      * ex.
      ```
      int first = 2;// 묵시적 변환
      double first = second;
      -> 출력값 : 10.0
      ```
      ---
5. 입출력
* 출력
   * System.out.`print`() - 줄바꿈 없이 출력
   * System.out.`println`() - 출력 후 줄바꿈
   * \n(개행 문자) - 줄바꿈
* 입력
   * Scanner
      * Scanner sc = new Scanner(System.in); -> 객체 생성후 sc변수에 담기
      * scanner.nextLine() -> 문자열 데이터 입력받기
      * nextInt, nextDouble, nextLong 으로 숫자 입력받기
      ---
6. 연산자
* 산술 연산자(+, -, *, /, %)
* 대입 연산자(=)
   * 복합 대입 연산자(+=, -=, *=, /= , %=)
* 증감 연산자(++, --)
   * 전위 연산 -> 연산 후 사용
   * 후위 연산 -> 사용 후 연산
   * ex.
   ```
   int a = 5;
   int b = 5;
   System.out.println("++a: " + (++a));  // 6 (먼저 증가 후 출력)
   System.out.println("현재 a 값: " + a);  // 6

   System.out.println("b++: " + (b++));  // 5 (출력 후 증가)
   System.out.println("현재 b 값: " + b);  // 6
   ```
* 비교 연산자(==, !=, <, >, <=, >=)
* 논리 연산자(!, &&, ||)
   * AND(&&) : 두 조건 모두 참일 대 참
   * OR(||) : 두 조건 중 하나라도 참일 때 참
   * NOT(!) : 참 -> 거짓, 거짓 -> 참
* 우선순위
   * 기본 연산자
      * 산술 -> 비교 -> 논리 -> 대입
   * 산술 연산자
      * 사칙연산 우선순위와 동일
   * 논리 연산자
      * ! -> && -> ||
* 문자열 비교(equals())
   * 문자열을 비교할 때 == 연산자가 아닌 .equals() 사용
   * ex. boolean isEqual = text1`.equals`(text2);
   ---
7. 조건문
* if문
   * if문 구조
   ```
      if(조건수식1){
         //조건수식 1이 참일 때 실행
         명령문;
      } else if(조건 수식2){
         //조건 수식 1이 거짓이고 조건 수식 2가 참일 때 실행
         명령문;
      } else {
         //조건 수식 1, 2 모두 거짓일 때 실행
         명령문;
      }
   ```   
* switch문
   * switch문 구조
```
   switch (단일값) {
    case 값 1:
    //단일값이 1일 때 실행
         명령문;
        break;
    case 값 2:
    //단일값이 2일 때 실행
        명령문;
        break;
    default:
    //단일값이 위의 값들 중 없을 때 실행
        명령문;
        break;
     }
```
* fall-through 현상
   * 각 case에 break를 사용하지 않으면 break를 만난 때까지 다음 case의 명령문을 실행
   ---
8. 반복문
* for
   * for문의 구조
   ```
   for (시작조건; 종결조건; 조건변화수식) {
		명령문;
   }
   ```
   ex.
   ```
   for (int i = 1; i <= 10; i++) {
      System.out.println("hello");
   }
   ```
   * break와 continue
      * break : 조건이 맞을 경우 멈춤
      * continue : 조건에 맞을 경우 해당 조건의 명령문 건너뜀
* while
   * while의 구조
   ```
   while (종결조건) {
		반복할 명령문;
   }
   ```
   * 종결조건 혹은 break가 없을 경우 무한 루프에 빠질 수 있음
* do-while
   * do-while의 구조
   ```
   do {
		반복할 명령문..
   } while (종결 조건)
   ```
   * 먼저 실행 후 종결 조건 확인 -> while문은 조건 확인 후 실행
   => 조건이 참이 아니더라도 무조건 1번은 실행
   ---
9. 배열
* 배열 
   * 비슷한 데이터를 묶어서 표현
   * 자료형[] 변수이름 = new 자료형[배열의길이];
   * ex. int[] arr = new int[5];
* 배열의 길이
   * 배열이름.length
   * `int arrLenght =  adventurerList.length;`
* 인덱스
   * 0부터 시작
   * ex.
   ```
   System.out.println("배열의 1번째 요소 = " + arr[0]);
   ```
* 배열 탐색
   * 향상된 for문
      * 모든 요소를 꺼내 활용할 때 사용
      ```
      for(배열의요소 : 배열) {
		   명령문;
      }
      ```
      * arr의 요소를 하나씩 꺼내 a에 저장
* 2차원 배열  
   * 첫 번째 인덱스는 행(가로), 두 번째 인덱스는 열(세로)
   * ex
   ```
   boolean [][] board = new boolean[2][2];
   => boolean [][] board = {
      {true, false}, 
		{false, true} 
   }
   ```
   ---
10. 메서드
* 메서드
   * 함수, 기능이라고도 함
   * 메서드의 구조
   ```
   public class 클래스이름 {

		[반환자료형] [메서드이름](매개변수) {
				명령문들;
		}
   }
   ```
   * 지역변수
      * 메서드 안에서만 사용가능한 변수
   * 메서드 호출과 선언
      * 호출부 -> main 등 메서드를 사용하기 위해 호출하는 곳
      * 선언부 -> 메서드가 정의되어있는 곳
      * 매개변수를 통해 연산에 필요한 데이터 전달 가능
      * 반환값 O -> return을 통해 연산한 값을 호출부로 전달 가능
      * 반환값 X -> return할 값이 없다면 void 선언
      ---

# 2. 내일 할 것
- java 챕터 2강의
- git 협업 강의 복습
- 계산기 과제

