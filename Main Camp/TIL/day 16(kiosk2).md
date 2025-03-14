[본캠프 16일차] kiosk 프로젝트2
2025.3.11

# 1. Kiosk 프로젝트
> lv3 start
- main의 순서제어부를 kiosk 클래스를 통해 조절하고 main은 kiosk 클래스를 생성하는 용도로 수정
```java
//main
public static void main(String[] args){
    Kiosk startbtn = new Kiosk();
    startbtn.start();
    }
```
---
- Kiosk 클래스 생성
    - 생성자를 통해 리스트에 메뉴
    추가
    ```java
    public Kiosk() {
        menuItems = new ArrayList<>();
        // 메뉴 항목 추가
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("HamBurger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }
    ```
    - start() 메소드
    ```java
    //main의 순서제어부 전체
    while(true){
        System.out.println("[SHAKESHACK MENU]");
        /*...중략...*/
    }
    ```
---
    - 예외처리가 제대로 되어있지 않음 확인
        - try-catch문 수정
```java
try {
    if (a == 0) {
        System.out.println("프로그램을 종료합니다.");
        break;
    } else if (a >= 0 && a < menuItems.size()+1) {
        //조건 추가
        MenuItem item = menuItems.get(a - 1);
        System.out.printf("선택한 메뉴 : %s, W %.2f, %s\n", item.getName(), item.getPrice(), item.getexplanation());
    } else {
        System.out.println("잘못된 입력입니다. 메뉴의 번호를 선택해주세요.");
    }
} catch (InputMismatchException e) {
    System.out.println("잘못된 입력입니다. 메뉴의 번호를 선택해주세요.");
    input.nextLine(); // 잘못된 입력을 소비
}
```
---
> lv4 start
- 메뉴 카테고리를 관리하는 menu 클래스 생성
    - menu 클래스를 통해 여러 menuitem 관리
    - list로 menuitem의 값 가져와 사용
```java
public class Menu {
    private String categoryName;
    private List<MenuItem> menuItems;

    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    public void setMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
```
---
- Kiosk 클래스 수정
    - MenuItem -> Menu list 선언
    ```java
    private List<Menu> menus;
    ```
    - 생성자의 메뉴 항목 추가
    ```java
    public Kiosk() {
        menus = new ArrayList<>();

        // 메뉴 카테고리 및 항목 추가
        Menu burgerMenu = new Menu("Burgers");
        /*...음료, 디저트 항목 추가...*/
        // 디저트 카테고리 추가
        Menu dessertMenu = new Menu("Desserts");
        dessertMenu.setMenuItem(new MenuItem("FrenchFries", 3.0, "감자튀김"));
        dessertMenu.setMenuItem(new MenuItem("VanillaIceCream", 2.5, "바닐라 아이스크림"));
        menus.add(dessertMenu);
    }
    ```
    ---
    - 카테고리 선택 후 카테고리에 맞는 아이템 선택
    ```java
    while (true) {
            System.out.println("[MAIN MENU]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, menus.get(i).getCategoryName());
            }
            System.out.println("0. 종료    | 종료");

            // 숫자 입력 받기
            System.out.print("입력 : ");
            int categoryChoice;
            try {
                categoryChoice = input.nextInt();
                if (categoryChoice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
                if (categoryChoice > 0 && categoryChoice <= menus.size()) {
                    Menu selectedMenu = menus.get(categoryChoice - 1);
                    
                    // 선택한 메뉴의 항목 출력
                    System.out.println("[" + selectedMenu.getCategoryName() + " MENU]");
                    List<MenuItem> items = selectedMenu.getMenuItems();
                    for (int i = 0; i < items.size(); i++) {
                        MenuItem item = items.get(i);
                        System.out.printf("%d. %s | W %.2f | %s\n", i + 1, item.getName(), item.getPrice(), item.getExplanation());
                    }
                    System.out.println("0. 돌아가기 | 이전 메뉴로");

                    // 숫자 입력 받기
                    System.out.print("입력 : ");
                    int itemChoice;
                    try {
                        itemChoice = input.nextInt();
                        if (itemChoice == 0) {
                            break; // 이전 메뉴로 돌아가기
                        } else if (itemChoice > 0 && itemChoice <= items.size()) {
                            MenuItem selectedItem = items.get(itemChoice - 1);
                            System.out.printf("선택한 메뉴 : %s, W %.2f, %s\n", selectedItem.getName(), selectedItem.getPrice(), selectedItem.getExplanation());
                        } else {
                            System.out.println("잘못된 입력입니다. 메뉴의 번호를 선택해주세요.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("잘못된 입력입니다. 메뉴의 번호를 선택해주세요.");
                        input.nextLine(); // 잘못된 입력을 소비
                    }
                } else {
                    System.out.println("잘못된 입력입니다. 카테고리를 선택해주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 카테고리를 선택해주세요.");
                input.nextLine(); // 잘못된 입력을 소비
            }
        }
    ```
    - 오류 발생 : 이전 메뉴로 돌아가지 않고 반복문이 종료됨
        - 카테고리 선택 후 메뉴 선택 단계에서 이전 메뉴로 돌아갈 때 0을 입력하면 break로 인해 반복문이 종료됨
        - 반복문을 종료하는 것이 아닌 이번 단계를 건너뛰고 처음으로 돌아가기 위해 continue로 수정
        ```java
        if (itemChoice == 0) {continue;}
        ```


# 2. 내일 할 것
- 키오스크 lv4 마무리
- 키오스크 도전 기능 구현 시작






