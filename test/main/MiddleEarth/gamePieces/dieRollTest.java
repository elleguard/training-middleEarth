package main.MiddleEarth.gamePieces;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class dieRollTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Die die = new Die() ;
		die.rollDie();
		die.getDots();
		System.out.println("ONE DIE TEST: " + die.getDots());
	}
	
	@Test
	public void twoDiceTest() {
		Die die1 = new Die();
		Die die2 = new Die();
		
		die1.rollDie();
		die2.rollDie();
		int totalDots = die1.getDots() + die2.getDots();
		System.out.println("TWO DICE TEST: " + totalDots);
	}
	
	@Test
	public void multipeRolls() {
		Die die = new Die();
		
		for (int i = 0; i < 1000; i++) {
			die.rollDie();
		}
		
		int value = die.getDots();
		if (value < 1)
			System.out.println("INVALID Die value less than 1");
		else if (value > 6)
			System.out.println("INVALID Die value greater than 6");			
	}
	
	@Test
	public void dotValueWithinRange() {
		Die die = new Die();
		int value = 0;
		
		for (int i = 0; i < 1000; i++)
		{
			die.rollDie();
			value = die.getDots();
			if (value < 1)
				System.out.println("INVALID Die value less than 1");
			else if (value > 6)
				System.out.println("INVALID Die value greater than 6");
				
		}
	}
	
	@Test
	public void isItRandom() {
		Die die = new Die();
		int value  = 0;
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five= 0;
		int six = 0;
		double times = 10000;
		
		for( int i = 0; i < times; i++)
		{
			die.rollDie();
			value = die.getDots();
			
			switch (value)
			{
				case 1: one++;
				break;
				case 2: two++;
				break; 
				case 3: three++;
				break;
				case 4: four++;
				break;
				case 5: five++;
				break;
				case 6: six++;
				break;
				default: System.out.println("INVALID Die Value");
				break;
								
			}
	
		}
		
		
		System.out.println("PERCENT ONE: " + ((double)one / times) * 100.0 +"%");
		System.out.println("PERCENT TWO: " + ((double)two / times) * 100.0 +"%");
		System.out.println("PERCENT THREE: " + ((double)three / times) * 100.0 +"%");
		System.out.println("PERCENT FOUR: " + ((double)four / times) * 100.0 +"%");
		System.out.println("PERCENT FIVE: " + ((double)five / times) * 100.0 +"%");
		System.out.println("PERCENT SIX: " + ((double)six / times) * 100.0 +"%");
		
		
	}
}

