package network.client;

import java.io.ObjectOutputStream;
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
	private Thread inputThread;
	private Thread outputThread;
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

			inputThread = new Thread(inputRunner);
			outputThread = new Thread(outputRunner);

			inputThread.start();
			outputThread.start();
			
			
			
			isSuccessful = true;
		}
		catch (Exception e)
		{
			System.out.println("here");
			System.out.println(e);
			
			// TODO Alert user about unknown host
		}
	}
	
	public boolean isSuccessfulConnection()
	{
		return isSuccessful;
	}
	
	public void sendMessage(Message message)
	{
//		try
//		{
//		ObjectOutputStream stream = new ObjectOutputStream(connection.getOutputStream());
//		
//		stream.writeObject(message);
//		stream.flush();
//		}
//		catch (Exception e)
//		{
//			System.out.println("ME");
//			System.out.println(e);
//		}
//		((ClientOutputThread) outputRunner).sendMessage(message);
		((ClientOutputThread) outputRunner).sendMessage(new Message(MessageKey.DB_GETALLUSERS));
	}
	
	public Message popMessage()
	{
		return ((ClientInputThread) inputRunner).getMessage();
	}
}
