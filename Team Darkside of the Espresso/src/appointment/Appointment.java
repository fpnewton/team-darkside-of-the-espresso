// $codepro.audit.disable variableShouldBeFinal
/*
 * The Appointment Class.
 */

package appointment;

import java.io.Serializable;
import java.util.Calendar;

import record.DoctorsOrders;

import users.Doctor;
import users.Patient;

// TODO: Auto-generated Javadoc
/**
 * The Appointment Class.
 * 
 * @author David Garner
 * @version 1.0.0
 */
public class Appointment implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The patient data. */
	private Patient patient;

	/** The Desired date. */
	private Calendar desiredDate;

	/** The Desired doctor. */
	private Doctor desiredDoctor;

	/** The Symptoms. */
	private String symptoms;

	/** The Doctors Orders for the follow-up appointment. */
	private DoctorsOrders docOrders;

	/**
	 * Appointment constructor.
	 * 
	 * @param patient
	 *            the patient
	 * @param date
	 *            the date
	 * @param doctor
	 *            the desired doctor
	 * @param symptoms
	 *            the symptoms
	 */
	public Appointment(Patient patient, Calendar date, Doctor doctor,
			String symptoms) {
		this.patient = patient;
		this.desiredDate = date;
		this.desiredDoctor = doctor;
		this.symptoms = symptoms;
		this.docOrders = null;
	}

	/**
	 * Instantiates a new appointment.
	 * 
	 * @param patient
	 *            the patient
	 * @param date
	 *            the date
	 * @param desiredDoctor
	 *            the desired doctor
	 * @param docOrders
	 *            the doc orders
	 */
	public Appointment(Patient patient, Calendar date, Doctor desiredDoctor,
			DoctorsOrders docOrders) {
		this.patient = patient;
		this.desiredDate = date;
		this.desiredDoctor = desiredDoctor;
		this.symptoms = null;
		this.docOrders = docOrders;
	}

	/**
	 * Schedule doctor.
	 * 
	 * @param doc
	 *            the doc
	 * @param pat
	 *            the pat
	 * @param preferredDate
	 *            the preferred date
	 */
	public void scheduleDoctor(Doctor doc, Patient pat, Calendar preferredDate) {
		if (!doc.checkAvailability(preferredDate)) {
			return;
		} else {
			doc.addAppointment(this);
			pat.getAppointmentHistory().add(this);
			doc.getAvailabilities().remove(this);
		}
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Calendar getDate() {
		return desiredDate;
	}

	/**
	 * Gets the desired doctor.
	 * 
	 * @return the desired doctor
	 */
	public Doctor getDesiredDoctor() {
		return desiredDoctor;
	}

	/**
	 * Gets the symptoms.
	 * 
	 * @return the symptoms
	 */
	public String getSymptoms() {
		return symptoms;
	}

	/**
	 * Sets the date.
	 * 
	 * @param date
	 *            the new date
	 */
	public void setDate(Calendar date) {
		this.desiredDate = date;
	}

	/**
	 * Sets the desired doctor.
	 * 
	 * @param desiredDoctor
	 *            the new desired doctor
	 */
	public void setDesiredDoctor(Doctor desiredDoctor) {
		this.desiredDoctor = desiredDoctor;
	}

	/**
	 * Sets the symptoms.
	 * 
	 * @param symptoms
	 *            the new symptoms
	 */
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	/**
	 * Gets the patient object.
	 * 
	 * @return The patient object
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Gets the doctors orders.
	 * 
	 * @return The doctors orders
	 */
	public DoctorsOrders getDocOrders() {
		return this.docOrders;
	}

	/**
	 * Sets the doctors orders.
	 * 
	 * @param docOrders
	 *            The doctors orders
	 */
	public void setDocOrders(DoctorsOrders docOrders) {
		this.docOrders = docOrders;
	}

	/**
	 * toString Override.
	 * 
	 * @return A string with the appointment data
	 */
	public String toString() {
		return "Patient Info: " + patient.toString() + "\nDesired Date: "
				+ desiredDate.toString() + "\nDesiredDoctor"
				+ desiredDoctor.toString() + "\nSymptoms: "
				+ symptoms.toString();
	}

	/**
	 * Sets the doctors orders.
	 * 
	 * @param docOrders
	 *            the new doctors orders
	 */
	public void setDoctorsOrders(DoctorsOrders docOrders) {
		this.docOrders = docOrders;
	}
}
