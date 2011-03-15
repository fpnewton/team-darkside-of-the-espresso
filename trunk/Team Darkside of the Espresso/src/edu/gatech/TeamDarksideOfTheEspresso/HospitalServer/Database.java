
package edu.gatech.TeamDarksideOfTheEspresso.HospitalServer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import edu.gatech.TeamDarksideOfTheEspresso.SystemLog.SystemLog;


public class Database
{
	private final String	strUserInfoTable	= "user_info";
	private final String	strUserTable		= "users";
	
	private Connection	dbConnection;
	private Statement	sqlStatement;
	private boolean		isInitialized;
	
	
	public boolean InitializeDB()
	{
		isInitialized = false;
		
		try
		{
			Class.forName("org.sqlite.JDBC");
			
			dbConnection = DriverManager.getConnection("jdbc:sqlite:DB/Data.db");
		}
		catch (ClassNotFoundException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);
			
			return false;
		}
		catch (SQLException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);
			
			return false;
		}
		
		isInitialized = true;
		
		return true;
		
		
		
//		try
//		{
//			Class.forName("org.sqlite.JDBC");
//			Connection conn = DriverManager.getConnection("jdbc:sqlite:DB/test.db");
//			Statement stat = conn.createStatement();
//			stat.executeUpdate("drop table if exists people;");
//			stat.executeUpdate("create table people (name, occupation);");
//			PreparedStatement prep = conn.prepareStatement("insert into people values (?, ?);");
//
//			prep.setString(1, "Gandhi");
//			prep.setString(2, "politics");
//			prep.addBatch();
//			prep.setString(1, "Turing");
//			prep.setString(2, "computers");
//			prep.addBatch();
//			prep.setString(1, "Wittgenstein");
//			prep.setString(2, "smartypants");
//			prep.addBatch();
//
//			conn.setAutoCommit(false);
//			prep.executeBatch();
//			conn.setAutoCommit(true);
//
//			ResultSet rs = stat.executeQuery("select * from people;");
//			while (rs.next())
//			{
//				System.out.println("name = " + rs.getString("name"));
//				System.out.println("job = " + rs.getString("occupation"));
//			}
//			rs.close();
//			conn.close();
//		}
//		catch (ClassNotFoundException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		catch (SQLException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return true;
	}
	
	
	public boolean CloseDbConnection()
	{
		if (isInitialized)
		{
			try
			{
				dbConnection.close();
			}
			catch (SQLException e)
			{
				SystemLog.LogMessage(e.getMessage(), Level.SEVERE);
				
				isInitialized = false;
				
				return false;
			}
		}
		
		isInitialized = false;
		
		return true;
	}
	
	
	public boolean CreateNewDatabase()
	{
		if (!isInitialized)
		{
			return false;
		}
		
		try
		{
			sqlStatement = dbConnection.createStatement();
			
			sqlStatement.executeUpdate("DROP TABLE IF EXISTS " + strUserInfoTable + ";");
			sqlStatement.executeUpdate("CREATE TABLE " + strUserInfoTable + "(id, name, address, phone_number, social_security_number, email_address, birth_date);");
		}
		catch (SQLException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);
			
			return false;
		}
		
		return true;
	}
}
