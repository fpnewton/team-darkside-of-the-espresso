
package network;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;

import log.SystemLog;



public class NetworkThread extends Thread
{
	private volatile	boolean	isDone;
	
	private				Client	Client;
	private				Server	Server;
	
	private				Message	Message;
	
	
	public NetworkThread(String ip, int port, boolean isHospitalServer) throws UnknownHostException, IOException
	{
		isDone = false;
		
		if (isHospitalServer)
		{
			Client = new Client(ip, port, Network.CHANNEL_B);
			Server = new Server(port, Network.CHANNEL_A);
		}
		else
		{
			Client = new Client(ip, port, Network.CHANNEL_A);
			Server = new Server(port, Network.CHANNEL_B);
		}
	}
	
	
	public void run()
	{
		while (!isDone)
		{
			if (Message != null)
			{
				if (!Client.SendMessage(Message))
				{
					SystemLog.LogMessage("Warning: An error has occured while sending a message.", Level.WARNING);
				}
				
				Message = null;
			}
		}
	}
	
	
	public void SendMessage(Message message)
	{
		Message = message;
	}
	
	
	public boolean isRunning()
	{
		return !isDone;
	}
}
