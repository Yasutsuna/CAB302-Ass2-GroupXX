package project;

public class Item {
	private String name;
	private double cost;
	private double price;
	private int reorder; //Check this
	private int amount;
	private int temp = 1; //Not all need this
	
	public Item(String name,double cost, double price, int reorder, int amount) {
		this.name = name;
		this.cost = cost;
		this.price = price;
		this.reorder = reorder;
		this.amount = amount;
		
	}
	
	public Item(String name2, double cost2, double price2, int reorder2, int amount2, int temp) {
		// TODO Auto-generated constructor stub
		this.name = name2;
		this.cost = cost2;
		this.price = price2;
		this.reorder = reorder2;
		this.amount = amount2;
		this.temp = temp;
	}
	
	public String getName () {
		return name;
	}
	
	public double getCost () {
		return cost;
	}
	
	public double getPrice () {
		return price;
	}
	
	public int getReorder () {
		return reorder;
	}
	
	public int getAmount () {
		return amount;
	}
	
	public int getTemp () {
		return temp;
	}
	
}


