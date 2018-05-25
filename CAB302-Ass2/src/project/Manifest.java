package project;

public class Manifest {
	
	int temp=0;
	Truck truck;
	private String name;
	private double cost;
	private int qty;
	
/*	public Manifest(List<Store> newdataList) {
		//this.balance = balance;
		this.newdataList = newdataList;
		callTruck();
	}*/
	
	/*public List<Store> getStoreList() {
		return newdataList;
	}*/
	
	public Manifest(String name, int qty, double cost, int temp) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.cost = cost;
		this.qty = qty;
		this.temp = temp;
		callTruck();
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
	
	
	private void callTruck() {
		if(temp == 0) {
			truck = new OrdinaryTruck(name,qty,cost,temp);
		}else {
			truck = new RefrigeratedTruck(name,qty,cost,temp);
		}
		truck.putItems();		
	}
}
