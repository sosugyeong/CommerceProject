package org.example.commerce;

import java.util.*;

public class CommerceSystem {
    private final Scanner sc = new Scanner(System.in);
    private final List<Category> categories;
    private Cart cart = new Cart();

    CommerceSystem(List<Category> categories){
        this.categories = categories;
    }

    public void start(){
        int select = 1;
        int menu;

        while (select != 0) {
            System.out.println("\n[ 실시간 커머스 플랫폼 메인 ]");
            for (int i = 0; i < categories.size(); i++) {
                System.out.println((i+1)+". "+categories.get(i).getCategoryName());
            }
            System.out.println("0. 종료      | 프로그램 종료");

            if (!(cart.getProductList().isEmpty())){ //cart의 장바구니가 비어있지 않으면
                System.out.println("\n[ 주문 관리 ]");
                System.out.println("4. 장바구니 확인 | 장바구니를 확인 후 주문합니다. ");
                System.out.println("5. 주문 취소    | 진행중인 주문을 취소합니다.");
            }
            System.out.printf("선택 >> ");
            menu = sc.nextInt();

            if (menu > 0 && menu <= categories.size()){ // 상품 메뉴 출력
                categoryMenu(categories.get(menu-1));
            } else if (menu == 4) { // 장바구니 확인
                checkCart();
            } else if (menu == 5) { // 주문 취소

            } else if (menu == 0) { // 종료
                break;
            }
        }
    }

    private void categoryMenu(Category category){ // 카테고리별 상품 메뉴 출력
        System.out.println("\n[ "+category.getCategoryName()+" 카테고리 ]");
        List<Product> products = category.getProducts();

        //상품 목록 출력
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.printf("%d. %-12s | %,10d원 | %3d개 | %s%n", (i + 1), p.getProductName(), p.getPrice(), p.getStock(), p.getComment());
        }
        System.out.println("0. 뒤로가기");

        System.out.print("선택 >> ");
        int productChoice = sc.nextInt();

        //선택한 상품 보기
        if (productChoice > 0 && productChoice <= products.size()){
            System.out.print("선택한 상품: ");
            Product p = products.get(productChoice-1);
            System.out.printf("%-10s | %,10d원 | %3d개 | %s%n", p.getProductName(), p.getPrice(), p.getStock(), p.getComment());
            addCart(p.getProductName(), p.getStock(),p.getPrice());
        } else if (productChoice == 0) {}
        else { //유효하지 않은 상품 번호 입력시
            System.out.println("유효하지 않은 상품 번호입니다. 다시 입력해주세요");
        }
    }

    private void addCart(String productName, int stock, int price){ // 장바구니 추가 메서드
        System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인            2. 취소");
        int select = sc.nextInt();
        if (select == 1){
            System.out.println("담을 수량을 입력해 주세요");
            System.out.printf("수량 : ");
            int count = sc.nextInt();
            price = price*count;

            if (stock < count) { //stock = 재고, count = 장바구니에 담을 수량
                System.out.println("재고가 부족합니다.");
                return;
            }
            cart.addProduct(productName, count, price);
            System.out.println(productName+"가 "+count+"개 장바구니에 추가되었습니다.");
        }
    }

    private void checkCart(){ //장바구니 확인 메서드
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("\n[ 장바구니 내역 ]");

        List<Cart.CartItem> items = cart.getItems();
        for (Cart.CartItem item : items){
            System.out.printf("%-10s | %,10d원 | 수량: %3d개 %n", item.getProductName(), item.getPrice(), item.getCount());
        }

        System.out.println("[ 총 주문 금액 ]");
        System.out.printf("%,10d원%n", cart.getTotalPrice());

        System.out.println("\n1. 주문 확정      2. 메인으로 돌아가기");
        int select = sc.nextInt();
        if (select == 1){
            System.out.printf("주문이 완료되었습니다! 총 금액: %,10d원%n",cart.getTotalPrice());
            //재고 차감 후 장바구니 초기화
            updateStock();
            items.clear();
        }
    }

    //모든 카테고리에서 그 카테고리 안의 모든 상품중 이름이 같은것을 찾는다. 찾았을시 재고 차감
    private void updateStock(){
        for(Cart.CartItem item : cart.getItems()){
            for (Category category : categories){
                for (Product p : category.getProducts()){
                    if (p.getProductName().equals(item.getProductName())){
                        System.out.print(p.getProductName()+"재고가 "+p.getStock());
                        p.reduceProduct(item.getCount());
                        System.out.print("개 -> "+p.getStock()+"개로 업데이트 되었습니다.\n");
                    }
                }
            }
        }
    }


}
