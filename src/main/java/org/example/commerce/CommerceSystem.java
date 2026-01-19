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
            System.out.println("0. 종료         | 프로그램 종료");
            System.out.printf("선택 >> ");
            menu = sc.nextInt();
            int index = 0;

            switch (menu){ //0=전자제품, 1=식품, 2=의류
                case 1:
                    System.out.println("\n[ 전자제품 카테고리 ]");
                    for (Product p : categories.get(menu-1).getProducts()) {
                        System.out.printf("%d. %-15s | %,10d원 | %3d개 | %s%n", (index + 1), p.getProductName(), p.getPrice(), p.getStock(), p.getComment());
                        index++;
                    }
                    break;
                case 2:
                    System.out.println("\n[ 식품 카테고리 ]");
                    for (Product p : categories.get(menu-1).getProducts()) {
                        System.out.printf("%d. %-15s | %,10d원 | %3d개 | %s%n", (index + 1), p.getProductName(), p.getPrice(), p.getStock(), p.getComment());
                        index++;
                    }
                    break;
                case 3:
                    System.out.println("\n[ 의류 카테고리 ]");
                    for (Product p : categories.get(menu-1).getProducts()) {
                        System.out.printf("%d. %-15s | %,10d원 | %3d개 | %s%n", (index + 1), p.getProductName(), p.getPrice(), p.getStock(), p.getComment());
                        index++;
                    }
                    break;
                case 0:
                    System.out.printf("커머스 플랫폼을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    break;
            }

        }
    }

    public void SelectProduct(){

    }
}
