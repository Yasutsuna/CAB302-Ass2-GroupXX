package project;

import java.util.ArrayList;

public class RefrigeratedTruck extends Truck{
	
	//private int lowestTemp=0;;
	double costWithTruck;
	private int capacity = 800;
	//private int itemleft = 0;
	private static int spaceUsing;
	ArrayList<Object> rtruckList = new ArrayList<>();
	
	public RefrigeratedTruck (String name, int qty, double cost, int temp) {
		super(name,qty,cost,temp);
	}
	
	@Override
	public void putItems () {
//	public void putItems (Item item, int quantity) throws DeliveryException {
//		if (temp!= 0) {
//			if (lowestTemp == 0) { //if there is no set lowestTemp
//				lowestTemp = temp;
//			}else{
//				if (lowestTemp > temp) {
//					lowestTemp = temp;
//				}
//			}	
//		}
		
//		if(spaceUsed() <= spaceAvailable()) {
//			rtruckList.add(name);
//			rtruckList.add(qty);
//		}else if(spaceUsed() > spaceAvailable()){
//			itemleft = spaceUsed() - capacity;
//			if(itemleft>capacity) {
//					List<Object> otruckList = new ArrayList<Object>();
				rtruckList.add(name);
				rtruckList.add(qty);
//			}
//		}
			System.out.println("This is refrigerated truck list : " + rtruckList);
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
		costWithTruck = Math.round(900 + 200 * (Math.pow(0.7, (double) temp/ 5)));
		return costWithTruck;
	}
	
	@Override
	public ArrayList<Object> getTrucklist(){
		return rtruckList;
	}
}
