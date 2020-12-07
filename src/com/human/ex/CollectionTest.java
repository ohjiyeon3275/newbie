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
							//부모가 Object라서 Object로 함
							//override된것이라 Rectangle형으로 쓰면 안됨(?)
		//A a = new A();를 예로들면
		if (this == obj)
			//a.equals(a)
			return true;
		
		if (obj == null)
			//점찍어서 구현하는 메서드이기때문에 앞의값은 null값이 될수없음
			//null과 비교하면 false값
			return false;
		

		//A a = new A();로 예를들면
		if (getClass() != obj.getClass())
			//getClass(a)가되면 A클래스이고 매개변수또한 A클래스인지 비교하는것
			//상속받은것과 기존클래스를 구분함
			return false;
		
		//형변환
		Rectangle other = (Rectangle) obj;
		
		//두 객체의 width height비교
		if (this.width != other.width)
			return false;
		if (this.height != other.height)
			return false;
		
		//equals재정의하기(비교 방법을 재정의한것 넓이로)
//		if(this.width*this.height == other.width*other.height) {
//			return true;
//		}else {
//			return false;
//		}
		
		return true;
	}
	
	
	//객체정렬 인터페이스 (Comparable)
	//제네릭
	@Override
	public int compareTo(Rectangle other) {
		//	-1 : 교환필요
		// 	0 : 같음
		// 	1 : 교환필요x
		int returnValue = 0;
		if(this.area()==other.area()) {
			returnValue = 0; //같음
		}else if(this.area()>other.area()) {
			returnValue = 1;
		}else if(this.area()<other.area()) {
			returnValue = -1;
		}
		//this. 와 other.를 비교해서 this가 클때 -1이 리턴되면 내림차순 정렬
		//this. 와 other.를 비교해서 this가 클때 1이 리턴되면 오름차순 정렬
		//찍어보고 확인하기
		return returnValue;
	}
	
	
}


//컬렉션을 사용하려면 equals랑 hashcode를 재정의해야한다
//equals를 정의해도 hash코드를 재정의하지않으면 구조상 이후의주소에있는 객체를 찾았을때
//이전주소의 객체를 찾을수없다 (a,b,c설명참고)


class RectangleWidthAsc implements Comparator<Rectangle>{

	@Override
	public int compare(Rectangle arg0, Rectangle arg1) {		
		int returnValue = 0;
		//width기준으로 정렬이 되게함
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
		//지워지지 않는 이유 : ? new로 생성하면 새주소가 만들어짐
		
		//equals를 재정의하면 같은주소로 보고 지워지게 만들수있음
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
		//지워지는 이유 : ? "hashcode"
		
		
		
		//<<객체정렬>>
		//compareTo, compare ==>object객체에 없음(인터페이스 사용)
		
		//compareTo ==> comparable 인터페이스 매개변수1개 : 자기자신과 매개변수 비교
		//compare ==>comparator 인터페이스  매개변수2개 : 매개변수 2개 비교
		System.out.println("----------------------------------");
	
		Collections.sort(arrList);
		for(Rectangle r : arrList) {
			System.out.println(r);
		}
		

		//width혹은 height로 정렬.		//익명클래스 상속받아서 만든것
//		Collections.sort(arrList, new Comparator<Rectangle>() {
//			@Override
//			public int compare(Rectangle arg0, Rectangle arg1) {
//				int returnValue = 0;
//				//width기준으로 정렬이 되게함
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
		
		//아래 식을 간추린것이 윗줄 , 익명클래스(선언하는것과 동시에 클래스이용하는것)
		RectangleWidthAsc rAsc = new RectangleWidthAsc();
		Collections.sort(arrList, rAsc);
		System.out.println("----------------------------------");
		for(Rectangle r : arrList) {
			System.out.println(r);
		}
		
		
		//익명클래스 ==> 람다식
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
		
		//ArrayList 활용
		ArrayList<Integer> arrList0 = new ArrayList<Integer>();
				//generic
		//추가 - add
		arrList0.add(40);
		arrList0.add(30);
		arrList0.add(20);
		arrList0.add(10);
		
		//get으로 확인 인덱스로 값찾기
		for(int i=0; i<arrList0.size(); i++) {
			System.out.println(arrList.get(i));
		}
		
		System.out.println("----------------------------------");
		
		//삭제 - remove
		arrList0.remove(1); //index값임 : 30이 삭제된다.
		arrList0.remove((Integer)10);// 10 이삭제된다
		for(int i=0; i<arrList0.size(); i++) {
			System.out.println(arrList.get(i));
		}
		
		System.out.println("----------------------------------");
		
		//정렬
		Collections.sort(arrList0);
		
		//순회하면서 출력
		Iterator<Integer> iter = arrList0.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		//찾는 데이터의 위치리턴
		int index = arrList0.indexOf((Integer)20); //equals와 hashcode
		System.out.println(index);
		index = arrList0.indexOf(20);
		System.out.println(index);
		
		//존재유무 true|false로 반환
		System.out.println(arrList0.contains(20));
		
		//개체로 넣어서 구현하기
		
		
		
		
		
	}

}


