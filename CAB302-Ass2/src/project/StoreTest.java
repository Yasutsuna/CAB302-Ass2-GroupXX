package project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StoreTest {

	int qty;
	double salesPrice;
	int reorderP;
	double orderCost;
	int orderAmount;
	String name;
	int temp;
	
	List<Store> storeList = new ArrayList<Store>();
	List<Store> storeTest = new ArrayList<Store>();
	Store store;
	
	/**
	 * Initialize store to be used
	 */
	public void initializedStore() {
		store = new Store("tomatoes",Integer.parseInt("0"), Double.parseDouble("1"),
					Double.parseDouble("2"),Integer.parseInt("325"),
					Integer.parseInt("400"),Integer.parseInt("10"));
       	storeList.add(store);
       	for (Store st : storeList) {
       		name = st.getName();
       		temp = st.getTemp();
       		qty = st.getQuantity();
			reorderP = st.getReorder();
			orderCost = st.getCost();
			orderAmount = st.getAmount();
			salesPrice = st.getPrice();
       	}
	}
	
	/**
	 * Test get name function
	 */
	@Test
	public void testGetName() {
		String testName = null;
		
		initializedStore();
		
		store = new Store("tomatoes", 0, 1, 2, 325, 400, 10);
		storeTest.add(store);
		
		for (Store st : storeTest) {
			testName = st.getName();
		}
		
		assertEquals(testName, name);
	}
	
	/**
	 * Test the get quantity function
	 */
	@Test
	public void testGetQuantity() {
		int testQuantity = 0;
		
		initializedStore();
		
		store = new Store("tomatoes", 0, 1, 2, 325, 400, 10);
		storeTest.add(store);
		
		for (Store st : storeTest) {
			testQuantity = st.getQuantity();
		}
		
		assertEquals(testQuantity, qty);
	}
	
	/**
	 * Test the get reorder amount function
	 */
	@Test
	public void testReorderAmount() {
		int testReorder = 0;
		
		initializedStore();
		
		store = new Store("tomatoes", 0, 1, 2, 325, 400, 10);
		storeTest.add(store);
		
		for (Store st : storeTest) {
			testReorder = st.getReorder();
		}
		
		assertEquals(testReorder, reorderP);
	}
	
	/**
	 * Test the get temperature function
	 */
	@Test
	public void testTemperature() {
		int testTemp = 0;
		
		initializedStore();
		
		store = new Store("tomatoes", 0, 1, 2, 325, 400, 10);
		storeTest.add(store);
		
		for (Store st : storeTest) {
			testTemp = st.getTemp();
		}
		
		assertEquals(testTemp, temp);
	}
	
	/**
	 * Test the get cost function
	 */
	@Test
	public void testCost() {
		double testCost = 0;
		
		initializedStore();
		
		store = new Store("tomatoes", 0, 1, 2, 325, 400, 10);
		storeTest.add(store);
		
		for (Store st : storeTest) {
			testCost = st.getCost();
		}
		
		assertEquals(testCost, orderCost, 0);
	}
	
	/**
	 * Test the get price function
	 */
	@Test
	public void testPrice() {
		double testPrice = 0;
		
		initializedStore();
		
		store = new Store("tomatoes", 0, 1, 2, 325, 400, 10);
		storeTest.add(store);
		
		for (Store st : storeTest) {
			testPrice = st.getPrice();
		}
		
		assertEquals(testPrice, salesPrice, 0);
	}
	
	/**
	 * Test the get amount function
	 */
	@Test
	public void testAmount() {
		double testAmount = 0;
		
		initializedStore();
		
		store = new Store("tomatoes", 0, 1, 2, 325, 400, 10);
		storeTest.add(store);
		
		for (Store st : storeTest) {
			testAmount = st.getAmount();
		}
		
		assertEquals(testAmount, orderAmount, 0);
	}
	
	/**
	 * Test the calculate function
	 */
	@Test
	public void testCalculate() {
		double cost = 200;
		int quantity = 3;
		double total = 1000;
		int amount = 5;
		
		
		if(quantity == 0) {
			quantity = amount;
		}
			total -= cost * quantity;
	
		assertEquals(total, 400, 0);
	}

}
