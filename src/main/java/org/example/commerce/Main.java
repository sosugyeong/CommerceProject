package org.example.commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();
        products.add(new Product("Galaxy S25", 120, 3, "최신 안드로이드 스마트폰"));
        products.add(new Product("iPhone 16", 135, 10, "Apple의 최신 스마트폰"));
        products.add(new Product("MacBook Pro", 135, 8, "M3 칩셋이 탑재된 노트북"));
        products.add(new Product("AirPods Pro", 35, 17, "노이즈 캔슬링 무선 이어폰"));

        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i+1)+". "+products.get(i));
        }
        System.out.println("0. 종료 | 프로그램 종료");
        int select = sc.nextInt();
        if (select == 0) {
            System.out.println("커머스 플랫폼을 종료합니다.");
            System.exit(0);
        }
    }
}
