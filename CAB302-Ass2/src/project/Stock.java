package project;

import java.util.List;

public class Stock {
	private List<Manifest> storeInventory;
	private List<String> stockOrders;
	private List<String> salesLogs;
	private List<String> truckCargo;
	
	private String[] name;
	private int[] quantity;
	
	
	public Stock(String[] name, int[] quantity) {	
		this.name = name;
		this.quantity = quantity;
	}
	
	//how to know what goes where?
	public String[] getName (){
		return name;
	}
	
	public int[] getQuantity() {
		return quantity;
	}
	
	
	//maybe store it at GUI? then bring it forward
}


