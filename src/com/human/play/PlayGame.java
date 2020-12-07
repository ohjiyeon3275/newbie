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
			
			System.out.println("1.����̱� 2.������ 3.����ֱ� 4.� 5.����");
			System.out.println("�Է�>>");
			
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
				System.out.println("�ٽ� �Է��ϼ���");
				break;
			}
			
			character.leverUp();
			
			if(flag) {
				flag=character.endGame();
			}
		}
		

	
	}
}
