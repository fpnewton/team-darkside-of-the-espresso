/**
 * Hospital Server Application Entry Point
 * 
 * @author	Fraser P. Newton
 * @date	March 4, 2011
 */

package edu.gatech.TeamDarksideOfTheEspresso.HospitalServer;


import java.io.IOException;
import java.net.ServerSocket;


public class Main
{
	/**
	 * Hospital Server application entry point
	 * 
	 * @param args Application arguments
	 */
	public static void main(String[] args) throws IOException
	{
        ServerSocket serverSocket = null;
        boolean listening = true;

        try
        {
        	serverSocket = new ServerSocket(4444);
        }
        catch (IOException e)
        {
            System.err.println("Could not listen on port: 4444.");
            System.exit(-1);
        }

        while (listening)
        {
        	new ServerThread(serverSocket.accept()).start();
        }

        serverSocket.close();
	}
}
