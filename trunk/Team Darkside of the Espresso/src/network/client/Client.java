package network.client;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import network.Message;
import network.MessageKey;

public class Client
{
	private Socket	connection;
	private boolean isSuccessful;
	private Runnable inputRunner;
	private Runnable outputRunner;
	private ArrayList<Message> messagePool;


	public Client(int port)
	{
		messagePool = new ArrayList<Message>();
		inputRunner = null;
		outputRunner = null;
		
		try
		{
			connection = new Socket(InetAddress.getByName("127.0.0.1"), port);

			System.out.println("Connected!");

			inputRunner = new ClientInputThread(connection);
			outputRunner = new ClientOutputThread(connection);

			Thread inputThread = new Thread(inputRunner);
			Thread outputThread = new Thread(outputRunner);

			inputThread.start();
			outputThread.start();
			
			((ClientOutputThread) outputRunner).sendMessage(new Message(MessageKey.DB_GETALLUSERS, ""));
			
			isSuccessful = true;
			
			while (inputThread.isAlive() && outputThread.isAlive())
			{
				Message msg = ((ClientInputThread) inputRunner).getMessage();
				
				if (msg != null)
				{
					messagePool.add(msg);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Client A");
			System.exit(-1);
			
			// TODO Alert user about unknown host
		}
	}
	
	public boolean isSuccessfulConnection()
	{
		return isSuccessful;
	}
	
	public void sendMessage(Message message)
	{
		((ClientOutputThread) outputRunner).sendMessage(message);
	}
	
	public Message popMessage(MessageKey key)
	{
		if (messagePool.size() > 0)
		{
			for (Message msg : messagePool)
			{
				if (msg.getKey() == key)
				{
					messagePool.remove(msg);
					
					return msg;
				}
			}
		}
		
		return null;
	}
}
