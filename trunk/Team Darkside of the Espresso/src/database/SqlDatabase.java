// $codepro.audit.disable numericLiterals, variableShouldBeFinal, nullPointerDereference
/*
 * SQL Database Class.
 */

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
import java.util.List;
import java.util.logging.Level;

import users.User;

import log.SystemLog;

/**
 * SQL Database Class.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class SqlDatabase {

	/** The db connection. */
	private Connection dbConnection;

	/** The SQL transaction statement. */
	private Statement sqlStatement;

	/**
	 * Loads the SQLite JDBC connector.
	 * 
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public SqlDatabase() throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC"); // $codepro.audit.disable
											// com.instantiations.assist.eclipse.analysis.unusedReturnValue
	}

	/**
	 * Creates the database tables.
	 * 
	 * @return true, if successful
	 */
	public boolean canCreateTables() {
		boolean isSuccessful = true;

		try {
			dbConnection = DriverManager
					.getConnection("jdbc:sqlite:DB/Users.db");

			sqlStatement = dbConnection.createStatement();

			final int results = sqlStatement
					.executeUpdate("DROP TABLE IF EXISTS users;");
			sqlStatement.executeUpdate("CREATE TABLE users"
					+ "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
					+ "name VARCHAR(255), username VARCHAR(255), "
					+ "password_hash VARCHAR(255), data);");

			SystemLog.LogMessage("Execute Update results: " + results,
					Level.SEVERE);
		} catch (SQLException e) {
			isSuccessful = false;

			handleException(e);
		} finally {
			try {
				if (sqlStatement != null) {
					sqlStatement.close();
				}

				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (SQLException e) {
				isSuccessful = false;

				handleException(e);
			}
		}

		return isSuccessful;
	}

	/**
	 * Insert user into the database.
	 * 
	 * @param user
	 *            the user
	 * @return true, if successful
	 */
	public boolean canInsertUser(User user) {
		PreparedStatement prepStatement = null;
		boolean isSuccessful = true;

		try {
			dbConnection = DriverManager
					.getConnection("jdbc:sqlite:DB/Users.db");

			prepStatement = dbConnection
					.prepareStatement("INSERT INTO users VALUES(NULL, ?, ?, ?, ?);");

			prepStatement.setString(1, user.getUserInformation().getName());
			prepStatement.setString(2, user.getUsername());
			prepStatement.setString(3, user.getPasswordHash());
			prepStatement.setBytes(4, getObjectBytes(user));
			prepStatement.execute();
		} catch (SQLException e) {
			isSuccessful = false;

			handleException(e);
		} catch (IOException e) {
			isSuccessful = false;

			handleException(e);
		} finally {
			try {
				if (prepStatement != null) {
					prepStatement.close();
				}

				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (SQLException e) {
				isSuccessful = false;

				handleException(e);
			}
		}

		return isSuccessful;
	}

	/**
	 * Can update user.
	 * 
	 * @param id
	 *            the id
	 * @param user
	 *            the user
	 * @return true, if successful
	 */
	public boolean canUpdateUser(int id, User user) {
		PreparedStatement prepStatement = null;
		boolean isSuccessful = true;

		try {
			dbConnection = DriverManager
					.getConnection("jdbc:sqlite:DB/Users.db");

			prepStatement = dbConnection
					.prepareStatement("UPDATE OR ROLLBACK users SET name = ?, username = ?, password_hash = ?, data = ? WHERE id = '"
							+ id + "';");

			prepStatement.setString(1, user.getUserInformation().getName());
			prepStatement.setString(2, user.getUsername());
			prepStatement.setString(3, user.getPasswordHash());
			prepStatement.setBytes(4, getObjectBytes(user));

			prepStatement.executeUpdate();
		} catch (SQLException e) {
			handleException(e);

			isSuccessful = false;
		} catch (IOException e) {
			handleException(e);

			isSuccessful = false;
		} finally {
			try {
				if (prepStatement != null) {
					prepStatement.close();
				}

				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (SQLException e) {
				handleException(e);

				isSuccessful = false;
			}
		}

		return isSuccessful;
	}

	/**
	 * Can delete user.
	 * 
	 * @param id
	 *            the id
	 * @return true, if successful
	 */
	public boolean canDeleteUser(int id) {
		boolean isSuccessful = true;

		try {
			dbConnection = DriverManager
					.getConnection("jdbc:sqlite:DB/Users.db");

			sqlStatement = dbConnection.createStatement();

			sqlStatement.executeUpdate("DELETE FROM users WHERE id = '" + id
					+ "';");
		} catch (SQLException e) {
			isSuccessful = false;

			handleException(e);
		} finally {
			try {
				if (sqlStatement != null) {
					sqlStatement.close();
				}

				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (SQLException e) {
				isSuccessful = false;

				handleException(e);
			}
		}

		return isSuccessful;
	}

	/**
	 * Gets the user id.
	 * 
	 * @param name
	 *            the name
	 * @return the user id
	 */
	// public int getUserID(String name) {
	// int id = -1;
	//
	// try {
	// ResultSet results;
	//
	// sqlStatement = dbConnection.createStatement();
	// results = sqlStatement.executeQuery("SELECT * FROM users WHERE name='" +
	// name
	// + "';");
	//
	// results.next();
	//
	// id = results.getInt("id");
	//
	// sqlStatement.close();
	// } catch (SQLException e) {
	// handleException(e);
	// }
	//
	// return id;
	// }
	public int getUserID(String name) {
		try {
			dbConnection = DriverManager
					.getConnection("jdbc:sqlite:DB/Users.db");
			ResultSet results = null;

			if (dbConnection != null) {
				results = dbConnection.createStatement().executeQuery(
						"SELECT * FROM users;");
			}

			if (results != null) {
				while (results.next()) {
					Object obj = getDatabaseObject(results, "data");
					User user = (User) obj;

					if (user.getUserInformation().getName().equals(name)) {
						return results.getInt("id");
					}
				}
			} else {
				if (!SystemLog
						.LogMessage(
								"Error: Unexpected null pointer defreferenced in sqlDatabase.",
								Level.SEVERE)) {
					System.out.println("Error: Unexpected null pointer "
							+ "defreferenced in sqlDatabase.");
				}
			}

		} catch (IOException e) {
			if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
				e.printStackTrace();
			}
		} finally {
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
						e.printStackTrace();
					}
				}
			}
		}

		return -1;
	}

	/**
	 * Gets the user.
	 * 
	 * @param id
	 *            the id
	 * @return the user
	 */
	public User getUser(int id) {
		return (User) getObject("data", id)[0];
	}

	/**
	 * Gets the all users.
	 * 
	 * @return the all users
	 */
	public User[] getAllUsers() {
		try {
			dbConnection = DriverManager
					.getConnection("jdbc:sqlite:DB/Users.db");

			ArrayList<User> output = new ArrayList<User>();
			ResultSet results = dbConnection.createStatement().executeQuery(
					"SELECT * FROM users;");

			if (results != null) {
				while (results.next()) {
					Object obj = getDatabaseObject(results, "data");
					output.add((User) obj);
				}
			} else {
				if (!SystemLog
						.LogMessage(
								"Error: Unexpected null pointer defreferenced in sqlDatabase.",
								Level.SEVERE)) {
					System.out.println("Error: Unexpected null pointer "
							+ "defreferenced in sqlDatabase.");
				}
			}

			return output.toArray(new User[output.size()]);
		} catch (IOException e) {
			if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
				e.printStackTrace();
			}
		} finally {
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
						e.printStackTrace();
					}
				}
			}
		}

		User[] ret = new User[0];

		return ret;
	}

	/**
	 * Gets the object.
	 * 
	 * @param columnName
	 *            the column name
	 * @param id
	 *            the id
	 * @return the object
	 */
	public Object[] getObject(String columnName, int id) {
		try {
			// dbConnection =
			// DriverManager.getConnection("jdbc:sqlite:DB/Users.db");
			List<Object> output = new ArrayList<Object>();
			ResultSet results = dbConnection.createStatement().executeQuery(
					"SELECT * FROM users WHERE id='" + id + "';");

			if (results != null) {
				while (results.next()) {
					Object obj = getDatabaseObject(results, columnName);
					output.add((User) obj);
				}
			} else {
				SystemLog
						.LogMessage(
								"Error: Unexpected null pointer defreferenced in sqlDatabase.",
								Level.SEVERE);
			}

			return output.toArray();
		} catch (IOException e) {
			if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
				e.printStackTrace();
			}

			User[] ret = new User[0];

			return ret;
		} catch (SQLException e) {
			if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
				e.printStackTrace();
			}

			User[] ret = new User[0];

			return ret;
		} catch (ClassNotFoundException e) {
			if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
				e.printStackTrace();
			}

			User[] ret = new User[0];

			return ret;
		} finally {
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * Gets the object bytes.
	 * 
	 * @param object
	 *            the object
	 * @return the object bytes
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private byte[] getObjectBytes(Object object) throws IOException {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
		byte[] ret = null;

		try {
			objectStream.writeObject(object);
			ret = byteStream.toByteArray();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			objectStream.close();
			byteStream.close();
		}

		return ret;
	}

	/**
	 * Gets the database object.
	 * 
	 * @param results
	 *            the results
	 * @param column
	 *            the column
	 * @return the database object
	 * @throws SQLException
	 *             the sQL exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	private static Object getDatabaseObject(ResultSet results, String column)
			throws SQLException, IOException, ClassNotFoundException {
		byte[] buffer = results.getBytes(column);

		if (buffer != null) {
			ByteArrayInputStream byteStream = new ByteArrayInputStream(buffer);
			ObjectInputStream objectStream = new ObjectInputStream(byteStream);
			Object ret = objectStream.readObject();

			objectStream.close();
			byteStream.close();

			return ret;
		}

		return null;
	}

	/**
	 * Handle exception.
	 * 
	 * @param e
	 *            the e
	 */
	private void handleException(Exception e) {
		if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
			e.printStackTrace();
		}
	}

	/**
	 * toString() Override.
	 * 
	 * @return An empty String
	 */
	public String toString() {
		return "";
	}
}
