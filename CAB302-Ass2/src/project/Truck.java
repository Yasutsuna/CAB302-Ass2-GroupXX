package project;

import java.util.ArrayList;

public abstract class Truck{
	
	int qty;
	double cost;
	String name;
	int temp;
	
	/**
	 * Sets the details when Truck is called
	 * @param name - The Name of the item
	 * @param qty - The quantity of the item
	 * @param cost - The cost of the item
	 * @param temp - The temp of the item
	 */
	public Truck(String name, int qty, double cost, int temp) {
		this.name = name;
		this.cost = cost;
		this.qty = qty;
		this.temp = temp;
	}
	
	/**
	 * Gets the name after it is set from above
	 * @return The name that is set previously
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the cost after it is set from above
	 * @return The cost that is set previously
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Gets the quantity after it is set from above
	 * @return The quantity that is set previously
	 */
	public int getQty() {
		return qty;
	}
	
	/**
	 * Gets the temperature after it is set from above
	 * @return The temperature that is set previously
	 */
	public int temp() {
		return temp;
	}
	
	/**
	 * To put items into the truck, overridden in Orignal Truck or Refrigerated Truck
	 * @throws DeliveryException throws exception if putItems failed (Done if original or refrigerated truck)
	 */
	public abstract void putItems() throws DeliveryException;
	
	/**
	 * To calculate the space used of the truck, overridden in Orignal Truck or Refrigerated Truck
	 * @return depending on which truck, returns the amount of space used.
	 */
	public abstract int spaceUsed();
	
	/**
	 * To calculate the space available into the truck, overridden in Orignal Truck or Refrigerated Truck
	 * @return depending on which truck, returns the amount of space available.
	 */
	public abstract int spaceAvailable();
	
	/**
	 * To calculate the truck cost, overridden in Orignal Truck or Refrigerated Truck
	 * @return depending on which truck, returns the cost of the truck.
	 */
	public abstract double getTruckCost();
	
	/**
	 * To get the truck list, overridden in Orignal Truck or Refrigerated Truck
	 * @return depending on which truck, returns the list of trucks.
	 */
	public abstract ArrayList<Object> getTrucklist();
}