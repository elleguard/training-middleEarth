package main.MiddleEarth.gamePieces;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.usaa.MiddleEarth.Chance;
import com.usaa.MiddleEarth.Token;

public class ChanceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Chance chance1 = new Chance(3);
		Token gandalf = new Token();
		gandalf.setPlayerName("Matt");
		gandalf.setTokenName("Gandalf");
		gandalf.setTotalMoney(1500);
		gandalf.setLocationOnBoard(0);
		
		chance1.getChanceItem(gandalf);
		System.out.println(gandalf.getTokenName() + " landed on Chance and now has " + gandalf.getTotalmoney());
		
		
	}

}
