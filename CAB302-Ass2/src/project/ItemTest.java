package project;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Jeffrey
 *
 */
public class ItemTest {
	
	/**
	 * Test if the item can be inserted
	 */
	@Test
	public void itemTest() {
		String data="mushroom, 2, 4, 200, 325, 10";
		try {
			Item item = new Item("mushroom", 2, 4, 200, 325, 10);
		} catch (Exception e) {
			fail("Failed @ itemTest w/ temp");
		}
		
		//Test without temperature
		String data2="mushroom, 2, 4, 200, 325";
		try {
			Item item = new Item("mushroom", 2, 4, 200, 325);
		} catch (Exception e) {
			fail("Failed @ itemTest w/o temp");
		}
		
	}
	
	//private static Random random = new Random();
	private static String name = new String ("mushroom");
	private static double cost = 100;
	private static double price = 500;
	private static int reorderPoint = 600;
	private static int reorderAmount = 700;
	private static int temperature = -10;
	
	Item item;
	
	/**
	 * Test the get item name fuction
	 */
	@Test
	public void getItemNameTest() {
		String testName = name;
		item = new Item("mushroom", 2, 4, 200, 325, 10);
		assertEquals(item.getName(), testName);
	}
	
	/**
	 * Test the get item cost function
	 */
	@Test
	public void getItemCostTest() {
		double testCost = cost;
		item = new Item("mushroom", 100, 4, 200, 325, 10);
		assertEquals(item.getCost(), testCost, 0.01);
	}
	
	/**
	 * Test the get item price function
	 */
	@Test
	public void getItemPriceTest() {
		double testPrice = price;
		item = new Item("mushroom", 2, 500, 200, 325, 10);
		assertEquals(item.getPrice(), testPrice,0.01);
	}
	
	/**
	 * Test the get reorder point function
	 */
	@Test
	public void getItemReorderPointTest() {
		int testReorderPoint = reorderPoint;
		item = new Item("mushroom", 2, 4, 600, 325, 10);
		assertEquals(item.getReorder(), testReorderPoint);
	}
	
	/**
	 * Test the get item reorder amount function
	 */
	@Test
	public void getItemReorderAmountTest() {
		int testReorderAmount = reorderAmount;
		item = new Item("mushroom", 2, 4, 200, 700, 10);
		assertEquals(item.getAmount(), testReorderAmount);
	}
	
	/**
	 * Test the get item temperataure function
	 */
	@Test
	public void getItemTemperatureTest() {
		int testTemperature = temperature;
		item = new Item("mushroom", 2, 4, 200, 325, -10);
		assertEquals(item.getTemp(), testTemperature);
	}
}


