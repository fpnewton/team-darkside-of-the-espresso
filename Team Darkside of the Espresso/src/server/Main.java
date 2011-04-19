/**
 * Hospital Server Application Entry Point
 * 
 * @author Fraser P. Newton
 * @date March 4, 2011
 */

package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.logging.Level;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import log.SystemLog;
import network.Server;

public class Main implements Runnable
{
	private static Socket						serverSocket;
	private static int							connectionCount;

	private static HashMap<String, String>		userDatabase;
	private static HashMap<Socket, SecretKey>	clientKeys;
	private static HashMap<Socket, String>		clientUsers;


	public Main(Socket connection)
	{
		serverSocket = connection;
	}


	public static void main(String args[]) throws ClassNotFoundException
	{
		Server s = new Server(10000);

		// try {
		// Server srv = new Server();
		//
		// System.out.println(srv.receiveMessage());
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// SqlDatabase db = new SqlDatabase();

		// db.OpenDatabaseConnection();
		// db.createNewDatabaseTables();

		// UserInfo ui = new UserInfo("George P. Burdell",
		// "1214 Woodridge Dr\nAtlanta, GA 30339", "678-468-0074",
		// "999-99-9999", "fnewton3@gatech.edu", null);
		// PatientInfo pi = new PatientInfo(20, "My Insurance Carrier",
		// "My Pharmacy", null, null);
		// Patient patient = new Patient("fnewton3", "password",
		// GenderType.Male, ui, pi);

		// db.InsertUser(patient);

		// patient.getPatientInfo().setAge(21);
		// patient.setUsername("bitches");

		// db.UpdateUser(1, patient);

		// Object pt[] = (Object[])db.getObject("data", 1);
		//
		// Patient p = (Patient)pt[0];
		// System.out.println(p.getUsername());

		// Patient p = (Patient)db.getUser(1);

		// p.setUsername("123456");
		// p.getUserInformation().setName("ABGDEZHE0IK^NM=OnPSTY1Xyo");
		// db.UpdateUser(1, p);

		// System.out.println(p.getUserInformation().getName());

		// db.closeDatabaseConnection();
	}


