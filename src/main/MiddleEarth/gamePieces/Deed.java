package main.MiddleEarth.gamePieces;

public class Deed extends Square {
	
	
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
	
	@Override
	public void setPurchaseValue(int val) {
		purchaseValue = val;
	}
		
	@Override
	public void setRentAmount(int amount) {
		rentAmount = amount;
		
	}
	
	@Override
	public void setMorgageAmount(int amount) {
		morgageAmount = amount;
	}
	
	@Override
	public void setOwnedBy(String name) {
		ownedBy = name;
	}
	
	@Override
	public int getPurchaseValue() {
		return purchaseValue;
	}
	
	@Override
	public int getRentAmount() {
		return rentAmount;
	}
	
	@Override
	public int getMorgageAmount() {
		return morgageAmount;
	}
	
	@Override
	public String getOwnedBy() {
		return ownedBy;
	}
	
	@Override
	public String getPropertyName() {
		return propertyName;
	}
	
	@Override
	public  void setPropertyName(String name) {
		propertyName = name;
	}
	
	@Override
	public String getSquareName() {
		return "Deed";
	}
	
	

}
