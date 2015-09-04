package main.MiddleEarth.gamePieces;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class playerActOnDeedTest {

	Deed shire = new Deed(1, 50, "The Shire", 10, 25, "Bank");
	Token gandalf = new Token();
	Token legolas = new Token();
	Token aragorn = new Token();
	Token sauran = new Token();
	ArrayList<Token> playerList = new ArrayList<Token>();
	GameController gameController = new GameController();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		initializePlayers();
		gameController.playerActOnDeed(aragorn, shire, playerList);
	}
	
	public void initializePlayers() {
		
		gandalf.setPlayerName("Matt");
		gandalf.setTokenName("Gandalf");
		gandalf.setTotalMoney(1500);
		gandalf.setLocationOnBoard(0);
		
		legolas.setPlayerName("Bob");
		legolas.setTokenName("Legolas");
		legolas.setTotalMoney(1500);
		legolas.setLocationOnBoard(0);
		
		aragorn.setPlayerName("Kate");
		aragorn.setTokenName("Aragorn");
		aragorn.setTotalMoney(1500);
		aragorn.setLocationOnBoard(0);
		
		sauran.setPlayerName("Kim");
		sauran.setTokenName("Sauran");
		sauran.setTotalMoney(1500);
		sauran.setLocationOnBoard(0);
		
		playerList.add(gandalf);
		playerList.add(legolas);
		playerList.add(aragorn);
		playerList.add(sauran);
	}

}
