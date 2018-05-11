package project;

import java.util.List;

public class Store {
	private static Store instance = null; 
	private double capital;
	private int name;
	private List<String> inventory;
	
	protected Store(double capital, int name, List<String> inventory) {
		this.capital = capital;
		this.name = name;
		this.inventory = inventory;
		
	}
	
	public Store getInstance() {
		if (instance == null) {
			instance = new Store(capital, name, inventory); 
		}
		
		return instance;
	}
	
	public int getName() {
		return name;
	}
	
	public double getCapital() {
		return capital;
	}
	
	public List<String> getInventory() {
		return inventory;
	}
	
}