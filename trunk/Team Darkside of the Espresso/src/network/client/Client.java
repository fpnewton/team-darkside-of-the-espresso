/*
 * The Class Client.
 */

package network.client;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import network.Message;
import network.MessageKey;

// TODO: Auto-generated Javadoc
/**
 * The Class Client.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class Client {

	/** The connection. */
	private Socket connection = null;

	/** The input runner. */
	private Runnable inputRunner;

	/** The output runner. */
	private Runnable outputRunner;

	/** The input thread. */
	private Thread inputThread = null;

	/** The output thread. */
	private Thread outputThread = null;

	/** The message pool. */
	private List<Message> messagePool = null;

	/**
	 * Instantiates a new client.
	 * 
	 * @param port
	 *            the port
	 */
	public Client(int port) {
		messagePool = new ArrayList<Message>();
		inputRunner = null;
		outputRunner = null;

		try {
			connection = new Socket(InetAddress.getByName("127.0.0.1"), port);

			System.out.println("Connected!");

			inputRunner = new ClientInputThread(connection);
			outputRunner = new ClientOutputThread(connection);

			inputThread = new Thread(inputRunner, "ClientInputThread");
			outputThread = new Thread(outputRunner, "ClientOutputThread");

			inputThread.start();
			outputThread.start();
		} catch (Exception e) {
			System.out.println("here");
			System.out.println(e);

			// TODO Alert user about unknown host
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Send message.
	 * 
	 * @param message
	 *            the message
	 */
	public void sendMessage(Message message) {
		// try
		// {
		// ObjectOutputStream stream = new
		// ObjectOutputStream(connection.getOutputStream());
		//
		// stream.writeObject(message);
		// stream.flush();
		// }
		// catch (Exception e)
		// {
		// System.out.println("ME");
		// System.out.println(e);
		// }
		// ((ClientOutputThread) outputRunner).sendMessage(message);
		((ClientOutputThread) outputRunner).sendMessage(new Message(
				MessageKey.DB_GETALLUSERS));
	}

	/**
	 * Pop message.
	 * 
	 * @return the message
	 */
	public Message popMessage() {
		return ((ClientInputThread) inputRunner).getMessage();
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
