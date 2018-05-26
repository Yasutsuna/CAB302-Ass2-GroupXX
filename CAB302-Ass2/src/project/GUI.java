package project;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Jeffrey
 *
 */
public class GUI extends JFrame implements ActionListener{
//TODO
	//GUI Global variable using below--------------
	JTextArea display;
	JScrollPane scrollpane;
	DefaultTableModel model;
	String[] header = {"Name","Quantity","Manufacturing Cost","Sell Price","Reorder Point","Reorder Amount","Temperature(°„C)"};	
	
	private JButton exportBtn;
	private JButton initializedBtn;
	private JButton manifestsBtn;
	private JButton salesLogBtn;
	
	private JTable table;
	DefaultTableModel tableModel;
	
	String name;
	int qty;
	double cost;
	double sellprice;
	int reorder;
	int amount;
	int temp;
	double i;
	double j;
	//---------------------------------------------
	
	//Reading file global variable-----------------
	String initFile = "item_properties.csv";
	String manifestFile = "manifest.csv";
	String[] itemDetail;
	//---------------------------------------------
	
	//Class Declare--------------------------------
	Item item;
	Store store;
	Manifest manifest;
	SalesLogbox slb;
	Sales sales;
	Stock stock;
	Truck otruck;
	Truck rtruck;
	//Truck truck2 = new RefrigeratedTruck(initFile, amount, balance, amount);
	//---------------------------------------------

	//Create list for holding item objects---------
    List<Item> itemList = new ArrayList<Item>();
    List<Manifest> manifestList = new ArrayList<Manifest>();
    List<Sales> salesList = new ArrayList<Sales>();
    List<Store> storeList = new ArrayList<Store>();
    List<Stock> stockList = new ArrayList<Stock>();
    List<Truck> truckList = new ArrayList<Truck>();
	//---------------------------------------------
	
