package project;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;


public class GUI extends JFrame implements ActionListener{
//TODO

	JTextArea display;
	JScrollPane scrollpane;
	
	private JButton exportBtn;
	private JButton initializedBtn;
	private JButton manifestsBtn;
	private JButton salesLogBtn;
	
	private JTextArea resultName;
	private JTextArea resultQty;
	private JTextArea resultCost;
	private JTextArea resultPrice;
	private JTextArea resultReorderP;
	private JTextArea resultReorderA;
	private JTextArea resultTemp;
	
	String initFile = "item_properties.csv";
	String manifestFile = "manifest.csv";
	String salesFile = "sales_log_0.csv";
	
	Item item;
	//Create list for holding item objects
    List<Item> itemList = new ArrayList<Item>();
	
	int selection = 0;
	static double balance = 100000.0;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GUI(){
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		//Company
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
		//
		
		//Display area
		display = new JTextArea();
		display.setEditable(false);
		display.setBorder(border);
		//display.setText("Click the Load Properties Doc Button to Start. ");
		scrollpane = new JScrollPane(display,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scrollpane.setViewportView();
		JPanel screen = new JPanel(new BorderLayout());
		screen.add(scrollpane,BorderLayout.CENTER);
		resetDisplay("Click the Load Properties Doc Button to Start.\n");
		
		//main function GUI
		JLabel name = new JLabel("Name : ");
		name.setBorder(border);
		JLabel qty = new JLabel("Quantity : ");
		qty.setBorder(border);
		JLabel cost = new JLabel("Manufacturing Cost : ");
		cost.setBorder(border);
		JLabel price = new JLabel("Sell Price : ");
		price.setBorder(border);
		JLabel reorderP = new JLabel("Reorder Point : ");
		reorderP.setBorder(border);
		JLabel reorderA = new JLabel("Reorder Amount : ");
		reorderA.setBorder(border);
		JLabel temp = new JLabel("Temperature (¡ãC): ");
		temp.setBorder(border);
		
		JPanel Name = new JPanel(new BorderLayout());
		Name.add(name);
  		JPanel Qty = new JPanel(new BorderLayout());
  		Qty.add(qty);
  		JPanel Cost = new JPanel(new BorderLayout());
  		Cost.add(cost);
  		JPanel Price = new JPanel(new BorderLayout());
  		Price.add(price);
  		JPanel ReorderP = new JPanel(new BorderLayout());
  		ReorderP.add(reorderP);
  		JPanel ReorderA = new JPanel(new BorderLayout());
  		ReorderA.add(reorderA);
  		JPanel Temp = new JPanel(new BorderLayout());
  		Temp.add(temp);
  		
  		JPanel left = new JPanel(new GridLayout(7,1));
  		left.add(Name);
  		left.add(Qty);
  		left.add(Cost);
  		left.add(Price);
  		left.add(ReorderP);
  		left.add(ReorderA);
  		left.add(Temp);
  		
  		//TextArea
  		resultName = new JTextArea("0");
  		resultName.setBorder(border);
  		resultName.setEditable(false);
		resultQty = new JTextArea("0");
		resultQty.setBorder(border);
		resultQty.setEditable(false);
  		resultCost = new JTextArea("0");
  		resultCost.setBorder(border);
  		resultCost.setEditable(false);
  		resultPrice = new JTextArea("0");
  		resultPrice.setBorder(border);
  		resultPrice.setEditable(false);
  		resultReorderP = new JTextArea("0");
  		resultReorderP.setBorder(border);
  		resultReorderP.setEditable(false);
  		resultReorderA = new JTextArea("0");
  		resultReorderA.setBorder(border);
  		resultReorderA.setEditable(false);
  		resultTemp = new JTextArea("0");
  		resultTemp.setBorder(border);
  		resultTemp.setEditable(false);
  		
  		JPanel right = new JPanel(new GridLayout(7,1));
  		right.add(resultName);
  		right.add(resultQty);
  		right.add(resultCost);
  		right.add(resultPrice);
  		right.add(resultReorderP);
  		right.add(resultReorderA);
  		right.add(resultTemp);
  		
  		JPanel functionPanel = new JPanel(new GridLayout(1,2));
  		functionPanel.add(left);
  		functionPanel.add(right);
  		
  		JPanel middlePanel = new JPanel(new GridLayout(2,1));
  		middlePanel.add(screen,BorderLayout.CENTER);
  		middlePanel.add(functionPanel,BorderLayout.CENTER);
  		
  		
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
			JOptionPane.showMessageDialog(null, "Get Export");
		}else if(e.getSource() == initializedBtn) {
			selection = 1;
			readFile(initFile);
			initializedBtn.setEnabled(false);
			//Item item = new Item(name, price, reorder, amount, temp);
		}else if(e.getSource() == manifestsBtn) {
			selection = 2;
			readFile(manifestFile);
		}else if(e.getSource() == salesLogBtn) {
			selection = 3;
			readFile(salesFile);
		}
		
	}
	
	public void readFile(String fileName) {
		BufferedReader reader = null;
    	
        try { 
            reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            
            //Skip the header line
            //reader.readLine();
            
            while((line=reader.readLine())!=null) {
                String[] itemDetail = line.split(",");
                if(itemDetail.length > 0) {
                	
                	if(selection == 1) {
	                	item = new Item(itemDetail[0],Double.parseDouble(itemDetail[1]),Double.parseDouble(itemDetail[2]),Integer.parseInt(itemDetail[3]),Integer.parseInt(itemDetail[4]),Integer.parseInt(itemDetail[5]));
	                	itemList.add(item);
	                	initialFunction();
                	}else if(selection == 2) {
                		System.out.print("selection 2");
                	}else if(selection == 3) {
                		System.out.print("selection 3");
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
	
	private void initialFunction() {
		balance -= Math.round(item.getCost() * item.getAmount());
		//Printing the Item
        for(Item i : itemList) {	
        	appendDisplay(i.getName() +"\n" + i.getCost() +"\n" + i.getPrice() +"\n" + i.getReorder() +"\n" + i.getAmount() +"\n" + i.getTemp() + "\n");
        }
	}
/*	public void readFile(String fileName) {
		String itemP = fileName;
		File file = new File(itemP); //read about file
		try {
			
			Scanner input = new Scanner(file);
			input.useDelimiter(",");
			//ArrayList<String> list = new ArrayList<String>();
			while (input.hasNext()) {
				String data = input.next();
				String[] values = data.split(",");
				for(int i=0; i<values.length; i++) {
					System.out.println(values[i]);
				}
				//System.out.println(item);
			}
			input.close();
		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}*/
	
	private void resetDisplay(String initialText) {
		display.setText(initialText);
	}
	
	private void appendDisplay(String newText) {
		display.setText(display.getText() + newText);
	}
	
	public static void main (String[] args) {
		GUI s = new GUI();
		s.setTitle("SuperMart Store Sales App");
	    s.setLocationRelativeTo(null);
	    s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    s.setSize(500, 800);
	    s.setLocation(30, 30);
	    s.setVisible(true);
	    
	    
	}
}