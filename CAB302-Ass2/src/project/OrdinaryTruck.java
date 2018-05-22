package project;

import java.util.List;

public abstract class OrdinaryTruck extends Truck{
	private List<Manifest> cargo;
	private double costWithTruck;
	
	public OrdinaryTruck (int cost, int capacity, List<Manifest> cargo) {
		super(cost, capacity);
		this.cargo = cargo;
	}
	
	public double getCostNormalTruck () {
		costWithTruck = 750 + (0.25 * this.getCapacity());
		return costWithTruck;
	}
	
	
	public List<Manifest> getCargo() {
		return cargo;
	}
	
	public void capacityCheck () { //questionable
		if (this.getCapacity() > 1000) {
			System.out.print("Overload!"); //throw exception
		}
	}
	
}
