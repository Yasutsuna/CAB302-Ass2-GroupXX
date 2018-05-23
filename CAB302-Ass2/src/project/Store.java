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
	private double total = 100000;
	
	//private Item properties;
	//private String[] foo = {"rice", "biscuits"}; //test 
	
	public Store(String name, double cost, double price,int reorder, int amount, int temp, double total) { //name is name, inventory is quantity
		this.name = name;
		this.cost = cost;
		this.price = price;
		this.reorder = reorder;
		this.amount = amount;
		this.temp = temp;
		this.total = total;
		//this.properties = properties;
		//if you want to use, remember to use name[1] and quantity[1]
	}
	
	public Store getInstance() {
		if (instance == null) {
			instance = new Store(name, cost, price, reorder, amount, temp, total);
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
		calculate();
		return total;
	}
	
	public void calculate() {
		quantity = amount;
		total -= cost * quantity;
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