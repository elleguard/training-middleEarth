package com.usaa.MiddleEarth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.usaa.MiddleEarth.GameController;

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
		gameController.newGame(2);
	}
	
	

}
