package project;

import java.util.List;

public abstract class Truck {
	private int temp;
	private double cost;
	private int capacity;
	private List<String> cargo;
	
	public Truck (int temp, int capacity) {
		this.temp = temp;
		this.capacity = capacity;
	}
	
	public int getTemp() {
		return temp;
	}
	
	public int getCapacity() {
		return capacity;
	}
	

}
