package project;

import java.util.List;

public abstract class OrdinaryTruck extends Truck{
	private double cost;
	//cargo
	
	public OrdinaryTruck (int temp, int capacity) {
		super(temp, capacity);
	}
	
	public double getCost () {
		cost = 750 + (0.25 * this.getCapacity());
		return cost;
	}
	
	public void capacityCheck () { //questionable
		if (this.getCapacity() > 1000) {
			System.out.print("Overload!"); //throw exception
		}
	}
	
	public List<String> cargo() {
		
		return null;
	}
}
