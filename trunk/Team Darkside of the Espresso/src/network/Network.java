/*
 * The Network Class.
 * 
 * Contains constants for the network stack.
 */

package network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
	
	public static byte[] toBytes(Object object)
	{
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		
		try
		{
			ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
			
			objectStream.writeObject(object);
		}
		catch (IOException e)
		{
			// TODO
			System.out.println(e);
		}
		
		return byteStream.toByteArray();
	}
	
	public static Object toObject(byte[] bytes)
	{
		Object object = null;

		try
		{
			object = new ObjectInputStream(new ByteArrayInputStream(bytes)).readObject();
		}
		catch (IOException e)
		{
			// TODO
			System.out.println(e);
		}
		catch (ClassNotFoundException e)
		{
			// TODO
			System.out.println(e);
		}
		
		return object;
	} 
}
