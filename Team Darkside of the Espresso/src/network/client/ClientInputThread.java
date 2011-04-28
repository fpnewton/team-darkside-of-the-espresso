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
	
	public ClientInputThread(Socket socket)
	{
		connection = socket;
		msg = null;
	}
	
	public void run()
	{
		while (true)
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
