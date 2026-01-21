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
}
