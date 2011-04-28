package network.client;

import java.io.ObjectOutputStream;
import java.net.Socket;

import network.Message;
import network.MessageKey;

public class ClientOutputThread implements Runnable
{
	private Socket connection;
	private Message message;
	private boolean isDone;
	
	public ClientOutputThread(Socket socket)
	{
		connection = socket;
		message = null;
		isDone = false;
	}
	
	public void run()
	{
		while (!isDone)
		{
			try
			{		
				if (message != null)
				{
					ObjectOutputStream stream = new ObjectOutputStream(connection.getOutputStream());
					
					stream.writeObject(message);
					stream.flush();
					
					message = null;
					System.out.println("Sent!");
				}
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
	public void stop()
	{
		isDone = true;
	}
	
	public void sendMessage(Message msg)
	{
		message = msg;
	}
}
