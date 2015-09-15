package com.usaa.MiddleEarth;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class GameController implements Runnable {

	public static int NUMBER_OF_SPACES = 13;
	public static int NUMBER_OF_PLAYERS = 5;
	
	//Instantiate classes
	private Token gandalf = new Token();
	private Token legolas = new Token();
	private Token aragorn = new Token();
	private Token sauran = new Token();
	private Token frodo = new Token();
	private ArrayList<Token> playerList = new ArrayList<Token>();
	private MoneyBank moneyBank = new MoneyBank();
	private DeedBank deedBank = new DeedBank();
	private Square square = new Square();
	private ArrayList<Square> squareList = new ArrayList<Square>();
	private Die die = new Die();
	//set square objects
	private PassGo passGo = new PassGo(0);
	private Deed shire = new Deed(1, 50, "The Shire", 10, 25, "Bank");
	private Deed bree = new Deed(2, 75, "Bree", 20, 40, "Bank");
	private Chance chance1 = new Chance(3);
	private Deed rivendell = new Deed(4, 100, "Rivendell", 30, 50, "Bank");
	private Deed rohan = new Deed(5, 125, "Rohan", 40, 60, "Bank");
	private Jail jail = new Jail(6);
	private Deed gondor = new Deed(7, 150, "Gondor", 50, 70, "Bank");
	private Deed mordor = new Deed(8, 175, "Mordor", 70, 90, "Bank");
	private Chance chance2 = new Chance(9);
	private Deed isenguard = new Deed(10, 200, "Isenguard", 80, 100, "Bank");
	private Deed deadmarshes = new Deed(11, 225, "The Dead Marshes", 90, 110, "Bank");
	private PrancingPony freeStay = new PrancingPony(12);
	private Deed minastirith = new Deed(13, 1000, "Minas Tirith", 450, 550, "Bank");
	private boolean isNotWinner;
	private int count = NUMBER_OF_PLAYERS;
	private int counter = 0;
	private int i = 0;
	
	public void newGame() {
		initializePlayers();
		initializeSquares();
		addDeedsToBankList();
		moneyBank.setMoney(500000);
		isNotWinner = true;
		gamePlay();
	}
	
	public void addDeedsToBankList() {
		deedBank.addDeedToBank(shire);
		deedBank.addDeedToBank(bree);
		deedBank.addDeedToBank(rivendell);
		deedBank.addDeedToBank(rohan);
		deedBank.addDeedToBank(gondor);
		deedBank.addDeedToBank(mordor);
		deedBank.addDeedToBank(isenguard);
		deedBank.addDeedToBank(deadmarshes);
		deedBank.addDeedToBank(minastirith);
	} 
	
	
	/*********************************************************Main Game Logic*******************************************************/
	
	public void gamePlay() {
		
	System.out.println("------------------------------------NEW GAME STARTED----------------------------------------------------------");
		
		while(isNotWinner) {
			counter++;
			for(i = 0; i < count; i++) {
				System.out.println("\r\n" + "--It is " + playerList.get(i).getTokenName() +"'s Turn--");
				//roll dice and move player
				int diceRoll = die.rollDie();
				square.moveToken(playerList.get(i), diceRoll);
				System.out.println(playerList.get(i).getTokenName() + " has rolled a " + diceRoll );
				
				squareTakeAction( playerList.get(i).getLocationOnBoard(), playerList.get(i));
				
				if(count == 1) {
					displayWinner(playerList.get(0));
					break;
				}
			}
			System.out.println("------------END OF ROUND " + counter +"--------------\r\n");
			try {
				postStatus();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			delay(1000);
			
		}
	}
	
	public void postStatus() throws Exception {
		String url = "http://localhost:8081";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());
		   
		
	}
	
	private void delay(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}	
	}
	
	// Method determines Square type and takes action
	public void squareTakeAction(int position, Token token) {
		if(squareList.get(position).getSquareName().equalsIgnoreCase("Deed")) {
			playerActOnDeed(token, squareList.get(position), playerList);
		}
		else if(squareList.get(position).getSquareName().equalsIgnoreCase("Jail")) {
			playerIsInJail(token);
		}
		else if(squareList.get(position).getSquareName().equalsIgnoreCase("Chance")) {
			playerActOnChance(squareList.get(position), token);
		}
		else if(squareList.get(position).getSquareName().equalsIgnoreCase("PassGo")) {
			playerPassesGo(token);
		}
		else if(squareList.get(position).getSquareName().equalsIgnoreCase("PrancingPony")) {
			freeStay.freeSpace(token);
		}
	
	}
	
	// Player lands on Jail Square--pays $50
	public void playerIsInJail(Token token) {
		jail.getOutOfJail(token);
		System.out.println(token.getTokenName() + " HAS BEEN CAPTURE BY ORCS!!!!!");
		if(token.getTotalmoney() > 0) {
			System.out.println(token.getTokenName() + " now has $" +  token.getTotalmoney());
		}
		else {
			playerIsBankrupt(token);
		}	
	}
	
	// Player lands on PassGo Square-- receives $200
	public void playerPassesGo(Token token) {
		passGo.getMoney(token);
		System.out.println(token.getTokenName() + " has passed go and collected $200");
		System.out.println(token.getTokenName() + " now has $ " +  token.getTotalmoney());
	}
	
	// Player lands on Chance Square-- opens chest to gain or lose money
	public void playerActOnChance(Square chance, Token token) {
		chance.getChanceItem(token);
		System.out.println(token.getTokenName() + " OPENED A MYSTERY CHEST");
		if(token.getTotalmoney() > 0) {
			System.out.println(token.getTokenName() + " now has $" + token.getTotalmoney());
		}
		else {
			playerIsBankrupt(token);
		}
	}
	
	// Player lands on Deed Square-- options to buy, or pay rent to owner 
	public void playerActOnDeed(Token token, Square deed, ArrayList<Token> playerList) {
		System.out.println(token.getTokenName() + " landed on a Property");
		System.out.println(deed.getPropertyName() + " is Owned By: " + deed.getOwnedBy());
		if(deed.getOwnedBy() != token.getTokenName()) {
			//check if owned by Bank
			if(deed.getOwnedBy().equalsIgnoreCase("Bank")) {
				//take action to buy
				if(deedBank.buyDeed(token, deed)) {
					deedBank.removeDeedFromBank(deed);
					token.addToProperties(deed);
					deed.setOwnedBy(token.getTokenName());
					System.out.println(token.getTokenName() + " purchased " + deed.getPropertyName());
					System.out.println(token.getTokenName() + "now has $" + token.getTotalmoney() + " left");
				}
				else {
					//TODO: auction property to other players
				}
			} 
			else {
				//must pay rent
				for(int i = 0; i < count; i++) {
					if(deed.getOwnedBy().equalsIgnoreCase(playerList.get(i).getTokenName())) {
						if(token.getTotalmoney() >= deed.getRentAmount()) {
							System.out.println(token.getTokenName() + " with $" + token.getTotalmoney() + " paid rent to " + playerList.get(i).getTokenName());
							token.setTotalMoney(token.getTotalmoney() - deed.getRentAmount());
							playerList.get(i).setTotalMoney(playerList.get(i).getTotalmoney() + deed.getRentAmount());
							System.out.println(token.getTokenName() + " now has $" + token.getTotalmoney() + " left");
						} 
						else {
							playerList.get(i).setTotalMoney(playerList.get(i).getTotalmoney() + deed.getRentAmount());
							playerIsBankrupt(token);
						}
					}
				} 
				
			}
			
		}
			
	}
	
	// If player does not have enough money, bankruptcy method removes player from game and returns assets to bank
	public void playerIsBankrupt(Token token) {
		//TODO: give property and money back to bank and remove from player list
		token.removeAllPropertiesForBankruptcy(token.getPropertyDeeds(), deedBank.getAllDeeds());
		token.setTotalMoney(0);		
		playerList.remove(token);
		count--;
		i--;
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" + token.getTokenName() + 
				" is BANKRUPT!>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	// Last player remaining to not declare bankruptcy, wins
	public void displayWinner(Token token) {
		isNotWinner = false;
		if(token.getIsGoodGuy() == true) {
		System.out.println("\r\n" + playerList.get(0).getTokenName() + " made it to Mount Doom and destroyed the Ring! \r\n"
				+ "Ending with: $" + playerList.get(0).getTotalmoney());
		} 
		else {
			System.out.println("\r\n" + playerList.get(0).getTokenName() + " has defeated the fellowship and claimed rulership over Middle Earth! \r\n"
					+ "Ending with: $" + playerList.get(0).getTotalmoney());
		}
	}
	

	/*************************************************INITIALIZE OBJECTS******************************************************/
	public void initializePlayers() {
			
			gandalf.setPlayerName("Matt");
			gandalf.setTokenName("Gandalf");
			gandalf.setTotalMoney(800);
			gandalf.setLocationOnBoard(0);
			gandalf.setIsGoodGuy(true);
			
			legolas.setPlayerName("Bob");
			legolas.setTokenName("Legolas");
			legolas.setTotalMoney(800);
			legolas.setLocationOnBoard(0);
			legolas.setIsGoodGuy(true);
			
			aragorn.setPlayerName("Kate");
			aragorn.setTokenName("Aragorn");
			aragorn.setTotalMoney(800);
			aragorn.setLocationOnBoard(0);
			aragorn.setIsGoodGuy(true);
			
			sauran.setPlayerName("Kim");
			sauran.setTokenName("Sauran");
			sauran.setTotalMoney(800);
			sauran.setLocationOnBoard(0);
			sauran.setIsGoodGuy(false);
			
			frodo.setPlayerName("Jon");
			frodo.setTokenName("Frodo");
			frodo.setTotalMoney(800);
			frodo.setLocationOnBoard(0);
			frodo.setIsGoodGuy(true);
			
			playerList.add(gandalf);
			playerList.add(legolas);
			playerList.add(aragorn);
			playerList.add(sauran);
			playerList.add(frodo);
	}
	
	public void initializeSquares() {
		
		squareList.add(passGo);
		squareList.add(shire);
		squareList.add(bree);
		squareList.add(chance1);
		squareList.add(rivendell);
		squareList.add(rohan);
		squareList.add(jail);
		squareList.add(gondor);
		squareList.add(mordor);
		squareList.add(chance2);
		squareList.add(isenguard);
		squareList.add(deadmarshes);
		squareList.add(freeStay);
		squareList.add(minastirith);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		initializePlayers();
		newGame();
	}

	
}


	

