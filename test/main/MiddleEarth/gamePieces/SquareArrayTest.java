package main.MiddleEarth.gamePieces;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SquareArrayTest {
	
	int number_of_squares = 7;
	private PassGo passGo = new PassGo(0);
	private Deed shire = new Deed(1, 50, "The Shire", 10, 25, "Bank");
	private Deed bree = new Deed(2, 75, "Bree", 20, 40, "Bank");
	private Chance chance1 = new Chance(3);
	private Deed rivendell = new Deed(4, 100, "Rivendell", 30, 50, "Bank");
	private Deed rohan = new Deed(5, 125, "Rohan", 40, 60, "Bank");
	private Jail jail = new Jail(6);
	ArrayList<Square> squareList = new ArrayList<Square>();
	private Token frodo = new Token();
	
	
	
	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void DeedTest() {
		
		instantiateObjects();
		
		/*for(int i = 0; i < number_of_squares; i++) {}*/

			for(int i = 0; i < squareList.size(); i++) {
				
				if(squareList.get(i).getSquareName().equalsIgnoreCase("Deed")) {
					
					System.out.println(i + " " + squareList.get(i).getSquareName());
					System.out.println(squareList.get(i).getPropertyName());
					
				}
				
				
			}
	
	}
	
	@Test
	public void JailTest() {
		
		instantiateObjects();
		
		
		for(int i = 0; i < squareList.size(); i++) {
			
			if(squareList.get(i).getSquareName().equalsIgnoreCase("Jail")) {
				
				System.out.println("Money Before: $" + frodo.getTotalmoney());
				System.out.println(i + " " + squareList.get(i).getSquareName());
				squareList.get(i).getOutOfJail(frodo);
				System.out.println("Money After: $" + frodo.getTotalmoney());
				
				
			}
			
			
		}

	}
	
	@Test
	public void ChanceTest() {
		
		instantiateObjects();
		
		for(int i = 0; i < squareList.size(); i++) {
			
			if(squareList.get(i).getSquareName().equalsIgnoreCase("Chance")) {
				
				System.out.println(i + " " + squareList.get(i).getSquareName());
				System.out.println("Money Before: $" + frodo.getTotalmoney());
				squareList.get(i).getChanceItem(frodo);
				System.out.println("Money After: $" + frodo.getTotalmoney());
			}
		}
	}
	
	@Test
	public void PassGoTest() {
		
		instantiateObjects();
		
		for(int i = 0; i < squareList.size(); i++) {
			
			if(squareList.get(i).getSquareName().equalsIgnoreCase("PassGo")) {
				
				System.out.println(i + " " + squareList.get(i).getSquareName());
				System.out.println("Money Before: $" + frodo.getTotalmoney());
				squareList.get(i).getMoney(frodo);
				System.out.println("Money After: $" + frodo.getTotalmoney());
			}
		}
	}
	
	
	public void instantiateObjects() {
		
		squareList.add(passGo);
		squareList.add(shire);
		squareList.add(bree);
		squareList.add(chance1);
		squareList.add(rivendell);
		squareList.add(rohan);
		squareList.add(jail);
		
		frodo.setPlayerName("Jon");
		frodo.setTokenName("Frodo");
		frodo.setTotalMoney(800);
		frodo.setLocationOnBoard(0);
		frodo.setIsGoodGuy(true);
		
	}

}
