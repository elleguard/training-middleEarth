package main.MiddleEarth.gamePieces;

public class PassGo extends Square {
	
	private int passGoAmount = 200;
	
	public PassGo(int squareId) {
		this.setSquareId(squareId);	
	}
	
	@Override
	public String getSquareName() {
		return "PassGo";
	}
	
	@Override
	public void getMoney(Token token) {
		token.setTotalMoney(token.getTotalmoney() + passGoAmount);
	}
}
