package net.view;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import net.DataBase.appController;

public class MetadataPanel extends JPanel
{
	private SpringLayout baseLayout;
	private appController baseController;
	
	public MetadataPanel()
	{

		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		int startOffset = 20;
		for(int count = 0;count < 6/* baseController.getDatabase().getMetaData()*/; count++)
		{
			JLabel test = new JLabel("" + count +"label");
			baseLayout.putConstraint(SpringLayout.NORTH, test, startOffset, SpringLayout.NORTH, this);
			
			startOffset += 20;
			JTextField textField = new JTextField(10);
			baseLayout.putConstraint(SpringLayout.NORTH, textField, startOffset, SpringLayout.NORTH, this);
			this.add(test);
			this.add(textField);
			startOffset += 50;
		}
	}
	
	public void setupLayout()
	{
		
	}
	
	public void setupListeners()
	{
		
		ArrayList<JTextField> myTextFields = new ArrayList<JTextField>();
		//JTextField [] myfield;
		//int fieldCount = 0;
		//fieldCount++;
		for(Component current : this.getComponents())
		{
			
			this.add((JTextField)current);
		}
	}

}
