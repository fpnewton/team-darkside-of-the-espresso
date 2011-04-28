/**
 * The Class Patient.
 * 
 * @author Patrick Tynan
 * @version 1.0
 */

package users;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;

import log.SystemLog;

import record.HealthHistory;
import record.MedicalHistory;

import appointment.Appointment;

public class Patient extends User {

	/** The my patient info. */
	private PatientInfo myPatientInfo;

	/** The Appointment history. */
	private ArrayList<Appointment> AppointmentHistory = new ArrayList<Appointment>();

	/** The my med history. */
	private MedicalHistory myMedHistory;

	/** The my health history. */
	private HealthHistory myHealthHistory;

	/**
	 * Instantiates a new patient.
	 * 
	 * @param Uname
	 *            the uname
	 * @param Pword
	 *            the pword
	 * @param Gend
	 *            the gend
	 * @param Info
	 *            the info
	 * @param PatInfo
	 *            the pat info
	 */
	// public Patient(){
	// super();
	// }

	/**
	 * Instantiates a new patient.
	 * 
	 * @param Uname
	 *            the uname
	 * @param Pword
	 *            the pword
	 * @param Gend
	 *            the gend
	 * @param Info
	 *            the info
	 * @param PatInfo
	 *            the pat info
	 */
	public Patient(String Uname, String Pword, GenderType Gend, UserInfo Info,
			PatientInfo PatInfo) {
		super(Uname, Pword, Gend, Info);
		this.myPatientInfo = PatInfo;
	}

	/**
	 * Gets the patient info.
	 * 
	 * @return the patient info
	 */
	public PatientInfo getPatientInfo() {
		return myPatientInfo;
	}

	// TODO Add Get Methods/Set Methods

	/**
	 * Schedule appointment.
	 * 
	 * @param date
	 *            the date
	 * @param time
	 *            the time
	 * @param symptoms
	 *            the symptoms
	 * @param PreferredDoctor
	 *            the preferred doctor
	 */
	public void scheduleAppointment(Calendar date, String symptoms,
			Doctor PreferredDoctor) {
		try {
			Appointment Appt = new Appointment(this, date, PreferredDoctor,
					symptoms);
			if (PreferredDoctor.checkAvailability(date)) {
				Appt.scheduleDoctor(PreferredDoctor, null, date);
			}
		} catch (Exception e) {
			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);
		}
	}

	/**
	 * Sets the patient info.
	 * 
	 * @param PatInfo
	 *            the new patient info
	 */
	public void setPatientInfo(PatientInfo PatInfo) {
		this.myPatientInfo = PatInfo;
	}

	/**
	 * View medical history.
	 */
	public void ViewMedicalHistory() {
		myMedHistory.toString();
	}

	/**
	 * Sets the medical history.
	 * 
	 * @param MHistory
	 *            the new medical history
	 */
	public void setMedicalHistory(MedicalHistory MHistory) {
		this.myMedHistory = MHistory;
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
	 * @param HHistory
	 *            the new health history
	 */
	public void setHealthHistory(HealthHistory HHistory) {
		this.myHealthHistory = HHistory;
	}

	/**
	 * View health history.
	 */
	public void ViewHealthHistory() {
		// TODO Implement Method
	}

	/**
	 * View invoice.
	 */
	public void ViewInvoice() {
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
	public void setAppointmentHistory(ArrayList<Appointment> appointmentHistory) {
		AppointmentHistory = appointmentHistory;
	}

	/**
	 * Gets the appointment history.
	 * 
	 * @return the appointment history
	 */
	public ArrayList<Appointment> getAppointmentHistory() {
		return AppointmentHistory;
	}

}
