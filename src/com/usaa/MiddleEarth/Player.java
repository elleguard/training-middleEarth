package com.usaa.MiddleEarth;

import java.util.ArrayList;

public class Player {
	
	private String playerName;
	private int totalMoney;
	private ArrayList<Square> propertyDeeds = new ArrayList<Square>();
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
	
	public ArrayList<Square> getPropertyDeeds() {
		return propertyDeeds;
	}
	
	public void addToProperties(Square deed) {
		//TODO: add property deed to propertyDeeds list
		propertyDeeds.add(deed);
		totalMoney -= deed.getPurchaseValue();
	}
	
	public boolean isBankrupt() {
		return isBankrupt;
	}
	
	public void removeAllPropertiesForBankruptcy(ArrayList<Square> propertyDeeds, ArrayList<Square> deedBank) {
		while(propertyDeeds.size() > 0) {
			propertyDeeds.get(0).setOwnedBy("Bank");
			deedBank.add(propertyDeeds.get(0));
			this.propertyDeeds.remove(propertyDeeds.get(0));	
		}
		isBankrupt = true;
	}

}
