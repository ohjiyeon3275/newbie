package com.human.character;

public class pikachu implements Character {

	private int experience=40;
	private int energy=50;
	private int level=1;
	
	@Override
	public void eat() {
		energy+=25;
	}

	@Override
	public void sleep() {
		energy+=10;
	}

	@Override
	public void play() {
		energy-=30;
		experience+=30;
	}

	@Override
	public void train() {
		energy-=20;
		experience+=20;
	}

	@Override
	public void leverUp() {
		if(experience>60) {
			experience-=40;
			level++;
			System.out.println("레벨 업 되었습니다.");
		}
	}

	@Override
	public boolean endGame() {
		boolean returnValue=true;
		if(level>4) {
			System.out.println("피카츄가 다 성장해서 용이 되었습니다~!^ㅡ^ ");
			returnValue=false;
		}else if(energy<0) {
			System.out.println("피카츄가 굶어 죽었습니다ㅠㅠ");
			returnValue=false;
		}
		return returnValue;
	}

	@Override
	public void printInfo() {
		System.out.println("=========================");
		System.out.println("피카츄 정보 입니다.");
		System.out.println("experience :"+experience);
		System.out.println("energy :"+energy);
		System.out.println("level :"+level);
		System.out.println("=========================");
	}

	public static void main(String[] args) {
		
		
	}
}
