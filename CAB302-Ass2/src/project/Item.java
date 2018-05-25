package project;

/**
 * Get the details of the item using polymorephism
 * @author Zhi Choon Ng
 *
 */
public class Item {
	private String name;
	private double cost;
	private double price;
	private int reorder; //Check this
	private int amount;
	private int temp; //Not all need this
	
	/**
	 * Used to set the details of the item from item_properties.csv, when it doesn't have a temperature
	 * 
	 * @param name - Name of the item ([name] of item_properties.csv)
	 * @param cost - Cost of the item ([cost] of item_properties.csv)
	 * @param price - Price of the item ([price] of item_properties.csv)
	 * @param reorder - Reorder point of the item ([reorder point] of item_properties.csv)
	 * @param amount - Reorder amount of the item ([reorder amount] of item_properties.csv)
	 */
	public Item(String name,double cost, double price, int reorder, int amount) {
		this.name = name;
		this.cost = cost;
		this.price = price;
		this.reorder = reorder;
		this.amount = amount;
	}
	
	/**
	 * Used to set the details of the item from item_properties.csv when it have a temperature
	 * 
	 * @param name2 - Name of the item ([name] of item_properties.csv)
	 * @param cost2 - cost of the item ([cost] of item_properties.csv)
	 * @param price2 - price of the item ([price] of item_properties.csv)
	 * @param reorder2 - reorder point of the item ([reorder point] of item_properties.csv)
	 * @param amount2 - reorder amount of the item ([reorder amount] of item_properties.csv)
	 * @param temp2 - temperature of the item ([temperature] of item_properties.csv)
	 */
	public Item(String name2, double cost2, double price2, int reorder2, int amount2, int temp) {
		// TODO Auto-generated constructor stub
		this.name = name2;
		this.cost = cost2;
		this.price = price2;
		this.reorder = reorder2;
		this.amount = amount2;
		this.temp = temp;
	}
	
	/**
	 * Used to get the Name of the Item after setting it above
	 * @return the Name of the current Item
	 */
	public String getName () {
		return name;
	}
	
	/**
	 * Used to get the cost of the Item after setting it above
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
}


