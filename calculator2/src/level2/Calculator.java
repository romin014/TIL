//객체지향 -> ?
//확실한 역할 설정
package level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private int result, a, b;
    private char mark;
    private ArrayList<Integer> results;

    public Calculator() {
        results = new ArrayList<>();
    }

    int calculate() {
        switch (mark) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b != 0) {
                    result = a / b;
                    //result = a % b;
                } else {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.“");
                }
                break;
            default:
                System.out.println("잘못된 연산 기호입니다.");
                break;
        }
        results.add(result);
        return result;
    }

    //setter
    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }
    //getter
//    public int getA() {
//        return a;
//    }
//
//    public int getB() {
//        return b;
//    }
//
//    public char getMark() {
//        return mark;
//    }

    public List<Integer> getResults() {
        return results;
    }

    //첫번째 인덱스의 값 삭제
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        } else {
            System.out.println("삭제할 결과가 없습니다.");
        }
    }
}
