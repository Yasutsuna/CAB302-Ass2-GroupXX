package project;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


public class GUI extends JFrame{
//TODO

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GUI(){
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
		
		//main function GUI
   		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		
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
		JLabel temp = new JLabel("Temperature (°„C): ");
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
  		
  		JPanel panel1 = new JPanel(new GridLayout(7,1));
  		panel1.add(Name);
  		panel1.add(Qty);
  		panel1.add(Cost);
  		panel1.add(Price);
  		panel1.add(ReorderP);
  		panel1.add(ReorderA);
  		panel1.add(Temp);
  		
  		JTextArea resultName = new JTextArea();
  		resultName.setBorder(border);
		JTextArea resultQty = new JTextArea();
		resultQty.setBorder(border);
  		JTextArea resultCost = new JTextArea();
  		resultCost.setBorder(border);
  		JTextArea resultPrice = new JTextArea();
  		resultPrice.setBorder(border);
  		JTextArea resultReorderP = new JTextArea();
  		resultReorderP.setBorder(border);
  		JTextArea resultReorderA = new JTextArea();
  		resultReorderA.setBorder(border);
  		JTextArea resultTemp = new JTextArea();
  		resultTemp.setBorder(border);
  		
  		JPanel panel2 = new JPanel(new GridLayout(7,1));
  		panel2.add(resultName);
  		panel2.add(resultQty);
  		panel2.add(resultCost);
  		panel2.add(resultPrice);
  		panel2.add(resultReorderP);
  		panel2.add(resultReorderA);
  		panel2.add(resultTemp);
  		
  		JPanel bigPanel = new JPanel(new GridLayout(1,2));
  		bigPanel.add(panel1,BorderLayout.CENTER);
  		bigPanel.add(panel2,BorderLayout.EAST);

  		JPanel studentDetail = new JPanel();
  		studentDetail.setLayout(new GridLayout(2,2));
  		studentDetail.add(new JLabel("Student Name : Jeffrey"));
  		studentDetail.add(new JLabel("Student ID : N9830642"));
    	studentDetail.add(new JLabel("Student Name : Jeffrey"));
    	studentDetail.add(new JLabel("Student ID : N9830642"));  	
    	add(studentDetail);
    	
    	JLabel B1 = new JLabel("CAB302 Team 168's CopyRight");
		B1.setForeground(Color.WHITE);
		B1.setHorizontalAlignment(getX()/2);
		
		JLabel B2 = new JLabel("Student Detail : ");
		B2.setForeground(Color.WHITE);
		
		JPanel B1B2 = new JPanel(new GridLayout(2,1));
		B1B2.add(B1);
		B1B2.add(B2);
		B1B2.setBackground(Color.DARK_GRAY);
		
		JPanel AB = new JPanel(new BorderLayout());
		AB.add(bigPanel, BorderLayout.CENTER);
		AB.add(B1B2, BorderLayout.SOUTH);
		
		JPanel C = new JPanel(new BorderLayout());
		C.add(AB,BorderLayout.CENTER);
		C.add(studentDetail,BorderLayout.SOUTH);
    	
    	JPanel combine = new JPanel(new BorderLayout());
    	combine.add(topPanel, BorderLayout.NORTH);
    	combine.add(bigPanel, BorderLayout.CENTER);
    	combine.add(C, BorderLayout.SOUTH);
    		
    	add(combine);
	}
	
	public static void main (String[] args) {
		GUI s = new GUI();
		s.setTitle("SuperMart Store Sales App");
	    s.setLocationRelativeTo(null);
	    s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    s.setExtendedState(Frame.MAXIMIZED_BOTH);
	    s.setVisible(true);
	}
}
