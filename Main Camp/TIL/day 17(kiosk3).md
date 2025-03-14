[본캠프 17일차] kiosk 프로젝트3
2025.3.12

# 1. Kiosk 프로젝트
> lv4
- 가독성을 위한 코드 수정
    - kiosk 클래스의 카테고리와 메뉴 선택 부분 나누기
    ```java
    else if (categoryChoice > 0 && categoryChoice <= menus.size()) {
        showMenuItems(menus.get(categoryChoice - 1), input);
    }
    ```
    ```java
    private void showMenuItems(Menu menu, Scanner input) {
        System.out.println("[" + menu.getCategoryName() + " MENU]");
        List<MenuItem> items = menu.getMenuItems();
        for (int i = 0; i < items.size(); i++) {
            MenuItem item = items.get(i);
            System.out.printf("%d. %s | W %.2f | %s\n", i + 1, item.getName(), item.getPrice(), item.getExplanation());
        }
        System.out.println("0. 뒤로가기");

        System.out.print("입력 : ");
        int itemChoice;
        try {
            itemChoice = input.nextInt();
            if (itemChoice == 0) {
                continue; // 이전 메뉴로 돌아가기
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
    }
    ```
    - 오류 발생 : 이전 단계로 돌아가기 위한 continue 사용 불가
        - Continue outside of loop 에러 발생
        -> 반복문 안에서 호출된 함수를 종료시키면 되기 때문에 return으로 수정
        ```java
        if (itemChoice == 0) {return;}
        ```
    ---

> 도전 기능 lv 1
- 장바구니 기능
    - 장바구니에 저장할 값들을 cartitem으로 관리
```java
    public class CartItem {
    private MenuItem menuItem;
    private int quantity;

    public CartItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    public double getTotal() {
        return menuItem.getPrice() * quantity;
    }

    public String getDetails() {
        return String.format("%s | W %.2f | 수량: %d", menuItem.getName(), menuItem.getPrice(), quantity);
    }
}
```

# 2. 내일 할 것
- 키오스크 도전기능 구현






