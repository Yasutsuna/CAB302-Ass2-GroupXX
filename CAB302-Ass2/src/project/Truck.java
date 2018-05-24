package project;

import java.util.ArrayList;
import java.util.List;

public abstract class Truck{
	
	List<Truck> truckList = new ArrayList<Truck>();
	int qty;
	double cost;
	String name;
	
	
	public abstract double getCost();
	
	public abstract int spaceUsed();
	
	public abstract int spaceAvailable();
	
	public abstract void putItems(List<Store> storeList);
}