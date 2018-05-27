package project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StockTestCase {

	//Variables copied from Stock.java
	int qty;
	//int salesQty;
	double salesPrice;
	int reorderP;
	double orderCost;
	int orderAmount;
	
	List<Store> storeList = new ArrayList<Store>();
	List<Store> storeTest = new ArrayList<Store>();
	Store store;
	Stock stock;
	
	public void initializedStore() {
		store = new Store("tomatoes",Integer.parseInt("0"), Double.parseDouble("1"),
					Double.parseDouble("2"),Integer.parseInt("325"),
					Integer.parseInt("400"),Integer.parseInt("10"));
       	storeList.add(store);
       	for (Store st : storeList) {
       		qty = st.getQuantity();
			reorderP = st.getReorder();
			orderCost = st.getCost();
			orderAmount = st.getAmount();
			salesPrice = st.getPrice();
       	}
		//System.out.println(store);
	}
	
	
	String nameSa;
	int qtySa;
	double costSa;
	
	Sales sales;
	List<Sales> salesList = new ArrayList<Sales>();
	List<Sales> salesTest = new ArrayList<Sales>();
	
	public void initializedSales() {
		sales = new Sales("tomatoes",Integer.parseInt("100"), Double.parseDouble("20"));
		salesList.add(sales);
		for (Sales sa : salesList) {
			nameSa = sa.getName();
			qtySa = sa.getQty();
			costSa = sa.getCost();
		}
	}
	
	
	
	@Test
	public void testGetStoreList() {
		int qtyTest = 0;
		//int salesQtyTest;
		double salesPriceTest = 0;
		int reorderPTest = 0;
		double orderCostTest = 0;
		int orderAmountTest = 0;
		
		initializedStore();
		
		store = new Store("tomatoes", 0, 1, 2, 325, 400, 10);
		storeTest.add(store);
		for (Store st : storeTest) {
       		qtyTest = st.getQuantity();
			reorderPTest = st.getReorder();
			orderCostTest = st.getCost();
			orderAmountTest = st.getAmount();
			salesPriceTest = st.getPrice();
       	}
		
		assertEquals(qty, qtyTest);
		assertEquals(reorderP, reorderPTest);
		assertEquals(orderCost, orderCostTest, 0);
		assertEquals(orderAmount, orderAmountTest);
		assertEquals(salesPrice, salesPriceTest, 0);
	}
	
	@Test
	public void testGetSalesList() {
		String nameSaTest = null;
		int qtySaTest = 0;
		double costSaTest = 0;
		
		initializedSales();
		
		sales = new Sales("tomatoes", 100, 20);
		salesTest.add(sales);
		for (Sales sa : salesTest) {
			nameSaTest = sa.getName();
			qtySaTest = sa.getQty();
			costSaTest = sa.getCost();
		}
		
		assertEquals(nameSa, nameSaTest);
		assertEquals(qtySa, qtySaTest);
		assertEquals(costSa, costSaTest, 0);
	}
	
	@Test
	public void testGetCapital() {
		double testCapital = 300000;
		stock = new Stock (300000, storeList, salesList);
		assertEquals(testCapital, stock.getCapital(), 0);
	}

	@Test
	public void testStoreManager() {
		double capital = 1000;
		
		int qtyTest2;
		int salesQtyTest2;
		double salesPriceTest2;
		int reorderPTest2;
		double orderCostTest2;
		int orderAmountTest2;
		
		initializedStore();
		initializedSales();
		
		//Copied over since private function??
		boolean check = false;
		for(Store st : storeList) {
			qtyTest2 = st.getQuantity();
			reorderPTest2 = st.getReorder();
			orderCostTest2 = st.getCost();
			orderAmountTest2 = st.getAmount();
			salesPriceTest2 = st.getPrice();
			for(Sales sa : salesList) {
				salesQtyTest2 = sa.getQty();
				if(check == false) {
					if(st.getName().equals(sa.getName())){
						qtyTest2 -= salesQtyTest2;
						capital += salesPriceTest2*salesQtyTest2;
						//System.out.print("Current banlance: " +capital+"\n");
					
						if(qtyTest2 <= reorderPTest2) {
							if(!(capital <= 0)) {
								qtyTest2 += orderAmountTest2;
								capital -= orderAmountTest2*orderCostTest2;
							}else {
								check = true;
							}
						}else {
							
						}
					}
				}
			}
		}
		
		assertEquals(capital, 800, 0);
	}
	
	//check if the getNames are used or not.
	
}
