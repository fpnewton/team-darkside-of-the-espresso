/**
 * The Class SystemAdmin.
 *
 */

package users;

import appointment.Appointment;

/**
 * 
 * @author Patrick Tynan
 * @version 1.0
 * 
 */
public class SystemAdmin extends User {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new system admin.
	 */
	// public SystemAdmin(){
	// super();
	// }
	//
	/**
	 * Instantiates a new system admin.
	 * 
	 * @param username
	 *            the uname
	 * @param password
	 *            the pword
	 * @param gender
	 *            the gend
	 * @param userInfo
	 *            the info
	 */
	public SystemAdmin(String username, String password, GenderType gender,
			UserInfo userInfo) {
		super(username, password, gender, userInfo);
	}

	/**
	 * Creates the user.
	 * 
	 * @param user
	 *            the user
	 */
	public void createUser(User user) {
		// TODO Implement Method
	}

	/**
	 * Edits the user.
	 * 
	 * @param user
	 *            the user
	 */
	public void editUser(User user) {
		// TODO Implement Method
	}

	/**
	 * Delete user.
	 * 
	 * @param user
	 *            the user
	 */
	public void deleteUser(User user) {
		// TODO Implement Method
	}

	/**
	 * Creates the treatment record.
	 */
	public void createTreatmentRecord() {
		// TODO Implement Method
	}

	/**
	 * View appointments.
	 */
	public void viewAppointments() {
		// TODO Implement Method
	}

	/**
	 * Schedule appointment.
	 * 
	 * @param appointment
	 *            the appointment
	 */
	public void scheduleAppointment(Appointment appointment) {
		// TODO Implement Method
	}

	/**
	 * View medical history.
	 * 
	 * @param user
	 *            the user
	 */
	public void viewMedicalHistory(User user) {
		// TODO Implement Method
	}

	/**
	 * View health history.
	 * 
	 * @param user
	 *            the user
	 */
	public void viewHealthHistory(User user) {
		// TODO Implement Method
	}

	/**
	 * Sets the password.
	 * 
	 * @param user
	 *            the user
	 * @param password
	 *            the password
	 */
	public void setPassword(User user, String password) {
		// TODO Implement Method
	}

	/**
	 * Suspend account.
	 * 
	 * @param user
	 *            the user
	 */
	public void suspendAccount(User user) {
		// TODO Implement Method
	}

	/**
	 * Unsuspend account.
	 * 
	 * @param user
	 *            the user
	 */
	public void unsuspendAccount(User user) {
		// TODO Implement Method
	}

	/**
	 * Converts the MedicalHistory to a string
	 * 
	 * @return the medical history in string form
	 */
	@Override
	public String toString() {
		return this.toString();
	}
}
