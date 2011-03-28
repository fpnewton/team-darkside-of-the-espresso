/**
 * The Server Class.
 * 
 * @author	Fraser P. Newton
 * @date	March 16, 2011
 */

package network;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;

import log.SystemLog;



public class Server
{

	/** The Server socket. */
	private ServerSocket	ServerSocket;


	/**
	 * Instantiates a new server.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public Server() throws IOException
	{
		this(Network.SERVER_PORT);
	}


	/**
	 * Instantiates a new server.
	 * 
	 * @param port
	 *            The port to listen for clients on
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public Server(int port) throws IOException
	{
		ServerSocket = new ServerSocket(port);
	}


	/**
	 * Instantiates a new server.
	 * 
	 * @param port
	 *            The port to listen for a client on
	 * @param channel
	 *            The communication channel that the client is transmitting data on
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public Server(int port, int channel) throws IOException
	{
		this(port + channel);
	}


	/**
	 * Receives a message from the client and returns the message object.
	 * 
	 * @return The message object that was received from the client
	 */
	public Message ReceiveMessage()
	{
		Message message;

		try
		{
			// Accept the client connection as a new socket
			Socket clientSocket = ServerSocket.accept();
			// Create an object stream to receive the data from the client
			ObjectInputStream objectStream = new ObjectInputStream(clientSocket.getInputStream());

			// Get the object from the stream data
			message = (Message) objectStream.readObject();

			// Close the object stream and client socket connection
			objectStream.close();
			clientSocket.close();

			return message;
		}
		catch (IOException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);
		}
		catch (ClassNotFoundException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);
		}

		return null;
	}
}
