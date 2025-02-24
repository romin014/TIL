package chapter1.operater;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        
        int sum = a+b;
        System.out.println("sum = " + sum);

        int sub = a - b;
        System.out.println("sub = " + sub);

        int mul = a * b;
        System.out.println("mul = " + mul);

        //몫
        int div = a / b;
        System.out.println("div = " + div);

        //나머지
        int mod = a % b;
        System.out.println("mod = " + mod);

        //시간
        int mod2 = (10+5)%12;
        System.out.println("mod2 = " + mod2);

        //짝수 홀수 - 0이 나오면 짝수
        int mod3 = 6%2;
        System.out.println("mod3 = " + mod3);

        //대입 연산
        int num = 5;
        //복합 대입 연산자
        num += 10;
        System.out.println("num = " + num);
        num -= 10;
        System.out.println("num = " + num);
        num *= 10;
        System.out.println("num = " + num);
        num /= 10;
        System.out.println("num = " + num);
        num %= 10;
        System.out.println("num = " + num);

        //증감연산자
        //전위연산 - 연산 후 값 활용
        int intBox = 5;
        System.out.println("++intBox = " + (++intBox));
        //후위연산 - 값 활용 후 연산
        int intBox2 = 5;
        System.out.println("intBox2++ = " + (intBox2++));

        //비교 연산자
        //같음(=) 같으면 true, 다르면 false
        System.out.println("10==10 : " + (10==10));
        //다름(!=) 같으면 false, 다르면 true
        System.out.println("10!=10 : " + (10!=10));
        //크기비교 연산자
        System.out.println("10<5 : " + (10<5));
        System.out.println("10>5 : " + (10>5));
        System.out.println("10<=5 : " + (10<=5));
        System.out.println("10>=5 : " + (10>=5));

        //논리연산자
        //AND 연산(&&) - 두 조건이 모두 참일 때 true
        //OR 연산(||) - 두 조건 중 하나라도 참일 떄 true
        //NOT 연산(!) - true -> false / false -> true
        System.out.println("false || true : " + (false || true));

        //문자열 비교 - .equals()
        String text = "Hello";
        String text2 = "World!";
        boolean result = text.equals(text2);
        System.out.println("result = " + result);








    }
}
