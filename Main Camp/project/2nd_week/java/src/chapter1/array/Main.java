package chapter1.array;

public class Main {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[10];
        int[] arr2 = new int[5];
        int[] arr3 = {1,2,3,4,5};

        int arrLength = arr3.length;
        System.out.println("arrLength = " + arrLength);

        System.out.println("배열의 첫번째 요소 접근: " + arr[0]);
        arr[0] = 10;
        System.out.println("배열의 첫번째 요소 접근: " + arr[0]);

        for (int i = 0; i < arr3.length; i++) {
            System.out.println("인덱스: " + i + ", 값: " + arr3[i]);
        }

        for(int a: arr3){
            System.out.println("값 : " + a);
        }

        boolean[][] board = new boolean[2][2];
        boolean[][] board2 = {
                {true, false},
                {false, true}
        };
    }
}
