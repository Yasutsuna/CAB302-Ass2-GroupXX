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
	public double getCost() {
		costWithTruck = Math.round(900 + (200 * Math.pow(0.7, (double) lowestTemp/ 5)));
		return costWithTruck;
	}
	
	@Override
	public void putItems (List<Store> storeList) {
//	public void putItems (Item item, int quantity) throws DeliveryException {
		for(Store s : storeList) {
			spaceUsing = s.getQuantity();
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
}


//private String name;
	//private int quantity;
	/*
	private List<Manifest> cargo;
	private int temperature;
	private double costWithTruck;
	//cargo
	
	public RefrigeratedTruck (int cost, int capacity, int temperature, List<Manifest> cargo) {
		super(cost, capacity);
		this.cargo = cargo;
		this.temperature = temperature;
	}
	
	
	
	public int getTemperature() {
		return temperature;
	}
	
	public List<Manifest> getCargo() {
		return cargo;
	}
	
	public void capacityCheck () { //questionable
		if (this.getCapacity() > 800) {
			System.out.print("Overload!"); //throw exception
		}
	}
	*/
	
	/*private int temperature;
	private double costWithTruck;
	private int lowestTemp;
	
	public RefrigeratedTruck() {
		super(name, quantity, price, temperature);
		capacity = 800;
	}
	
	@Override
	public double getCost() {
		costWithTruck = 900 + (200 * Math.pow(0.7,(double)lowestTemp/5)) + super.getCost();
		return costWithTruck;
	}
	
	//check logic
	public void addCargo (int name, int quantity) {
		if (temperature != 0) {
			if (temperature == 0) {
				lowestTemp = temperature;
			}
			
			else {
				if (lowestTemp > temperature) {
					lowestTemp = temperature;
				}
			}
		}
		
	}*/
