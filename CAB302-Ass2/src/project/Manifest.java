package project;

import java.util.List;

public class Manifest {
	
	private List<Store> storeList;
	int temp=0;
	//double balance;
	Truck truck;
	
	public Manifest( List<Store> storeList) {
		//this.balance = balance;
		this.storeList = storeList;
		callTruck();
	}
	
	public List<Store> getStoreList() {
		return storeList;
	}
	
	private void callTruck() {
		for(Store s : storeList) {
			temp = s.getTemp();
			if(temp == 0) {
				truck = new OrdinaryTruck();
			}else {
				truck = new RefrigeratedTruck();
			}
			truck.putItems(storeList);
		}
		
	}
}
