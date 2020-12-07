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
		productName[0]="�縻";productName[1]="Ƽ����";productName[2]="�ȭ";productName[3]="û����";
		productPrice[0]=1000;productPrice[1]=10000;productPrice[2]=20000;productPrice[3]=20000;
		productNum[0]=100;productNum[1]=30;productNum[2]=40;productNum[3]=20;
		client[0]="�޸ջ��";client[1]="";client[2]="";client[3]="�̰���";
	}
	
	public static void inbound() {
		int tempIndex=0;
		System.out.println("�԰��� ��ǰ �̸��� �Է��ϼ���");
		String inputName = sc.nextLine();
		
		for(int i=0; i<index;i++) {
			if(inputName.equals(productName[i])){
				tempIndex = i;
			}
		}
		
		if(inputName.equals(productName[tempIndex])){
			System.out.println("�̹� �ִ� ��ǰ�� ������ �߰��մϴ�. ������ �Է��ϼ���");
			int plusNum = Integer.parseInt(sc.nextLine());
			productNum[tempIndex]+=plusNum;
			stock(tempIndex);
		}else {
			productName[index]=inputName;
			System.out.println("�԰��� ��ǰ�� ������ �Է��ϼ���");
			double inputPrice = Double.parseDouble(sc.nextLine());
			productPrice[index]=inputPrice;
			
			System.out.println("�԰��� ��ǰ�� ������ �Է��ϼ���");
			int inputNum = Integer.parseInt(sc.nextLine());
			productNum[index]+=inputNum;
			
			System.out.println("�ŷ�ó �̸��� �Է��ϼ���(��������)");
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
		System.out.println("����� ��ǰ �̸��� �Է��ϼ���");
		String inputName = sc.nextLine();
		for(int i=0;i<index;i++) {
			if(inputName.equals(productName[i])) {
				System.out.println("����� ��ǰ�� ������ �Է��ϼ��� ���� ��ǰ���� : "+productNum[i]);
				int outNum = Integer.parseInt(sc.nextLine());
				
				productNum[i]-=outNum;	
				stock(i);
				if(productNum[i]==0) {
					System.out.println("��ǰ�� ��� 0�� �Ǿ� ������ ����ϴ�.");
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
		System.out.println("��ǰ�̸� : "+productName[num]);
		System.out.println("��ǰ���� : "+productPrice[num]);
		System.out.println("��ǰ���� : "+productNum[num]);
		System.out.println("�ŷ�ó�� : "+client[num]);
		System.out.println("�� ��ǰ���� : "+productPrice[num]*productNum[num]);
		System.out.println("=============================");
	}
	
	public static void main(String[] args) {
		init();
		//1.�԰� 2.��� 3.��� Ȯ�� 4.����
		boolean flag = true;
		while(flag) {
			System.out.println("1.�԰� 2.��� 3.��� Ȯ�� 4.��� ��� Ȯ�� 5.����");
			int input = Integer.parseInt(sc.nextLine());
			switch(input) {
			case 1 : 
				inbound();
				break;
			case 2 : 
				outbound();
				break;
			case 3 : 
				System.out.println("��ȸ�� ��ǰ�� �̸��� �Է��ϼ���");
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
					System.out.println("��ȸ�� ��ǰ�� �����ϴ�.");
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
				System.out.println("�ٽ� �Է����ּ���");
			}
		}
		
		
		
		
	}
	
}
