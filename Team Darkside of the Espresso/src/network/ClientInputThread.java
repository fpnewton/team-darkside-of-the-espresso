package network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientInputThread implements Runnable
{
	private Socket connection;
	private List<Message> messagePool;
	
	public ClientInputThread(Socket clientSocket)
	{
		messagePool = new ArrayList<Message>();
		
		connection = clientSocket;
	}
	
	public void run()
	{
		// TODO Auto-generated method stub
	}
	
	public int getMessagePoolSize()
	{
		return messagePool.size();
	}
	
	public Message popMessage()
	{
		if (messagePool.size() < 1)
		{
			return null;
		}
		
		Message msg = messagePool.get(0);
		
		messagePool.remove(0);
		
		return msg;
	}
	
	public void sendBytes(byte[] bytes)
	{
		try
		{
			BufferedOutputStream output = new BufferedOutputStream(connection.getOutputStream());
			byte[] b = new byte[4];
			
			for (int i = 0; i < 4; i++)
			{
				int offset = (b.length - 1 - i) * 8;
				
				b[i] = (byte) ((bytes.length >>> offset) & 0xFF);
			}
			output.write(b[0]);
			output.write(b[1]);
			output.write(b[2]);
			output.write(b[3]);
			output.write(bytes);
			output.flush();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}


	public byte[] recieveBytes()
	{
		try
		{
			BufferedInputStream input = new BufferedInputStream(connection.getInputStream());
			byte[] b = new byte[4];
			
			b[0] = (byte) input.read();
			b[1] = (byte) input.read();
			b[2] = (byte) input.read();
			b[3] = (byte) input.read();
			int value = 0;
			
			for (int i = 0; i < 4; i++)
			{
				int shift = (4 - 1 - i) * 8;
				
				value += (b[i] & 0x000000FF) << shift;
			}
			
			byte[] bytearr = new byte[value];
			
			input.read(bytearr);
			
			return bytearr;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
}
