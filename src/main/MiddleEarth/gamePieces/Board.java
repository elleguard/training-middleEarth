package main.MiddleEarth.gamePieces;

public class Board {
	
	public int squareId;
	
	//TODO: pass player object to determine where player is and place player
	public void moveToken(Token token, int spacesToMove) {
		token.setLocationOnBoard(token.getLocationOnBoard() + spacesToMove);
	}
	
	public int getSquareId() {
		return squareId;
	}
	
	public void setSquareId(int id) {
		squareId = id;
	}

}
