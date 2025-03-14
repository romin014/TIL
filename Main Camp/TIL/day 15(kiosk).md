[본캠프 15일차] kiosk 프로젝트
2025.3.10

# 1. Kiosk 프로젝트
> lv1 start

- 조건에 맞게 출력하기
    - scanner를 선언하고 입력된 값에 따라 원하는 동작을 할 수 있도록 구현
```java
//lv 1 전체코드
public class Main {
        public static void main(String[] args){
            //scanner 선언
                Scanner input = new Scanner(System.in);
                //while문을 사용해 특정 조건을 만족할 때까지 반복
                while(true){
                        System.out.println("[SHAKESHACK MENU]");
                        System.out.println("1. ShackBurger      | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                        System.out.println("2. SmokeShack       | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                        System.out.println("3. CheeseBurger     | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                        System.out.println("4. HamBurger        | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
                        System.out.println("0. 종료              | 종료");

                        System.out.print("입력 : ");
                        int a = input.nextInt();
                        //반복문 종료 조건
                        if(a==0) {
                                System.out.println("프로그램을 종료합니다.");
                                break;
                        } else{
                                try{
                                        switch (a){
                                                case 1 :
                                                        System.out.println("ShackBurger를 선택하셨습니다.");
                                                        break;
                                                case 2 :
                                                        System.out.println("SmokeShack를 선택하셨습니다.");
                                                        break;
                                                case 3 :
                                                        System.out.println("CheeseBurger를 선택하셨습니다.");
                                                        break;
                                                case 4 :
                                                        System.out.println("HamBurger를 선택하셨습니다.");
                                                        break;
                                                default:
                                                        System.out.println("잘못된 입력입니다. 메뉴의 번호를 선택해주세요.");
                                                        break;
                                        }
                                } catch (InputMismatchException e) {
                                        System.out.println("잘못된 입력입니다. 메뉴의 번호를 선택해주세요.");
                                        input.nextLine(); // 잘못된 입력을 소비
                                }
                        }
                }
        }
}
```

> lv2 start
- lv1 main의 메뉴를 MenuItem 클래스로 관리
```java
//MenuItem
//이름, 가격, 설명을 관리하기 위한 클래스
public class MenuItem {
    private String name;
    private double price;
    private String explanation;

    // 생성자
    public MenuItem(String name, double price, String explanation) {
        this.name = name;
        this.price = price;
        this.explanation = explanation;
    }

    // getter
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getexplanation() {
        return explanation;
    }
}
```
- main 수정
    - MenuItem 리스트 선언 및 초기화
    ```java
        List<MenuItem> menuItems = new ArrayList<>();
    ```
    - 리스트에 값 추가하기
    ```java
    menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
    menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
    menuItems.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
    menuItems.add(new MenuItem("HamBurger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    ```
    - 기존의 print가 아닌 반복문을 사용해 메뉴 출력
    ```java
    System.out.println("[SHAKESHACK MENU]");
    for (int i = 0; i < menuItems.size(); i++) {
        MenuItem item = menuItems.get(i);
        System.out.printf("%d. %s | W %.2f | %s\n", i+1, item.getName(), item.getPrice(), item.getexplanation());
    }
    System.out.println("0. 종료    | 종료");
    ```
    -> print("문자" + 값 + "문자")의 형식보다 printf("%자료형", 값)의 형태가 원하는 형태로 출력하기에 수월
    - 선택한 결과 출력하기
    ```java
    if(a==0) {
        System.out.println("프로그램을 종료합니다.");
        break;
    } else{
        try{
            MenuItem item = menuItems.get(a-1);
            //printf형태로 변경
            System.out.printf("선택한 메뉴 : %s, W %.2f, %s\n", item.getName(), item.getPrice(), item.getexplanation());

        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 메뉴의 번호를 선택해주세요.");
            input.nextLine(); // 잘못된 입력을 소비
        }
    }
    ```


# 2. 내일 할 것
- 키오스크 lv3





