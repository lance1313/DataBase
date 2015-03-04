package net.view;

import javax.swing.JFrame;

import net.DataBase.DatabaseControl;
/**
 * 
 * @author jlin3312
 * @version .1
 * this is the frame to hold th Gui for my databases.
 */
public class DatabaseFrame extends JFrame
{
	private DatabaseGUI GUI;
	private DatabaseControl control;
	
	public DatabaseFrame()
	{
		
		// this.control = control;
		 GUI = new DatabaseGUI();
		 setupFrame();
	}
	
	
	
	
	public void setupFrame()
	{
		this.setContentPane(GUI);// this means i can do all the parent
		// class can do to .
		this.setSize(1000, 1000);
		this.setResizable(true);
		this.setVisible(true);
	}


	

}
