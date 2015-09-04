package main.MiddleEarth.gamePieces;

public class MoneyBank {
	
	private int totalMoneyInBank;
	
	public int getMoney(int amount) {
		//TODO:delete amount form total money and give to player
		totalMoneyInBank -= amount;
		return amount;
	}
	
	public void setMoney(int total) {
		//TODO:set amount of money in MoneyBank
		totalMoneyInBank = total;
	}
	
}
