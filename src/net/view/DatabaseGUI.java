package net.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import net.DataBase.DatabaseControl;
import net.DataBase.DatabaseRunner;
import net.DataBase.appController;
/**
 * 
 * @author jlin3312
 * @version 1.3 adding display tables
 * 
 */
public class DatabaseGUI extends JPanel
{

	public JButton appButton;
	private JTextArea DisplayArea;
	private JScrollPane displayPane;
	private SpringLayout baselayout;
	private appController baseController = new appController();
	private JTable tabledata;
	
	public DatabaseGUI()
	{
		appButton = new JButton("Query");
		DisplayArea = new JTextArea(10,30);
		//displayPane = new JScrollPane(DisplayArea);
		baselayout = new SpringLayout();
		
		setupTable();
		setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.setBackground(Color.magenta);
		this.setLayout(baselayout);
		this.add(appButton);
		this.add(displayPane);
	}
	
	private void setupTable()
	{
		//one D array for column titles
		//2D array for contents.
		displayPane = new JScrollPane(tabledata);
	}
	
	public void setupPane()
	{
		
	}
	
	public void setupLayout()
	{
		baselayout.putConstraint(SpringLayout.NORTH, displayPane, 100, SpringLayout.NORTH, this);
	}
	
	public void setupListeners()
	{
		appButton.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent click)
		{
			String databaseAnswer = baseController.getDatabase().descibeTable();
					DisplayArea.setText(databaseAnswer);
		}
		});
	}
	
	

}
