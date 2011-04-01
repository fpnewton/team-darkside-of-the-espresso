/*
 * The LoginController Class.
 */

package ui;

import client.Main;
import database.Crypto;
import users.User;

/**
 * The LoginController Class.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class LoginController {
    
    /** The Login attempts remaining. */
    private int loginAttemptsRemaining;
    
    /** The max login attempts for all users. */
    private static final int MAX_LOGIN_ATTEMPTS = 3;

    /**
     * Instantiates a new login controller.
     */
    public LoginController() {
	loginAttemptsRemaining = MAX_LOGIN_ATTEMPTS;
    }

    /**
     * Login.
     *
     * @param username the username
     * @param password the password
     * @return true, if successful
     */
    public boolean login(String username, String password) {
	final User[] userList = Main.getDatabaseObject().getAllUsers();
	final String passwordHash = Crypto.getSha1Hash(password);

	for (User usr : userList) {
	    if (usr.getUsername().equals(username)
		    && usr.getPasswordHash().equals(passwordHash)) {
		return true;
	    }
	}

	loginAttemptsRemaining--;
	return false;
    }

    /**
     * Gets the login attempts remaining.
     *
     * @return the login attempts remaining
     */
    public int getLoginAttemptsRemaining() {
	return loginAttemptsRemaining;
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
