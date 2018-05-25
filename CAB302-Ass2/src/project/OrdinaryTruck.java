package project;

import java.util.ArrayList;

public class OrdinaryTruck extends Truck{
	
	double costWithTruck;
	private int capacity = 1000;
	//private int itemleft = 0;
	private static int spaceUsing;
	ArrayList<Object> otruckList = new ArrayList<Object>();
	
	public OrdinaryTruck(String name, int qty, double cost, int temp) {
		super(name,qty,cost,temp);
	}
	
	@Override
	public void putItems() {
		// TODO Auto-generated method stub
//		if(spaceUsed() <= spaceAvailable()) {
//			this.otruckList.add(name);
//			this.otruckList.add(qty);
//		}else if(spaceUsed() > spaceAvailable()){
//			itemleft = spaceUsed() - capacity;
//			if(itemleft>capacity) {
//				List<Object> otruckList = new ArrayList<Object>();
				otruckList.add(name);
				otruckList.add(qty);
			//}
		//}
		System.out.println("This is Ordinary truck list : " + otruckList);
	}

	@Override
	public int spaceUsed() {
		// TODO Auto-generated method stub
		spaceUsing += qty;
		return spaceUsing;
	}

	@Override
	public int spaceAvailable() {
		// TODO Auto-generated method stub
		return capacity -= spaceUsing;
	}

	@Override
	public double getTruckCost() {
		// TODO Auto-generated method stub
		costWithTruck = Math.round(750 + (0.25 * spaceUsed()));
		return costWithTruck;
	}
	
	@Override
	public ArrayList<Object> getTrucklist(){
		return otruckList;
	}
}
