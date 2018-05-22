package project;

import java.util.List;

public abstract class Truck {
	private double cost; //price * quantity

	private int capacity;

	
	public Truck (int cost, int capacity) {
		this.cost = cost;
		this.capacity = capacity;
	}
	
	public double getCost() {
		return cost;
	}
	
	public int getCapacity() {
		return capacity;
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