package com.human.play;

import java.util.Scanner;
import com.human.character.*;
import com.human.character.Character;

public class MakeCharacter {
	
	public Character selectCharacter() {
		Character returnValue=null;

		Scanner sc = new Scanner(System.in);
		System.out.println("ĳ���͸� �Է��ϼ���");
		System.out.println("1.��ī�� 2.���Ƹ� 3.�ֹ���");
		
		String ch = sc.nextLine();
		if(ch.equals("1")) {
			returnValue = new pikachu();
		}else if(ch.equals("2")) {
			returnValue = new chick();
		}else if(ch.equals("3")) {
			returnValue = new worm();
		}else {
			System.out.println("�ٽ� �Է��ϼ���:)");
		}
		
		return returnValue;
	}
	
}
