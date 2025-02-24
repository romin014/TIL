package io;

import java.util.Scanner;

public class InOutQuiz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("이름을 입력하세요: ");
        String name = input.nextLine();

        System.out.print("나이를 입력하세요: ");
        int age = input.nextInt();

        System.out.println("출력결과:");
        System.out.println("이름: "+name);
        System.out.println("나이: "+age);


    }
}
