package project;

public class Manifest {
	
	private String name;
	private int currentleft;
	
	Stock stock;
	
	public Manifest(String name, int currentleft) {
		this.name = name;
		this.currentleft = currentleft;
	}
	
	public String getName() {
		return name;
	}
	
	public double getCurrentleft( ) {
		return currentleft;
	}
}