    int selection = 0;
	double balance = 100000.0;
	int quantity = 0;
	double total;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The GUI Design
	 */
	public GUI(){
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		//Company--------------------------------------
		JLabel companyName = new JLabel("SuperMart Fresh Market");
		companyName.setHorizontalAlignment(getX()/2);
		JLabel A = new JLabel("Sales App: ");
		A.setForeground(Color.WHITE);
		
		JPanel bg = new JPanel(new BorderLayout());
		bg.add(A);
		bg.setBackground(Color.DARK_GRAY);
		
		JPanel top = new JPanel(new GridLayout(2,1));
		top.add(companyName);
		top.add(bg);
		
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.add(top, BorderLayout.SOUTH);
		//---------------------------------------------
		
		//Display area---------------------------------
		display = new JTextArea();
		display.setEditable(false);
		display.setBorder(border);
		//display.setText("Click the Load Properties Doc Button to Start. ");
		scrollpane = new JScrollPane(display,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scrollpane.setViewportView();
		JPanel screen = new JPanel(new BorderLayout());
		screen.add(scrollpane,BorderLayout.CENTER);
		resetDisplay("Started Capital : " + balance + "\nClick the Load Properties Doc Button to Start.\n"
				+ "-------------------------------------------------------------------\n");
		//--------------------------------------------
		
		
		//Tabular design------------------------------
		tableModel = new DefaultTableModel(header,0);
  		table = new JTable(tableModel);
  		table.setPreferredScrollableViewportSize(getMaximumSize());
  		JScrollPane pane = new JScrollPane();
  		pane.setViewportView(table);
  		
  		JPanel middlePanel = new JPanel(new GridLayout(2,1));
  		middlePanel.add(screen,BorderLayout.NORTH);
  		middlePanel.add(pane,BorderLayout.CENTER);
  		//--------------------------------------------
  		
  		//button Create-------------------------------
  		exportBtn =  new JButton("Export Manifests");
  		exportBtn.addActionListener(this);
  		initializedBtn =  new JButton("Load properties Doc");
  		initializedBtn.addActionListener(this);
  		manifestsBtn =  new JButton("Load  Manifests");
  		manifestsBtn.addActionListener(this);
  		salesLogBtn =  new JButton("Load Sales Logs");
		salesLogBtn.addActionListener(this);
  		//--------------------------------------------
		
  		//Button Panel--------------------------------
  		JPanel btmrow1 = new JPanel(new GridLayout(1,3));
  		btmrow1.add(manifestsBtn);
  		btmrow1.add(salesLogBtn);
  		btmrow1.add(exportBtn);
  		
  		JPanel btmPanel = new JPanel(new BorderLayout());
		btmPanel.add(initializedBtn,BorderLayout.CENTER);
		btmPanel.add(btmrow1,BorderLayout.SOUTH);
		//--------------------------------------------
		
    	JPanel combine = new JPanel(new BorderLayout());
    	combine.add(topPanel, BorderLayout.NORTH);
    	combine.add(middlePanel, BorderLayout.CENTER);
    	combine.add(btmPanel, BorderLayout.SOUTH);
    	
    	add(combine);
	}
	
	/**
	 * The action when a button is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == exportBtn) {
			try {
				exportFile();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Get Export");
		}else if(e.getSource() == initializedBtn) {
			selection = 1;
			try {
				readFile(initFile);
			} catch (CSVFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			initializedBtn.setEnabled(false);
			//printingCapital();
			insertTable();
		}else if(e.getSource() == manifestsBtn) {
			selection = 2;
			manifestsFunction();
			//update Table
//			for(Store store : new ArrayList<>(storeList)) {
//    			storeList.remove(store);
//    		}
			//updateStore();
			updateTable();
		}else if(e.getSource() == salesLogBtn) {
			selection = 3;
			slb = new SalesLogbox(this);
			slb.setVisible(true);
		}
		//
	}
	
	/**
	 * Gathers the data when the GUI Button 1 is pressed and store the item to Store
	 */
	public void initialFunction() {
		store = new Store(item.getName(), quantity, item.getCost(), item.getPrice(), item.getReorder(), item.getAmount(), item.getTemp());
        storeList.add(store);
        balance = store.getTotal();
	}
	/**
	 * Gathers the data when the GUI Button 2 is pressed. The details will be stored in Stock
	 * It will also get the cost of the truck used.
	 */
	public void manifestsFunction() {
			stock = new Stock(balance,storeList,salesList);
			balance = stock.getCapital();
			for(Store s : stock.newdataList) {
				//System.out.println("Name: "+s.getName()+ " Quantity: " + s.getQuantity() + " Cost: " + s.getCost() + " Temp: " + s.getTemp());
				manifest = new Manifest(s.getName(),s.getQuantity(),s.getCost(),s.getTemp());
				otruck = new OrdinaryTruck(s.getName(),s.getQuantity(),s.getCost(),s.getTemp());
				rtruck = new RefrigeratedTruck(s.getName(),s.getQuantity(),s.getCost(),s.getTemp());
				i = otruck.getTruckCost();
				j = rtruck.getTruckCost();
				
			}
			total = (i+j);
			System.out.println("total of ordinary: " + i + " total of refrigerated: " + j + " total of truck paid: "+ total);
			balance -= total;
			//System.out.println("truck pay: " + otruck.getTruckCost()/* + truck2.getCost()*/);
			//System.out.println("truck 1: " + rtruck.getTrucklist());
			printingCapital();
	}
	
	/**
	 * Displays the result of the scren
	 */
	public void salesFunction(){
		// TODO Auto-generated method stub
		appendDisplay("--------------------------Sales---------------------------\n"
				+ "Name: " + sales.getName() + "\nQuantity:" + sales.getQty() + "\n");
	}

	/**
	 * 
	 *create the data of after initial
	 *table insert
	 * 
	 */
	private void insertTable() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<storeList.size();i++) {
  			name = storeList.get(i).getName();
  			qty = storeList.get(i).getQuantity();
  			cost = storeList.get(i).getCost();
  			sellprice = storeList.get(i).getPrice();
  			reorder = storeList.get(i).getReorder();
  			amount = storeList.get(i).getAmount();
  			temp = storeList.get(i).getTemp();
  			if(temp == 0) {
  				Object[] objs = {name,qty,cost,sellprice,reorder,amount};
  				tableModel.addRow(objs);
  			}else {
  				Object[] objs = {name,qty,cost,sellprice,reorder,amount,temp};
  				tableModel.addRow(objs);
  			}
  		}
	}
	
	//update the data
	
	/**
	 * Updates the table
	 */
	private void updateTable() {
		// TODO Auto-generated method stub
		for(int i= storeList.size()-1;i>=0;i--) {
			tableModel.removeRow(i);
		}
		for(int i=0; i<stock.newdataList.size();i++) {
  			name = stock.newdataList.get(i).getName();
  			qty = stock.newdataList.get(i).getQuantity();
  			cost = stock.newdataList.get(i).getCost();
  			sellprice = stock.newdataList.get(i).getPrice();
  			reorder = stock.newdataList.get(i).getReorder();
  			amount = stock.newdataList.get(i).getAmount();
  			temp = stock.newdataList.get(i).getTemp();
  			if(temp == 0) {
  				Object[] objs = {name,qty,cost,sellprice,reorder,amount};
  				tableModel.addRow(objs);
  			}else {
  				Object[] objs = {name,qty,cost,sellprice,reorder,amount,temp};
  				tableModel.addRow(objs);
  			}
  			
  		}
	}
	
	/**
	 * Reads the csv file
	 * @param fileName - Needs to be item_properties.csv
	 * @throws CSVFormatException - Will throw an error if the csv format is wrong
	 */
	public void readFile(String fileName) throws CSVFormatException {
		BufferedReader reader = null;
    	
        try { 
            reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            
            while((line=reader.readLine())!=null) {
                itemDetail = line.split(",",-1);
                if(itemDetail.length > 0) {
                	//Button clicked *selection
                	if(selection == 1) {
                		if(itemDetail.length==5) {
                			item = new Item(itemDetail[0],Double.parseDouble(itemDetail[1]),
            					Double.parseDouble(itemDetail[2]),Integer.parseInt(itemDetail[3]),
            					Integer.parseInt(itemDetail[4]));
		               		itemList.add(item);
                		}else if (itemDetail.length==6){
               				item = new Item(itemDetail[0],Double.parseDouble(itemDetail[1]),
               						Double.parseDouble(itemDetail[2]),Integer.parseInt(itemDetail[3]),
               						Integer.parseInt(itemDetail[4]),Integer.parseInt(itemDetail[5]));
    		               	itemList.add(item);   	
                		}
                		else {
                			throw new CSVFormatException();
                		}
                		initialFunction();
                	}else if(selection == 2) {
                		
                	}else if(selection == 3){
                		double cost = 0;
                		for(Store s : storeList) {
                			if(itemDetail[0].equals(s.getName())) {
                				cost = s.getCost();
                			}
                		}
                		sales = new Sales(itemDetail[0], Integer.parseInt(itemDetail[1]),cost);
                		//System.out.println("Printing: " + itemDetail[0] + " Price: " + cost);
                		salesList.add(sales);
                		salesFunction();
                	}
                }
            }      
        }catch (Exception e) {
            e.printStackTrace(); 
        }finally {
        	try {
        		reader.close();
        	}catch(IOException ie){
        		JOptionPane.showMessageDialog(null, "Error occured while closing the BufferedReader");
        		ie.printStackTrace();
        	}
        }
	}
	
	/**
	 * Exports and replace the manifest.csv
	 * @throws FileNotFoundException - Will throw if manifest.csv doesn't exist
	 */
	private void exportFile() throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter pw = new PrintWriter(new File("Manifest.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append(">Refrigarated");
        sb.append("\n");
        sb.append(item.getName());
        sb.append(',');
        sb.append(item.getAmount());
        sb.append("\n");
        sb.append(">Ordinary");
        sb.append("\n");

        pw.write(sb.toString());
        pw.close();
	}
	
	//display function below
	
	/**
	 * Resets the display
	 * @param initialText - Used initially to print the text.
	 */
	public void resetDisplay(String initialText) {
		display.setText(initialText);
	}
	
	/**
	 * Sets the text.
	 * @param newText - Used to update the textbox.
	 */
	//Printing Function below
	public void appendDisplay(String newText) {
		display.setText(display.getText() + newText);
	}
	
	
	//Printing Function below
	
	/**
	 * Prints the capital on the GUI screen
	 */
	public void printingCapital() {
		appendDisplay( "-------------------------------------------------------------\n" + 
						"                Current Capital : " + balance + 
						"\n-------------------------------------------------------------\n");
	}
	
	
	public static void main (String[] args) {
		GUI s = new GUI();
		s.setTitle("SuperMart Store Sales App");
	    s.setLocationRelativeTo(null);
	    s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    s.setSize(1000, 800);
	    s.setLocation(30, 30);
	    s.setVisible(true);
	}
}