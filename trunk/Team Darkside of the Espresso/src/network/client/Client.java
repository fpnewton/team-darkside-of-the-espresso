package network.client;

import java.net.InetAddress;
import java.net.Socket;

import network.Message;
import network.MessageKey;

public class Client
{
	private Socket	connection;
	private boolean isSuccessful;
	private Runnable inputRunner;
	private Runnable outputRunner;


	public Client(int port)
	{
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
//	
//	public int getMessagePoolSize()
//	{
//		return ((ClientInputThread) inputRunner).getMessagePoolSize();
//	}
//	
//	public Message popMessage()
//	{
//		return ((ClientInputThread) inputRunner).popMessage();
//	}
}
