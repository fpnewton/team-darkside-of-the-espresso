
package edu.gatech.TeamDarksideOfTheEspresso.HospitalServer;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;

import edu.gatech.TeamDarksideOfTheEspresso.SystemLog.SystemLog;
import edu.gatech.TeamDarksideOfTheEspresso.Users.Patient;
import edu.gatech.TeamDarksideOfTheEspresso.Users.PatientInfo;
import edu.gatech.TeamDarksideOfTheEspresso.Users.UserInfo;


public class UsersDbThread extends Thread
{
	private static final ReentrantReadWriteLock	RwLock				= new ReentrantReadWriteLock();
	private static final Lock					WriteLock			= RwLock.writeLock();

	private final String						strUserInfoTable	= "user_info";
	private final String						strUserTable		= "users";

	private Connection							dbConnection;
	private Statement							sqlStatement;


	public boolean OpenDatabase()
	{
		return OpenDatabase("DB/Users.db");
	}


	public boolean OpenDatabase(String Filename)
	{
		try
		{
			// Attempt to get mutex lock
			WriteLock.tryLock(60, TimeUnit.SECONDS);

			// Check if the file exists
			File file = new File(Filename);

			try
			{
				Class.forName("org.sqlite.JDBC");

				dbConnection = DriverManager.getConnection("jdbc:sqlite:" + Filename);

				if (!file.exists())
				{
					CreateNewDatabase();
				}
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
		}
		catch (InterruptedException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);

			return false;
		}

		return true;
	}


	public boolean CloseDatabase()
	{
		try
		{
			dbConnection.close();
			WriteLock.unlock();
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
		try
		{
			sqlStatement = dbConnection.createStatement();

			// Create the tables with dynamic data types
			sqlStatement.executeUpdate("DROP TABLE IF EXISTS " + strUserInfoTable + ";");
			sqlStatement.executeUpdate("CREATE TABLE " + strUserInfoTable + "('id', 'user_id', 'name', 'address', 'phone_number', 'social_security_number', 'email_address', 'birth_date');");
			sqlStatement.executeUpdate("DROP TABLE IF EXISTS " + strUserTable + ";");
			sqlStatement.executeUpdate("CREATE TABLE " + strUserTable + "('id', 'username', 'password_hash', 'gender', 'is_active');");
		}
		catch (SQLException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);

			return false;
		}

		return true;
	}


	public boolean InsertPatient(Patient user)
	{
		if (!InsertUserInfo(user.getUserInformation()))
		{
			SystemLog.LogMessage("Error: Could not insert user info for patient into the database.", Level.SEVERE);

			return false;
		}

		if (!InsertPatientInfo(user.getPatientInfo()))
		{
			SystemLog.LogMessage("Error: Could not insert patient info for patient into the database.", Level.SEVERE);

			return false;
		}

		return true;
	}


	private boolean InsertPatientInfo(PatientInfo info)
	{
		try
		{
			sqlStatement = dbConnection.createStatement();

			PreparedStatement prepStatement = dbConnection.prepareStatement("INSERT INTO patient_info VALUES(?, ?, ?, ?, ?, ?);");

			prepStatement.addBatch();

			dbConnection.setAutoCommit(false);
			prepStatement.executeBatch();
			dbConnection.setAutoCommit(true);
		}
		catch (SQLException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);
			
			return false;
		}

		return true;
	}


	private boolean InsertUserInfo(UserInfo info)
	{
		return true;
	}
}
