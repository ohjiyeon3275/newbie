package com.human.ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Rectangle implements Comparable<Rectangle>{
	
	public double width , height;
	
	public double area() {
		return width*height;
	}
	
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
							//�θ� Object�� Object�� ��
							//override�Ȱ��̶� Rectangle������ ���� �ȵ�(?)
		//A a = new A();�� ���ε��
		if (this == obj)
			//a.equals(a)
			return true;
		
		if (obj == null)
			//���� �����ϴ� �޼����̱⶧���� ���ǰ��� null���� �ɼ�����
			//null�� ���ϸ� false��
			return false;
		

		//A a = new A();�� �������
		if (getClass() != obj.getClass())
			//getClass(a)���Ǹ� AŬ�����̰� �Ű��������� AŬ�������� ���ϴ°�
			//��ӹ����Ͱ� ����Ŭ������ ������
			return false;
		
		//����ȯ
		Rectangle other = (Rectangle) obj;
		
		//�� ��ü�� width height��
		if (this.width != other.width)
			return false;
		if (this.height != other.height)
			return false;
		
		//equals�������ϱ�(�� ����� �������Ѱ� ���̷�)
//		if(this.width*this.height == other.width*other.height) {
//			return true;
//		}else {
//			return false;
//		}
		
		return true;
	}
	
	
	//��ü���� �������̽� (Comparable)
	//���׸�
	@Override
	public int compareTo(Rectangle other) {
		//	-1 : ��ȯ�ʿ�
		// 	0 : ����
		// 	1 : ��ȯ�ʿ�x
		int returnValue = 0;
		if(this.area()==other.area()) {
			returnValue = 0; //����
		}else if(this.area()>other.area()) {
			returnValue = 1;
		}else if(this.area()<other.area()) {
			returnValue = -1;
		}
		//this. �� other.�� ���ؼ� this�� Ŭ�� -1�� ���ϵǸ� �������� ����
		//this. �� other.�� ���ؼ� this�� Ŭ�� 1�� ���ϵǸ� �������� ����
		//���� Ȯ���ϱ�
		return returnValue;
	}
	
	
}


//�÷����� ����Ϸ��� equals�� hashcode�� �������ؾ��Ѵ�
//equals�� �����ص� hash�ڵ带 ���������������� ������ �������ּҿ��ִ� ��ü�� ã������
//�����ּ��� ��ü�� ã�������� (a,b,c��������)


class RectangleWidthAsc implements Comparator<Rectangle>{

	@Override
	public int compare(Rectangle arg0, Rectangle arg1) {		
		int returnValue = 0;
		//width�������� ������ �ǰ���
		if(arg0.width>arg1.width) {
			returnValue = -1;
		}else if(arg0.width<arg1.width) {
			returnValue = 1;
		}else {
			
		}
		return returnValue;
	
	}
	
}

