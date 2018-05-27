
package project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author Jeffrey
 *
 */
public class SalesTest {

	Sales sales;
	List<Sales> salesList = new ArrayList<Sales>();
	
	String name;
	int qty;
	double cost;
	
	/**
	 * Initialize a dummy sales list to be used
	 */
	public void initialized() {
		sales = new Sales("tomatoes",Integer.parseInt("100"), Double.parseDouble("2"));
       	salesList.add(sales);
       	for (Sales st : salesList) {
       		name = st.getName();
       		cost = st.getCost();
       		qty = st.getQty();
       	}
	}
	
	/**
	 * test the get name fuction
	 */
	@Test
	public void testGetName() {
		String testName = null;
		
		initialized();
		
		sales = new Sales ("tomatoes", 100 ,2);
		salesList.add(sales);
		
		for (Sales st : salesList) {
			testName = st.getName();
		}
		
		assertEquals(testName,name);
		
	}
	
	/**
	 * test the get quantity function
	 */
	@Test
	public void testGetQty() {
		int testQty = 0;
		
		initialized();
		
		sales = new Sales ("tomatoes", 100 ,2);
		salesList.add(sales);
		
		for (Sales st : salesList) {
			testQty = st.getQty();
		}
		
		assertEquals(testQty,qty);
	}
	
	/**
	 * test the get cost function
	 */
	@Test
	public void testGetCost() {
		double testCost = 0;
		
		initialized();
		
		sales = new Sales ("tomatoes", 100 ,2);
		salesList.add(sales);
		
		for (Sales st : salesList) {
			testCost = st.getCost();
		}
		
		assertEquals(testCost,cost,0);
	}

}
