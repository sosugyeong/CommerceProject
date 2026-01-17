package org.example.commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();
        products.add(new Product("Galaxy S25", 1200000, 3, "최신 안드로이드 스마트폰"));
        products.add(new Product("iPhone 16", 1350000, 10, "Apple의 최신 스마트폰"));
        products.add(new Product("MacBook Pro", 1350000, 8, "M3 칩셋이 탑재된 노트북"));
        products.add(new Product("AirPods Pro", 350000, 17, "노이즈 캔슬링 무선 이어폰"));

        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
        int index = 0;
        for (Product p : products){
            System.out.printf("%d. %-15s | %,10d원 | %3d개 | %s%n", (index+1), p.getProductName(), p.getPrice(), p.getStock(), p.getComment());
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
