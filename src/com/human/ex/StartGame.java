package com.human.ex;

import com.human.play.MakeCharacter;
import com.human.play.PlayGame;
import com.human.character.Character;

public class StartGame {

	public static void main(String[] args) {
		
		PlayGame pg = new PlayGame();
		MakeCharacter mc = new MakeCharacter();
		Character selectCharacter = mc.selectCharacter();
		pg.play(selectCharacter);
		
		
	}

}
