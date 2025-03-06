package level2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calculator cal = new Calculator();
        Index index = new Index(cal,input);
        //3. "exit"가 입력될 때까지 반복
        String end = "";
        while (!end.equals("exit")) {

            //1. 정수 입력받기
            System.out.println("양의 정수 2개를 입력하세요.(0 포함)\n(공백을 통해 두 숫자를 나눌 수 있습니다.)");
            System.out.print("입력 : ");
            int a = input.nextInt();
            int b = input.nextInt();
            int result;

            //줄바꿈 문자 소비
            input.nextLine();

            if (a >= 0 && b >= 0) {

                System.out.println("필요한 연산의 기호를 입력해주세요.(+, -, *, /)");
                System.out.print("입력 : ");
                char mark = input.nextLine().charAt(0);

                cal.setA(a);
                cal.setB(b);
                cal.setMark(mark);

                result = cal.calculate();
                System.out.println("결과 : " + result);
            } else {
                System.out.println("양의 정수를 입력해주세요.(0 포함)");
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

