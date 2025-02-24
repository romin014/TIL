package chapter1.operater;

import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        //Quiz1
        int a = 10;
        int b = 20;

        int sum = a + b;
        int sub = a - b;
        int mul = a * b;
        int div = a / b;
        int mod = a % b;

        System.out.println("덧셈 결과 : " + sum);
        System.out.println("뺄셈 결과 : " + sub);
        System.out.println("곱셈 결과 : " + mul);
        System.out.println("나눗셈 결과 : " + div);
        System.out.println("나머지 결과 : " + mod);

        //Quiz2
        int x = 10;
        int y = 20;

        System.out.println("x가 y보다 큰가? : " + (x>y));
        System.out.println("x가 y보다 작은가? : " + (x<y));
        System.out.println("x가 y보다 같은가? : " + (x==y));
        System.out.println("x가 y보다 다른가? : " + (x!=y));

        //Quiz3
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 문자열을 입력하세요: ");
        String str = sc.nextLine();
        System.out.print("두 번째 문자열을 입력하세요: ");
        String str2 = sc.nextLine();
        boolean result = str.equals(str2);
        System.out.print("두 문자열이 같은가요? " + result);



    }
}
