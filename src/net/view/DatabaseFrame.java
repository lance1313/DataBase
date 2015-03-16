package net.view;

import javax.swing.JFrame;

import net.DataBase.DatabaseControl;
import net.DataBase.appController;
/**
 * 
 * @author jlin3312
 * @version 1.0
 * this is the frame to hold th Gui for my databases.
 */
public class DatabaseFrame extends JFrame
{
	private DatabaseGUI GUI;
	private DatabaseControl control;
	private appController bc;
	
	public DatabaseFrame(appController baseController)
	{
		this.bc = baseController;
		// this.control = control;
		 GUI = new DatabaseGUI(bc);
		 setupFrame();
	}
	
	
	
	
	public void setupFrame()
	{
		
		// class can do to .
		this.setSize(404, 404);
		this.setResizable(true);
		this.setContentPane(GUI);// this means i can do all the parent
		this.setVisible(true);
	}


	

}
