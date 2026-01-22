package org.example.commerce;

import java.util.List;

public class Category {
    private String categoryName; //전자제품, 의류 등 카테고리이름
    private final List<Product> products; //해당 카테고리에 속한 상품들

    Category(String categoryName, List<Product> products){
        this.categoryName = categoryName;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    //카테고리 이름 반환 메서드
    public String getCategoryName(){ //카테고리 이름을 반환하는 메서드
        return categoryName;
    }

    //새로운 상품 정보를 입력받아 카테고리에 추가
    public void addProduct(String productNm, int price, int stock, String comment){
        products.add(new Product(productNm, price, stock, comment));
    }

    //상품 검색 (상품 수정/삭제)
    public Product findProduct(String productNm){
        for (Product p : products){
            if (p.getProductName().equals(productNm)){
                return p; //찾은 상품을 통째로 반환
            }
        }
        return null; //못찾으면 null 반환
    }

    //검색해서 나온 상품을 삭제
    public void delete(String productNm){
        Product p = findProduct(productNm);

        if (p != null){
            System.out.printf("%s 상품을 삭제합니다.%n", p.getProductName());
            products.remove(p);
            System.out.println("삭제가 완료되었습니다.");
        } else {
            System.out.println("삭제할 상품을 찾을 수 없습니다.");
        }
    }
}
