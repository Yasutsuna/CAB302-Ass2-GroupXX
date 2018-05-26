package project;

/**
 * 
 * @author Zhi Choon Ng
 *
 */
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
	
	/**
	 * Used to store the item properties after bringing it from readFile function
	 * 
	 * @param name - Name of the item 
	 * @param cost - Cost of the item 
	 * @param price - Price of the item 
	 * @param reorder - Reorder of the item 
	 * @param amount - Amount of the item 
	 * @param temp - Temperature of the item 
	 * @param quantity - Quantity of the item
	 */
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
	
	/**
	 * get the singleton instance.
	 * 
	 * @return a 'static' instance of the Store.
	 */
	public Store getInstance() {
		if (instance == null) {
			instance = new Store(name, quantity, cost, price, reorder, amount, temp);
		}
		return instance;
		
	}
	
	/**
	 * Used to get the Name of the Item after setting it above
	 * @return the Name of the current Item
	 */
	public String getName () {
		return name;
	}
	
	/**
	 * Used to get the Quantity of the Item after setting it above
	 * @return the Quantity of the current Item
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Used to get the Cost of the Item after setting it above
	 * @return the cost of the current Item
	 */
	public double getCost () {
		return cost;
	}
	
	/**
	 * Used to get the price of the Item after setting it above
	 * @return the price of the current Item
	 */
	public double getPrice () {
		return price;
	}
	
	/**
	 * Used to get the reorder point of the Item after setting it above
	 * @return the reorder point of the current Item
	 */
	public int getReorder () {
		return reorder;
	}
	
	/**
	 * Used to get the reorder amount of the Item after setting it above
	 * @return the reorder amount of the current Item
	 */
	public int getAmount () {
		return amount;
	}
	
	/**
	 * Used to get the temperature of the Item after setting it above
	 * @return the temperature of the current Item
	 */
	public int getTemp () {
		return temp;
	}
	
	/**
	 * Used to get the balance of the Item
	 * @return the balance
	 */
	public double getTotal() {
		return total;
	}
	
	/**
	 * Used to get the temperature of the Item after setting it above
	 */
	public void calculate() {
		if(quantity == 0) {
			quantity = amount;
		}
			total -= cost * quantity;
	}
}