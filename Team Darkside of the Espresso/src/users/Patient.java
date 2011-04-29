/**
 * The Class Patient.
 */

package users;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;

import log.SystemLog;

import record.HealthHistory;
import record.MedicalHistory;

import appointment.Appointment;

/**
 * 
 * @author Patrick Tynan
 * @version 1.0
 */
public class Patient extends User {

	/** The my patient info. */
	private PatientInfo myPatientInfo;

	/** The Appointment history. */
	private List<Appointment> appointmentHistory = new ArrayList<Appointment>();

	/** The my med history. */
	private MedicalHistory myMedHistory;

	/** The my health history. */
	private HealthHistory myHealthHistory;

	/** The Current appointments. */
	private final List<Appointment> currentAppointments;

	/**
	 * Instantiates a new patient.
	 * 
	 * @param uName
	 *            the uname
	 * @param pWord
	 *            the pword
	 * @param gend
	 *            the gend
	 * @param info
	 *            the info
	 * @param patInfo
	 *            the pat info
	 */
	public Patient(String uName, String pWord, GenderType gend, UserInfo info,
			PatientInfo patInfo) {
		super(uName, pWord, gend, info);
		this.myPatientInfo = patInfo;
		this.currentAppointments = new ArrayList<Appointment>();
		this.myHealthHistory = new HealthHistory();
	}

	/**
	 * Gets the patient info.
	 * 
	 * @return the patient info
	 */
	public PatientInfo getPatientInfo() {
		return myPatientInfo;
	}

	/**
	 * Schedule appointment.
	 * 
	 * @param date
	 *            the date
	 * @param symptoms
	 *            the symptoms
	 * @param preferredDoctor
	 *            the preferred doctor
	 */
	public void scheduleAppointment(Calendar date, String symptoms,
			Doctor preferredDoctor) {
		try {
			final Appointment appt = new Appointment(this, date, preferredDoctor,
					symptoms);
			if (preferredDoctor.isAvailable(date)) {
				appt.scheduleDoctor(preferredDoctor, null, date);
			}
		} catch (Exception e) {
			SystemLog.canLogMessage(e.getMessage(), Level.SEVERE);
		}
	}

	/**
	 * Sets the patient info.
	 * 
	 * @param patInfo
	 *            the new patient info
	 */
	public void setPatientInfo(PatientInfo patInfo) {
		this.myPatientInfo = patInfo;
	}

	/**
	 * View medical history.
	 */
	public void viewMedicalHistory() {
		System.out.println(myMedHistory.toString());
	}

	/**
	 * Sets the medical history.
	 * 
	 * @param mHistory
	 *            the new medical history
	 */
	public void setMedicalHistory(MedicalHistory mHistory) {
		this.myMedHistory = mHistory;
	}

	/**
	 * Gets the medical history.
	 * 
	 * @return the medical history
	 */
	public MedicalHistory getMedicalHistory() {
		return this.myMedHistory;
	}

	/**
	 * Sets the health history.
	 * 
	 * @param hHistory
	 *            the new health history
	 */
	public void setHealthHistory(HealthHistory hHistory) {
		this.myHealthHistory = hHistory;
	}

	/**
	 * View health history.
	 */
	public void viewHealthHistory() {
		// TODO Implement Method
	}

	/**
	 * View invoice.
	 */
	public void viewInvoice() {
		// TODO Implement Method
	}

	/**
	 * Gets the health history.
	 * 
	 * @return the health history
	 */
	public HealthHistory getHealthHistory() {
		return myHealthHistory;
	}

	/**
	 * Sets the appointment history.
	 * 
	 * @param appointmentHistory
	 *            the new appointment history
	 */
	public void setAppointmentHistory(List<Appointment> appointmentHistory) {
		this.appointmentHistory = appointmentHistory;
	}

	/**
	 * Gets the appointment history.
	 * 
	 * @return the appointment history
	 */
	public List<Appointment> getAppointmentHistory() {
		return appointmentHistory;
	}

	/**
	 * Gets the current appointments
	 * 
	 * @return the current appointments
	 */
	public List<Appointment> getCurrentAppointments() {
		return currentAppointments;
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
