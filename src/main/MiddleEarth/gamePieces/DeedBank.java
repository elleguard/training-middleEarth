package main.MiddleEarth.gamePieces;

import java.util.ArrayList;

public class DeedBank {
	
	private ArrayList<Square> allDeeds = new ArrayList<Square>();
	
	public void addDeedToBank(Deed deed) {
		//TODO:add deed to bank
		allDeeds.add(deed);
	}
	
	public void removeDeedFromBank(Square deed) {
		//TODO:remove based on name
		allDeeds.remove(deed);
	}
	
	public ArrayList<Square> getAllDeeds() {
		return allDeeds;
	}
	
	public boolean buyDeed(Token token, Square deed) {
		//return true if player can afford else false
		if(token.getTotalmoney() - deed.getPurchaseValue() >= 0) {
			return true;
		} else {
			return false;
		}
	}	
	
}
