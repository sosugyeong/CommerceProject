package org.example.commerce;

import java.util.ArrayList;
import java.util.List;

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

    //items 리스트에서 상품명이 파라미터로 받은 상품명과 같은것들을 지운다
    public void removeProductCart(String productNm){
        items.removeIf(item -> item.getProductName().equals(productNm));
    }
}
