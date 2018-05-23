package project;

public class Stock {
	private  int storeInventory; //current store
	private  int stockOrders; // reorder point
	private double salesLogs; //sales qty?price?
	private String truckCargo; //truck
	
	Item item;
	Store store;
	Sales sales;
	
	/*public Stock() {	
		classification();
	}*/
	
	public Stock(int storeInventory, int stockOrders , double salesLogs, String truckCargo) {	
		this.storeInventory = storeInventory;
		this.stockOrders = stockOrders;
		this.salesLogs = salesLogs;
		this.truckCargo = truckCargo;	
		//classification();
	}

	public void classification() {
		// TODO Auto-generated method stub
		System.out.println(storeInventory + stockOrders + salesLogs);
	}

	//how to know what goes where?
	public int getStoreInv(){
		return storeInventory;
	}
	
	public int getStockOrd() {
		return stockOrders;
	}
	
	public double getSalesLog() {
		return salesLogs;
	}
	
	public String getTruckCargo() {
		return truckCargo;
	}
}


