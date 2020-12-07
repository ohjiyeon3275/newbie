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
		productName.add("�縻");productName.add("Ƽ����");productName.add("�ȭ");productName.add("û����");
		productPrice.add(1000.0);productPrice.add(10000.0);productPrice.add(20000.0);productPrice.add(20000.0);
		productNum.add(100);productNum.add(30);productNum.add(40);productNum.add(20);
		client.add("�޸ջ��");client.add("");client.add("");client.add("�̰���");
	}
	
	public static void inbound() {
		System.out.println("�԰��� ��ǰ �̸��� �Է��ϼ���");
		String inputName = sc.nextLine();
		
		if(productName.contains(inputName)) {
			int tempIndex=productName.indexOf(inputName);
			System.out.println("�̹� �ִ� ��ǰ�� ������ �߰��մϴ�. ������ �Է��ϼ���");
			int plusNum = Integer.parseInt(sc.nextLine());
			int temp = productNum.get(tempIndex);
			temp+=plusNum;
			productNum.set(tempIndex, temp);
			stock(tempIndex);
		}else {
			productName.add(inputName);
			
			System.out.println("�԰��� ��ǰ�� ������ �Է��ϼ���");
			double inputPrice = Double.parseDouble(sc.nextLine());
			productPrice.add(inputPrice);
			
			System.out.println("�԰��� ��ǰ�� ������ �Է��ϼ���");
			int inputNum = Integer.parseInt(sc.nextLine());
			productNum.add(inputNum);
			
			System.out.println("�ŷ�ó �̸��� �Է��ϼ���(��������)");
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
		System.out.println("����� ��ǰ �̸��� �Է��ϼ���");
		String outName = sc.nextLine();
		
		int outIndex = productName.indexOf(outName);
		
		System.out.println("����� ��ǰ�� ������ �Է��ϼ��� ���� ��ǰ���� : "+productNum.get(outIndex));
		int outNum = Integer.parseInt(sc.nextLine());
		numIndex = productNum.get(outIndex);
		numIndex -= outNum;
		productNum.set(outIndex, numIndex);
		stock(outIndex);
		
		if(productNum.indexOf(outIndex)==0) {
			System.out.println("��ǰ�� ��� 0�� �Ǿ� ������ ����ϴ�.");
			productName.remove(outIndex);
			productPrice.remove(outIndex);
			productNum.remove(outIndex);
			client.remove(outIndex);
			index--;
		}
	}
	
	public static void stock(int num) {
		System.out.println("=============================");
		System.out.println("��ǰ�̸� : "+productName.get(num));
		System.out.println("��ǰ���� : "+productPrice.get(num));
		System.out.println("��ǰ���� : "+productNum.get(num));
		System.out.println("�ŷ�ó�� : "+client.get(num));
		System.out.println("�� ��ǰ���� : "+productPrice.get(num)*productNum.get(num));
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
				
				int findIndex = productName.indexOf(find);
				if(findIndex >= 0) {
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
