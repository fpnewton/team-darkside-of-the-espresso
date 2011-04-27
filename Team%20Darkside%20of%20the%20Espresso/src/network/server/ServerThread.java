// $codepro.audit.disable cyclomaticComplexity, booleanMethodNamingConvention
/**
 * The ServerThread Class.
 */

package network.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;

import log.SystemLog;
import network.Message;
import network.MessageKey;
import users.User;


/**
 * The ServerThread Class.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class ServerThread implements Runnable {

	/** The server shutdown message. */
	private static final String SERVER_DOWN_MESSAGE = "The server is going down NOW!";

	/** The client disconnect message. */
	private static final String CLIENT_DISCONNECT_MESSAGE = 
		"The client has disconnected.";

	/** The INVALI d_ message. */
	private static final String INVALID_MESSAGE = "Error: Invalid message from client.";

	/** The connection. */
	private Socket connection = null;

	/** The is done thread flag. */
	private boolean isDone;

	/** The is term flag to shutdown the server. */
	private boolean isTerm;

	/** The db handler. */
	private DbHandler dbHandler = null;

	/**
	 * Instantiates a new server thread.
	 * 
	 * @param client
	 *            the client
	 */
	public ServerThread(Socket client) {
		connection = client;
		isDone = false;
		isTerm = false;
		dbHandler = new DbHandler();
	}

	/**
	 * Run the main server thread.
	 */
	public void run() {
		ObjectInputStream stream = null;

		try {
			// Create an object stream to receive incoming messages from the
			// client
			stream = new ObjectInputStream(connection.getInputStream());

			while (!isDone) {
				// Stop the server thread if the client has disconnected
				if (connection.isClosed()) {
					// Log the client disconnect message
					if (!SystemLog.LogMessage(CLIENT_DISCONNECT_MESSAGE,
							Level.INFO)) {
						System.out.println("Error: Could not log message \""
								+ CLIENT_DISCONNECT_MESSAGE + "\".");
					}

					isDone = true;

					continue;
				}

				// Receive the message object from the client
				Message msg = (Message) stream.readObject();

				// Stop the server thread if a TERM message was sent
				if (msg.getKey() == MessageKey.TERM) {
					System.out.println(SERVER_DOWN_MESSAGE);

					if (!SystemLog.LogMessage(SERVER_DOWN_MESSAGE, Level.INFO)) {
						System.out.println("Error: Could not log message \""
								+ SERVER_DOWN_MESSAGE + "\".");
					}

					isDone = true;
					isTerm = true;
				} else {
					// Process all other messages
					processMessage(msg);
				}
			}
		} catch (Exception e) {
			for (StackTraceElement tr : e.getStackTrace()) {
				if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
					System.out.println(tr.toString());
				}
			}
		} finally {
			try {
				// Close the object stream for the incoming messages
				if (stream != null) {
					stream.close();
				}

				// Close the socket connection with the client
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				for (StackTraceElement tr : e.getStackTrace()) {
					if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
						System.out.println(tr.toString());
					}
				}
			}
		}
	}

	/**
	 * Did receive TERM message.
	 * 
	 * @return true, if successful
	 */
	public boolean didReceiveTerm() {
		return isTerm;
	}

	/**
	 * Process message.
	 * 
	 * @param message
	 *            The message to process
	 */
	private void processMessage(Message message) {
		switch (message.getKey()) {
		case NULL:
			// Discard message.
			break;

		case PING:
			messagePing(message);
			break;

		case ECHO:
			messageEcho(message);
			break;

		case DISCONNECT:
			messageDisconnect(message);
			break;

		case DB_LOGIN:
			messageLogin(message);
			break;

		case DB_LOGOUT:
			messageLogout(message);
			break;

		case DB_GETUSER:
			try {
				dbHandler.handleGetUser(Integer.parseInt(message.getData()),
						connection);
			} catch (Exception e) {
				for (StackTraceElement tr : e.getStackTrace()) {
					if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
						System.out.println(tr.toString());
					}
				}
			}

			break;

		case DB_GETALLUSERS:
			//dbHandler.handleGetAllUsers(connection);
			System.out.println("Done");
			break;

		case DB_CREATEUSER:
			dbHandler.handleCreateUser((User) message.getAttachment(),
					connection);
			break;

		case DB_UPDATEUSER:
			try {
				dbHandler.handleUpdateUser(Integer.parseInt(message.getData()),
						(User) message.getAttachment(), connection);
			} catch (Exception e) {
				for (StackTraceElement tr : e.getStackTrace()) {
					if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
						System.out.println(tr.toString());
					}
				}
			}

			break;

		case DB_DELETEUSER:
			try {
				dbHandler.handleDeleteUser(Integer.parseInt(message.getData()),
						connection);
			} catch (Exception e) {
				for (StackTraceElement tr : e.getStackTrace()) {
					if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
						System.out.println(tr.toString());
					}
				}
			}

			break;

		case DB_GETUSERLIST:
			// TODO
			break;

		default:
			System.out.println();

			if (!SystemLog.LogMessage(INVALID_MESSAGE, Level.SEVERE)) {
				System.out.println("Error: Could not write error message \""
						+ INVALID_MESSAGE + "\" to the system log.");
			}
			break;
		}
	}

	/**
	 * Message ping.
	 * 
	 * @param message
	 *            The message
	 */
	private void messagePing(Message message) {
		ObjectOutputStream stream = null;

		try {
			// Create the object stream
			stream = new ObjectOutputStream(connection.getOutputStream());

			// Write the object to the stream
			stream.writeObject(new Message(MessageKey.PING, "Hello!"));
			stream.flush();
		} catch (IOException e) {
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
			} catch (IOException e) {
				for (StackTraceElement tr : e.getStackTrace()) {
					if (!SystemLog.LogMessage(tr.toString(), Level.SEVERE)) {
						System.out.println(tr.toString());
					}
				}
			}
		}
	}

	/**
	 * Message echo.
	 * 
	 * @param message
	 *            The message
	 */
	private void messageEcho(Message message) {
		// Output the ECHO message to the terminal and system log
		System.out.println("Message Echo: " + message.getData());

		if (!SystemLog.LogMessage("Server Message Echo: " + message.getData(),
				Level.INFO)) {
			System.out.println("Error: Could not write message echo \""
					+ message.getData() + "\" to system log.");
		}
	}

	/**
	 * Message disconnect.
	 * 
	 * @param message
	 *            The message
	 */
	private void messageDisconnect(Message message) {
		System.out.println(CLIENT_DISCONNECT_MESSAGE);

		if (!SystemLog.LogMessage(CLIENT_DISCONNECT_MESSAGE, Level.INFO)) {
			System.out.println("Error: Could not write message \""
					+ CLIENT_DISCONNECT_MESSAGE + "\"" + message.getData()
					+ "\" to system log.");
		}
	}

	/**
	 * Message login.
	 * 
	 * @param message
	 *            The message
	 */
	private void messageLogin(Message message) {
		// TODO
	}

	/**
	 * Message logout.
	 * 
	 * @param message
	 *            The message
	 */
	private void messageLogout(Message message) {
		// TODO
	}

	/**
	 * Gets a textual representation of this object.
	 * 
	 * @return A string with this object
	 */
	public String toString() {
		return this.getClass().getName();
	}
}
