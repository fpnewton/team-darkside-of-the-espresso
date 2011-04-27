/*
 * Hospital Client Application Entry Point
 */

package client;

import java.awt.EventQueue;

import network.Message;
import network.MessageKey;
import network.Network;
import network.client.Client;
import ui.ApplicationWindow;
import users.User;


/**
 * Hospital Client Application Entry Point.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class Main {
    private static ApplicationWindow window;
    private static User currentUser;
    private static Client client;

    /**
     * Hospital Client application entry point.
     * 
     * @param args
     *            Application arguments
     * @throws ClassNotFoundException
     */
    public static void main(String[] args)
    {
    	// No user is logged in at the login window
		currentUser = null;
		
		// Start the networking client threads
		client = new Client(Network.NETWORK_PORT);
		
		if (!client.isSuccessfulConnection())
		{
			// TODO Handle invalid network stack
			System.out.println("Error: Could not connect.");
		}
		
		Message msg = new Message(MessageKey.DB_GETUSER, "1");
		client.sendMessage(msg);
		
		msg = client.popMessage();
		Object obj = msg.getAttachment();
		
		System.out.println(obj.getClass().getName());
		
		// Launch the GUI
		EventQueue.invokeLater(new Runnable()
		{
		    public void run()
		    {
				try
				{
				    window = new ApplicationWindow();
				}
				catch (Exception e)
				{
				    e.printStackTrace();
				}
		    }
		});
    }
    
    public static Client getClientObject()
    {
    	return client;
    }

    public static ApplicationWindow getApplicationWindow() {
	return window;
    }

    public static User getCurrentUser() {
	return currentUser;
    }

    public static void setCurrentUser(User newUser) {
	currentUser = newUser;
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
