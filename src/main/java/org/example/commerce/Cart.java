package org.example.commerce;

import java.util.ArrayList;
import java.util.List;
/*
 * 사용자가 선택한 상품을 장바구니에 추가
 * 상품명, 수량, 가격 정보 저장 / 항목을 동적으로 추가 및 조회 / 잘못된 선택시 예외처리
 *
 * 재고관리
 * 장바구니에 담을때 재고 확인. 부족할시 경고 메시지 출력
 * 주문 완료하면 해당상품의 재고 차감
 *
 * 주문 전에 장바구니에 담긴 모든 상품과 총 금액을 출력
 *
 * 상품 선택시 장바구니에 추가할지 물어보고 입력값에 따라 추가, 취소 처리
 * 장바구니에 담긴 목록 처리*/

public class Cart {
    //장바구니에 넣을 상품을 저장하는 리스트
    private final List<CartItem> items = new ArrayList<>();

    //장바구니 안에서만 사용할 물건 정보
    public static class CartItem {
        private String productName;
        private int count;
        private int price;

        CartItem(String productName, int count, int price){
            this.productName = productName;
            this.count = count;
            this.price = price;
        }

        public String getProductName() {
            return productName;
        }
        public int getCount() {
            return count;
        }
        public int getPrice() {
            return price;
        }
    }

    //장바구니 저장
    public void addProduct(String productName, int count, int price){
        items.add(new CartItem(productName, count, price));
    }

    //장바구니 반환
    public List<CartItem> getProductList() {
        return items;
    }

    //장바구니 확인 메서드에서 쓸 getItems
    public List<CartItem> getItems(){
        return this.items;
    }

    public int getTotalPrice(){
        int total = 0;
        for(CartItem item : items){
            total += item.getPrice();
        }
        return total;
    }
}
