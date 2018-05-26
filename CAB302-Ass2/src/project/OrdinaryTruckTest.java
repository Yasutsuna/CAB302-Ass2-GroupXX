package project;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class OrdinaryTruckTest {
	
	
	@Test
	public void testSpaceUsed() {
		OrdinaryTruck truck = new OrdinaryTruck("tomatoes", 100, 2, 10);
		//spaceUsing in OrdinaryTruck = 0;
		//quantity gotten from above
		
		int result = truck.spaceUsed();
		assertEquals(100, result);
	}
	
	@Test
	public void testSpaceAvailable() {
		OrdinaryTruck truck = new OrdinaryTruck("tomatoes", 100, 2, 10);
		//spaceUsing in OrdinaryTruck = 0;
		//capacity in OrdinaryTruck = 1000;
		
		int result2 = truck.spaceAvailable();
		assertEquals(1000, result2);
	}
	
	
	
	
	//Need to test putItems
}
