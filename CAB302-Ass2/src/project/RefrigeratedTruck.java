package project;

import java.util.List;

public abstract class RefrigeratedTruck extends Truck{
	
	private List<Manifest> cargo;
	private int temperature;
	private double costWithTruck;
	//cargo
	
	public RefrigeratedTruck (int cost, int capacity, int temperature, List<Manifest> cargo) {
		super(cost, capacity);
		this.cargo = cargo;
		this.temperature = temperature;
	}
	
	public double getCostColdTruck() {
		costWithTruck = 900 + 200 * Math.pow(0.7,(double)temperature/5);
		return costWithTruck;
	}
	
	public int getTemperature() {
		return temperature;
	}
	
	public List<Manifest> getCargo() {
		return cargo;
	}
	
	public void capacityCheck () { //questionable
		if (this.getCapacity() > 800) {
			System.out.print("Overload!"); //throw exception
		}
	}
}

