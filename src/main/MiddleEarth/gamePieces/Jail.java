package main.MiddleEarth.gamePieces;

public class Jail extends Board {

	private int jailMoney = 50;
	
	public Jail(int squareId) {
		this.setSquareId(squareId);
	}
	
	public void getOutOfJail(Token token) {
		token.setTotalMoney(token.getTotalmoney() - jailMoney);
	}
}
