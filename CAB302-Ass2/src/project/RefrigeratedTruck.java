package project;

import java.util.List;

public abstract class RefrigeratedTruck extends Truck{
	private double cost;
	//cargo
	
	public RefrigeratedTruck (int temp, int capacity) {
		super(temp, capacity);
	}
	
	public double getCost() {
		cost = 900 + 200 * Math.pow(0.7,this.getTemp()/5);
		return cost;
	}
	
	public void capacityCheck () { //questionable
		if (this.getCapacity() > 800) {
			System.out.print("Overload!"); //throw exception
		}
	}
	
	public List<String> cargo() {
		
		return null;
	}
}
