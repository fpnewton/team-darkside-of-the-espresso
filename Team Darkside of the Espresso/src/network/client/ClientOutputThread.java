package network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientOutputThread implements Runnable
{
	private Socket connection;
	
	public ClientOutputThread(Socket clientSocket)
	{
		connection = clientSocket;
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		Message msg = new Message(MessageKey.ECHO, "Hello!");
		
		try
		{
			ObjectOutputStream stream = new ObjectOutputStream(connection.getOutputStream());
			
			stream.writeObject(msg);
			
			stream.close();
			connection.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (true);
	}
}
