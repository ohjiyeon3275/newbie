package com.human.character;

public class worm implements Character{
	
	public int hp=20;
	public int xp=30;
	public int level=1;
	public String stage="�ֹ���";
	
	@Override
	public void eat() {
		hp += 30;
		System.out.println(stage+"(��)�� ���� �Ծ��");
		
	}

	@Override
	public void sleep() {
		hp+=20;
		xp-=5;
		System.out.println(stage+"(��)�� ���� �ڿ�");
		
	}

	@Override
	public void play() {
		hp-=30;
		xp+=25;
		System.out.println(stage+"�� �Բ� ��ƿ�");
		
	}

	@Override
	public void train() {
		hp-=25;
		xp+=40;
		System.out.println(stage+"(��)�� �Ʒý��ѿ�");
		
	}

	@Override
	public void leverUp() {
		if(xp>90) {
			level++;
			xp=50;
			System.out.print("�������� �Ǿ����ϴ�.");
			if(level==2) {
				stage="������";
				System.out.println(stage+"(��)�� �Ǿ����");
			}else if(level==3) {
				stage="����";
				System.out.println(stage+"(��)�� �Ǿ����");
			}else if(level==4) {
				stage="����";
				System.out.println(stage+"(��)�� �Ǿ����");
			}
		}
		
	}

	@Override
	public boolean endGame() {
		boolean returnValue=true;
		if(level>4) {
			System.out.println("���� ���ư��ϴ�~!~!");
			returnValue=false;
		}else if(hp<0) {
			System.out.println(stage+"(��)�� ���� �׾����̤�");
			returnValue=false;
		}
		return returnValue;
	}

	@Override
	public void printInfo() {
		System.out.println("=========================");
		System.out.println(stage+" ���� �Դϴ�.");
		System.out.print("experience :"+xp);
		System.out.print("  energy :"+hp);
		System.out.println("  level :"+level);
		System.out.println("=========================");
		
	}
	

}
