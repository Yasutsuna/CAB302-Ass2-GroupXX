package project;

import java.util.List;

public abstract class Truck {
	private int temp;
	private double cost;
	private int capacity;
	private List<String> cargo;
	
	public Truck (int temp, int capacity, double cost, List<String> cargo) {
		this.temp = temp;
		this.capacity = capacity;
		this.cost = cost;
		this.cargo = cargo;
	}
	
	public int getTemp() {
		return temp;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public double getCost() {
		return cost;
	}
	
	public List<String> cargo() {
		return cargo;
	}
}
