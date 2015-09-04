package main.MiddleEarth.gamePieces;

public class Deed extends Board {
	
	private String ownedBy;
	private int rentAmount;
	private int morgageAmount;
	private int purchaseValue;
	private String propertyName;
	
	public Deed(int squareId, int purchaseValue, String propertyName, int rentAmount, int morgageAmount, String ownedBy) {
		this.squareId = squareId;
		this.propertyName = propertyName;
		this.purchaseValue = purchaseValue;
		this.rentAmount = rentAmount;
		this.morgageAmount = morgageAmount;		
		this.ownedBy = ownedBy;
	}
	
	public void setPurchaseValue(int val) {
		purchaseValue = val;
	}
	
	public void setSquareId(int id) {
		squareId = id;
	}
	
	public  void setPropertyName(String name) {
		propertyName = name;
	}
	
	public void setRentAmount(int amount) {
		rentAmount = amount;
		
	}
	
	public void setMorgageAmount(int amount) {
		morgageAmount = amount;
	}
	
	public void setOwnedBy(String name) {
		ownedBy = name;
	}
	
	public int getPurchaseValue() {
		return purchaseValue;
	}
	public int getSquareId() {
		return squareId;
	}
	
	public String getPropertyName() {
		return propertyName;
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

}
