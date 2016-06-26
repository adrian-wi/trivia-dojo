
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.trivia.game.Game;
import com.adaptionsoft.games.trivia.Player;


public class GameRunner {

	private static boolean aWinner;

	public static void main(String[] args) {
		Game aGame = new Game();
		
		aGame.add(new Player("Chet"));
		aGame.add(new Player("Pat"));
		aGame.add(new Player("Sue"));
		
		Random rand = new Random();
	
		do {
			
			aGame.roll(rand.nextInt(5) + 1);
			
			if (rand.nextInt(9) == 7) {
				aWinner = aGame.wrongAnswer();
			} else {
				aWinner = aGame.wasCorrectlyAnswered();
			}
			
			
			
		} while (!aWinner);
		
	}
}
