package level3_2;

public enum OperatorType {
    //속성
    ADD('+'),
    SUB('-'),
    MUL('*'),
    DIV('/');

    private final char mark;

    //생성자
    OperatorType(char mark) {
        this.mark = mark;
    }

    //기능
    public char getMarkl() {
        return mark;
    }

    public static OperatorType setMark(char mark) {
        for (OperatorType op : OperatorType.values()) {
            //values() : 모든 열거 객체 배열로 만들어 리턴
            //선언된 상수와 입력받은 기호가 일치하면 op 리턴
            if (op.getMarkl() == mark) {
                return op;
            }
        }
        throw new IllegalArgumentException("잘못된 연산 기호입니다: " + mark);
    }

}


