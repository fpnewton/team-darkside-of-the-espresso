/*
 * Hospital Server Application Entry Point
 */

package server;

import network.Network;
import network.server.Server;
import users.GenderType;
import users.SystemAdmin;
import users.UserInfo;
import database.Crypto;
import database.SqlDatabase;

/**
 * Hospital Server Application Entry Point
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class Main {

	/** The Server. */
	private static Server Server = null;

	/**
	 * Application entry point.
	 * 
	 * @param args
	 *            Command line args
	 */
	public static void main(String args[]) {
		Server = new Server(Network.NETWORK_PORT);
		try {
			final SqlDatabase db = new SqlDatabase();

			db.canCreateTables();
			db.canInsertUser(new SystemAdmin("fnewton3", Crypto
					.getSha1Hash("password"), GenderType.Male, new UserInfo(
					"a", "b", "c", null, null, null)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * toString() override.
	 * 
	 * @return A string
	 */
	public String toString() {
		return this.getClass().getName();
	}
}
