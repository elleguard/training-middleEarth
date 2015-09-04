package main.MiddleEarth.gamePieces;

public class Square {
	
	public int squareId;
	public String squareName;
	
	// For Deed Square 
	private String ownedBy;
	private int rentAmount;
	private int morgageAmount;
	private int purchaseValue;
	private String propertyName;
	
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
	
	public String getSquareName() {
		return squareName;
	}
	
	public  void setSquareName(String name) {
		squareName = name;
	}
	
	
	
	// For Deed Square
	
	public void setPurchaseValue(int val) {
	}
		
	
	public void setRentAmount(int amount) {
		
	}
	
	public void setMorgageAmount(int amount) {
	}
	
	public void setOwnedBy(String name) {
	}
	
	public int getPurchaseValue() {
		return purchaseValue;
	}
	
	public int getRentAmount() {
		return rentAmount;
	}
	
	public int getMorgageAmount() {
		return morgageAmount;
	}
	
	public String getOwnedBy() {
		return ownedBy;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public  void setPropertyName(String name) {
	}
	
	// For Jail Square
	public void getOutOfJail(Token token) {
	}
	
	//For Chance Square
	public void getChanceItem(Token token) {
	}
	
	//For Pass Go Square
	public void getMoney(Token token) {
	}
	
	//For freeSpace Square
	public void freeSpace(Token token) {
	}
	
	
}
