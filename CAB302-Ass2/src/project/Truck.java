package project;

import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public abstract class Truck {
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
	
	ArrayList<Sales> cargo = new ArrayList<Sales>();
	public int capacity;
	Sales sales;
	
	public double getCost() {
		int cost = 0;
		for (Sales i : cargo) {
			cost = cost + i.getQty() * i.getPrice(); //drag the price shoud be fine.
			//cost = cost + i.getQty() * 3;
		}
		return cost;
	}
	
	public int spaceUsed() {
		int count = 0;
		for (Sales i : cargo) {
			count = i.getQty();
		}
		return count;
	}
	
	public int spaceAvailable() {
		return capacity - spaceUsed();
	}
	
	public void putItems(Item item, int quantity) {
		if (quantity > spaceUsed()) {
			
			//error overload
		}
		
		for (Sales i : cargo) {
		sales = new Sales (i.getName(), quantity); 
		//ArrayList<Sales> s???? = new ArrayList<Sales>(); //check this part
		cargo.add(sales); //check this part
		}
	}
	

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