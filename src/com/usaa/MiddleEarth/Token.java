package com.usaa.MiddleEarth;

public class Token extends Player {
	
	private String tokenName;
	private int locationOnBoard;
	private boolean isGoodGuy;
	
	public String getTokenName() {
		return tokenName;
	}
	
	public void setTokenName(String tokenName) {
		this.tokenName = tokenName; 
	}
	
	public void setLocationOnBoard(int location) {
		locationOnBoard = location;	
		if(locationOnBoard > GameController.NUMBER_OF_SPACES) {
			locationOnBoard = locationOnBoard % GameController.NUMBER_OF_SPACES - 1;
		}
	}
	
	public int getLocationOnBoard() {
		return locationOnBoard;
	}
	
	public void setIsGoodGuy(boolean isGood) {
		isGoodGuy = isGood;
	}
	
	public boolean getIsGoodGuy() {
		return isGoodGuy;
	}
	
	

}
