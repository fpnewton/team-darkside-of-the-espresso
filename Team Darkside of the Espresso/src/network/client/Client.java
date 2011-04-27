package network.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;

import network.Network;

import log.SystemLog;
import network.Message;
import network.MessageKey;
import network.Network;

public class Client
{
	private Socket	connection;
	private boolean isSuccessful;
	private Runnable inputRunner;
	private Runnable outputRunner;


	public Client()
	{
		this(Network.NETWORK_PORT);
	}


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
			
			isSuccessful = true;
		}
		catch (UnknownHostException e)
		{
			if (!SystemLog.LogMessage(e.getStackTrace().toString(), Level.SEVERE))
			{
				e.printStackTrace();
			}
			
			// TODO Alert user about unknown host
		}
		catch (IOException e)
		{
			if (!SystemLog.LogMessage(e.getStackTrace().toString(), Level.SEVERE))
			{
				e.printStackTrace();
			}
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
	
	public int getMessagePoolSize()
	{
		return ((ClientInputThread) inputRunner).getMessagePoolSize();
	}
	
	public Message popMessage()
	{
		return ((ClientInputThread) inputRunner).popMessage();
	}
}
