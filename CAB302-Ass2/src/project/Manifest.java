package project;

public class Manifest {
	private String name;
	private double currentleft;
	
	public Manifest(String name, double currentleft) {
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
