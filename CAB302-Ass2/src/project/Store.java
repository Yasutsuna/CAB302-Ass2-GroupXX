package project;

public class Store {
	private static Store instance = null; 
	
	//private List<Manifest> manifest;
	private String name;
	private int quantity;
	private double capital = 0;
	double price;
	
	//private Item properties;
	//private String[] foo = {"rice", "biscuits"}; //test 
	
	public Store(String name, int quantity, double price, double capital) { //name is name, inventory is quantity
		this.name = name;
		this.quantity  = quantity;
		this.price = price;
		this.capital = capital;
		//this.properties = properties;
		//if you want to use, remember to use name[1] and quantity[1]
	}
	
	public Store getInstance() {
		if (instance == null) {
			instance = new Store(name, quantity, price, capital);
		}
		return instance;
		
	}
	
	public String getName () {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getCapital() {
		calculate();
		return capital;
	}
	
	public void calculate() {
		capital = price * quantity;
	}
	
	/*public double capital () {
		//System.out.println(properties.getName().toString());
		//System.out.println(name[1]);
		//System.out.println(properties);
		
		for (int i = 0; i < 2; i++) {
		//	if (properties.getName().equals(name[i]) ) {
			if (properties.getName().equals(name[i]) ) {
				capital = capital - properties.getPrice();
				System.out.println("\n" + capital + "\n");
			}
			else {
				System.out.println("Boo!");
			}
	
		}
		return capital;
	*/
}