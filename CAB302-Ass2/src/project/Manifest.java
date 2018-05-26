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
	/**
	 * Used to set the details when Manifest is called
	 * 
	 * @param name - The name of the item
	 * @param qty - The quantity of the item
	 * @param cost - The cost of the item
	 * @param temp - The temperature of the item
	 */
	public Manifest(String name, int qty, double cost, int temp) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.cost = cost;
		this.qty = qty;
		this.temp = temp;
		callTruck();
	}
	
	/**
	 * Used to get the name from above
	 * @return the name which has been set above
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Used to get the cost from above
	 * @return the cost which has been set above
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Used to get the quantity from above
	 * @return the quantity which has been set above
	 */
	public int getQty() {
		return qty;
	}
	
	/**
	 * Used to get the temperature from above
	 * @return the temperature which has been set above
	 */
	public int temp() {
		return temp;
	}
	
	/**
	 * chooses which truck to be used. Once chose, the items are placed inside.
	 */
	private void callTruck() {
		if(temp == 0) {
			truck = new OrdinaryTruck(name,qty,cost,temp);
		}else {
			truck = new RefrigeratedTruck(name,qty,cost,temp);
		}
		try {
			truck.putItems();
		} catch (DeliveryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
