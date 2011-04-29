/*
 * Hospital Server Application Entry Point
 */

package server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import network.Message;
import network.MessageKey;
import network.Network;
import network.server.Server;

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
		try
		{
			int buffer_size = 1024;
	
			byte buffer[] = new byte[buffer_size];
	
			DatagramSocket ds = new DatagramSocket(Network.NETWORK_PORT-1);
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutput out = new ObjectOutputStream(bos);   
			out.writeObject(new Message(MessageKey.ECHO));
			
			byte buf[] = bos.toByteArray();
			int p = buf.length;
			
			ds.send(new DatagramPacket(buf, p, InetAddress.getLocalHost(), Network.NETWORK_PORT));
			
			
			
//			ds.send(p)
//			
//			int pos = 0;
//			while (true) {
//				int c = System.in.read();
//				switch (c) {
//				case -1:
//					System.out.println("Server Quits.");
//					return;
//				case '\r':
//					break;
//				case '\n':
//					ds.send(new DatagramPacket(buffer, pos, InetAddress
//							.getLocalHost(), Network.NETWORK_PORT));
//					pos = 0;
//					break;
//				default:
//					buffer[pos++] = (byte) c;
//				}
//			}
		}
		catch (IOException e)
		{
			// TODO
			System.out.println(e);
		}
		// nbServer s = new nbServer();
		// Server = new Server(Network.NETWORK_PORT);
		// try {
		// final SqlDatabase db = new SqlDatabase();
		//
		// db.canCreateTables();
		// db.canInsertUser(new SystemAdmin("fnewton3", Crypto
		// .getSha1Hash("password"), GenderType.MALE, new UserInfo(
		// "a", "b", "c", null, null, null)));
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// System.exit(-1);
		// }
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
