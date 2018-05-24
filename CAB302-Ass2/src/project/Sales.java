package project;

public class Sales {

	private String name;
	private int qty;
	private double cost;

	public Sales(String name, int qty, double cost) {
		this.name = name;
		this.qty = qty;
		this.cost = cost;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQty() {
		return qty;
	}
	
	public double getCost() {
		return cost;
	}
}
