package net.view;

import java.awt.Component;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import net.DataBase.DatabaseControl;

public class Panel extends JPanel
{
	private SpringLayout baseLayout;
	private JButton submitQueryButton;
	private DatabaseControl  baseController;
	private JLabel dynamicLabel;
	
	
	public Panel(DatabaseControl  baseController,String table)
	{
		this.baseController = baseController;
		submitQueryButton = new JButton();
		dynamicLabel = new JLabel();
		
		setupPanel(table);
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel(String table)
	{
		this.setLayout(baseLayout);
		this.add(submitQueryButton);
		int verticalOffset = 20;
		//int startOffset = 20;
		for(int count = 0;count < 6; count++)
		{
//			JLabel test = new JLabel("" + count +"label");
//			baseLayout.putConstraint(SpringLayout.NORTH, test, verticalOffset, SpringLayout.NORTH, this);
			this.add(dynamicLabel);
			
			
			
			verticalOffset += 20;
			JTextField textField = new JTextField(10);
			baseLayout.putConstraint(SpringLayout.NORTH, textField, verticalOffset, SpringLayout.NORTH, this);
			//this.add(test);
			this.add(textField);
			verticalOffset += 50;
		}
	}
	
	public void setupLayout()
	{
		
	}
	
	public void setupListeners()
	{
		//JTextField [] myfield;
		ArrayList<JTextField> myTextFields = new ArrayList<JTextField>();
		//int fieldCount = 0;
		
		for(Component current : this.getComponents())
		{
			//fieldCount++;
			this.add((JTextField)current);
		}
	}
	

}
