// $codepro.audit.disable cyclomaticComplexity
/*
 * The DbHandler Class.
 */

package network.server;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;

import database.SqlDatabase;
import log.SystemLog;
import network.Message;
import network.MessageKey;
import users.User;

/**
 * The DbHandler Class.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class DbHandler {

	/** The database. */
	private SqlDatabase database = null;

	/** The NULL database message. */
	private static final String NULL_DB_MESSAGE = "NULL database";

	/** The NULL connection socket message. */
	private static final String NULL_SOCKET_MESSAGE = "NULL socket";

	/** The NULL user object message. */
	private static final String NULL_USER_MESSAGE = "NULL user";

	/**
	 * Instantiates a new db handler.
	 */
	public DbHandler() {
		try {
			// Attempt to instantiate the database object
			database = new SqlDatabase();
		} catch (ClassNotFoundException e) {
			for (StackTraceElement tr : e.getStackTrace()) {
				if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
					System.out.println(tr.toString());
				}
			}
		}
	}

	/**
	 * Instantiates a new db handler.
	 * 
	 * @param db
	 *            the db
	 */
	public DbHandler(SqlDatabase db) {
		database = db;
	}

	/**
	 * Gets the user.
	 * 
	 * @param id
	 *            the id
	 * @param connection
	 *            the connection
	 */
	public void handleGetUser(int id, Socket connection) {
		// Check if the database and connection objects are valid
		if (database == null) {
			// Log the error
			if (!SystemLog.LogMessage("Error: " + NULL_DB_MESSAGE + ".",
					Level.SEVERE)) {
				System.out.println("Error: Could not write message \""
						+ NULL_DB_MESSAGE + "\" to system log.");
			}
		} else if (connection == null) {
			// Log the error
			if (!SystemLog.LogMessage("Error: " + NULL_SOCKET_MESSAGE + ".",
					Level.SEVERE)) {
				System.out.println("Error: Could not write message \""
						+ NULL_SOCKET_MESSAGE + "\" to system log.");
			}
		} else {
			// Object stream to the client
			ObjectOutputStream stream = null;

			try {
				// Create the object stream and get the user's User object
				stream = new ObjectOutputStream(connection.getOutputStream());

				// Send the User object back to the client
				stream.writeObject(new Message(MessageKey.DB_GETUSER, "User",
						database.getUser(id)));
				stream.flush();
			} catch (Exception e) {
				// Catch Integer.parseInt() and other exceptions
				for (StackTraceElement tr : e.getStackTrace()) {
					if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
						System.out.println(tr.toString());
					}
				}
			} finally {
				try {
					// Attempt to close the object stream
					if (stream != null) {
						stream.close();
					}
				} catch (Exception e) {
					// Catch null pointer and other exceptions
					for (StackTraceElement tr : e.getStackTrace()) {
						if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
							System.out.println(tr.toString());
						}
					}
				}
			}
		}
	}

	/**
	 * Gets the all users.
	 * 
	 * @param connection
	 *            the connection
	 */
	public void handleGetAllUsers(Socket connection) {
		// Check if the connection object is valid
		if (connection == null) {
			// Log the error
			if (!SystemLog.LogMessage("Error: " + NULL_SOCKET_MESSAGE + ".",
					Level.SEVERE)) {
				System.out.println("Error: Could not write message \""
						+ NULL_SOCKET_MESSAGE + "\" to system log.");
			}
		} else {
			// Object stream to the client
			ObjectOutputStream stream = null;

			try {
				// Create the object stream and get the user's User object
				stream = new ObjectOutputStream(connection.getOutputStream());

				// Send the User object back to the client
				stream.writeObject(new Message(MessageKey.DB_GETUSER, "User",
						database.getAllUsers()));
				stream.flush();
			} catch (Exception e) {
				// Catch Integer.parseInt() and other exceptions
				for (StackTraceElement tr : e.getStackTrace()) {
					if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
						System.out.println(tr.toString());
					}
				}
			} finally {
				try {
					// Attempt to close the object stream
					if (stream != null) {
						stream.close();
					}
				} catch (Exception e) {
					// Catch null pointer and other exceptions
					for (StackTraceElement tr : e.getStackTrace()) {
						if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
							System.out.println(tr.toString());
						}
					}
				}
			}
		}
	}

	/**
	 * Creates the user.
	 * 
	 * @param user
	 *            the user
	 * @param connection
	 *            the connection
	 */
	public void handleCreateUser(User user, Socket connection) {
		// Check if the database, connection, and user objects are valid
		if (database == null) {
			// Log the error
			if (!SystemLog.LogMessage("Error: " + NULL_DB_MESSAGE + ".",
					Level.SEVERE)) {
				System.out.println("Error: Could not write message \""
						+ NULL_DB_MESSAGE + "\" to system log.");
			}
		} else if (connection == null) {
			// Log the error
			if (!SystemLog.LogMessage("Error: " + NULL_SOCKET_MESSAGE + ".",
					Level.SEVERE)) {
				System.out.println("Error: Could not write message \""
						+ NULL_SOCKET_MESSAGE + "\" to system log.");
			}
		} else if (user == null) {
			// Log the error
			if (!SystemLog.LogMessage("Error: " + NULL_USER_MESSAGE + ".",
					Level.SEVERE)) {
				System.out.println("Error: Could not write message \""
						+ NULL_USER_MESSAGE + "\" to system log.");
			}
		} else {
			// Object stream to the client
			ObjectOutputStream stream = null;

			try {
				// Create the object stream and get the user's User object
				stream = new ObjectOutputStream(connection.getOutputStream());

				final boolean result = database.canInsertUser(user);

				// Send the User object back to the client
				stream.writeObject(new Message((result) ? MessageKey.SUCCESS
						: MessageKey.FAILURE, "CreateUser Result"));
				stream.flush();
			} catch (Exception e) {
				// Catch Integer.parseInt() and other exceptions
				for (StackTraceElement tr : e.getStackTrace()) {
					if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
						System.out.println(tr.toString());
					}
				}
			} finally {
				try {
					// Close the object stream
					if (stream != null) {
						stream.close();
					}
				} catch (Exception e) {
					// Catch null pointer and other exceptions
					for (StackTraceElement tr : e.getStackTrace()) {
						if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
							System.out.println(tr.toString());
						}
					}
				}
			}
		}
	}

	/**
	 * Update user.
	 * 
	 * @param id
	 *            the id
	 * @param user
	 *            the user
	 * @param connection
	 *            the connection
	 */
	public void handleUpdateUser(int id, User user, Socket connection) {
		// Check if the database, connection, and user objects are valid
		if (database == null) {
			// Log the error
			if (!SystemLog.LogMessage("Error: " + NULL_DB_MESSAGE + ".",
					Level.SEVERE)) {
				System.out.println("Error: Could not write message \""
						+ NULL_DB_MESSAGE + "\" to system log.");
			}
		} else if (connection == null) {
			// Log the error
			if (!SystemLog.LogMessage("Error: " + NULL_SOCKET_MESSAGE + ".",
					Level.SEVERE)) {
				System.out.println("Error: Could not write message \""
						+ NULL_SOCKET_MESSAGE + "\" to system log.");
			}
		} else if (user == null) {
			// Log the error
			if (!SystemLog.LogMessage("Error: " + NULL_USER_MESSAGE + ".",
					Level.SEVERE)) {
				System.out.println("Error: Could not write message \""
						+ NULL_USER_MESSAGE + "\" to system log.");
			}
		} else {
			// Object stream to the client
			ObjectOutputStream stream = null;

			try {
				// Create the object stream and get the user's User object
				stream = new ObjectOutputStream(connection.getOutputStream());

				final boolean result = database.updateUser(id, user);

				// Send the User object back to the client
				stream.writeObject(new Message((result) ? MessageKey.SUCCESS
						: MessageKey.FAILURE, "UpdateUser Result"));
				stream.flush();
			} catch (Exception e) {
				// Catch Integer.parseInt() and other exceptions
				for (StackTraceElement tr : e.getStackTrace()) {
					if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
						System.out.println(tr.toString());
					}
				}
			} finally {
				try {
					// Close the object stream
					if (stream != null) {
						stream.close();
					}
				} catch (Exception e) {
					// Catch null pointer and other exceptions
					for (StackTraceElement tr : e.getStackTrace()) {
						if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
							System.out.println(tr.toString());
						}
					}
				}
			}
		}
	}

	/**
	 * Delete user.
	 * 
	 * @param id
	 *            the id
	 * @param connection
	 *            the connection
	 */
	public void handleDeleteUser(int id, Socket connection) {
		// Check if the database, connection, and user objects are valid
		if (database == null) {
			// Log the error
			if (!SystemLog.LogMessage("Error: " + NULL_DB_MESSAGE + ".",
					Level.SEVERE)) {
				System.out.println("Error: Could not write message \""
						+ NULL_DB_MESSAGE + "\" to system log.");
			}
		} else if (connection == null) {
			// Log the error
			if (!SystemLog.LogMessage("Error: " + NULL_SOCKET_MESSAGE + ".",
					Level.SEVERE)) {
				System.out.println("Error: Could not write message \""
						+ NULL_SOCKET_MESSAGE + "\" to system log.");
			}
		} else {
			// Object stream to the client
			ObjectOutputStream stream = null;

			try {
				// Create the object stream and get the user's User object
				stream = new ObjectOutputStream(connection.getOutputStream());

				final boolean result = database.deleteUser(id);

				// Send the User object back to the client
				stream.writeObject(new Message((result) ? MessageKey.SUCCESS
						: MessageKey.FAILURE, "DeleteUser Result"));
				stream.flush();
			} catch (Exception e) {
				// Catch Integer.parseInt() and other exceptions
				for (StackTraceElement tr : e.getStackTrace()) {
					if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
						System.out.println(tr.toString());
					}
				}
			} finally {
				try {
					// Close the object stream
					if (stream != null) {
						stream.close();
					}
				} catch (Exception e) {
					// Catch null pointer and other exceptions
					for (StackTraceElement tr : e.getStackTrace()) {
						if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
							System.out.println(tr.toString());
						}
					}
				}
			}
		}
	}

	/**
	 * Gets the user list.
	 * 
	 * @param connection
	 *            the connection
	 */
	public void handleGetUserList(Socket connection) {
		// Check if the database, connection, and user objects are valid
		if (database == null) {
			// Log the error
			if (!SystemLog.LogMessage("Error: " + NULL_DB_MESSAGE + ".",
					Level.SEVERE)) {
				System.out.println("Error: Could not write message \""
						+ NULL_DB_MESSAGE + "\" to system log.");
			}
		} else if (connection == null) {
			// Log the error
			if (!SystemLog.LogMessage("Error: " + NULL_SOCKET_MESSAGE + ".",
					Level.SEVERE)) {
				System.out.println("Error: Could not write message \""
						+ NULL_SOCKET_MESSAGE + "\" to system log.");
			}
		} else {
			// Object stream to the client
			ObjectOutputStream stream = null;

			try {
				// Create the object stream and get the user's User object
				stream = new ObjectOutputStream(connection.getOutputStream());

				final User userList[] = database.getAllUsers();

				// Send the User object back to the client
				stream.writeObject(new Message(MessageKey.DB_GETUSERLIST,
						"GetUserList Result", userList));
				stream.flush();
			} catch (Exception e) {
				// Catch Integer.parseInt() and other exceptions
				for (StackTraceElement tr : e.getStackTrace()) {
					if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
						System.out.println(tr.toString());
					}
				}
			} finally {
				try {
					// Close the object stream
					if (stream != null) {
						stream.close();
					}
				} catch (Exception e) {
					// Catch null pointer and other exceptions
					for (StackTraceElement tr : e.getStackTrace()) {
						if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
							System.out.println(tr.toString());
						}
					}
				}
			}
		}
	}

	/**
	 * Converts the object to a string.
	 * 
	 * @return A string with the fully qualified name of the class
	 */
	public String toString() {
		return this.getClass().toString();
	}
}