	public void run()
	{
		try
		{
			String processed = new String();

			// DiffyHellman setup
			SecretKey temp = this.dhServerSideSetup(serverSocket);

			clientKeys.remove(serverSocket);
			clientKeys.put(serverSocket, temp);

			// Authentication
			System.out.println("Authenticating...");
			String[] user_pass = this.getUserandPass();
			System.out.println("Checking...");
			if (user_pass == null)
			{
				System.out.println("Authentication failed, closing connection.");
				sendEncryptedMessage(serverSocket, "A,FAIL", clientKeys.get(serverSocket));
				clientKeys.remove(serverSocket);
				clientUsers.remove(serverSocket);
				serverSocket.close();
				return;
				// quit
			}
			else if (checkPassword(user_pass[1], user_pass[2]))
			{
				System.out.println("Authenticated, user:" + user_pass[1]);
				clientUsers.remove(serverSocket);
				clientUsers.put(serverSocket, user_pass[1]);
				sendEncryptedMessage(serverSocket, "A,SUCCESS", clientKeys.get(serverSocket));
			}
			else
			{
				System.out.println("Authentication failed, closing connection.");
				sendEncryptedMessage(serverSocket, "A,FAIL", clientKeys.get(serverSocket));
				clientKeys.remove(serverSocket);
				clientUsers.remove(serverSocket);
				serverSocket.close();
				return;
				// quit
			}

			// Message cycle
			while (!processed.equals("DONE"))
			{
				processed = clientUsers.get(serverSocket) + ":"
						+ recieveDecryptedMessage(serverSocket, clientKeys.get(serverSocket));
				this.broadcastMessage(processed);
			}
		}
		catch (Exception e)
		{
			if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE))
			{
				e.printStackTrace();
			}
		}
		finally
		{
			try
			{
				clientKeys.remove(serverSocket);
				clientUsers.remove(serverSocket);

				serverSocket.close();

				SystemLog.LogMessage("Client connection closed.", Level.INFO);
			}
			catch (IOException e)
			{
				if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE))
				{
					e.printStackTrace();
				}
			}
		}

	}


	public void sendBytes(Socket connection, byte[] bytes)
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
			if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE))
			{
				e.printStackTrace();
			}
		}
	}


	public byte[] recieveBytes(Socket connection)
	{
		try
		{
			BufferedInputStream input = new BufferedInputStream(connection.getInputStream());
			byte[] b = new byte[4];
			
			b[0] = (byte) input.read();
			b[1] = (byte) input.read();
			b[2] = (byte) input.read();
			b[3] = (byte) input.read();
			
			int value = 0;
			
			for (int i = 0; i < 4; i++)
			{
				int shift = (4 - 1 - i) * 8;
				
				value += (b[i] & 0x000000FF) << shift;
			}
			
			byte[] bytearr = new byte[value];
			
			input.read(bytearr);
			
			return bytearr;
		}
		catch (Exception e)
		{
			if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE))
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	static final String	HEXES = "0123456789ABCDEF";


	public static String getHex(byte[] raw)
	{
		if (raw == null)
		{
			return null;
		}
		
		final StringBuilder hex = new StringBuilder(2 * raw.length);
		
		for (final byte b : raw)
		{
			hex.append(HEXES.charAt((b & 0xF0) >> 4)).append(HEXES.charAt((b & 0x0F)));
		}
		
		return hex.toString();
	}


	public SecretKey dhServerSideSetup(Socket connection)
	{
		try
		{
			AlgorithmParameterGenerator paramGen = AlgorithmParameterGenerator
					.getInstance("DiffieHellman");
			paramGen.init(1024);
			AlgorithmParameters params = paramGen.generateParameters();
			DHParameterSpec dhSpec = (DHParameterSpec) params
					.getParameterSpec(DHParameterSpec.class);
			this.sendEncryptedMessage(connection, "" + dhSpec.getP() + "," + dhSpec.getG() + ","
					+ dhSpec.getL(), null);
			try
			{
				KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DiffieHellman");
				keyGen.initialize(dhSpec);
				KeyPair pair = keyGen.generateKeyPair();
				PrivateKey privatekey = pair.getPrivate();
				PublicKey publickey = pair.getPublic();
				byte[] publicbytes = publickey.getEncoded();

				sendBytes(connection, publicbytes);
				publicbytes = recieveBytes(connection);

				X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicbytes);
				KeyFactory keyFactory = KeyFactory.getInstance("DiffieHellman");
				publickey = keyFactory.generatePublic(x509KeySpec);
				KeyAgreement keyAgreement = KeyAgreement.getInstance("DiffieHellman");
				
				keyAgreement.init(privatekey);
				keyAgreement.doPhase(publickey, true);
				
				SecretKey secret = keyAgreement.generateSecret("DES");
				
				return secret;
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		catch (NoSuchAlgorithmException e)
		{
			System.out.println(e);
		}
		catch (InvalidParameterSpecException e)
		{
			System.out.println(e);
		}
		return null;
	}


	public String[] getUserandPass()
	{
		String temp = this.recieveDecryptedMessage(serverSocket, clientKeys.get(serverSocket));
		String[] parsed = temp.split(",");
		
		if (parsed != null && parsed[0].equals("A") && parsed.length == 3)
		{
			return parsed;
		}
		
		return null;
	}


	public String recieveDecryptedMessage(Socket connection, SecretKey key)
	{
		String processed = new String();
		
		if (key != null)
		{
			try
			{
				BufferedInputStream input = new BufferedInputStream(connection.getInputStream());
				byte[] raw = key.getEncoded();
				SecretKeySpec keySpec = new SecretKeySpec(raw, "DES");
				Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
				
				cipher.init(Cipher.DECRYPT_MODE, keySpec);
				CipherInputStream ciph = new CipherInputStream(input, cipher);
				InputStreamReader inputreader = new InputStreamReader(ciph, "US-ASCII");
				int character;
				
				while ((character = inputreader.read()) != 13)
				{
					processed = processed + (char) character;
				}
			}
			catch (Exception e)
			{
				if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE))
				{
					e.printStackTrace();
				}
			}
		}
		else
		{
			try
			{
				BufferedInputStream input = new BufferedInputStream(connection.getInputStream());
				InputStreamReader inputreader = new InputStreamReader(input, "US-ASCII");
				int character;
				while ((character = inputreader.read()) != 13)
				{
					processed = processed + (char) character;
				}
			}
			catch (Exception e)
			{
				if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE))
				{
					e.printStackTrace();
				}
			}
		}
		for (char a : processed.toCharArray())
		{
			if (!((a >= 32) && (a <= 126)))
			{
				System.out
						.println("Client message contained nonprintable character.... silently dropping it.");
			}
		}
		
		return processed;
	}


	public void sendEncryptedMessage(Socket connection, String message, SecretKey key)
	{
		// if key = null dont encrypt
		while (message.length() % 32 != 0)
		{
			message = message + (char) 13;
		}
		if (key != null)
		{
			try
			{
				BufferedOutputStream output = new BufferedOutputStream(connection.getOutputStream());
				byte[] raw = key.getEncoded();
				SecretKeySpec keySpec = new SecretKeySpec(raw, "DES");
				Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
				
				cipher.init(Cipher.ENCRYPT_MODE, keySpec);
				
				CipherOutputStream ciph = new CipherOutputStream(output, cipher);
				OutputStreamWriter outputwriter = new OutputStreamWriter(ciph, "US-ASCII");
				
				outputwriter.write(message + (char) 13);
				outputwriter.flush();
				ciph.flush();
			}
			catch (Exception e)
			{
				if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE))
				{
					e.printStackTrace();
				}
			}
		}
		else
		{
			try
			{
				BufferedOutputStream output = new BufferedOutputStream(connection.getOutputStream());
				OutputStreamWriter outputwriter = new OutputStreamWriter(output, "US-ASCII");
				
				outputwriter.write(message + (char) 13);
				outputwriter.flush();
			}
			catch (Exception e)
			{
				if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE))
				{
					e.printStackTrace();
				}
			}
		}
	}


	public void broadcastMessage(String message)
	{
		System.out.println("Broadcasting...");
		
		for (Socket key : clientKeys.keySet())
		{
			sendEncryptedMessage(key, message, clientKeys.get(key));
		}
	}
	
	public boolean checkPassword(String username, String password)
	{
		return true;
	}
}
