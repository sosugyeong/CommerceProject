package org.example.commerce;

public enum Grade {
    BRONZE(0.0), //0% 할인
    SILVER(0.05), //5% 할인
    GOLD(0.1), //10% 할인
    PLATINUM(0.15); //15% 할인

    private final double discount;

    Grade(double discount){
        this.discount = discount;
    }

    //할인율 계산 메서드
    public int calDiscountPrice(int originalPrice){
        return (int) (originalPrice * (1 - this.discount));
    }

    public double getDiscount(){
        return discount;
    }
}
