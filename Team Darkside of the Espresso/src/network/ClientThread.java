/*
 * The ClientThread Class.
 */

package network;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * The ClientThread Class.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class ClientThread extends Thread {

    /** The client. */
    private Client client = null;

    /** The is done flag. */
    private boolean isDone;

    /**
     * Instantiates a new client thread.
     * 
     * @param ipAddress
     *            the ip address of the server
     * @param port
     *            the port
     * @param channel
     *            the channel
     * 
     * @throws UnknownHostException
     *             the unknown host exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public ClientThread(String ipAddress, int port, int channel)
	    throws UnknownHostException, IOException {
	isDone = false;

	client = new Client(ipAddress, port, channel);
    }

    /**
     * Cleanup.
     */
    public void cleanup() {
	client.cleanup();
    }

    /**
     * Send a message to the server.
     * 
     * @param message
     *            The message to send
     * 
     * @return true, if successful
     */
    public boolean sendMessage(Message message) {
	return client.sendMessage(message);
    }

    /**
     * The client thread loop.
     */
    public void run() {
	while (!isDone) {
	    // TODO
	}
    }

    /**
     * Checks if is running.
     * 
     * @return true, if is running
     */
    public boolean isRunning() {
	return !isDone;
    }

    /**
     * Terminates the running thread.
     */
    public void terminate() {
	isDone = true;
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
