package chapter1.loop;

public class Main {
    public static void main(String[] args) {
        int customers = 3;

        for (int i = 1; i <= customers; i++) {
            if (i == 2) {
                continue;
            }
            System.out.println(i + "번째 손님, 안녕하세요!");
        }
        System.out.println("반복문이 종료되었습니다.");


        int i = 1;
        while (i <= 3) {
            System.out.println("i 가 3 보다 작습니다.");
            i++;
        }

        int j = 1;
        do {
            System.out.println("안녕하세요.");
            j++;
        } while (j <= 3);
    }

}

