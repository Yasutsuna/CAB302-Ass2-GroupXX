package project;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
			if(sl0.isSelected()) {
				g.readFile(sales0);
			}else if(sl1.isSelected()) {
				g.readFile(sales1);
			}else if(sl2.isSelected()) {
				g.readFile(sales2);
			}else if(sl3.isSelected()) {
				g.readFile(sales3);
			}else if(sl4.isSelected()) {
				g.readFile(sales4);
			}else {
				JOptionPane.showMessageDialog(null, "Please select one of the selection");
			}
		}else {
			super.dispose();
		}
	}
}
