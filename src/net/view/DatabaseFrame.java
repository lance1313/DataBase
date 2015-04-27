package net.view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
		 setupListeners();
		
	}
	
	
	
	
	public void setupFrame()
	{
		
		// class can do to .
		this.setSize(404, 404);
		this.setResizable(true);
		this.setContentPane(GUI);// this means i can do all the parent
		this.setVisible(true);
	}
	
	private void setupListeners()
	{
		this.addWindowListener(new WindowListener()
				{

					@Override
					public void windowActivated(WindowEvent arg0)
					{
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosed(WindowEvent e)
					{
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosing(WindowEvent e)
					{
						bc.saveQueryTimingInfo();
						
					}
					
					@Override
					public void windowOpened(WindowEvent e)
					{
						
						
					}

					@Override
					public void windowDeactivated(WindowEvent e)
					{
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowDeiconified(WindowEvent e)
					{
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowIconified(WindowEvent e)
					{
						// TODO Auto-generated method stub
						
					}

					
			
				});
	}


	

}
