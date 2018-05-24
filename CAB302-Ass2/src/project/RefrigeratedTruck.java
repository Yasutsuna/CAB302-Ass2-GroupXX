package project;

import java.util.List;

public class RefrigeratedTruck extends Truck{
	
	private int lowestTemp = 0;
	private double costWithTruck;
	private int capacity = 800;
	private int spaceUsing = 0;
	
	public RefrigeratedTruck() {
		super();
	}
	
	@Override
	public void putItems (List<Store> storeList) {
//	public void putItems (Item item, int quantity) throws DeliveryException {
		for(Store s : storeList) {
			spaceUsing += s.getQuantity();
			if (s.getTemp()!= 0) {
				if (lowestTemp == 0) { //if there is no set lowestTemp
					lowestTemp = s.getTemp();
				}else{
					if (lowestTemp > s.getTemp()) {
						lowestTemp = s.getTemp();
					}
				}
			}
		}
	}

	@Override
	public int spaceUsed() {
		// TODO Auto-generated method stub
		return spaceUsing;
	}

	@Override
	public int spaceAvailable() {
		// TODO Auto-generated method stub
		return capacity - spaceUsing;
	}
	
	@Override
	public double getCost() {
		costWithTruck = Math.round(900 + (200 * Math.pow(0.7, (double) lowestTemp/ 5)));
		return costWithTruck;
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
