package network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import network.Message;
import network.MessageKey;
import network.Network;
import users.User;
import database.SqlDatabase;

public class Server
{
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private SqlDatabase database;
	private boolean isDone;

	
	public Server(int port)
	{
		clientSocket = null;

		try
		{
			serverSocket = new ServerSocket(Network.NETWORK_PORT);
			database = new SqlDatabase();

			while (!isDone)
			{
				clientSocket = serverSocket.accept();
				
//				Runnable handlerRunner = new Handler(clientSocket, database);
//				Thread handlerThread = new Thread(handlerRunner);
//				
//				handlerThread.start();
				Runnable serverRunner = new ServerThread(clientSocket, database);
				Thread serverThread = new Thread(serverRunner);
				
				serverThread.start();
			}
		} 
		catch (IOException e)
		{
			System.out.println(e);
		} catch (ClassNotFoundException e)
		{
			System.out.println(e);
		}
	}
}
