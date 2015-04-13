package net.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

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
	private appController baseController;
	private JTable tabledata;
	private JPasswordField password;
	
	public DatabaseGUI(appController bc)
	{
		this.baseController = bc;
		appButton = new JButton("Query");
		DisplayArea = new JTextArea(10,30);
		//displayPane = new JScrollPane(DisplayArea);
		baselayout = new SpringLayout();
		password = new JPasswordField(null,30);
		
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
		this.add(password);
		//password.setEchoChar(``);
		password.setFont(new Font("Serif", Font.BOLD, 30));
		//cellRenderer = new 
	}
	
	private void setupTable()
	{
		//one D array for column titles
		//2D array for contents.
		tabledata = new JTable(baseController.getDatabase().tableInfo(),baseController.getDatabase().getMetaData());
		displayPane = new JScrollPane(tabledata);
		for(int spot = 0; spot < tabledata.getColumnCount();spot++)
		{
			//tabledata.getColumnModel().getColumn(spot).setCellRenderer(cellRenderer);
		}
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
