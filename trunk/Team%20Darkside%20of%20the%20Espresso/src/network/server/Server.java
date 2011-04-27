package network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import javax.crypto.SecretKey;

import log.SystemLog;
import network.Network;



public class Server
{
	private HashMap<Socket, SecretKey>	clientKeys;
	private HashMap<Socket, String>		clientUsers;
	private List<Session>				clientSessions;


	public Server()
	{
		this(Network.NETWORK_PORT);
	}


	public Server(int port)
	{
		clientKeys = new HashMap<Socket, SecretKey>();
		clientUsers = new HashMap<Socket, String>();
		clientSessions = new ArrayList<Session>();
		
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
				
				clientSessions.add(new Session(connection, null));
				
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
}
