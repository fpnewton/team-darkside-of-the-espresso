
package edu.gatech.TeamDarksideOfTheEspresso.HospitalServer;


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
import java.util.logging.Level;

import edu.gatech.TeamDarksideOfTheEspresso.SystemLog.SystemLog;
import edu.gatech.TeamDarksideOfTheEspresso.Users.User;
import edu.gatech.TeamDarksideOfTheEspresso.Users.UserInfo;


public class Database
{
	private final String	strUserInfoTable	= "user_info";
	private final String	strUserTable		= "users";

	private Connection		dbConnection;
	private Statement		sqlStatement;
	private boolean			isInitialized;
	private static int		count				= 0;


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

		// try
		// {
		// Class.forName("org.sqlite.JDBC");
		// Connection conn =
		// DriverManager.getConnection("jdbc:sqlite:DB/test.db");
		// Statement stat = conn.createStatement();
		// stat.executeUpdate("drop table if exists people;");
		// stat.executeUpdate("create table people (name, occupation);");
		// PreparedStatement prep =
		// conn.prepareStatement("insert into people values (?, ?);");
		//
		// prep.setString(1, "Gandhi");
		// prep.setString(2, "politics");
		// prep.addBatch();
		// prep.setString(1, "Turing");
		// prep.setString(2, "computers");
		// prep.addBatch();
		// prep.setString(1, "Wittgenstein");
		// prep.setString(2, "smartypants");
		// prep.addBatch();
		//
		// conn.setAutoCommit(false);
		// prep.executeBatch();
		// conn.setAutoCommit(true);
		//
		// ResultSet rs = stat.executeQuery("select * from people;");
		// while (rs.next())
		// {
		// System.out.println("name = " + rs.getString("name"));
		// System.out.println("job = " + rs.getString("occupation"));
		// }
		// rs.close();
		// conn.close();
		// }
		// catch (ClassNotFoundException e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// catch (SQLException e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// return true;
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


	public boolean InsertObject(UserInfo user)
	{
		if (!isInitialized)
		{
			return false;
		}

		try
		{
			sqlStatement = dbConnection.createStatement();

			PreparedStatement prep = dbConnection.prepareStatement("INSERT INTO users VALUES(?, ?, ?, ?, ?, ?);");

			try
			{
				write(user, prep);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			prep.execute();
		}
		catch (SQLException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);

			return false;
		}

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

			// Create the tables with dynamic data types
			sqlStatement.executeUpdate("DROP TABLE IF EXISTS " + strUserInfoTable + ";");
			sqlStatement.executeUpdate("CREATE TABLE " + strUserInfoTable + "('id', 'user_id', 'name', 'address', 'phone_number', 'social_security_number', 'email_address', 'birth_date');");
			sqlStatement.executeUpdate("DROP TABLE IF EXISTS " + strUserTable + ";");
			sqlStatement.executeUpdate("CREATE TABLE " + strUserTable + "('id', 'username', 'password_hash', 'gender', 'user_info', 'is_active');");
		}
		catch (SQLException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);

			return false;
		}

		return true;
	}


	public UserInfo getUser(int id)
	{
		try
		{
			ResultSet rs = sqlStatement.executeQuery("SELECT * FROM users;");
			while (rs.next())
			{
				Object obj = read(rs, "user_info");
				UserInfo p = (UserInfo) obj;
				
				return p;
			}
			rs.close();
		}
		catch (SQLException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);

			return null;
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}


	public static void write(Object obj, PreparedStatement ps) throws SQLException, IOException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oout = new ObjectOutputStream(baos);
		oout.writeObject(obj);
		oout.close();
		ps.setBytes(1, baos.toByteArray());
		ps.setInt(2, ++count);
	}


	public static Object read(ResultSet rs, String column) throws SQLException, IOException, ClassNotFoundException
	{
		byte[] buf = rs.getBytes(column);
		if (buf != null)
		{
			ObjectInputStream objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
			return objectIn.readObject();
		}
		return null;
	}
}
