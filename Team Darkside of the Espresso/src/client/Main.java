/*
 * Hospital Client Application Entry Point
 */

package client;

import java.awt.EventQueue;
import java.util.logging.Level;

import log.SystemLog;
import ui.ApplicationWindow;
import ui.LoginWindow;
import users.User;
import database.SqlDatabase;

/**
 * Hospital Client Application Entry Point.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class Main {
    /** The SQL database object */
    private static SqlDatabase Database;
    
    private static ApplicationWindow window;
    
    private static User currentUser;

    /**
     * Hospital Client application entry point.
     * 
     * @param args
     *            Application arguments
     */
    public static void main(String[] args) {
	currentUser = null;
	
	try {
	    Database = new SqlDatabase();
	    
	   // Database.createTables();
	    //Database.insertUser(new SystemAdmin("fnewton3", Crypto.getSha1Hash("password"), GenderType.Male, new UserInfo("Fraser Newton", "Address", "678-468-0074", "999-99-9999", "fnewton3@gatech.edu", new Date())));
	} catch (ClassNotFoundException e) {
	    if (!SystemLog.LogMessage(e.getMessage(), Level.SEVERE)) {
		e.printStackTrace();
	    }
	}

	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    window = new ApplicationWindow();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Gets the database object.
     * 
     * @return A pointer to the database object
     */
    public static SqlDatabase getDatabaseObject() {
	return Database;
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
