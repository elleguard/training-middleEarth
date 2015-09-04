package main.MiddleEarth.gamePieces;

import java.awt.List;
import java.util.ArrayList;

public class Player {
	
	private String playerName;
	private int totalMoney;
	private ArrayList<Deed> propertyDeeds = new ArrayList<Deed>();
	private boolean isBankrupt = false;
	
	public void getPlayerName() {
		
	}
	
	public void setPlayerName(String name) {
		
	}
	
	public int getTotalmoney() {
		return totalMoney;
	}
	
	public void setTotalMoney(int amount) {
		totalMoney = amount;
	}
	
	public void addToTotalMoney(int money) {
		
	}
	
	public ArrayList<Deed> getPropertyDeeds() {
		return propertyDeeds;
	}
	
	public void addToProperties(Deed property) {
		//TODO: add property deed to propertyDeeds list
		propertyDeeds.add(property);
		totalMoney -= property.getPurchaseValue();
	}
	
	public boolean isBankrupt() {
		return isBankrupt;
	}
	
	public void removeAllPropertiesForBankruptcy(ArrayList<Deed> propertyDeeds, ArrayList<Deed> deedBank) {
		while(propertyDeeds.size() > 0) {
			propertyDeeds.get(0).setOwnedBy("Bank");
			deedBank.add(propertyDeeds.get(0));
			this.propertyDeeds.remove(propertyDeeds.get(0));	
		}
		isBankrupt = true;
	}

}
