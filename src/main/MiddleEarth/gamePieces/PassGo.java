package main.MiddleEarth.gamePieces;

public class PassGo extends Board {
	
	private int passGoAmount = 200;
	
	public PassGo(int squareId) {
		this.setSquareId(squareId);	
	}
	
	public void getMoney(Token token) {
		token.setTotalMoney(token.getTotalmoney() + passGoAmount);
	}
}
