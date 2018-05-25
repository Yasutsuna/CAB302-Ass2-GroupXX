package project;

import java.util.ArrayList;
import java.util.List;

public abstract class Truck{
	
	int qty;
	double cost;
	String name;
	int temp;
	
	public Truck(String name, int qty, double cost, int temp) {
		this.name = name;
		this.cost = cost;
		this.qty = qty;
		this.temp = temp;
	}
	
	public String getName() {
		return name;
	}
	
	public double getCost() {
		return cost;
	}
	
	public int getQty() {
		return qty;
	}
	
	public int temp() {
		return temp;
	}
	
	public abstract void putItems();
	
	public abstract int spaceUsed();
	
	public abstract int spaceAvailable();
	
	public abstract double getTruckCost();
	
	public abstract ArrayList<Object> getTrucklist();
}