package project;

import java.util.List;

public class OrdinaryTruck extends Truck{
	
	private double costWithTruck;
	private int capacity = 1000;
	private int spaceUsing = 0;
	
	public OrdinaryTruck() {
		super();
	}
	
	@Override
	public void putItems(List<Store> storeList) {
		// TODO Auto-generated method stub
		for(Store s : storeList) {
			spaceUsing += s.getQuantity();
		}
	}
	
	@Override
	public double getCost() {
		costWithTruck = Math.round(750 + (0.25 * spaceUsed()));
		return costWithTruck;
	}

	@Override
	public int spaceUsed() {
		// TODO Auto-generated method stub
		return spaceUsing;
	}

	@Override
	public int spaceAvailable() {
		// TODO Auto-generated method stub
		return capacity;
	}

	@Override
	public int getName() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}
}
