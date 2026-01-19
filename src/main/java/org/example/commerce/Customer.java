package org.example.commerce;

public class Customer {
    private String customerName;
    private String email;
    private String rank;
    private int totalPrice;

    //생성자
    Customer(String customerName, String email, String rank){
        this.customerName = customerName;
        this.email = email;
        this.rank = rank;
        updateRank();
    }

    //누적 금액 추가 메서드
    public void SumTotalPrice(int amount){
        this.totalPrice += amount;
        updateRank();
    }

    // 총 구매 금액에 따른 등급 산정
    public void updateRank(){
        if (totalPrice >= 2000000){
            this.rank = "플레티넘";
        } else if (totalPrice >= 1000000) {
            this.rank = "골드";
        } else if (totalPrice >= 500000) {
            this.rank = "실버";
        } else {
            this.rank = "브론즈";
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getRank() {
        return rank;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
