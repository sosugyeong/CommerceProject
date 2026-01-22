package org.example.commerce;

import java.util.List;
import java.util.Scanner;

public class AdminManager {
    private final Scanner sc;
    private Cart cart;
    private List<Category> categories;
    AdminManager(List<Category> categories, Cart cart, Scanner sc){
        this.categories = categories;
        this.cart = cart;
        this.sc = sc;
    }

    //관리자 모드 메뉴 선택
    public void managerUI(){
        System.out.println("[ 관리자 모드 ]");
        System.out.print("1. 상품 추가\n2. 상품 수정\n3. 상품 삭제\n4. 전체 상품 현황\n0. 메인으로 돌아가기\n선택 >> ");
        int select = sc.nextInt();

        switch (select){
            case 1: //상품 추가
                manageAdd();
                break;
            case 2: //상품 수정
                manageEdit();
                break;
            case 3://상품 삭제
                manageDelete();
                break;
            case 4://전체 상품 현황
                managePrint();
                break;
            case 0:
                System.out.println("관리자 모드를 종료합니다.");
                break;
            default:
                System.out.println("잘못된 번호입니다.");
                break;
        }
    }

    public void manageAdd(){
        System.out.println("어느 카테고리에 상품을 추가하시겠습니까?");
        System.out.println("1. 전자제품\n2. 식품\n3. 의류");
        int categoryIdx = sc.nextInt();
        sc.nextLine();

        Category targetCategory = categories.get(categoryIdx-1); //추가할 카테고리 선택

        System.out.println("[ "+targetCategory.getCategoryName()+" 카테고리에 상품 추가 ]");
        System.out.print("상품명을 입력해주세요: "); String strNm = sc.nextLine();
        //입력받은 상품명이 해당 카테고리 안에 이미 있는지 확인
        Product targetProduct2 = targetCategory.findProduct(strNm);

        if (targetProduct2 != null){ //존재함
            System.out.println("이미 있는 상품입니다!!");
        } else { //존재하지 않음
            System.out.print("가격을 입력해주세요: "); int intPrice = sc.nextInt();
            System.out.print("재고수량을 입력해주세요: "); int intStock = sc.nextInt();
            sc.nextLine();
            System.out.print("상품 설명을 입력해주세요: "); String strComment = sc.nextLine();

            targetCategory.addProduct(strNm, intPrice, intStock, strComment);
        }
    }

    public void manageEdit(){
        System.out.println("수정할 상품이 있는 카테고리 번호를 입력해 주세요.");
        System.out.println("1. 전자제품\n2. 식품\n3. 의류");
        int categoryIdx2 = sc.nextInt();
        sc.nextLine();

        Category targetCategory2 = categories.get(categoryIdx2-1); //추가할 상품이 속한 카테고리

        System.out.print("수정할 상품명을 입력해주세요: ");
        String productName = sc.nextLine();
        Product tergetProduct = targetCategory2.findProduct(productName);

        System.out.printf("현재 상품 정보:%n");
        System.out.print("수정할 항목을 선택해주세요:\n1. 가격\n2. 설명\n3. 재고수량\n선택>> ");
        int categoryIdx4 = sc.nextInt();

        if (tergetProduct != null){
            if(categoryIdx4 == 1){
                System.out.print("새로운 가격: ");
                int newPrice = sc.nextInt();
                tergetProduct.setPrice(newPrice);
            } else if (categoryIdx4 == 2) {
                sc.nextLine();
                System.out.print("새로운 설명: ");
                String newComment = sc.nextLine();
                tergetProduct.setComment(newComment);
            } else if (categoryIdx4 == 3) {
                System.out.print("새로운 재고수량: ");
                int newStock = sc.nextInt();
                tergetProduct.setStock(newStock);
            }
        }
    }

    public void manageDelete(){
        System.out.println("삭제할 상품이 있는 카테고리 번호를 입력해 주세요.");
        System.out.println("1. 전자제품\n2. 식품\n3. 의류");
        int categoryIdx3 = sc.nextInt();
        sc.nextLine();

        Category targetCategory3 = categories.get(categoryIdx3-1);

        System.out.print("삭제할 상품명을 입력해주세요: ");
        String productName2 = sc.nextLine();

        //해당 카테고리의 리스트에서 상품 객체를 제거한다
        targetCategory3.delete(productName2);
        //장바구니 리스트에서도 삭제
        cart.removeProductCart(productName2);
    }

    public void managePrint(){ //모든 카테고리 리스트를 돌면서 각 카테고리가 가진 상품 리스트 상세정보 출력
        for (int i = 0; i < 3; i++) {
            Category targetCategory4 = categories.get(i);
            for(Product p : targetCategory4.getProducts()){
                System.out.printf("%-10s | %,10d원 | %3d개 | %s%n", p.getProductName(), p.getPrice(), p.getStock(), p.getComment());
            }
        }
    }
}
