package network.client;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import log.SystemLog;
import network.Message;



public class ClientInputThread implements Runnable
{
	private final String SERVER_DISCONNECT_MESSAGE = "The server has disconnected.";
	
	private Socket connection;
	private List<Message> messagePool;
	private boolean isDone;
	
	public ClientInputThread(Socket clientSocket)
	{
		messagePool = new ArrayList<Message>();
		
		connection = clientSocket;
		
		isDone = false;
	}
	
	public void run()
	{
		while (!isDone)
		{
			try
			{
				// Create an object stream to receive incoming messages from the
				// client
				ObjectInputStream stream = new ObjectInputStream(connection.getInputStream());

				while (!isDone)
				{
					// Stop the server thread if the client has disconnected
					if (connection.isClosed())
					{
						// Log the client disconnect message
						if (!SystemLog.LogMessage(SERVER_DISCONNECT_MESSAGE, Level.INFO))
						{
							System.out.println("Error: Could not log message \"" + SERVER_DISCONNECT_MESSAGE + "\".");
						}

						isDone = true;

						continue;
					}

					// Receive the message object from the client
					Message msg = (Message) stream.readObject();
					
					messagePool.add(msg);
				}

				// Close the object stream for the incoming messages
				stream.close();

				// Close the socket connection with the client
				connection.close();
			}
			catch (Exception e)
			{
				if (!SystemLog.LogMessage(e.getStackTrace().toString(), Level.SEVERE))
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public int getMessagePoolSize()
	{
		return messagePool.size();
	}
	
	public Message popMessage()
	{
		if (messagePool.size() < 1)
		{
			return null;
		}
		
		Message msg = messagePool.get(0);
		
		messagePool.remove(0);
		
		return msg;
	}
}
