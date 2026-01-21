package org.example.commerce;

public class Product {
    private String productName;
    private int price;
    private int stock;
    private String comment;

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getComment() {
        return comment;
    }

    public Product(String productName, int price, int stock, String comment){
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.comment = comment;
    }

    //재고 차감
    public void reduceProduct(int amount){
        if (this.stock >= amount){
            this.stock -= amount;
        } else {
            System.out.println("재고가 부족합니다.");
        }
    }
}
