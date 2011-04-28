/*
 * The Class ClientOutputThread.
 */

package network.client;

import java.io.ObjectOutputStream;
import java.net.Socket;

import network.Message;

/**
 * The Class ClientOutputThread.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class ClientOutputThread implements Runnable {

	/** The connection. */
	private Socket connection = null;

	/** The message. */
	private Message message;

	/** The is done. */
	private boolean isDone;

	/**
	 * Instantiates a new client output thread.
	 * 
	 * @param socket
	 *            the socket
	 */
	public ClientOutputThread(Socket socket) {
		connection = socket;
		message = null;
		isDone = false;
	}

	/**
	 * Thread loop
	 */
	public void run() {
		ObjectOutputStream stream = null;

		try {
			stream = new ObjectOutputStream(connection.getOutputStream());
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

		while (!isDone) {
			try {
				if (message != null) {
					stream.writeObject(message);
					stream.flush();

					message = null;
					System.out.println("Sent!");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Stop.
	 */
	public void stop() {
		isDone = true;
	}

	/**
	 * Send message.
	 * 
	 * @param msg
	 *            the msg
	 */
	public void sendMessage(Message msg) {
		message = msg;
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
