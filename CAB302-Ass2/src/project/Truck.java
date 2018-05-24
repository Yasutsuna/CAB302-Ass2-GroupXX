package project;

import java.util.ArrayList;
import java.util.List;

public abstract class Truck{
	
	List<Truck> truckList = new ArrayList<Truck>();
	int qty;
	double cost;
	String name;
	
	public abstract void putItems(List<Store> storeList);
	
	public abstract int spaceUsed();
	
	public abstract int spaceAvailable();
	
	public abstract int getName();
	
	public abstract int getQuantity();
	
	public abstract double getCost();
}