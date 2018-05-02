package project;

public class Store {
	private static Store instance = new Store();
	
	private Store() {}
	
	public static Store getInstance() {
		return instance;
	}
}

/*public class StoreDemo {
 * 	public static void main
 * 
 * Store object = Store.getInstance()
 * object.showMessage();
*/