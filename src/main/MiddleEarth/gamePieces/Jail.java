package main.MiddleEarth.gamePieces;

public class Jail extends Square {

	private int jailMoney = 50;
	
	public Jail(int squareId) {
		this.setSquareId(squareId);
	}
	
	@Override
	public void getOutOfJail(Token token) {
		token.setTotalMoney(token.getTotalmoney() - jailMoney);
	}
	
	@Override
	public String getSquareName() {
		return "Jail";
	}
	
}
