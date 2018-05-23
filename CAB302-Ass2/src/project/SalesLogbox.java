package project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class SalesLogbox extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	GUI g;
	Sales sales;
	
	JButton okBtn;
	JButton closeBtn;
	
	JRadioButton sl0;
	JRadioButton sl1;
	JRadioButton sl2;
	JRadioButton sl3;
	JRadioButton sl4;
	
	//CSV file name
	String sales0 = "sales_log_0.csv";
	String sales1 = "sales_log_1.csv";
	String sales2 = "sales_log_2.csv";
	String sales3 = "sales_log_3.csv";
	String sales4 = "sales_log_4.csv";
	String fileName;
	
	
	List<Sales> salesList = new ArrayList<Sales>();
	
	public SalesLogbox(){
		
		sl0 = new JRadioButton("Sales Log 0");
		sl1 = new JRadioButton("Sales Log 1");
		sl2 = new JRadioButton("Sales Log 2");
		sl3 = new JRadioButton("Sales Log 3");
		sl4 = new JRadioButton("Sales Log 4");
		
		ButtonGroup group = new ButtonGroup();
		group.add(sl0);
		group.add(sl1);
		group.add(sl2);
		group.add(sl3);
		group.add(sl4);
		
		JPanel top = new JPanel(new GridLayout(5,1));
		top.add(sl0);
		top.add(sl1);
		top.add(sl2);
		top.add(sl3);
		top.add(sl4);
		
		okBtn = new JButton("OK");
		okBtn.addActionListener(this);
		closeBtn = new JButton("Close");
		closeBtn.addActionListener(this);
		
		JPanel btm = new JPanel();
		btm.add(okBtn);
		btm.add(closeBtn);
		
		JPanel combine = new JPanel(new BorderLayout());
		combine.add(top,BorderLayout.CENTER);
		combine.add(btm,BorderLayout.SOUTH);
		
		add(combine);
		
		setTitle("Sales Log Selection");
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setSize(375, 350);
	    setLocation(600, 250);
	    setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == okBtn) {
			super.dispose();
			if(sl0.isSelected()) {
				readFile(sales0);
				//passFilename(sales0);
				//System.out.println(sales.getName());
			}else if(sl1.isSelected()) {
				readFile(sales1);
			}else if(sl2.isSelected()) {
				readFile(sales2);
			}else if(sl3.isSelected()) {
				readFile(sales3);
			}else if(sl4.isSelected()) {
				readFile(sales4);
			}else {
				JOptionPane.showMessageDialog(null, "Please select one of the selection");
			}
		}else {
			super.dispose();
		}
	}
	
	public void passFilename(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFilename() {
		return fileName;
	}
	
	private void readFile(String fileName) {
		// TODO Auto-generated method stub
		BufferedReader reader = null;
		String[] itemDetail;
        try { 
            reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            
            while((line=reader.readLine())!=null) {
                itemDetail = line.split(",",-1);
                if(itemDetail.length > 0) {
                	sales = new Sales(itemDetail[0], Integer.parseInt(itemDetail[1]));
            		salesList.add(sales);
            		salesFunction();
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

	private void salesFunction(){
		// TODO Auto-generated method stub
		System.out.println(sales.getName() + "\n" + sales.getQty());
	}
}
