package network.client;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

import network.Message;
import users.User;

public class ClientInputThread implements Runnable
{
	private Socket connection;
	private Message msg;
	private boolean isDone;
	
	public ClientInputThread(Socket socket)
	{
		connection = socket;
		msg = null;
		isDone = false;
	}
	
	public void run()
	{
		while (!isDone)
		{
			try
			{
				ObjectInputStream oo = new ObjectInputStream(connection.getInputStream());
				
				msg = (Message) oo.readObject();
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
	public Message getMessage()
	{
		return msg;
	}
}
