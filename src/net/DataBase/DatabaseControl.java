package net.DataBase;

import java.sql.*;

import javax.swing.JOptionPane;

import com.mysql.*;

import net.view.DatabaseFrame;

/**
 * this is in charcge of talking to the database.
 * 
 * @author jlin3312
 * @version 1.2 fixed the error messages. this controles the actions betwwen the models and the view.
 */
public class DatabaseControl
{

	private DatabaseFrame Frame;
	private String connectionString;
	private Connection databaseConnection;
	// private DatabaseRunner baseControl;
	private appController baseController;
	private String currentQuery;

	/**
	 * creates a object with a reference to the appController
	 * 
	 * @param baseControl
	 *            this links the runner to the controlers constructor.
	 */
	public DatabaseControl(appController baseControl)
	{
		this.baseController = baseControl;
		
		// the way to talk to databases. order user-the host-tool
		connectionString = "jdbc:mysql://localhost/keplarparts?user=root";

		checkDrivers();
		setupConnection();

	}

	/**
	 * this checks if you can connect to the database and if not gives an error.
	 */
	private void checkDrivers()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");// looks inside my project run the name in side.
		}
		catch (Exception currentException)
		{
			displayErrors(currentException);
			System.exit(1);
		}
	}

	// use to connect to a database
	private void setupConnection()
	{
		try
		{
			databaseConnection = DriverManager.getConnection(connectionString);
		}
		catch (SQLException currentException)
		{
			displayErrors(currentException);
		}
	}

	public void closeConnection()
	{
		try
		{
			databaseConnection.close();// = DriverManager.getConnection(connectionString);
		}
		catch (SQLException error)
		{
			displayErrors(error);
		}
	}

	/**
	 * 
	 * @param currentException
	 *            this is the error to display
	 */
	private void displayErrors(Exception currentException)
	{
		JOptionPane.showMessageDialog(baseController.getAppFrame(), currentException.getMessage());

		if (currentException instanceof SQLException)
		{
			JOptionPane.showMessageDialog(baseController.getAppFrame(), "SQL State:" + ((SQLException) currentException));
			JOptionPane.showMessageDialog(baseController.getAppFrame(), "SQL Error code:" + ((SQLException) currentException));
		}

	}

	/**
	 * 
	 * @return this is the code that when ran it takes the server code and translates it in to a string
	 */
	public String displayTables()
	{
		String results = "";
		// list the tables that belong to my database.
		// to list a table to a database you must have a statment attatched.
		String query = "SHOW TABLES";

		try
		{
			// a statment is required to transfer
			Statement firstStatement = databaseConnection.createStatement();
			// resultSet is the data in the database server.
			ResultSet answer = firstStatement.executeQuery(query);
			// next is an iterator
			while (answer.next())
			{// every time it is called it reads the string and then shrinks the answer
				results += answer.getString(1) + "\n";
			}
			answer.close();
			firstStatement.close();

		}

		catch (SQLException currentSQLError)
		{
			displayErrors(currentSQLError);
		}

		return results;
	}
	
	/**
	 *  this is an important mathod to prevent altering
	 * @return stops checking them
	 */
	public boolean checkForDataViolation()
	{
		if(currentQuery.toUpperCase().contains("DROP")||
				 currentQuery.toUpperCase().contains("TRUNCATE")
				|| currentQuery.toUpperCase().contains("SET")
				|| currentQuery.toUpperCase().contains("ALTER"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String[][] selectQueryResults(String query)
	{
		

		// this is a safty net if other code fails and no data is present.
					this.currentQuery =  query;
					String  [] [] results;			
		
		try
		{
			
			if(checkForDataViolation())
			{
				
			}
			// a statment is required to transfer
						Statement firstStatement = databaseConnection.createStatement();
						// resultSet is the data in the database server.
						ResultSet answer = firstStatement.executeQuery(query);
						int columnCount = answer.getMetaData().getColumnCount();
						int rowCount = 1;
						answer.last();
						rowCount  = answer.getRow();
						
						// this line is telling the database that the one d array is relly a two d array with one row.
						results = new String[rowCount][columnCount];

						while (answer.next())
						{
							for(int col = 0; col < columnCount; col++)
							{
							// this gets the colom 0 and row is minus 1 because it staerts at 0.
							results[answer.getRow()-1][col] = answer.getString(col + 1);
							}
						}

						answer.close();
						firstStatement.close();
		}
		
		catch(SQLException currentSQLError)
		{
			// this is a safty net if other code fails and no data is present.
						results = new String[][]/* this says it is a 1x1 table. */{ { "problem occered :)" } };
						displayErrors(currentSQLError);
		}
		
		return results;
	}
	
	public String [] [] realResults()
	{
		String [] [] results;
		String query = "SELECT * FROM `INNODB_SYS_COLUMNS`";
		
		try
		{
			// a statment is required to transfer
						Statement firstStatement = databaseConnection.createStatement();
						// resultSet is the data in the database server.
						ResultSet answer = firstStatement.executeQuery(query);
						int columnCount = answer.getMetaData().getColumnCount();
						int rowCount = 1;
						answer.last();
						rowCount  = answer.getRow();
						
						// this line is telling the database that the one d array is relly a two d array with one row.
						results = new String[rowCount][columnCount];

						while (answer.next())
						{
							for(int col = 0; col < columnCount; col++)
							{
							// this gets the colom 0 and row is minus 1 because it staerts at 0.
							results[answer.getRow()-1][col] = answer.getString(col + 1);
							}
						}

						answer.close();
						firstStatement.close();
		}
		
		catch(SQLException currentSQLError)
		{
			// this is a safty net if other code fails and no data is present.
						results = new String[][]/* this says it is a 1x1 table. */{ { "problem occered :)" } };
						displayErrors(currentSQLError);
		}
		
		return results;
	}

	public String[][] tableInfo()
	{
		String[][] results = { { "default" } };
		String query = "SHOW TABLES";

		try
		{
			// a statment is required to transfer
			Statement firstStatement = databaseConnection.createStatement();
			// resultSet is the data in the database server.
			ResultSet answer = firstStatement.executeQuery(query);
			int rowCount = 1;
			answer.last();
			rowCount = answer.getRow();
			
			// this line is telling the database that the one d array is relly a two d array with one row.
			results = new String[rowCount][1];

			while (answer.next())
			{
				// this gets the colom 0 and row is minus 1 because it staerts at 0.
				results[1][1] = answer.getString(1);
			}

			answer.close();
			firstStatement.close();

		}

		catch (SQLException currentSQLError)
		{
			// this is a safty net if other code fails and no data is present.
			results = new String[][]/* this says it is a 1x1 table. */{ { "problem occered :)" } };
			displayErrors(currentSQLError);
		}

		return results;
	}

	public String[] getMetaData()
	{
		String[] colomnInformation;
		String query = "SHOW TABLES";

		try
		{

			Statement firstStatement = databaseConnection.createStatement();
			ResultSet answer = firstStatement.executeQuery(query);
			ResultSetMetaData myMeta = answer.getMetaData();

			colomnInformation = new String[myMeta.getColumnCount()];
			for (int spot = 0; spot < myMeta.getColumnCount(); spot++)
			{
				colomnInformation[spot] = myMeta.getColumnName(spot + 1);
			}

			answer.close();
			firstStatement.close();

		}

		catch (SQLException currentSQLError)
		{
			colomnInformation = new String[] { "nada exists" };
			displayErrors(currentSQLError);
		}
		return colomnInformation;
	}

	/**
	 * 
	 * @return it allows you to see inside database tables.
	 */
	public String descibeTable()
	{
		String results = "";
		// list the tables that belong to my database.
		// to list a table to a database you must have a statment attatched.
		String query = "DESCRIBE `contry`";

		try
		{
			// a statment is required to transfer
			Statement firstStatement = databaseConnection.createStatement();
			// resultSet is the data in the database server.
			ResultSet answer = firstStatement.executeQuery(query);
			// next is an iterator
			while (answer.next())
			{// every time it is called it reads the string and then shrinks the answer
				results += answer.getString(1) + "\t" + answer.getString(2) + "\t";
			}
			answer.close();
			firstStatement.close();

		}

		catch (SQLException currentSQLError)
		{
			displayErrors(currentSQLError);
		}

		return results;
	}

	// insert method
	public int describeTable()
	{
		int rowsAffected = 0;
		// this is were the database.table rows and then the values
		String insertQuery = "INSERT INTO `keplarparts`.`contry`(`ID`,`Name_of_contry`) VALUES (10,`hi`);";

		try
		{
			Statement insertStatement = databaseConnection.createStatement();
			rowsAffected = insertStatement.executeUpdate(insertQuery);
			insertStatement.close();
		}
		catch (SQLException currentSQLError)
		{
			displayErrors(currentSQLError);
		}

		return rowsAffected;

	}

}
