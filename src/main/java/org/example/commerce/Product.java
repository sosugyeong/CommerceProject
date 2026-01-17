package org.example.commerce;

public class Product {
    private String productName;
    private int price;
    private int stock;
    private String comment;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getComment() {
        return comment;
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

    public String toString(){
        return productName+" | "+price+" | "+stock+" | "+comment;
    }
}
