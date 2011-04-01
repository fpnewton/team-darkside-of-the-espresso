/*
 * The ServerThread Class.
 */

package network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The ServerThread Class.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class ServerThread extends Thread {
    /** The server. */
    private Server server = null;

    private List<Message> messagePool = null;

    /** The is done flag. */
    private boolean isDone;

    /**
     * Instantiates a new server thread.
     * 
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
    public ServerThread(int port, int channel) throws IOException {
	isDone = false;

	server = new Server(port, channel);
	messagePool = new ArrayList<Message>();
    }

    /**
     * Cleanup.
     */
    public void cleanup() {
	server.cleanup();
    }

    public Message[] getMessages(MessageKey key) {
	final List<Message> msgList = new ArrayList<Message>();

	for (Message msg : messagePool) {
	    if (msg.equals(key)) {
		msgList.add(msg);
		messagePool.remove(msg);
	    }
	}

	return msgList.toArray(new Message[msgList.size()]);
    }

    public int getMessagePoolSize() {
	return messagePool.size();
    }

    /**
     * The client thread loop.
     */
    public void run() {
	while (!isDone) {
	    messagePool.add(server.receiveMessage());
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