public class CollectionTest {
	public static void main(String[] args) {
	
		System.out.println(new Rectangle(10,10));
		
		ArrayList<Rectangle> arrList = new ArrayList<Rectangle>();
	
		arrList.add(new Rectangle(10, 10));
		arrList.add(new Rectangle(11, 11));
		arrList.add(new Rectangle(12, 12));
		arrList.add(new Rectangle(13, 13));
		arrList.add(new Rectangle(14, 14));
		arrList.add(new Rectangle(13, 20));
		
		for(int i=0;i<arrList.size();i++) {
			System.out.println(arrList.get(i));
		}
		
		System.out.println("----------------------------------");
		
		arrList.remove(1);//11,11
		arrList.remove(new Rectangle(12,12));
		//�������� �ʴ� ���� : ? new�� �����ϸ� ���ּҰ� �������
		
		//equals�� �������ϸ� �����ּҷ� ���� �������� ���������
		for(Rectangle r : arrList) {
			System.out.println(r);
		}
		
		System.out.println("----------------------------------");
		
		Rectangle rect = new Rectangle(15,15);
		arrList.add(rect);
		arrList.remove(rect);
		for(Rectangle r : arrList) {
			System.out.println(r);
		}
		//�������� ���� : ? "hashcode"
		
		
		
		//<<��ü����>>
		//compareTo, compare ==>object��ü�� ����(�������̽� ���)
		
		//compareTo ==> comparable �������̽� �Ű�����1�� : �ڱ��ڽŰ� �Ű����� ��
		//compare ==>comparator �������̽�  �Ű�����2�� : �Ű����� 2�� ��
		System.out.println("----------------------------------");
	
		Collections.sort(arrList);
		for(Rectangle r : arrList) {
			System.out.println(r);
		}
		

		//widthȤ�� height�� ����.		//�͸�Ŭ���� ��ӹ޾Ƽ� �����
//		Collections.sort(arrList, new Comparator<Rectangle>() {
//			@Override
//			public int compare(Rectangle arg0, Rectangle arg1) {
//				int returnValue = 0;
//				//width�������� ������ �ǰ���
//				if(arg0.width>arg1.width) {
//					returnValue = -1;
//				}else if(arg0.width<arg1.width) {
//					returnValue = 1;
//				}else {
//					
//				}
//				return returnValue;
//			}
//		});
		
		System.out.println("----------------------------------");
		for(Rectangle r : arrList) {
			System.out.println(r);
		}
		
//		Collections.sort(arrList, new RectangleWidthAsc());
		
		//�Ʒ� ���� ���߸����� ���� , �͸�Ŭ����(�����ϴ°Ͱ� ���ÿ� Ŭ�����̿��ϴ°�)
		RectangleWidthAsc rAsc = new RectangleWidthAsc();
		Collections.sort(arrList, rAsc);
		System.out.println("----------------------------------");
		for(Rectangle r : arrList) {
			System.out.println(r);
		}
		
		
		//�͸�Ŭ���� ==> ���ٽ�
		Collections.sort(arrList, (a,b) -> {
			int returnValue = 0;
			if(((Rectangle)a).height < ((Rectangle)b).height) {
				returnValue = 1;
			}else if(((Rectangle)a).height > ((Rectangle)b).height) {
				returnValue = -1;
			}
			return returnValue;
		});
		
		System.out.println("----------------------------------");
		for(Rectangle r : arrList) {
			System.out.println(r);
		}
		
		
		
//		Comparator<Rectangle> com = new Comparator<Rectangle>() {
//
//			@Override
//			public int compare(Rectangle arg0, Rectangle arg1) {
//				return 0;
//			}
//			
//		};
//		Collections.sort(arrList, com);
		
		System.out.println("----------------------------------");
		
		
		
		System.out.println("----------------------------------");
		System.out.println("--------------ArrayList-----------");
		System.out.println("----------------------------------");
		
		//ArrayList Ȱ��
		ArrayList<Integer> arrList0 = new ArrayList<Integer>();
				//generic
		//�߰� - add
		arrList0.add(40);
		arrList0.add(30);
		arrList0.add(20);
		arrList0.add(10);
		
		//get���� Ȯ�� �ε����� ��ã��
		for(int i=0; i<arrList0.size(); i++) {
			System.out.println(arrList.get(i));
		}
		
		System.out.println("----------------------------------");
		
		//���� - remove
		arrList0.remove(1); //index���� : 30�� �����ȴ�.
		arrList0.remove((Integer)10);// 10 �̻����ȴ�
		for(int i=0; i<arrList0.size(); i++) {
			System.out.println(arrList.get(i));
		}
		
		System.out.println("----------------------------------");
		
		//����
		Collections.sort(arrList0);
		
		//��ȸ�ϸ鼭 ���
		Iterator<Integer> iter = arrList0.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		//ã�� �������� ��ġ����
		int index = arrList0.indexOf((Integer)20); //equals�� hashcode
		System.out.println(index);
		index = arrList0.indexOf(20);
		System.out.println(index);
		
		//�������� true|false�� ��ȯ
		System.out.println(arrList0.contains(20));
		
		//��ü�� �־ �����ϱ�
		
		
		
		
		
	}

}


