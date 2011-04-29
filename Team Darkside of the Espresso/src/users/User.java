/**
 * The Class User.
 */

package users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import appointment.Appointment;

/**
 * @author Patrick Tynan
 * @version 1.0
 */
public abstract class User implements Serializable {
	/** The Username. */
	private String username;

	/** The Password hash. */
	private String passwordHash;

	/** The Gender. */
	private GenderType gender;

	/** The User information. */
	private UserInfo userInformation;

	/** The is active. */
	private boolean isActive;

	/** The appointments. */
	private final List<Appointment> appointments;

	/**
	 * Instantiates a new user.
	 * 
	 * @param uName
	 *            the uname
	 * @param pWord
	 *            the pword
	 * @param gend
	 *            the gend
	 * @param info
	 *            the info
	 */
	public User(String uName, String pWord, GenderType gend, UserInfo info) {
		appointments = new ArrayList<Appointment>();
		this.username = uName;
		this.gender = gend;
		this.userInformation = info;
		this.passwordHash = pWord;
		isActive = true;
	}

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Gets the password hash.
	 * 
	 * @return the password hash
	 */
	public String getPasswordHash() {
		return passwordHash;
	}

	/**
	 * Gets the gender.
	 * 
	 * @return the gender
	 */
	public GenderType getGender() {
		return gender;
	}

	/**
	 * Gets the user information.
	 * 
	 * @return the user information
	 */
	public UserInfo getUserInformation() {
		return userInformation;
	}

	/**
	 * Checks if is active.
	 * 
	 * @return true, if is active
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Sets the username.
	 * 
	 * @param username
	 *            the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Sets the password hash.
	 * 
	 * @param passwordHash
	 *            the new password hash
	 */
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	/**
	 * Sets the gender.
	 * 
	 * @param gender
	 *            the new gender
	 */
	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	/**
	 * Sets the user information.
	 * 
	 * @param userInformation
	 *            the new user information
	 */
	public void setUserInformation(UserInfo userInformation) {
		this.userInformation = userInformation;
	}

	/**
	 * Activate user.
	 */
	public void activateUser() {
		isActive = true;
	}

	/**
	 * Deactive user.
	 */
	public void deactiveUser() {
		isActive = false;
	}

	/**
	 * Login.
	 * 
	 * @param uName
	 *            the uname
	 * @param pWord
	 *            the pword
	 * @return true, if successful
	 */
	public boolean canLogin(String uName, String pWord) {
		if (uName.equals(this.username) && pWord.equals(this.passwordHash)) {
			this.activateUser();
			return true;
		}
		return false;
	}

	/**
	 * Adds an appointment
	 * 
	 * @param appt
	 *            the new appointment
	 */
	public void addAppointment(Appointment appt) {
		appointments.add(appt);
	}

	/**
	 * Gets the appointment list
	 * 
	 * @return the appointment list
	 */
	public List<Appointment> getAppointmentList() {
		return appointments;
	}

	/**
	 * Removes an appointment
	 * 
	 * @param appt
	 *            the appointment to be removed
	 */
	public void removeAppointment(Appointment appt) {
		appointments.remove(appt);
	}

}
