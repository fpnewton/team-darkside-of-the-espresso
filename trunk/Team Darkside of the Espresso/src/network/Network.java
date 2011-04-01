/*
 * The Network Class.
 * 
 * Contains constants for the network stack.
 */

package network;

/**
 * The Network Class.
 * 
 * Contains constants for the network stack.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class Network {

    /** The Constant CLIENT_PORT. */
    public static final int CLIENT_PORT = 1459;

    /** The Constant SERVER_PORT. */
    public static final int SERVER_PORT = 1459;

    /** The Constant CHANNEL_A. */
    public static final int CHANNEL_A = 0; // Hospital Client to Hospital Server

    /** The Constant CHANNEL_B. */
    public static final int CHANNEL_B = 1; // Hospital Server to Hospital Client

    /**
     * Converts the object to a string.
     * 
     * @return A string with the fully qualified name of the class
     */
    public String toString() {
	return this.getClass().toString();
    }
}
