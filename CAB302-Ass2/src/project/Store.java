package project;

public class Store {
	private static Store instance = null; 
	
	//private List<Manifest> manifest;
	private String name;
	private int quantity;
	private double cost;
	private double price;
	private int reorder;
	private int amount;
	private int temp;
	static double total = 100000;
	
	public Store(String name, int quantity, double cost, double price,int reorder, int amount, int temp) { //name is name, inventory is quantity
		this.name = name;
		this.quantity = quantity;
		this.cost = cost;
		this.price = price;
		this.reorder = reorder;
		this.amount = amount;
		this.temp = temp;
		calculate();
	}
	
	public Store getInstance() {
		if (instance == null) {
			instance = new Store(name, quantity, cost, price, reorder, amount, temp);
		}
		return instance;
		
	}
	
	public String getName () {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
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
	
	public double getTotal() {
		return total;
	}
	
	public void calculate() {
		if(quantity == 0) {
			quantity = amount;
		}
			total -= cost * quantity;
	}
}