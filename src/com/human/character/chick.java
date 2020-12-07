package com.human.character;

public class chick implements Character {

	public int energy=50;
	public int experience=50;
	public int level =1; 
	
	@Override
	public void eat() {
		System.out.println("병아리가 밥을 먹습니다");
		energy+=20;
	
	}

	@Override
	public void sleep() {
		System.out.println("병아리가 잠을 잡니다");
		energy+=15;
	}

	@Override
	public void play() {
		System.out.println("병아리와 같이 놀아요");
		if(energy<30) {
			System.out.println("에너지가 다 떨어져가요! 조심하세요!");
		}
		energy-=20;
		experience+=10;
		
	}

	@Override
	public void train() {
		System.out.println("병아리를 훈련시킵니다!");
		if(energy<30) {
			System.out.println("에너지가 다 떨어져가요! 조심하세요!");
		}
		energy-=25;
		experience+=15;
	}

	@Override
	public void leverUp() {
		
		if(experience>80) {
			level+=1;
			experience=50;
			System.out.println("레벨이 +1 되었습니다.");
		}
		
		
	}
	
	@Override
	public boolean endGame() {
		boolean returnValue = true;
		if(level>5) {
			System.out.println("병아리가 닭이 되었습니다~~!!");
			returnValue=false;
		}else if(energy<0) {
			System.out.println("병아리가 굶어 죽었어요ㅜㅜ");
			returnValue=false;
		}
		return returnValue;
	}

	@Override
	public void printInfo() {
		System.out.println("=========================");
		System.out.println("병아리 정보 입니다.");
		System.out.println("experience :"+experience);
		System.out.println("energy :"+energy);
		System.out.println("level :"+level);
		System.out.println("=========================");
	}

}
