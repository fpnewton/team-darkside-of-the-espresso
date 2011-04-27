/*
 * The Session Class.
 */

package network.server;

import java.net.Socket;

import users.User;


/**
 * The Session Class.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class Session {
	/** The client socket. */
	private final Socket clientSocket;

	/** The current user. */
	private final User currentUser;

	/**
	 * Instantiates a new session.
	 * 
	 * @param client
	 *            The Socket connection to the client for the session
	 * @param user
	 *            The user for the session
	 */
	public Session(Socket client, User user) {
		clientSocket = client;
		currentUser = user;
	}

	/**
	 * Gets the connection socket.
	 * 
	 * @return The connection socket
	 */
	public Socket getConnectionSocket() {
		return clientSocket;
	}

	/**
	 * Gets the current user.
	 * 
	 * @return The current user
	 */
	public User getCurrentUser() {
		return currentUser;
	}

	/**
	 * Converts this object to a String.
	 * 
	 * @return A String with the current user's name
	 */
	public String toString() {
		return "Current User: " + currentUser.getUserInformation().getName()
				+ ".\n";
	}
}
