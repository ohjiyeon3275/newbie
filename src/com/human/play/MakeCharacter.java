package com.human.play;

import java.util.Scanner;
import com.human.character.*;
import com.human.character.Character;

public class MakeCharacter {
	
	public Character selectCharacter() {
		Character returnValue=null;

		Scanner sc = new Scanner(System.in);
		System.out.println("캐릭터를 입력하세요");
		System.out.println("1.피카츄 2.병아리 3.애벌레");
		
		String ch = sc.nextLine();
		if(ch.equals("1")) {
			returnValue = new pikachu();
		}else if(ch.equals("2")) {
			returnValue = new chick();
		}else if(ch.equals("3")) {
			returnValue = new worm();
		}else {
			System.out.println("다시 입력하세요:)");
		}
		
		return returnValue;
	}
	
}
