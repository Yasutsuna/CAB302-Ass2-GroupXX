package project;

public class Manifest {
	
	private String name;
	private int currentleft;
	
	Stock stock;
	//RefrigeratedTruck rtruck ;
	//Truck truck;
	
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
	
	private void loadingTruck() {
		//truck = new RefrigeratedTruck();
	}
}
