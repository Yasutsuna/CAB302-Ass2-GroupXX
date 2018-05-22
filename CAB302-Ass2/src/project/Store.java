package project;

public class Store {
	private static Store instance = null; 
	
	//private List<Manifest> manifest;
	private String[] name;
	private int[] quantity;
	private double capital;
	
	protected Store(String[] name, int[] quantity, double capital) { //name is name, inventory is quantity
		this.name = name;
		this.quantity  = quantity;
		this.capital = capital;
		//if you want to use, remember to use name[1] and quantity[1]
		
	}

	
	
	public Store getInstance() {
		//if (instance == null) {
			
			instance = new Store(name, quantity, capital);
		
		return instance;
		//}
	}
	
	public String[] getName () {
		return name;
	}
	
	public int[] getQuantity() {
		return quantity;
	}
}