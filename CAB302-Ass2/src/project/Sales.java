package project;

/**
 * 
 * @author Zhi Choon Ng
 *
 */
public class Sales {

	private String name;
	private int qty;
	private double cost;

	/**
	 * Used to set the details for Sales and add it back into the GUI (Check this) after
	 * getting it from sales_log_X.csv
	 * 
	 * @param name - Name of the item ([name] of sales_log_X.csv)
	 * @param qty - Quantity of the item ([quantity] of sales_log_X.csv)
	 * @param cost - Cost of the item, pulled by matching the name from sales_log_X.csv
	 * 				to the details of the item stored in the Store.
	 */
	public Sales(String name, int qty, double cost) {
		this.name = name;
		this.qty = qty;
		this.cost = cost;
	}
	
	/**
	 * Used to get the Name of the Item after setting it above
	 * @return the Name of the current Item
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Used to get the Quantity of the Item after setting it above
	 * @return the quantity of the current Item
	 */
	public int getQty() {
		return qty;
	}
	
	/**
	 * Used to get the Cost of the Item after setting it above
	 * @return the cost of the current Item
	 */
	public double getCost() {
		return cost;
	}
}
