package project;

import static org.junit.Assert.*;

import org.junit.Test;

public class RefrigeratedTruckTest {

	@Test
	public void testSpaceUsed() {
		RefrigeratedTruck truck = new RefrigeratedTruck("tomatoes", 100, 2, 10);
		//spaceUsing in OrdinaryTruck = 0;
		//quantity gotten from above
		
		int result = truck.spaceUsed();
		assertEquals(100, result);
	}
	
	@Test
	public void testSpaceAvailable() {
		RefrigeratedTruck truck = new RefrigeratedTruck("tomatoes", 100, 2, 10);
		//spaceUsing in RefrigeratedTruck = 0;
		//capacity in RefrigeratedTruck = 800;
		
		int result2 = truck.spaceAvailable();
		assertEquals(800, result2);
	}
	
	@Test
	public void testTruckCost() {
		RefrigeratedTruck truck = new RefrigeratedTruck("tomatoes", 100, 2, 10);
		
		double result3 = truck.getTruckCost();
		assertEquals(998, result3, 0);
	}
	

}
