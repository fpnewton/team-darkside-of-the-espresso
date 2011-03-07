
package edu.gatech.TeamDarksideOfTheEspresso.HospitalServer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerThread extends Thread
{
	private Socket	socket	= null;
	private boolean	isDone	= false;


	public ServerThread(Socket socket)
	{
		super("HospitalServerThread");
		this.socket = socket;
	}


	public void run()
	{
		try
		{
			PrintWriter		out	= new PrintWriter(socket.getOutputStream(), true);
			BufferedReader	in	= new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String inputLine;
			String outputLine = "Hello.";
			
			out.println(outputLine);

			while ((inputLine = in.readLine()) != null)
			{
				outputLine = inputLine;
				out.println(outputLine);
				
				System.out.println(outputLine);
				
				if (outputLine.equals("term"))
				{
					break;
				}
			}
			
			out.close();
			in.close();
			socket.close();

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public boolean isDone()
	{
		return isDone;
	}

}
