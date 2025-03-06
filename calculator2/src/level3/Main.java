//1. try-catch 문으로 예외처리

package level3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calculator cal = new Calculator();
        Index index = new Index(cal,input);

        String end = "";
        while (!end.equals("exit")) {
            int a = 0, b = 0;
            int result;
            while (true){
                try {
                    System.out.println("양의 정수 2개를 입력하세요.(0 포함)\n(공백을 통해 두 숫자를 나눌 수 있습니다.)");
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    a = input.nextInt();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    b = input.nextInt();

                    //줄바꿈 문자 소비
                    input.nextLine();

                    if (a >= 0 && b >= 0) {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("잘못된 입력입니다. 양의 정수를 입력해주세요.");
                    input.nextLine(); // 잘못된 입력을 소비
                }
            }


            System.out.println("사칙연산의 기호를 입력해주세요.(+, -, *, /)");
            System.out.print("입력 : ");
            char mark = input.nextLine().charAt(0);

            try{
                cal.setA(a);
                cal.setB(b);
                //OperatorType symbol = new OperatorType(mark);
                //열거형 생성자는 직접 호출하는 것이 불가능
                //이미 정의된 인스턴스를 사용해야함
                //fromMark(정적메소드)를 사용하여 상수집합 호출
                OperatorType symbol = OperatorType.setMark(mark);

                cal.setMark(symbol);

                result = cal.calculate();
                System.out.println("결과 : " + result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }



            index.resultdisplay();

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

