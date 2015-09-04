package main.MiddleEarth.gamePieces;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		GameController gameController = new GameController();
		gameController.initializePlayers();
		gameController.newGame();
	}
	
	

}
