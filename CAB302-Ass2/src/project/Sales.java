package project;

public class Sales {

	private String name;
	private int qty;

	public Sales(String name, int qty) {
		this.name = name;
		this.qty = qty;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQty() {
		return qty;
	}
}
