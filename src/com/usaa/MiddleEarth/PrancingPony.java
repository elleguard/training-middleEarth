package com.usaa.MiddleEarth;

public class PrancingPony extends Square {
	
	public PrancingPony(int squareId) {	
		this.setSquareId(squareId);
	}
	
	@Override
	public String getSquareName() {
		return "PrancingPony";
	}
	
	@Override
	public void freeSpace(Token token) {
		System.out.println(token.getTokenName() + " has received a free night stay at the PRANCING PONY");
	}

}
