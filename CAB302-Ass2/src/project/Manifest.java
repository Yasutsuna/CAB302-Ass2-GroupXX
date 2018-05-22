package project;

public class Manifest {
	private String name;
	private int quantity;
	
	public Manifest(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQuantity( ) {
		return quantity;
	}
}
