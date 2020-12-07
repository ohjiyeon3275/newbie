package com.human.ex;

import java.util.Scanner;

public class Product {
	
	public static String[] productName = new String[100];
	public static double[] productPrice = new double[100];
	public static int[] productNum = new int [100];
	public static String[] client = new String[100];
	
	public static int index=4;
	public static Scanner sc = new Scanner(System.in);
	
	public static void init() {
		productName[0]="양말";productName[1]="티셔츠";productName[2]="운동화";productName[3]="청바지";
		productPrice[0]=1000;productPrice[1]=10000;productPrice[2]=20000;productPrice[3]=20000;
		productNum[0]=100;productNum[1]=30;productNum[2]=40;productNum[3]=20;
		client[0]="휴먼상사";client[1]="";client[2]="";client[3]="싱가폴";
	}
	
	public static void inbound() {
		int tempIndex=0;
		System.out.println("입고할 상품 이름을 입력하세요");
		String inputName = sc.nextLine();
		
		for(int i=0; i<index;i++) {
			if(inputName.equals(productName[i])){
				tempIndex = i;
			}
		}
		
		if(inputName.equals(productName[tempIndex])){
			System.out.println("이미 있는 제품에 개수만 추가합니다. 개수를 입력하세요");
			int plusNum = Integer.parseInt(sc.nextLine());
			productNum[tempIndex]+=plusNum;
			stock(tempIndex);
		}else {
			productName[index]=inputName;
			System.out.println("입고할 상품의 가격을 입력하세요");
			double inputPrice = Double.parseDouble(sc.nextLine());
			productPrice[index]=inputPrice;
			
			System.out.println("입고할 상품의 개수를 입력하세요");
			int inputNum = Integer.parseInt(sc.nextLine());
			productNum[index]+=inputNum;
			
			System.out.println("거래처 이름을 입력하세요(생략가능)");
			String inputClient = sc.nextLine();
			if(inputClient!=null) {
				client[index]=inputClient;
			}else {
				client[index]="";
			}
			index++;
			stock(index);	
		}
	}	

	
	public static void outbound() {
		System.out.println("출고할 상품 이름을 입력하세요");
		String inputName = sc.nextLine();
		for(int i=0;i<index;i++) {
			if(inputName.equals(productName[i])) {
				System.out.println("출고할 상품의 개수를 입력하세요 현재 상품개수 : "+productNum[i]);
				int outNum = Integer.parseInt(sc.nextLine());
				
				productNum[i]-=outNum;	
				stock(i);
				if(productNum[i]==0) {
					System.out.println("상품의 재고가 0이 되어 정보를 지웁니다.");
					productName[i+1]=productName[i];
					productPrice[i+1]=productPrice[i+1];
					productNum[i+1]=productNum[i];
					client[i+1]=client[i];
					index--;
				}
				
					
			}
		}
	}
	
	public static void stock(int num) {
		System.out.println("=============================");
		System.out.println("상품이름 : "+productName[num]);
		System.out.println("상품가격 : "+productPrice[num]);
		System.out.println("상품개수 : "+productNum[num]);
		System.out.println("거래처명 : "+client[num]);
		System.out.println("총 제품가격 : "+productPrice[num]*productNum[num]);
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
				int findIndex=0;
				for(int i=0;i<index;i++) {
					if(find.equals(productName[i])) {
						findIndex=i;
					}
				}
				if(find.equals(productName[findIndex])) {
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
