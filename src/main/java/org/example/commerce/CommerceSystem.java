package org.example.commerce;

import java.util.*;

public class CommerceSystem {
    private final Scanner sc = new Scanner(System.in);
    private final List<Product> products;

    //생성자를 통해 값을 할당
    CommerceSystem(List<Product> products){
        this.products = products;
    }

    public void start(){
        while (true) {
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            int index = 0;
            for (Product p : products) {
                System.out.printf("%d. %-15s | %,10d원 | %3d개 | %s%n", (index + 1), p.getProductName(), p.getPrice(), p.getStock(), p.getComment());
                index++;
            }
            System.out.println("0. 종료             | 프로그램 종료");

            int select = sc.nextInt();
            if (select == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                System.exit(0);
            }
        }
    }
}
