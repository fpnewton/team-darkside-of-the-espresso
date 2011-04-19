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
    
	public static byte[] getBytesFromObject(Object object)
	{
		try
		{
			if (object != null)
			{
				ByteArrayOutputStream ByteStream = new ByteArrayOutputStream();
				ObjectOutputStream ObjectStream = new ObjectOutputStream(ByteStream);
				byte[] output = null;

				ObjectStream.writeObject(object);
				ObjectStream.close();

				output = ByteStream.toByteArray();
				ByteStream.close();

				return output;
			}
		}
		catch (IOException e)
		{
			if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE))
			{
				e.printStackTrace();
			}
		}

		return null;
	}


	public static Object getObjectFromBytes(byte[] buffer)
	{
		try
		{
			if (buffer != null)
			{
				ByteArrayInputStream byteStream = new ByteArrayInputStream(buffer);
				ObjectInputStream objectStream = new ObjectInputStream(byteStream);

				Object output = objectStream.readObject();
				objectStream.close();

				return output;
			}
		}
		catch (IOException e)
		{
			if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE))
			{
				e.printStackTrace();
			}
		}
		catch (ClassNotFoundException e)
		{
			if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE))
			{
				e.printStackTrace();
			}
		}

		return null;
	}
	
	public static void sendBytes(Socket connection, byte[] bytes)
	{
		try
		{
			BufferedOutputStream output = new BufferedOutputStream(connection.getOutputStream());
			byte[] b = new byte[4];

			for (int i = 0; i < 4; i++)
			{
				int offset = (b.length - 1 - i) * 8;

				b[i] = (byte) ((bytes.length >>> offset) & 0xFF);
			}
			
			output.write(b[0]);
			output.write(b[1]);
			output.write(b[2]);
			output.write(b[3]);
			output.write(bytes);
			output.flush();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}


	public static byte[] recieveBytes(Socket connection)
	{
		try
		{
			BufferedInputStream input = new BufferedInputStream(connection.getInputStream());
			byte[] b = new byte[4];
			int value = 0;

			b[0] = (byte) input.read();
			b[1] = (byte) input.read();
			b[2] = (byte) input.read();
			b[3] = (byte) input.read();

			for (int i = 0; i < 4; i++)
			{
				int shift = (4 - 1 - i) * 8;

				value += (b[i] & 0x000000FF) << shift;
			}

			byte[] bytearr = new byte[4];

			input.read(bytearr);

			return bytearr;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return null;
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
