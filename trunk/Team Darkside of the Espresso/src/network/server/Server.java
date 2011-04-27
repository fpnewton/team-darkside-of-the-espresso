package network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;

import javax.crypto.SecretKey;

import network.Network;

import log.SystemLog;

public class Server implements Runnable
{
	public static HashMap<Socket, SecretKey>	clientKeys;
	public static HashMap<Socket, String>		clientUsers;


	public Server()
	{
		this(Network.NETWORK_PORT);
	}


	public Server(int port)
	{
		clientKeys = new HashMap<Socket, SecretKey>();
		clientUsers = new HashMap<Socket, String>();
		
		try
		{
			ServerSocket socket = new ServerSocket(port);
			
			while (true)
			{
				Socket connection = socket.accept();
				
				if (SystemLog.LogMessage("New client attempting to connect.", Level.INFO))
				{
					System.out.println("New client attempting to connect.");
				}
				
				clientKeys.put(connection, null);
				clientUsers.put(connection, null);
				
				Runnable runner = new ServerThread(connection);
				Thread threader = new Thread(runner);
				
				threader.start();
			}
		}
		catch (IOException e)
		{
			if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE))
			{
				e.printStackTrace();
			}
		}
	}


	public void run()
	{
		// TODO Auto-generated method stub		
	}
}
