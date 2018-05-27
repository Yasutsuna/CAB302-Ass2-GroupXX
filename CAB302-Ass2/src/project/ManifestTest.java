package project;

import static org.junit.Assert.*;

import org.junit.Test;


public class ManifestTest {
	Manifest manifest =  new Manifest("tomatoes", 100, 2, 10);
	
	String name = "tomatoes";
	int qty = 100;
	double cost = 2;
	int temp = 10;
	
	@Test
	public void testGetName() {
		assertEquals(manifest.getName(), name);
	}
	
	@Test
	public void testGetCost() {
		assertEquals(manifest.getCost(), cost, 0);
	}
	
	@Test
	public void testGetQty() {
		assertEquals(manifest.getQty(), qty);
	}
	
	@Test
	public void testGetTemp() {
		assertEquals(manifest.temp(), temp);
	}
	
	//callTruck test

}
