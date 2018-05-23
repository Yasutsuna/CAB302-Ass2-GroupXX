package project;

import java.util.List;

public class Stock2 {

	int qty;
	int salesQty;
	double salesPrice;
	int reorderP;
	double orderCost;
	int orderAmount;
	
	
	public Stock2(double capital, List<Store> storeList, List<Item> itemList, List<Sales> salesList) {
		// TODO Auto-generated constructor stub
		for(Store st : storeList) {
			qty = st.getQuantity();
			reorderP = st.getReorder();
			orderCost = st.getCost();
			orderAmount = st.getAmount();
			for(Sales sa : salesList) {
				salesQty = sa.getQty();
				if(st.getName().equals(sa.getName())){
					qty -= salesQty;
					capital += salesPrice*salesQty;
					System.out.print("Current banlance: " +capital+"\n");
					if(qty <= reorderP) {
						if(capital > 0) {
							qty += orderAmount;
							capital -= orderAmount*orderCost;
							System.out.println(sa.getName() + "bought!");
						}else {
							System.out.println("No Enought Capital");
						}
					}else {
						System.out.println(sa.getName() + "Continues");
					}
				}
			}
		}
	}
}


