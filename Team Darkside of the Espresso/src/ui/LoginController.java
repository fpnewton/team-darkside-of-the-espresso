/*
 * The LoginController Class.
 */

package ui;

import java.util.ArrayList;

import network.Message;
import network.MessageKey;
import users.User;
import client.Main;
import database.Crypto;

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
    public boolean canLogin(String username, String password) {
    final Message msg = new Message(MessageKey.DB_GETALLUSERS,"");
    Main.getClientObject().sendMessage(msg);
	@SuppressWarnings("unchecked")
	final ArrayList<User> userList = (ArrayList<User>)Main.getClientObject().popMessage(msg.getKey()).getAttachment();
	final String passwordHash = Crypto.getSha1Hash(password);

	for (User usr : userList) {
	    if (usr.getUsername().equals(username)
		    && usr.getPasswordHash().equals(passwordHash)) {
		Main.setCurrentUser(usr);
		
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
