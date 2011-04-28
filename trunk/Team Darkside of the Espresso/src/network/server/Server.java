/*
 * The Class Server.
 */

package network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import network.Network;
import database.SqlDatabase;

/**
 * The Class Server.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class Server {

	/** The server socket. */
	private ServerSocket serverSocket = null;

	/** The client socket. */
	private Socket clientSocket;

	/** The database. */
	private SqlDatabase database = null;

	/** The is done. */
	private boolean isDone;

	/**
	 * Instantiates a new server.
	 * 
	 * @param port
	 *            the port
	 */
	public Server(int port) {
		clientSocket = null;

		try {
			serverSocket = new ServerSocket(Network.NETWORK_PORT);
			database = new SqlDatabase();

			while (!isDone) {
				clientSocket = serverSocket.accept();

				// Runnable handlerRunner = new Handler(clientSocket, database);
				// Thread handlerThread = new Thread(handlerRunner);
				//
				// handlerThread.start();
				Runnable serverRunner = new ServerThread(clientSocket, database);
				Thread serverThread = new Thread(serverRunner, "ServerThread");

				serverThread.start();
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
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
