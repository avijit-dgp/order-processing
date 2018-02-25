package model;

public class Entity {
	private String name;
	private int unitPrice;
	
	public Entity() {
		super();
		
	}
	public Entity(String name, int unitPrice) {
		super();
		this.name = name;
		this.unitPrice = unitPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	

}
