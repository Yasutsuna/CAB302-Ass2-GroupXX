package project;

public class Stock {
	//current capital
	private double capital;
	//storeInventory
	private String name;
	private int qty;
	//stockOrders
	private String oname;
	private double ocost;
	private int oamount;
	private int reorderP;
	//salesLog
	private String sname;
	private double sprice;
	private int sqty;
	//Truck
	private String Refrigarated; 
	private String ordinary;
	
	Item item;
	
	/*public Stock(double capital, Store store, Item item, Sales sales) {	
		classification();
	}*/
	
	public Stock(double capital, String name, int qty, String oname , double ocost, int oamount, int reorderP, String sname, double sprice, int sqty) {	
		this.capital = capital;
		this.name = name;
		this.qty = qty;
		this.oname = oname;
		this.ocost = ocost;
		this.oamount = oamount;
		this.reorderP = reorderP;
		this.sname = sname;	
		this.sprice = sprice;	
		this.sqty = sqty;
		classification();
	}

	public void classification() {
		// TODO Auto-generated method stub
		/*capital -= sprice * sqty;
		if(capital <= 0) {
			System.out.println("Fail");
		}else {
			qty -= sqty;
			if(qty<=reorderP) {
				qty += item.getAmount(); 
				capital -= item.getCost()*item.getAmount();
			}else {
				
			}
		}*/
		
		if(name.equals(sname)) {
			qty -= sqty;
			capital += sprice * sqty;
			if(qty <= reorderP) {
				if(capital > 0) {
					qty += 2;
					capital -= ocost*oamount;
					System.out.println(capital);
				}else {
					System.out.println("***No enought Capital***");
				}
			}else {
				System.out.println("updated");
			}
		}
		
	}

	//store's item
	public String getName(){
		return name;
	}
	
	public int getQty(){
		return qty;
	}
	
	//orderpoint detail
	public String getOname() {
		return oname;
	}
	
	public double getOcost() {
		return ocost;
	}
	
	public int getOamount() {
		return oamount;
	}
	
	public int getReorderP() {
		return reorderP;
	}
	
	//salesLog detail
	public String getSname() {
		return sname;
	}
	
	public double getSprice() {
		return sprice;
	}
	
	public int getSqty() {
		return sqty;
	}
}


