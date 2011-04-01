/*
 * The Server Class.
 */

package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;

import log.SystemLog;

/**
 * The Server Class.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class Server {

    /** The Server socket. */
    private ServerSocket serverSocket;

    /**
     * Instantiates a new server.
     * 
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Server() throws IOException {
	this(Network.SERVER_PORT);
    }

    /**
     * Instantiates a new server.
     * 
     * @param port
     *            The port to listen for clients on
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Server(int port) throws IOException {
	serverSocket = new ServerSocket(port);
    }

    /**
     * Instantiates a new server.
     * 
     * @param port
     *            The port to listen for a client on
     * @param channel
     *            The communication channel that the client is transmitting data
     *            on
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Server(int port, int channel) throws IOException {
	this(port + channel);
    }

    /**
     * Close the socket connection.
     */
    public void cleanup() {
	try {
	    if (serverSocket != null) {
		serverSocket.close();
	    }
	} catch (IOException e) {
	    if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * Receives a message from the client and returns the message object.
     * 
     * @return The message object that was received from the client
     */
    public Message receiveMessage() {
	Message message = null;
	Socket clientSocket = null;
	ObjectInputStream objectStream = null;

	try {
	    // Accept the client connection as a new socket
	    clientSocket = serverSocket.accept();
	    // Create an object stream to receive the data from the client
	    objectStream = new ObjectInputStream(clientSocket.getInputStream());

	    // Get the object from the stream data
	    message = (Message) objectStream.readObject();
	} catch (IOException e) {
	    if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
		message = null;

		e.printStackTrace();
	    }
	} catch (ClassNotFoundException e) {
	    if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
		message = null;

		e.printStackTrace();
	    }
	} finally {
	    // Close the object stream and client socket connection

	    try {
		if (objectStream != null) {
		    objectStream.close();
		}

		if (clientSocket != null) {
		    clientSocket.close();
		}
	    } catch (IOException e) {
		if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
		    message = null;

		    e.printStackTrace();
		}
	    }
	}

	return message;
    }

    /**
     * Converts the object to a string.
     * 
     * @return A string with the fully qualified name of the class
     */
    public String toString() {
	return this.getClass().toString();
    }
}
