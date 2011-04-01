/*
 * The Network Client Class.
 */

package network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;

import log.SystemLog;

/**
 * The Network Client Class.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class Client {

    /** The Client socket. */
    private Socket clientSocket;

    /**
     * Instantiates a new client.
     * 
     * @throws UnknownHostException
     *             The unknown host exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Client() throws UnknownHostException, IOException {
	this("127.0.0.1", Network.CLIENT_PORT);
    }

    /**
     * Instantiates a new client.
     * 
     * @param ip
     *            The IP address of the server
     * @throws UnknownHostException
     *             The unknown host exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Client(String ip) throws UnknownHostException, IOException {
	this(ip, Network.CLIENT_PORT);
    }

    /**
     * Instantiates a new client.
     * 
     * @param ip
     *            The IP address of the server
     * @param port
     *            The port to connect to the server
     * @throws UnknownHostException
     *             The unknown host exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Client(String ip, int port) throws UnknownHostException, IOException {
	clientSocket = new Socket(ip, port);
    }

    /**
     * Instantiates a new client.
     * 
     * @param ip
     *            The IP address of the server
     * @param port
     *            The port the server is listening on
     * @param channel
     *            The communication channel to use for the transmission
     * @throws UnknownHostException
     *             the unknown host exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Client(String ip, int port, int channel) throws UnknownHostException,
	    IOException {
	this(ip, port + channel);
    }

    /**
     * Closes the client socket.
     */
    public void cleanup() {
	try {
	    // Close the client socket
	    if (clientSocket != null) {
		clientSocket.close();
	    }
	} catch (IOException e) {
	    if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * Send a message to the server.
     * 
     * @param message
     *            The message to send to the server
     * @return true, if successful and no exceptions were thrown
     */
    public boolean sendMessage(Message message) {
	ObjectOutputStream objectStream = null;

	try {
	    // Create an object stream to transport the message
	    objectStream = new ObjectOutputStream(clientSocket.getOutputStream());

	    // Write the message to the stream
	    objectStream.writeObject(message);

	    // Make sure all data has been sent and close the stream
	    objectStream.flush();
	} catch (UnknownHostException e) {
	    if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
		e.printStackTrace();
	    }

	    return false;
	} catch (IOException e) {
	    if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
		e.printStackTrace();
	    }

	    return false;
	} finally {
	    try {
		if (objectStream != null) {
		    objectStream.close();
		}
	    } catch (IOException e) {
		if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
		    e.printStackTrace();
		}
	    }
	}

	return true;
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
