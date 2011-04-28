/*
 * The Class ClientInputThread.
 */

package network.client;

import java.io.ObjectInputStream;
import java.net.Socket;

import network.Message;

/**
 * The Class ClientInputThread.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class ClientInputThread implements Runnable {

	/** The connection. */
	private Socket connection = null;

	/** The msg. */
	private Message msg;

	/** The is done. */
	private boolean isDone;

	/**
	 * Instantiates a new client input thread.
	 * 
	 * @param socket
	 *            the socket
	 */
	public ClientInputThread(Socket socket) {
		connection = socket;
		msg = null;
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
					msg = (Message) stream.readObject();
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
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public Message getMessage() {
		return msg;
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
