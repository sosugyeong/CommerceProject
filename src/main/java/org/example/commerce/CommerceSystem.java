package org.example.commerce;

import java.util.*;

public class CommerceSystem {
    private final Scanner sc = new Scanner(System.in);
    private List<Category> categories;
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
            System.out.printf("선택 >> ");
            menu = sc.nextInt();

            if (menu > 0 && menu <= categories.size()){
                categoryMenu(categories.get(menu-1));
            } else if (menu == 0) {
                break;
            }
        }
    }

    private void categoryMenu(Category category){
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
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                if (productChoice-1 == i){
                    System.out.printf("%-12s | %,10d원 | %3d개 | %s%n", p.getProductName(), p.getPrice(), p.getStock(), p.getComment());
                }
            }
        }
    }
}
