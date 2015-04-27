package net.view;

import java.awt.Component;
import java.awt.event.*;
import java.util.ArrayList;
import net.DataBase.appController;
import javax.swing.*;

import net.DataBase.DatabaseControl;

public class Panel extends JPanel
{
	private SpringLayout baseLayout;
	private JButton submitQueryButton;
	private DatabaseControl  baseController;
	private JLabel dynamicLabel;
	private ArrayList<JTextField> inputFieldList;
	private String tableName;
	private appController appController;
	
	JTextField dynamicField = new JTextField(20);
	
	public Panel(DatabaseControl  baseController,String table)
	{
		this.baseController = baseController;
		this.tableName = table;
		submitQueryButton = new JButton();
		dynamicLabel = new JLabel();
		inputFieldList = new ArrayList<JTextField>();
		
		
		setupPanel(table);
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel(String table)
	{
		this.setLayout(baseLayout);
		this.add(submitQueryButton);
		String[] columns = baseController.getDatabaseColumnNames(tableName);
		int verticalOffset = 20;
		//int startOffset = 20;
		for(int count = 0;count < 6; count++)
		{
			
			if(!columns[count].equalsIgnoreCase("id"))
			{
			JTextField textField = new JTextField(10);
//			JLabel test = new JLabel("" + count +"label");
//			baseLayout.putConstraint(SpringLayout.NORTH, test, verticalOffset, SpringLayout.NORTH, this);
			this.add(dynamicLabel);
			inputFieldList.add(dynamicField);
			
			
			
			verticalOffset += 20;
			
			baseLayout.putConstraint(SpringLayout.NORTH, textField, verticalOffset, SpringLayout.NORTH, this);
			baseLayout.putConstraint(SpringLayout.EAST,dynamicField,60,SpringLayout.EAST,dynamicLabel);
			
			//this.add(test);
			this.add(textField);
			verticalOffset += 50;
			}
		}
	}
	
	public void setupLayout()
	{
		
	}
	
	private String getValueList()
	{
		String values = "";
		for(int spot = 0; spot < inputFieldList.size(); spot++)
		{
			String temp = inputFieldList.get(spot).getText();
			
			if(spot == inputFieldList.size()-1)
			{
				values += "'" + temp + "', ";
			}
			else 
			{
				values += "'" + temp + "' ";
			}
		}
		return values;
	}
	
	private String getFieldList()
	{
		String fields ="(";
		//needs the format (`field`,`field`,`field`,`field`...);
		for(int spot = 0; spot < inputFieldList.size(); spot++)
		{
			String temp = inputFieldList.get(spot).getName();
			int cutoff = temp.indexOf("Field");
			temp = temp.substring(0,cutoff);
			if(spot == inputFieldList.size()-1)
			{
				fields += "`" + temp + "`, ";
			}
			else 
			{
				fields += "`" + temp + "` ";
			}
			
		}
		
		return fields;
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
		
		submitQueryButton.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0)
			{
				String query = "INSERT INTO" + tableName + "" + getFieldList() + "VALUES" + getValueList() +";";
				appController.getDatabase().submitQuery(query);
				
			}
			
		});
			
		
	}
	

}
