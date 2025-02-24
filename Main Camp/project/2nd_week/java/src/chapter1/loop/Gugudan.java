package chapter1.loop;

import java.util.Scanner;

public class Gugudan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Quiz1
        System.out.print("출력할 구구단 단수를 입력하세요(2~9): ");
        int number = input.nextInt();
        if (number < 2 || number > 9) {
            System.out.println("2~9사이의 숫자를 입력해주세요.");
        } else {
            System.out.println("====  " + number + "단  ====");
            for (int z = 1; z <= 9; z++) {
                System.out.println(number + " x " + z + " = " + (number * z));
            }


            //Quiz2
            for (int i = 2; i <= 9; i++) {
                System.out.println("====  " + i + "단  ====");
                for (int j = 1; j <= 9; j++) {
                    System.out.println(i + " x " + j + " = " + (i * j));
                }
            }
        }
    }
}
