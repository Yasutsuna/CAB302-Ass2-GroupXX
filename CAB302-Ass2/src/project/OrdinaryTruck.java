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
	public void putItems(List<Store> storeList) {
		// TODO Auto-generated method stub
		for(Store s : storeList) {
			spaceUsing = s.getQuantity();
		}
	}
}

/*public OrdinaryTruck (int cost, int capacity, List<Manifest> cargo) {
super(cost, capacity);
this.cargo = cargo;
}

public double getCostNormalTruck () {
costWithTruck = 750 + (0.25 * this.getCapacity());
return costWithTruck;
}


public List<Manifest> getCargo() {
return cargo;
}

public void capacityCheck () { //questionable
if (this.getCapacity() > 1000) {
	System.out.print("Overload!"); //throw exception
}
}*/


/*public OrdinaryTruck(String name, int quantity, double price, int temperature) {
super(name, quantity, price, temperature);
capacity = 1000;
}
*/
