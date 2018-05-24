package project;

import java.util.ArrayList;
import java.util.List;

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
	
	
	public Stock(double capital, List<Store> storeList, List<Sales> salesList) {
		this.capital = capital;
		this.storeList = storeList;
		this.salesList = salesList;
		// TODO Auto-generated constructor stub
		storeManage();
	}

	public String getName () {
		return name;
	}
	
	public int getQuantity() {
		return qty;
	}
	
	public double getCost () {
		return orderCost;
	}
	
	public double getPrice () {
		return salesPrice;
	}
	
	public int getReorder () {
		return reorderP;
	}
	
	public int getAmount () {
		return orderAmount;
	}
	
	public int getTemp () {
		return temp;
	}
	
	public List<Store> getStoreList(){
		return storeList;
	}
	
	public List<Sales> getSalesList(){
		return salesList;
	}
	
	public double getCapital(){
		return capital;
	}


	private void storeManage() {
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
						System.out.print("Current banlance: " +capital+"\n");
					
						if(qty <= reorderP) {
							if(!(capital <= 0)) {
								qty += orderAmount;
								capital -= orderAmount*orderCost;
								System.out.println(name + " bought!");
								System.out.println("name: " + name + " and " + qty + " left");
								//update();
							}else {
								System.out.println("No Enought Capital");
								check = true;
							}
						}else {
							System.out.println(sa.getName() + " more than reorder Point so Continues");
						}
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