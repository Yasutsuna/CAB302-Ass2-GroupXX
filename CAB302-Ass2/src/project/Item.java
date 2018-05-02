package project;

public class Item {
	private String name;
	private double price;
	private int reorder; //Check this
	private int amount;
	private int temp = 1; //Not all need this
	
	public Item(String name, double price, int reorder, int amount, int temp) {
		this.name = name;
		this.price = price;
		this.reorder = reorder;
		this.amount = amount;
		this.temp = temp;
	}
	
	public String getName () {
		return name;
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


