package com.human.character;

public class chick implements Character {

	public int energy=50;
	public int experience=50;
	public int level =1; 
	
	@Override
	public void eat() {
		System.out.println("���Ƹ��� ���� �Խ��ϴ�");
		energy+=20;
	
	}

	@Override
	public void sleep() {
		System.out.println("���Ƹ��� ���� ��ϴ�");
		energy+=15;
	}

	@Override
	public void play() {
		System.out.println("���Ƹ��� ���� ��ƿ�");
		if(energy<30) {
			System.out.println("�������� �� ����������! �����ϼ���!");
		}
		energy-=20;
		experience+=10;
		
	}

	@Override
	public void train() {
		System.out.println("���Ƹ��� �Ʒý�ŵ�ϴ�!");
		if(energy<30) {
			System.out.println("�������� �� ����������! �����ϼ���!");
		}
		energy-=25;
		experience+=15;
	}

	@Override
	public void leverUp() {
		
		if(experience>80) {
			level+=1;
			experience=50;
			System.out.println("������ +1 �Ǿ����ϴ�.");
		}
		
		
	}
	
	@Override
	public boolean endGame() {
		boolean returnValue = true;
		if(level>5) {
			System.out.println("���Ƹ��� ���� �Ǿ����ϴ�~~!!");
			returnValue=false;
		}else if(energy<0) {
			System.out.println("���Ƹ��� ���� �׾����̤�");
			returnValue=false;
		}
		return returnValue;
	}

	@Override
	public void printInfo() {
		System.out.println("=========================");
		System.out.println("���Ƹ� ���� �Դϴ�.");
		System.out.println("experience :"+experience);
		System.out.println("energy :"+energy);
		System.out.println("level :"+level);
		System.out.println("=========================");
	}

}
