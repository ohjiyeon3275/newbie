package com.human.ex;

import java.util.ArrayList;
import java.util.Scanner;

public class CollectionProduct {
	public static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<String> productName = new ArrayList<String>();
	public static ArrayList<Double> productPrice = new ArrayList<Double>();
	public static ArrayList<Integer> productNum = new ArrayList<Integer>();
	public static ArrayList<String> client = new ArrayList<String>();
	
	public static int index=4;
	public static int numIndex=0;
	
	public static void init() {
		productName.add("양말");productName.add("티셔츠");productName.add("운동화");productName.add("청바지");
		productPrice.add(1000.0);productPrice.add(10000.0);productPrice.add(20000.0);productPrice.add(20000.0);
		productNum.add(100);productNum.add(30);productNum.add(40);productNum.add(20);
		client.add("휴먼상사");client.add("");client.add("");client.add("싱가폴");
	}
	
	public static void inbound() {
		System.out.println("입고할 상품 이름을 입력하세요");
		String inputName = sc.nextLine();
		
		if(productName.contains(inputName)) {
			int tempIndex=productName.indexOf(inputName);
			System.out.println("이미 있는 제품에 개수만 추가합니다. 개수를 입력하세요");
			int plusNum = Integer.parseInt(sc.nextLine());
			int temp = productNum.get(tempIndex);
			temp+=plusNum;
			productNum.set(tempIndex, temp);
			stock(tempIndex);
		}else {
			productName.add(inputName);
			
			System.out.println("입고할 상품의 가격을 입력하세요");
			double inputPrice = Double.parseDouble(sc.nextLine());
			productPrice.add(inputPrice);
			
			System.out.println("입고할 상품의 개수를 입력하세요");
			int inputNum = Integer.parseInt(sc.nextLine());
			productNum.add(inputNum);
			
			System.out.println("거래처 이름을 입력하세요(생략가능)");
			String inputClient = sc.nextLine();
			if(inputClient!=null) {
				client.add(inputClient);
			}else {
				client.add("");
			}	
			stock(index);
			index++;
		}
	}
	
	public static void outbound() {
		System.out.println("출고할 상품 이름을 입력하세요");
		String outName = sc.nextLine();
		
		int outIndex = productName.indexOf(outName);
		
		System.out.println("출고할 상품의 개수를 입력하세요 현재 상품개수 : "+productNum.get(outIndex));
		int outNum = Integer.parseInt(sc.nextLine());
		numIndex = productNum.get(outIndex);
		numIndex -= outNum;
		productNum.set(outIndex, numIndex);
		stock(outIndex);
		
		if(productNum.indexOf(outIndex)==0) {
			System.out.println("상품의 재고가 0이 되어 정보를 지웁니다.");
			productName.remove(outIndex);
			productPrice.remove(outIndex);
			productNum.remove(outIndex);
			client.remove(outIndex);
			index--;
		}
	}
	
	public static void stock(int num) {
		System.out.println("=============================");
		System.out.println("상품이름 : "+productName.get(num));
		System.out.println("상품가격 : "+productPrice.get(num));
		System.out.println("상품개수 : "+productNum.get(num));
		System.out.println("거래처명 : "+client.get(num));
		System.out.println("총 제품가격 : "+productPrice.get(num)*productNum.get(num));
		System.out.println("=============================");
	}
	
	public static void main(String[] args) {
		init();
		//1.입고 2.출고 3.재고 확인 4.종료
		
		boolean flag = true;
		while(flag) {
			System.out.println("1.입고 2.출고 3.재고 확인 4.모든 재고 확인 5.종료");
			int input = Integer.parseInt(sc.nextLine());
			switch(input) {
			case 1 : 
				inbound();
				break;
			case 2 : 
				outbound();
				break;
			case 3 : 
				System.out.println("조회할 상품의 이름을 입력하세요");
				String find = sc.nextLine();
				
				int findIndex = productName.indexOf(find);
				if(findIndex >= 0) {
					stock(findIndex);
				}else {
					System.out.println("조회할 상품이 없습니다.");
					
				}
				break;
			case 4 : 
				for(int i=0;i<index;i++) {
					stock(i);
				}
				break;
			case 5 :
				flag=false;
				break;
			default :
				System.out.println("다시 입력해주세요");
			}
		}
		
		
		
		
	}
	
}
