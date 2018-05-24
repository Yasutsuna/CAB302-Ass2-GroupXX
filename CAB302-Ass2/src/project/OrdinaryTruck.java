package project;

public abstract class OrdinaryTruck extends Truck{
	
	private double costWithTruck;
	
	public OrdinaryTruck() {
		capacity = 1000;
	}
	
	@Override
	public double getCost() {
		costWithTruck = 750 + (0.25 * spaceUsed() + super.getCost());
		return costWithTruck;
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
