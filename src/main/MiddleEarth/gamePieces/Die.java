package main.MiddleEarth.gamePieces;

import java.util.Random;

public class Die {
	
		public final static int DEFAULT_NUMBER_OF_DIE_FACES = 6;

		int dots;
		Random number = new Random();
		
		public void rollDie() {
			dots = number.nextInt(DEFAULT_NUMBER_OF_DIE_FACES) + 1;
		}
		
		public int getDots() {
			return dots;
		}
}

 