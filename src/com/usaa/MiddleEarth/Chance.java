package com.usaa.MiddleEarth;

import java.util.Random;

public class Chance extends Square {
	
	private int chanceValue;
	private Random number = new Random();
	
	public Chance(int squareId) {
		this.setSquareId(squareId);
	}
	
	@Override
	public String getSquareName() {
		return "Chance";
	}
	
	@Override
	public void getChanceItem(Token token) {
		chanceValue = number.nextInt(3) + 1;
		//1 represents a bad chance card resulting in owing 100 dollars
		if(chanceValue == 1 || chanceValue == 2) {
			token.setTotalMoney(token.getTotalmoney()-100);
		//2 represents a good chance card resulting in receiving 100 dollars
		} 
		else {
			token.setTotalMoney(token.getTotalmoney()+100);
		}
	}

}
