[본캠프 10일차] 계산기 프로젝트 3

# 1. 오늘의 학습 내용
`키워드` - repeat(), lv2 마무리

### 1. 알고리즘 스터디
1. repeat()
- 문자열 반복
- 사용방법
    - str.repeat(//반복할 횟수);

2. StringBuilder
- String은 변경할 수 없는 객체이기 때문에 String + String 등의 연산을 수행하면 새로운 객체가 계속 생성되기 때문에 메모리 관리에 비효율절임   
-> StringBuilder는 변경 할 수 있기 때문에 문자열을 더할 때 새로운 객체를 생성하는 것이 아니라 기존 데이터에 더하는 방식을 사용함 -> 빠름
- 사용방법
    - 객체 생성
        - StringBuilder sb = new StringBuilder();
    - append()
        - 특정 문자열 더하기  
        (ex) sb.append("abc");
        - 특정 인덱스에 문자열 더하기  
        (ex) sb.append(4).append("\n");
    - insert()
        - 특정 인덱스에 문자열 추가  
        (ex) sb.insert(2, "ccc");
    - replace()
        - 첫번째 인덱스부터 두번째 인덱스 전까지의 문자열 대체
        (ex) sb.replace(3, 6, "hi");

### 2. 계산기 프로젝트
> lv 2 마무리
1. getter 메서드와 setter 메서드 생성
```java
//Calculator.java
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
   public int getA() {
       return a;
   }

   public int getB() {
       return b;
   }

   public char getMark() {
       return mark;
   }

    public int getResults() {
        return results;
    }
```
- 생성한 메서드에 맞게 main 수정
    - 생성자로 받아왔던 매개변수를 setter를 통해 받아오기
```java
//Main.java
System.out.println("필요한 연산의 기호를 입력해주세요.(+, -, *, /)");
System.out.print("입력 : ");
char mark = input.nextLine().charAt(0);
// setter메서드를 통한 입력
cal.setA(a);
cal.setB(b);
cal.setMark(mark);

result = cal.calculate();
System.out.println("결과 : " + result);
```

2. 컬랙션을 통해 result값을 저장하고 저장값 삭제 기능
- 기존 int 자료형을 ArrayList<Integer> 로 받아오기
```java
//Calculator.java
private ArrayList<Integer> results;
//arraylist 초기화를 위한 생성자
public Calculator() {
    results = new ArrayList<>();
}
int calculate() {

    /*연산수행 코드*/

    results.add(result);
    return result;
}

public List<Integer> getResults() {
    return results;
}
```
- results에 저장한 값 삭제
```java
//Calculator.java
//첫번째 인덱스의 값 삭제
public void removeResult() {
    if (!results.isEmpty()) {
        results.remove(0);
    } else {
        System.out.println("삭제할 결과가 없습니다.");
    }
}
```
- 저장된 결과 목록 보여주고 저장된 값 중 가장 먼저 저장된 값 삭제
```java
//Main.java

System.out.println("현재 저장된 결과 목록을 보려면 view, 넘어가려면 enter를 눌러주세요.");
String index = input.nextLine();
if (index.equals("view")) {
    System.out.println("현재 저장된 결과 목록: " + cal.getResults());
                    
    // 결과 삭제 여부 확인
    System.out.println("가장 먼저 저장된 결과를 삭제하시겠습니까? (yes/no)");
    String delete = input.nextLine();

    if (delete.equals("yes")) {
        cal.removeResult(); // 첫 번째 결과 삭제
        System.out.println("가장 먼저 저장된 결과가 삭제되었습니다.");
                            
    } else if (delete.equals("no")) {
        System.out.println("넘어갑니다.");
                            
    } else {
        System.out.println("yes 혹은 no를 입력해주세요");
    }
                    
                    
} else if (index.isEmpty()) {
    System.out.println("넘어갑니다.");
                    
} else {
    System.out.println("view 혹은 enter를 입력해주세요");
}
            
```
- while 문을 사용해 잘 못 입력했을 경우 반복
```java
while (true) {
    System.out.println("현재 저장된 결과 목록을 보려면 view, 넘어가려면 enter를 눌러주세요.");
    String index = input.nextLine();
    if (index.equals("view")) {
        System.out.println("현재 저장된 결과 목록: " + cal.getResults());
        while (true) {
            // 결과 삭제 여부 확인
            System.out.println("가장 먼저 저장된 결과를 삭제하시겠습니까? (yes/no)");
            String delete = input.nextLine();

            if (delete.equals("yes")) {
                cal.removeResult(); // 첫 번째 결과 삭제
                System.out.println("가장 먼저 저장된 결과가 삭제되었습니다.");
                break;
            } else if (delete.equals("no")) {
                System.out.println("넘어갑니다.");
                break;
            } else {
                System.out.println("yes 혹은 no를 입력해주세요");
            }
        }
        break;
    } else if (index.isEmpty()) {
        System.out.println("넘어갑니다.");
        break;
    } else {
        System.out.println("view 혹은 enter를 입력해주세요");
    }
}
```

3. 튜터님께 받은 피드백
- 객체지향에 대해 생각해보고 확실한 역할을 설정해주기  
-> Main의 연산들을 클래스로 분리해보기  
-> result의 결과값을 출력하고 삭제하는 기능을 Index 클래스로 분리해보기


# 2. 내일 할 것
- 피드백을 통한 lv2 수정
- 계산기 과제 lv 3 완료

