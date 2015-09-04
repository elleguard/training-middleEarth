package main.MiddleEarth.gamePieces;

import java.util.ArrayList;

public class DeedBank {
	
	private ArrayList<Deed> allDeeds = new ArrayList<Deed>();
	
	public void addDeedToBank(Deed deed) {
		//TODO:add deed to bank
		allDeeds.add(deed);
	}
	
	public void removeDeedFromBank(Deed deed) {
		//TODO:remove based on name
		allDeeds.remove(deed);
	}
	
	public ArrayList<Deed> getAllDeeds() {
		return allDeeds;
	}
	
	public boolean buyDeed(Token token, Deed deed) {
		//return true if player can afford else false
		if(token.getTotalmoney() - deed.getPurchaseValue() >= 0) {
			return true;
		} else {
			return false;
		}
	}	
	
}
