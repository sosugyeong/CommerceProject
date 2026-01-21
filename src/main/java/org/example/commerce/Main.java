package org.example.commerce;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //전자제품 카테고리에 들어갈 상품 리스트
        List<Product> elecProducts = new ArrayList<>();
        elecProducts.add(new Product("Galaxy S25", 1200000, 3, "최신 안드로이드 스마트폰"));
        elecProducts.add(new Product("iPhone 16", 1350000, 10, "Apple의 최신 스마트폰"));
        elecProducts.add(new Product("MacBook Pro", 1350000, 8, "M3 칩셋이 탑재된 노트북"));
        elecProducts.add(new Product("AirPods Pro", 350000, 17, "노이즈 캔슬링 무선 이어폰"));

        //식품 카테고리에 들어갈 상품 리스트
        List<Product> foodProducts = new ArrayList<>();
        foodProducts.add(new Product("딸기", 15000, 20, "맛있는 설향딸기"));

        //의류 카테고리에 들어갈 상품 리스트
        List<Product> clothesProducts = new ArrayList<>();
        clothesProducts.add(new Product("가나디 잠옷", 39900, 12, "가나디 천사와 악마 수면잠옷"));

        //전자제품, 식품, 의류 카테고리 객체 생성
        Category electronics = new Category("전자제품", elecProducts);
        Category food = new Category("식품", foodProducts);
        Category clothes = new Category("의류", clothesProducts);

        // CommerceSystem에 Product 대신 Category를 넘겨줌
        List<Category> categories = new ArrayList<>();
        categories.add(electronics);
        categories.add(food);
        categories.add(clothes);

        CommerceSystem system = new CommerceSystem(categories);
        system.start();
    }
}
