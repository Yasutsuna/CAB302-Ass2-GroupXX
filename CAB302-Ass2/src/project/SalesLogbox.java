package project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 * @author Jeffrey
 *
 */
public class SalesLogbox extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	GUI g;
	
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
	
	/**
	 * Used to choose which sales log to be used.
	 * @param g
	 */
	public SalesLogbox(GUI g){
		super();
		this.g = g;
		
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

	/**
	 * What happens when a button is pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == okBtn) {
			super.dispose();
			if(sl0.isSelected()) {
				try {
					g.readFile(sales0);
				} catch (CSVFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//passFilename(sales0);
				//System.out.println(sales.getName());
			}else if(sl1.isSelected()) {
				try {
					g.readFile(sales1);
				} catch (CSVFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(sl2.isSelected()) {
				try {
					g.readFile(sales2);
				} catch (CSVFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(sl3.isSelected()) {
				try {
					g.readFile(sales3);
				} catch (CSVFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(sl4.isSelected()) {
				try {
					g.readFile(sales4);
				} catch (CSVFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Please select one of the selection");
			}
			
		}else {
			super.dispose();
		}
	}
}
