/**
 * Hospital Client Application Entry Point
 * 
 * @author	Fraser P. Newton
 * @date	March 4, 2011
 */

package edu.gatech.TeamDarksideOfTheEspresso.HospitalClient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Main
{
	/**
	 * Hospital Client application entry point
	 * 
	 * @param args	Application arguments
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		// TODO Implement Method
	        Socket			sock	= null;
	        PrintWriter		out		= null;
	        BufferedReader	in		= null;

	        try
	        {
	        	sock = new Socket("127.0.0.1", 4444);
	            out = new PrintWriter(sock.getOutputStream(), true);
	            in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
	        }
	        catch (UnknownHostException e)
	        {
	            System.err.println("Don't know about host: taranis.");
	            System.exit(1);
	        }
	        catch (IOException e)
	        {
	            System.err.println("Couldn't get I/O for " + "the connection to: taranis.");
	            System.exit(1);
	        }

		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput;
		
		out.println("Hello!");
		System.out.println("Received: " + in.readLine());
		out.println("term");

//		while ((userInput = stdIn.readLine()) != null)
//		{
//		    out.println(userInput);
//		    System.out.println("echo: " + in.readLine());
//		}

		out.close();
		in.close();
		stdIn.close();
		sock.close();
	}

}
