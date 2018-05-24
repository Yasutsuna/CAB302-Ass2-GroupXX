package project;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


public class GUI extends JFrame implements ActionListener{
//TODO

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
	
	String initFile = "item_properties.csv";
	String manifestFile = "manifest.csv";
	
	String[] itemDetail;
	
	Item item;
	Store store;
	Manifest manifest;
	SalesLogbox slb;
	Sales sales;
	Stock2 stock;

	//Create list for holding item objects
    List<Item> itemList = new ArrayList<Item>();
    List<Manifest> manifestList = new ArrayList<Manifest>();
    List<Sales> salesList = new ArrayList<Sales>();
    List<Store> storeList = new ArrayList<Store>();
	
	int selection = 0;
	double balance = 100000.0;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
				+ "------------------------------------------------------------------------\n");
		//--------------------------------------------
		
		
		//main GUI------------------------------------
		//Create for the data inserting
		//model = new DefaultTableModel(data,header);
		tableModel = new DefaultTableModel(header,0);
  		table = new JTable(tableModel);
  		table.setPreferredScrollableViewportSize(getMaximumSize());
  		JScrollPane pane = new JScrollPane();
  		pane.setViewportView(table);
  		
  		//store.setData((DefaultTableModel)table.getModel());
  		
  		JPanel middlePanel = new JPanel(new GridLayout(2,1));
  		middlePanel.add(screen,BorderLayout.NORTH);
  		middlePanel.add(pane,BorderLayout.CENTER);
  		//--------------------------------------------
  		
  		//button Create
  		exportBtn =  new JButton("Export Manifests");
  		exportBtn.addActionListener(this);
  		initializedBtn =  new JButton("Load properties Doc");
  		initializedBtn.addActionListener(this);
  		manifestsBtn =  new JButton("Load  Manifests");
  		manifestsBtn.addActionListener(this);
  		salesLogBtn =  new JButton("Load Sales Logs");
		salesLogBtn.addActionListener(this);
  		
  		//Button Panel
  		JPanel btmrow1 = new JPanel(new GridLayout(1,3));
  		btmrow1.add(manifestsBtn);
  		btmrow1.add(salesLogBtn);
  		btmrow1.add(exportBtn);
  		
  		JPanel btmPanel = new JPanel(new BorderLayout());
		btmPanel.add(initializedBtn,BorderLayout.CENTER);
		btmPanel.add(btmrow1,BorderLayout.SOUTH);
    	
    	JPanel combine = new JPanel(new BorderLayout());
    	combine.add(topPanel, BorderLayout.NORTH);
    	combine.add(middlePanel, BorderLayout.CENTER);
    	combine.add(btmPanel, BorderLayout.SOUTH);
    		
    	add(combine);
	}

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
			readFile(initFile);
			initializedBtn.setEnabled(false);
			//printingCapital();
			for(int i=0; i<storeList.size();i++) {
	  			name = storeList.get(i).getName();
	  			qty = storeList.get(i).getQuantity();
	  			cost = storeList.get(i).getCost();
	  			sellprice = storeList.get(i).getPrice();
	  			reorder = storeList.get(i).getReorder();
	  			amount = storeList.get(i).getAmount();
	  			temp = storeList.get(i).getTemp();
	  			
	  			Object[] objs = {name,qty,cost,sellprice,reorder,amount,temp};
	  	  		tableModel.addRow(objs);
	  		}
			//Item item = new Item(name, price, reorder, amount, temp);
		}else if(e.getSource() == manifestsBtn) {
			selection = 2;
			manifestsFunction();
			//stock = new Stock(store.getQuantity(),item.getReorder(),0,"Refrigarated");
		}else if(e.getSource() == salesLogBtn) {
			selection = 3;
			slb = new SalesLogbox(this);
			slb.setVisible(true);
		}
		//
	}
	
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

	public void readFile(String fileName) {
		BufferedReader reader = null;
    	
        try { 
            reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            
            while((line=reader.readLine())!=null) {
                itemDetail = line.split(",",-1);
                if(itemDetail.length > 0) {
                	//Button clicked
                	if(selection == 1) {
                		if(itemDetail.length<6) {
                			item = new Item(itemDetail[0],Double.parseDouble(itemDetail[1]),
            					Double.parseDouble(itemDetail[2]),Integer.parseInt(itemDetail[3]),
            					Integer.parseInt(itemDetail[4]));
		               		itemList.add(item);
		               		initialFunction();
                		}else {                			
               				item = new Item(itemDetail[0],Double.parseDouble(itemDetail[1]),
               						Double.parseDouble(itemDetail[2]),Integer.parseInt(itemDetail[3]),
               						Integer.parseInt(itemDetail[4]),Integer.parseInt(itemDetail[5]));
    		               	itemList.add(item);
    	                	initialFunction();
                		}
                	}else if(selection == 2) {
                		
                		if(itemDetail[0].contains(">")) {
                			//skip reading the line here
                		}else {
                			manifest = new Manifest(itemDetail[0], Integer.parseInt(itemDetail[1]));
                			manifestList.add(manifest);
                			manifestsFunction();
                		}
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

	public void printingCapital() {
		appendDisplay( "--------------------------------------\n" + 
						"Current Capital : " + balance + 
						"\n--------------------------------------\n");
	}
	
	public void initialFunction() {
		store = new Store(item.getName(), item.getCost(), item.getPrice(), item.getReorder(), item.getAmount(), item.getTemp());
        storeList.add(store);
		
		//Printing the Item
//        appendDisplay(name + item.getName() +"\n" + qty + store.getQuantity() + "\n" + cost + item.getCost() +"\n" + 
//        		sellprice + item.getPrice() +"\n" + reorder + item.getReorder() +"\n" + amount 
//        		+ item.getAmount() +"\n" + temp + item.getTemp() + "\n\n");
//	
        balance = store.getTotal();
	}
	
	public void manifestsFunction() {
		//balance = store.getTotal();
			stock = new Stock2(balance,storeList,salesList);
			balance = stock.getCapital();
			//balance = stock.getCapital();
			System.out.println(balance + "abc");
			printingCapital();
			
			Truck truck = new RefrigeratedTruck();
	}
	
	public void salesFunction(){
		// TODO Auto-generated method stub
		for(Sales s : salesList) {
			System.out.println(s.getName() + "\n" + s.getQty());
		}
	}
	
	public void resetDisplay(String initialText) {
		display.setText(initialText);
	}
	
	public void appendDisplay(String newText) {
		display.setText(display.getText() + newText);
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