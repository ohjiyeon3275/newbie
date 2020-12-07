package com.human.character;

public class worm implements Character{
	
	public int hp=20;
	public int xp=30;
	public int level=1;
	public String stage="애벌레";
	
	@Override
	public void eat() {
		hp += 30;
		System.out.println(stage+"(이)가 밥을 먹어요");
		
	}

	@Override
	public void sleep() {
		hp+=20;
		xp-=5;
		System.out.println(stage+"(이)가 잠을 자요");
		
	}

	@Override
	public void play() {
		hp-=30;
		xp+=25;
		System.out.println(stage+"와 함께 놀아요");
		
	}

	@Override
	public void train() {
		hp-=25;
		xp+=40;
		System.out.println(stage+"(을)를 훈련시켜요");
		
	}

	@Override
	public void leverUp() {
		if(xp>90) {
			level++;
			xp=50;
			System.out.print("레벨업이 되었습니다.");
			if(level==2) {
				stage="번데기";
				System.out.println(stage+"(이)가 되었어요");
			}else if(level==3) {
				stage="성충";
				System.out.println(stage+"(이)가 되었어요");
			}else if(level==4) {
				stage="나비";
				System.out.println(stage+"(이)가 되었어요");
			}
		}
		
	}

	@Override
	public boolean endGame() {
		boolean returnValue=true;
		if(level>4) {
			System.out.println("나비가 날아갑니당~!~!");
			returnValue=false;
		}else if(hp<0) {
			System.out.println(stage+"(이)가 굶어 죽었어요ㅜㅜ");
			returnValue=false;
		}
		return returnValue;
	}

	@Override
	public void printInfo() {
		System.out.println("=========================");
		System.out.println(stage+" 정보 입니다.");
		System.out.print("experience :"+xp);
		System.out.print("  energy :"+hp);
		System.out.println("  level :"+level);
		System.out.println("=========================");
		
	}
	

}
