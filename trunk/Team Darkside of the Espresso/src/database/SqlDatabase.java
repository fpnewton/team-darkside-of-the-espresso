
package database;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

import users.User;

import log.SystemLog;



public class SqlDatabase
{
	private Connection		dbConnection;
	private Statement		sqlStatement;

	private final String	strUserTable	= "users";


	/*
	 * Users Table: id, data_id, name, username, password_hash,
	 * last_login_attempts Data Table: id, user_id, data
	 */

	public boolean OpenDatabaseConnection()
	{
		try
		{
			// Attempt to load the SQLite connector
			Class.forName("org.sqlite.JDBC");

			dbConnection = DriverManager.getConnection("jdbc:sqlite:DB/Users.db");
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

		return true;
	}


	public boolean CloseDatabaseConnection()
	{
		try
		{
			// Attempt to close the database connection
			dbConnection.close();
		}
		catch (SQLException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);

			return false;
		}

		return true;
	}


	public boolean CreateNewDatabaseTables()
	{
		try
		{
			// Attempt to create a SQL statement
			sqlStatement = dbConnection.createStatement();

			sqlStatement.executeUpdate("DROP TABLE IF EXISTS " + strUserTable + ";");
			sqlStatement.executeUpdate("CREATE TABLE " + strUserTable + "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name, username, password_hash, data);");

			// Delete the SQL statement
			sqlStatement.close();
		}
		catch (SQLException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);

			return false;
		}

		return true;
	}


	public boolean InsertUser(User user)
	{
		try
		{
			PreparedStatement prepStatement = dbConnection.prepareStatement("INSERT INTO users VALUES(NULL, ?, ?, ?, ?);");

			prepStatement.setString(1, user.getUserInformation().getName());
			prepStatement.setString(2, user.getUsername());
			prepStatement.setString(3, user.getPasswordHash());
			prepStatement.setBytes(4, getObjectBytes(user));
			prepStatement.execute();

			prepStatement.close();
		}
		catch (SQLException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);

			return false;
		}
		catch (IOException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);

			return false;
		}

		return true;
	}


	public int getUserID(String Name)
	{
		int id = -1;

		try
		{
			ResultSet results;

			sqlStatement = dbConnection.createStatement();
			results = sqlStatement.executeQuery("SELECT * FROM users WHERE name='" + Name + "';");

			results.next();

			id = results.getInt("id");

			sqlStatement.close();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}


	public User getUser(int id)
	{
		try
		{
			ResultSet results;

			sqlStatement = dbConnection.createStatement();
			results = sqlStatement.executeQuery("SELECT * FROM users WHERE id='" + id + "';");

			results.next();

			User obj[] = (User[])getObject("data", id);

			sqlStatement.close();
			
			return obj[0];
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}


	public Object[] getObject(String ColumnName, int id)
	{
		try
		{
			ArrayList<Object> Out = new ArrayList<Object>();
			ResultSet Results = dbConnection.createStatement().executeQuery("SELECT * FROM users WHERE id= " + id + ";");

			while (Results.next())
			{
				Object obj = getDatabaseObject(Results, ColumnName);
				Out.add((User) obj);
			}

			return Out.toArray();
		}
		catch (IOException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);

			return null;
		}
		catch (SQLException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);

			return null;
		}
		catch (ClassNotFoundException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);

			return null;
		}
	}


	private byte[] getObjectBytes(Object object) throws SQLException, IOException
	{
		ByteArrayOutputStream ByteStream = new ByteArrayOutputStream();
		ObjectOutputStream ObjectStream = new ObjectOutputStream(ByteStream);

		ObjectStream.writeObject(object);
		ObjectStream.close();

		return ByteStream.toByteArray();
	}


	private static Object getDatabaseObject(ResultSet results, String column) throws SQLException, IOException, ClassNotFoundException
	{
		byte[] Buffer = results.getBytes(column);

		if (Buffer != null)
		{
			ByteArrayInputStream ByteStream = new ByteArrayInputStream(Buffer);
			ObjectInputStream ObjectStream = new ObjectInputStream(ByteStream);

			return ObjectStream.readObject();
		}

		return null;
	}
}
