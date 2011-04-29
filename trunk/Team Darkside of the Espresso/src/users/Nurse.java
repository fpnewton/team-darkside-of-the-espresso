/**
 * The Class Nurse.
 */

package users;

/**
 * 
 * @author Patrick Tynan
 * @version 1.0
 * 
 */
public class Nurse extends User {

	/**
	 * Instantiates a new nurse.
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
	public Nurse(String uName, String pWord, GenderType gend, UserInfo info) {
		super(uName, pWord, gend, info);
	}

	/**
	 * Creates the patient.
	 */
	public void createPatient() {
		// TODO Implement Method
	}

	/**
	 * Delete patient.
	 */
	public void deletePatient() {
		// TODO Implement Method
	}

	/**
	 * View patients.
	 */
	public void viewPatients() {
		// TODO Implement Method
	}

	/**
	 * Edits the user.
	 * 
	 * @param patient
	 *            the patient
	 */
	public void editUser(Patient patient) {
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
	 * Converts the MedicalHistory to a string
	 * 
	 * @return the medical history in string form
	 */
	@Override
	public String toString() {
		return this.toString();
	}
}
