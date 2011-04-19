package network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
	private Socket	connection;


	public Client()
	{
		this(Network.NETWORK_PORT);
	}


	public Client(int port)
	{
		try
		{
			connection = new Socket(InetAddress.getByName("127.0.0.1"), port);

			System.out.println("Connected!");

			Runnable inputRunner = new ClientInputThread(connection);
			Runnable outputRunner = new ClientOutputThread(connection);

			Thread inputThread = new Thread(inputRunner);
			Thread outputThread = new Thread(outputRunner);

			inputThread.start();
			outputThread.start();
		}
		catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
