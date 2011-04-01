/*
 * The NetworkConnector Class.
 */

package network;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * The NetworkConnector Class.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class NetworkConnector {
    private Thread clientThread;
    private Thread serverThread;

    /**
     * Instantiates a new network connector.
     * 
     * @param ipAddress
     *            the ip address
     * @param port
     *            the port
     * @param type
     *            the type
     * @throws UnknownHostException
     *             the unknown host exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public NetworkConnector(String ipAddress, int port, NetworkConnectorType type)
	    throws UnknownHostException, IOException {

	if (type == NetworkConnectorType.CLIENT) {
	    clientThread = new ClientThread(ipAddress, port, Network.CHANNEL_A);
	    serverThread = new ServerThread(port, Network.CHANNEL_B);
	} else {
	    clientThread = new ClientThread(ipAddress, port, Network.CHANNEL_B);
	    serverThread = new ServerThread(port, Network.CHANNEL_A);
	}
    }

    public void cleanup() {
	((ClientThread) clientThread).terminate();
	((ServerThread) serverThread).terminate();
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
	return ((ClientThread) clientThread).sendMessage(message);
    }

    public Message[] getMessages(MessageKey key) {
	return ((ServerThread) clientThread).getMessages(key);
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
