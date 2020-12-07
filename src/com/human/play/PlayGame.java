package com.human.play;
import java.util.Scanner;

import com.human.character.Character;
import com.human.character.pikachu;

public class PlayGame {
	
	private Character character;
	private boolean flag=true;
	
	Scanner sc = new Scanner(System.in);
	
	public void play(Character c) {
		character = c;
		
		while(flag) {
			
			character.printInfo();
			
			System.out.println("1.밥먹이기 2.잠재우기 3.놀아주기 4.운동 5.종료");
			System.out.println("입력>>");
			
			String select = sc.nextLine();
			
			switch(select) {
			case "1" :
				character.eat();
				break;
			case "2" :
				character.sleep();
				break;
			case "3" :
				character.play();
				break;
			case "4" :
				character.train();
				break;
			case "5" :
				flag=false;
				break;
			default :
				System.out.println("다시 입력하세요");
				break;
			}
			
			character.leverUp();
			
			if(flag) {
				flag=character.endGame();
			}
		}
		

	
	}
}
