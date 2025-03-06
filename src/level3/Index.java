package level3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Index {
    private Calculator cal;
    private Scanner input;

    public Index(Calculator calculator, Scanner input) {
        this.cal = calculator;
        this.input = input;
    }

    public void resultdisplay() {
        while (true) {
            try {
                System.out.println("현재 저장된 결과 목록을 보려면 view, 넘어가려면 enter를 눌러주세요.");
                String index = input.nextLine();

                if (index.equals("view")) {
                    System.out.println("현재 저장된 결과 목록: " + cal.getResults());

                    // 결과 삭제 여부 확인
                    resultDelete();
                    break; // 결과를 본 후 루프 종료
                } else if (index.isEmpty()) {
                    System.out.println("넘어갑니다.");
                    break; // 빈 입력 시 루프 종료
                } else {
                    System.out.println("view 혹은 enter를 입력해주세요");
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                input.nextLine(); // 잘못된 입력을 소비
            }
        }
    }

    private void resultDelete() {
        while (true) {
            try {
                System.out.println("가장 먼저 저장된 결과를 삭제하시겠습니까? (yes/no)");
                String delete = input.nextLine();

                if (delete.equals("yes")) {
                    cal.removeResult(); // 첫 번째 결과 삭제
                    System.out.println("가장 먼저 저장된 결과가 삭제되었습니다.");
                    break; // 삭제 후 루프 종료
                } else if (delete.equals("no")) {
                    System.out.println("넘어갑니다.");
                    break; // 삭제하지 않음
                } else {
                    System.out.println("yes 혹은 no를 입력해주세요");
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                input.nextLine(); // 잘못된 입력을 소비
            }
        }
    }

//    // Getter
//    public Calculator getCalculator() {
//        return cal;
//    }
//    public Scanner getInput() {
//        return input;
//    }
//
//
//    // Setter
//    public void setCalculator(Calculator calculator) {
//        this.cal = calculator;
//    }
//    public void setInput(Scanner input) {
//        this.input = input;
//    }


}
