package net.DataBase;

import java.util.ArrayList;

import net.model.QueryInfo;
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
	private ArrayList<QueryInfo> timingInfoList;
	
	public appController()
	{
		database = new DatabaseControl(this);
		appFrame = new DatabaseFrame(this);
		timingInfoList = new ArrayList<QueryInfo>();
		
	}
	/**
	 * the method to call other methods.
	 */
	public void start()
	{
		database.connectionStringBuilder("localHost", "keplarparts", "root", "");
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
	
	public ArrayList<QueryInfo> getTimingInfoList()
	{
		return timingInfoList;
	}

}
