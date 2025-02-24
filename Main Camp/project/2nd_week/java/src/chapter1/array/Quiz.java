package chapter1.array;

public class Quiz {
    public static void main(String[] args) {
        //Quiz1
        int[] arr1 = {3, 4, 7, 10, 15, 20};
        System.out.print("짝수: ");
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] % 2 == 0) {
                System.out.print(arr1[i] + " ");
            }
        }
        System.out.println("");

        //Quiz2
        int[] arr2 = {2, 5, 8};
        int sum = 0;
        for (int i = 0; i < arr2.length; i++) {
            sum += arr2[i];
        }
        System.out.println("누적합: " + sum);

        //Quiz3 - 검은돌 true
        boolean[][] board = {
                {true, false},
                {false, true}
        };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]) {
                    System.out.println("검은돌 위치: (" + i + "," + j + ")");
                }
            }
        }
    }
}
