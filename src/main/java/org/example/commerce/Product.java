package org.example.commerce;

public class Product {
    private String productName;
    private int price;
    private int stock;
    private String comment;

    //getter
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

    //setter
    public void setPrice(int price) {
        this.price = price;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setComment(String comment) {
        this.comment = comment;
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
