package network.client;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

import network.Message;
import users.User;

public class ClientInputThread implements Runnable
{
private Socket connection;
	
	public ClientInputThread(Socket socket)
	{
		connection = socket;
	}
	
	public void run()
	{
		while (true)
		{
			try
			{
				ObjectInputStream oo = new ObjectInputStream(
						connection.getInputStream());
	
		
				Message input = (Message) oo.readObject();
				
				@SuppressWarnings("unchecked")
				ArrayList<User> list = (ArrayList<User>) input.getAttachment();
				System.out.println(list.get(0).getUsername());
				System.out.println(list.get(0).getUserInformation().getName());
				
				break;
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}
}
