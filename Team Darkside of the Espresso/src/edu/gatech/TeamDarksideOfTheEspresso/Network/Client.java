/**
 * The Network Client Class.
 * 
 * @author	Fraser P. Newton
 * @date	March 16, 2011
 */

package edu.gatech.TeamDarksideOfTheEspresso.Network;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;

import edu.gatech.TeamDarksideOfTheEspresso.SystemLog.SystemLog;


public class Client
{

	/** The Client socket. */
	private Socket	ClientSocket;


	/**
	 * Instantiates a new client.
	 * 
	 * @throws UnknownHostException
	 *             The unknown host exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public Client() throws UnknownHostException, IOException
	{
		this("127.0.0.1", Network.CLIENT_PORT);
	}


	/**
	 * Instantiates a new client.
	 * 
	 * @param ip
	 *            The IP address of the server
	 * @throws UnknownHostException
	 *             The unknown host exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public Client(String ip) throws UnknownHostException, IOException
	{
		this(ip, Network.CLIENT_PORT);
	}


	/**
	 * Instantiates a new client.
	 * 
	 * @param ip
	 *            The IP address of the server
	 * @param port
	 *            The port to connect to the server
	 * @throws UnknownHostException
	 *             The unknown host exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public Client(String ip, int port) throws UnknownHostException, IOException
	{
		ClientSocket = new Socket(ip, port);
	}
	
	
	/**
	 * Instantiates a new client.
	 *
	 * @param ip The IP address of the server
	 * @param port The port the server is listening on
	 * @param channel The communication channel to use for the transmission
	 * @throws UnknownHostException the unknown host exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Client(String ip, int port, int channel) throws UnknownHostException, IOException
	{
		this(ip, port + channel);
	}


	/**
	 * Closes the client socket.
	 * 
	 * @return true, if successful and no exceptions were thrown
	 */
	public boolean Close()
	{
		try
		{
			// Close the client socket
			ClientSocket.close();
		}
		catch (IOException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);

			return false;
		}

		return true;
	}


	/**
	 * Send a message to the server.
	 * 
	 * @param message
	 *            The message to send to the server
	 * @return true, if successful and no exceptions were thrown
	 */
	public boolean SendMessage(Message message)
	{
		try
		{
			// Create an object stream to transport the message
			ObjectOutputStream objectStream = new ObjectOutputStream(ClientSocket.getOutputStream());
			
			// Write the message to the stream
			objectStream.writeObject(message);
			
			// Make sure all data has been sent and close the stream
			objectStream.flush();
			objectStream.close();
		}
		catch (UnknownHostException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);

			return false;
		}
		catch (IOException e)
		{
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);

			return false;
		}

		return true;
	}
}
