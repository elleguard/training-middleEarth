package main.MiddleEarth.gamePieces;

import java.awt.List;
import java.util.ArrayList;

public class GameController {

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
	private Board board = new Board();
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
	private Deed minastirith = new Deed(13, 1000, "Minas Tirith", 450, 550, "Bank");
	private boolean isNotWinner;
	private int count = NUMBER_OF_PLAYERS;
	private int counter = 0;
	private int i = 0;
	
	public void newGame() {
		initializePlayers();
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
	
	public void gamePlay() {
	
		System.out.println("------------------------------------NEW GAME STARTED----------------------------------------------------------");
		
		while(isNotWinner) {
			counter++;
			for(i = 0; i < count; i++) {
				System.out.println("\r\n" + "--It is " + playerList.get(i).getTokenName() +"'s Turn--");
				
				//roll dice and move player
				int diceRoll = die.rollDie();
				board.moveToken(playerList.get(i), diceRoll);
				System.out.println(playerList.get(i).getTokenName() + " has rolled a " + diceRoll );
				
				//switch statement used to represent game board and actions taken when player lands on each square
				switch (playerList.get(i).getLocationOnBoard()) {
				
				case 0:
					passGo.getMoney(playerList.get(i));
					System.out.println(playerList.get(i).getTokenName() + " has passed go and collected $200");
					System.out.println(playerList.get(i).getTokenName() + " now has $ " +  playerList.get(i).getTotalmoney());
					break;
				case 1: 
					playerActOnDeed(playerList.get(i), shire, playerList);
					break;
				case 2: 
					playerActOnDeed(playerList.get(i), bree, playerList);
					break;
				case 3: 
					playerActOnChance(chance1, playerList.get(i));
					break;
				case 4:
					playerActOnDeed(playerList.get(i), rivendell, playerList);
					break;
				case 5:
					playerActOnDeed(playerList.get(i), rohan, playerList);
					break;
				case 6:
					playerIsInJail(playerList.get(i));
					break;
				case 7:
					playerActOnDeed(playerList.get(i), gondor, playerList);
					break;
				case 8:
					playerActOnDeed(playerList.get(i), mordor, playerList);
					break;
				case 9:
					playerActOnChance(chance2, playerList.get(i));
					break;
				case 10:
					playerActOnDeed(playerList.get(i), isenguard, playerList);
					break;
				case 11:
					playerActOnDeed(playerList.get(i), deadmarshes, playerList);
					break;
				case 12:
					System.out.println(playerList.get(i).getTokenName() + " has received a free night stay at the PRANCING PONY");
					break;
				case 13:
					playerActOnDeed(playerList.get(i), minastirith, playerList);
					break;
				default:
					passGo.getMoney(playerList.get(i));
					break;
				}
				
				if(count == 1) {
					displayWinner(playerList.get(0));
					break;
				}
			}
			System.out.println("------------END OF ROUND " + counter +"--------------\r\n");
		}
	}
	
	
	
	public void playerIsInJail(Token token) {
		jail.getOutOfJail(token);
		System.out.println(token.getTokenName() + " HAS BEEN CAPTURE BY ORCS!!!!!");
		if(token.getTotalmoney() > 0) {
			System.out.println(token.getTokenName() + " now has $" +  token.getTotalmoney());
		}
		else
		{
			playerIsBankrupt(token);
		}	
	}
	
	public void playerActOnChance(Chance chance, Token token) {
		chance.getChanceItem(token);
		System.out.println(token.getTokenName() + " OPENED A MYSTERY CHEST");
		if(token.getTotalmoney() > 0) {
			System.out.println(token.getTokenName() + " now has $" + token.getTotalmoney());
		}
		else
		{
			playerIsBankrupt(token);
		}
	}
	public void playerActOnDeed(Token token, Deed deed, ArrayList<Token> playerList) {
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

	
}


	

