/*
 * Hospital Client Application Entry Point
 */

package client;

import java.awt.EventQueue;
import java.util.Date;
import java.util.logging.Level;

import log.SystemLog;

import database.Crypto;
import database.SqlDatabase;

import ui.LoginWindow;
import users.GenderType;
import users.SystemAdmin;
import users.UserInfo;

/**
 * Hospital Client Application Entry Point.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class Main {
    /** The SQL database object */
    private static SqlDatabase Database;

    /**
     * Hospital Client application entry point.
     * 
     * @param args
     *            Application arguments
     */
    public static void main(String[] args) {
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
		    final LoginWindow window = new LoginWindow();

		    window.getFrmLoginWindow().setVisible(true);
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

    /**
     * Converts the object to a string.
     * 
     * @return A string with the fully qualified name of the class
     */
    public String toString() {
	return this.getClass().toString();
    }
}
