package project;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrdinaryTruckTest2 {

	@Test 
	public void testGetTruckCost() {
		OrdinaryTruck truck = new OrdinaryTruck("tomatoes", 100, 2, 10);
		
		double result3 = truck.getTruckCost();
		assertEquals(775, result3, 0);
		
	//Note: Requires to be run in a saperate test file as it calls get spaceUsed method
	// If used in the same file as the other two test files, will result in them being called
	//twice, thus resulting being unable to test the othe two test cases properly.
	} 

}
