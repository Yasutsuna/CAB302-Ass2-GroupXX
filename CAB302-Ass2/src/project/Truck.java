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
	
	//public void putItems(Item item, int quantity) throws DeliveryException {
	public abstract void putItems(List<Store> storeList); //{
		/*for(Store s : storeList) {
			name = s.getName();
			qty = s.getQuantity();
			cost = s.getCost();
		}
		if ( qty > spaceUsed()) {	
			//throw new DeliveryException();
		}*/
	//}
}

/*
Truck logic:
Saperate temperature items
if itemDetail(5) == 1 { put into ordinary truck }

else {put into cold truck coldTruckCargo}

	Arrays.sort(cold truck cargo);}
	
	m=0;
	for (int i = 0; i < array.length; i++}
		if (cargo[m] + array[i] < 1000) {
			put array[i] in cargo[m];
			
	else {
			placeLeft = 1000 - cargo[m];
			
			m++;
			put in cargo[m];
			put array[i] in cargo[m];

	
	k=0;
	for (int i = 0; i < array.length; i++) {
		if (cargo[k] + array[i] < 800) {
			put array [i] in cargo[k];
			
	else 
			k++
			put in cargo[k];
			put array[i] in cargo[k];

*/

//Other truck shit
	/*private double cost; //price * quantity

	private String name;
	private int quantity;
	private double price;
	private int temperature;
	
	public int capacity;
	public int space;;
	
	private List<Sales> dryGoods;
	private List<Sales> wetGoods;
	 
	//cant work like this cant instintate 
	public Truck (String name, int quantity, double price, int temperature) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.temperature = temperature;
		
		//if (this.temperature == 0) {
			//how to put in dryGoods? run Ordinary Truck?
		//}
	}
	
	
	public double getCost() {
		cost = price * quantity;
		return cost;
	}
	
	public int getCapacity() {
		capacity = space;
		return capacity;
	}
	
	public int getTemperature() {
		return temperature;
	}
	
	public int getUsedSpace() {
		space = space + quantity;
		return space;
	}*/