/**
 * Hospital Server Application Entry Point
 * 
 * @author Fraser P. Newton
 * @date March 4, 2011
 */

package server;

import network.Network;
import network.server.Server;


public class Main
{
	private static Server server = null;
	
	public static void main(String args[])
	{
		server = new Server(Network.NETWORK_PORT);
	}
}
