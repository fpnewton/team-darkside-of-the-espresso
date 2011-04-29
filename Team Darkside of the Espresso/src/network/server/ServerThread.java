/*
 * The Class ServerThread.
 */

package network.server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import log.SystemLog;
import network.Message;
import network.MessageKey;
import users.User;
import database.SqlDatabase;

/**
 * The Class ServerThread.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class ServerThread implements Runnable {

	/** The connection. */
	private Socket connection = null;

	/** The database. */
	private SqlDatabase database = null;

	/** The is done. */
	private boolean isDone;

	/**
	 * Instantiates a new server thread.
	 * 
	 * @param socket
	 *            the socket
	 * @param db
	 *            the db
	 */
	public ServerThread(Socket socket, SqlDatabase db) {
		database = db;
		connection = socket;
		isDone = false;
	}

	/**
	 * Thread loop
	 */
	public void run() {
		ObjectInputStream stream = null;
		try {
			stream = new ObjectInputStream(connection.getInputStream());

			while (!isDone) {
				try {
					Message input = (Message) stream.readObject();

					processMessage(input);
				} catch (EOFException e) {
					isDone = true;
					SystemLog.canLogMessage(e.toString(), Level.INFO);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Process message.
	 * 
	 * @param msg
	 *            the msg
	 */
	private void processMessage(Message msg) {
		switch (msg.getKey()) {
		case ECHO:
			System.out.println(msg.getData());
			break;

		case DB_GETUSERID:
			break;

		case DB_GETALLUSERS:
			final User users[] = database.getAllUsers();
			final List<User> userList = new ArrayList<User>();

			for (User u : users) {
				userList.add(u);
			}

			sendMessage(new Message(MessageKey.DB_GETALLUSERS, userList));
			break;

		case DB_CREATEUSER:
			break;

		case DB_UPDATEUSER:
			break;

		case DB_DELETEUSER:
			break;

		default:
			break;
		}
	}

	/**
	 * Send message.
	 * 
	 * @param msg
	 *            the msg
	 */
	private void sendMessage(Message msg) {
		ObjectOutputStream stream = null;

		try {
			stream = new ObjectOutputStream(connection.getOutputStream());

			stream.writeObject(msg);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				if (stream != null) {
					stream.flush();
					stream.close();
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * toString() override.
	 * 
	 * @return A string
	 */
	public String toString() {
		return this.getClass().getName();
	}
}
