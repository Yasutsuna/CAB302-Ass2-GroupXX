package project;

import java.util.List;

public class Stock {

	int qty;
	int salesQty;
	double salesPrice;
	int reorderP;
	double orderCost;
	int orderAmount;
	private double capital;
	private List<Store> storeList;
	private List<Sales> salesList;
	
	
	public Stock(double capital, List<Store> storeList, List<Sales> salesList) {
		this.capital = capital;
		this.storeList = storeList;
		this.salesList = salesList;
		// TODO Auto-generated constructor stub
		storeManage();
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
		boolean check = false;
		for(Store st : storeList) {
			qty = st.getQuantity();
			reorderP = st.getReorder();
			orderCost = st.getCost();
			orderAmount = st.getAmount();
			salesPrice = st.getPrice();
			for(Sales sa : salesList) {
				salesQty = sa.getQty();
				if(check == false) {
					if(st.getName().equals(sa.getName())){
						qty -= salesQty;
						capital += salesPrice*salesQty;
						System.out.print("Current banlance: " +capital+"\n");
					
						if(qty <= reorderP) {
							if(!(capital <= 0)) {
								qty += orderAmount;
								capital -= orderAmount*orderCost;
								System.out.println(sa.getName() + " bought!");
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
		}
	}
}