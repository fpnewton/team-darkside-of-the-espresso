package network;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;

import log.SystemLog;

public class ServerThread implements Runnable
{
	private final String	SERVER_DOWN_MESSAGE			= "The server is going down NOW!";
	private final String	CLIENT_DISCONNECT_MESSAGE	= "The client has disconnected.";

	private Socket			connection;
	private boolean			isDone;
	private boolean			isTerm;


	public ServerThread(Socket client)
	{
		connection = client;
		isDone = false;
		isTerm = false;
	}


	public void run()
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
					if (!SystemLog.LogMessage(CLIENT_DISCONNECT_MESSAGE, Level.INFO))
					{
						System.out.println("Error: Could not log message \""
								+ CLIENT_DISCONNECT_MESSAGE + "\".");
					}

					isDone = true;

					continue;
				}

				// Receive the message object from the client
				Message msg = (Message) stream.readObject();

				// Stop the server thread if a TERM message was sent
				if (msg.getKey() == MessageKey.TERM)
				{
					System.out.println(SERVER_DOWN_MESSAGE);

					if (!SystemLog.LogMessage(SERVER_DOWN_MESSAGE, Level.INFO))
					{
						System.out.println("Error: Could not log message \"" + SERVER_DOWN_MESSAGE + "\".");
					}

					isDone = true;
					isTerm = true;
				}
				else
				{
					// Process all other messages
					processMessage(msg);
				}
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


	public boolean didReceiveTerm()
	{
		return isTerm;
	}


	private void processMessage(Message message)
	{

		System.out.println("Message Echo: " + message.getData());

		if (!SystemLog.LogMessage("Server Message Echo: " + message.getData(), Level.INFO))
		{
			System.out.println("Error: Could not write message echo to system log.");
		}

	}
}
