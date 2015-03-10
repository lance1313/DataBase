package net.DataBase;

import net.view.DatabaseFrame;
/**
 * this controlles the GUI and the table.
 * @author jlin3312
 *@version 1.1 I added the 2 methods
 *
 */
public class appController
{
	private DatabaseFrame appFrame;
	private static DatabaseControl database;
	
	public appController()
	{
		database = new DatabaseControl(null);
		appFrame = new DatabaseFrame();
	}
	
	public void start()
	{
		
	}
	/**
	 * 
	 * @return  returns its self
	 * makes a method for other classes to access.
	 */
	public DatabaseFrame getAppFrame()
	{
		return appFrame;
		
	}
	/**
	 * 
	 * @return
	 * returns its self
	 */
	public DatabaseControl getDatabase()
	{
		return database;
		
	}

}
