package network.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;

import log.SystemLog;
import network.Message;



public class ClientOutputThread implements Runnable
{
	private Socket connection;
	private Message tempMessage;
	private boolean isDone;
	
	public ClientOutputThread(Socket clientSocket)
	{
		connection = clientSocket;
		tempMessage = null;
	}

	public void run()
	{
		ObjectOutputStream stream = null;
		
		try
		{
			stream = new ObjectOutputStream(connection.getOutputStream());
			
			while (!isDone)
			{
				try
				{				
					if (tempMessage != null)
					{
						stream.writeObject(tempMessage);
						
						tempMessage = null;
					}
				}
				catch (IOException e)
				{
					if (!SystemLog.LogMessage(e.getStackTrace().toString(), Level.SEVERE))
					{
						e.printStackTrace();
					}
				}
			}
		}
		catch (IOException e)
		{
			if (!SystemLog.LogMessage(e.getStackTrace().toString(), Level.SEVERE))
			{
				e.printStackTrace();
			}
		}
		finally
		{
			try
			{
				stream.close();
				connection.close();
			}
			catch (IOException e)
			{
				if (!SystemLog.LogMessage(e.getStackTrace().toString(), Level.SEVERE))
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public void sendMessage(Message message)
	{
		tempMessage = message;
	}
	
	public void terminate()
	{
		isDone = true;
	}
}
