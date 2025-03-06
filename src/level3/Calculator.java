package level3;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private int result, a, b;
    private OperatorType mark;
    private ArrayList<Integer> results;

    public Calculator() {
        results = new ArrayList<>();
    }

    public int calculate() {
        try {
            switch (mark) {
                case ADD:
                    result = a + b;
                    break;
                case SUB:
                    result = a - b;
                    break;
                case MUL:
                    result = a * b;
                    break;
                case DIV:
                    if (b != 0) {
                        result = a / b;
                    } else {
                        throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다."); // 예외 발생
                    }
                    break;
                default:
                    throw new IllegalArgumentException("잘못된 연산 기호입니다."); // 예외 발생
            }
            results.add(result); // 결과를 리스트에 추가
            return result; // 결과 반환
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 예외 메시지 출력
            return 0; // 오류 발생 시 0 반환
        }
    }

    // Setter 메서드
    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setMark(OperatorType mark) {
        this.mark = mark;
    }

    // Getter 메서드
    public List<Integer> getResults() {
        return results;
    }

    // 첫 번째 인덱스의 값 삭제
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        } else {
            System.out.println("삭제할 결과가 없습니다.");
        }
    }
}
