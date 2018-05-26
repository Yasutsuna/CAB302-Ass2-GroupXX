package project;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jeffrey
 *
 */
public class Stock {

	String name;
	int qty;
	double orderCost;
	double salesPrice;
	int reorderP;
	int orderAmount;
	int temp;
	int salesQty;
	private double capital;
	private List<Store> storeList;
	private List<Sales> salesList;
	public List<Store> newdataList = new ArrayList<Store>();
	
	/**Used to set the details on the items when used.
	 * 
	 * @param capital - The amount of capital
	 * @param storeList - The item properties from item_properties.csv
	 * @param salesList -  The item properties from sales_log_X.csv
	 */
	public Stock(double capital, List<Store> storeList, List<Sales> salesList) {
		this.capital = capital;
		this.storeList = storeList;
		this.salesList = salesList;
		// TODO Auto-generated constructor stub
		try {
			storeManage();
		} catch (StockException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Used to get the Name of the Item after setting it above
	 * @return the Name of the current Item
	 */
	public String getName () {
		return name;
	}
	
	/**
	 * Used to get the quantity of the Item after setting it above
	 * @return the quantity of the current Item
	 */
	public int getQuantity() {
		return qty;
	}
	
	/**
	 * Used to get the order cost of the Item after setting it above
	 * @return the order cost of the current Item
	 */
	public double getCost () {
		return orderCost;
	}
	
	/**
	 * Used to get the sales price of the Item after setting it above
	 * @return the sales price of the current Item
	 */
	public double getPrice () {
		return salesPrice;
	}
	
	/**
	 * Used to get the reorder point of the Item after setting it above
	 * @return the reorder point of the current Item
	 */
	public int getReorder () {
		return reorderP;
	}
	
	/**
	 * Used to get the order amount of the Item after setting it above
	 * @return the order amount of the current Item
	 */
	public int getAmount () {
		return orderAmount;
	}
	
	/**
	 * Used to get the temp of the Item after setting it above
	 * @return the temp of the current Item
	 */
	public int getTemp () {
		return temp;
	}
	
	/**
	 * Used to get the Store List after setting it above
	 * 
	 * @return the details of an item properties
	 */
	public List<Store> getStoreList(){
		return storeList;
	}
	
	/**
	 * Used to get the Sales list after setting it above
	 * 
	 * @return the details of an item in the Sales List
	 */
	public List<Sales> getSalesList(){
		return salesList;
	}
	
	/**
	 * Used to get the capital after setting it above
	 * 
	 * @return the capital of the store.
	 */
	public double getCapital(){
		return capital;
	}

	/**
	 * Used to get the capital after setting it above
	 * 
	 * @return the capital of the store.
	 */
	private void storeManage() throws StockException {
		// TODO Auto-generated method stub
		//checking the Balance enough or not
		boolean check = false;
		for(Store st : storeList) {
			name = st.getName();
			qty = st.getQuantity();
			reorderP = st.getReorder();
			orderCost = st.getCost();
			orderAmount = st.getAmount();
			salesPrice = st.getPrice();
			temp = st.getTemp();
			for(Sales sa : salesList) {
				salesQty = sa.getQty();
				if(check == false) {
					if(name.equals(sa.getName())){
						qty -= salesQty;
						capital += salesPrice*salesQty;
						if(qty <= reorderP) {
							if(!(capital <= 0)) {
								qty += orderAmount;
								capital -= orderAmount*orderCost;
								System.out.println(name + " bought!");
								System.out.println("name: " + name + " and " + qty + " left");
								//update();
							}else {
								check = true;
								System.out.println("No Enought Capital");
								throw new StockException();

							}
						}else {
							System.out.println(sa.getName() + " more than reorder Point so Continues");
						}
						System.out.print("Current banlance: " +capital+"\n");
					}
				}
			}
			update();
		}
	}
	
	public void update() {
		Store newdata = new Store(name,qty,orderCost,salesPrice,reorderP,orderAmount,temp);
		newdataList.add(newdata);
	}
	
}