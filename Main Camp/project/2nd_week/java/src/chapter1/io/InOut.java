package io;

import java.util.Scanner;

public class InOut {
    public static void main(String[] args) {
        //개행
        System.out.println("Hello");
        System.out.println("Java");

        System.out.print("Hello");
        System.out.print("Java");

        System.out.println("Hello\nWorld");

        //입력
        Scanner scanner = new Scanner(System.in);

        //문자열 입력받기
        System.out.print("좋아하는 문장 입력 : ");
        String sentence = scanner.nextLine();
        System.out.println("sentence = "+ sentence);

        //정수 입력받기
        System.out.print("좋아하는 숫자 입력 : ");
        int intBox = scanner.nextInt();
        System.out.println("intBox = "+ intBox);

        //소수점
        System.out.print("숫자(소수점) 입력 : ");
        double dobleBox = scanner.nextDouble();
        System.out.println("dobleBox = "+ dobleBox);
    }
}
