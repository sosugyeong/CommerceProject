package org.example.commerce;

public class Customer {
    private String customerName;
    private String email;
    private int totalPrice;
    private Grade grade; // 등급

    //생성자
    Customer(String customerName, String email, Grade grade){
        this.customerName = customerName;
        this.email = email;
        this.grade = grade;
        updateGrade();
    }

    //누적 금액 추가 메서드
    public void totalPrice(int amount){
        this.totalPrice += amount;
        updateGrade();
    }

    // 총 구매 금액에 따른 등급 산정
    public void updateGrade(){
        if (totalPrice >= 2000000){
            this.grade = Grade.PLATINUM;
        } else if (totalPrice >= 1000000) {
            this.grade = Grade.GOLD;
        } else if (totalPrice >= 500000) {
            this.grade = Grade.SILVER;
        } else {
            this.grade = Grade.BRONZE;
        }
    }

    public String getCustomerName() {
        return customerName;
    }
    public String getEmail() {
        return email;
    }
    public int getTotalPrice() {
        return totalPrice;
    }

    public Grade getGrade() {
        return grade;
    }
}
