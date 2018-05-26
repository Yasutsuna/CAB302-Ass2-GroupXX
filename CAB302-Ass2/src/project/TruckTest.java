package project;

import static org.junit.Assert.*;

import org.junit.Test;

public class TruckTest {
	
	String name = "tomatoes";
	int qty = 100;
	double cost = 2;
	int temp = 10;
	Truck truck = new RefrigeratedTruck("tomatoes", 100, 2, 10);

	@Test
	public void testGetName() {
		assertEquals(truck.getName(), name);
	}
	
	@Test
	public void testQuantity() {
		assertEquals(truck.getQty(), qty);
	}
	
	@Test
	public void testCost() {
		assertEquals(truck.getCost(), cost, 0);
	}
	
	@Test
	public void testTemperature() {
		assertEquals(truck.temp(), temp);
	}


}
