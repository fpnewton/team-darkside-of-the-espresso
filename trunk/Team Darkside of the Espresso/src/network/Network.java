/*
 * The Network Class.
 * 
 * Contains constants for the network stack.
 */

package network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;

import log.SystemLog;


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
    public static final int NETWORK_PORT = 1459;
   

    /**
     * Converts the object to a string.
     * 
     * @return A string with the fully qualified name of the class
     */
    public String toString() {
	return this.getClass().toString();
    }
}
