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
		database = new DatabaseControl(this);
		appFrame = new DatabaseFrame(this);
		
	}
	/**
	 * the method to call other methods.
	 */
	public void start()
	{
		database.connectionStringBuilder(pathToServer, databaseName, user, password);
		database.setupConnection();
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
