/**
 * Hospital Server Application Entry Point
 * 
 * @author Fraser P. Newton
 * @date March 4, 2011
 */

package server;

import network.Network;
import network.server.Server;
import users.GenderType;
import users.SystemAdmin;
import users.UserInfo;
import database.Crypto;
import database.SqlDatabase;


public class Main
{
	private static Server server = null;
	
	public static void main(String args[])
	{
		//server = new Server(Network.NETWORK_PORT);
		try {
			SqlDatabase db = new SqlDatabase();
			
			db.canCreateTables();
			db.canInsertUser(new SystemAdmin("fnewton3", Crypto.getSha1Hash("password"), GenderType.Male, new UserInfo("a", "b", "c", null, null, null)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
