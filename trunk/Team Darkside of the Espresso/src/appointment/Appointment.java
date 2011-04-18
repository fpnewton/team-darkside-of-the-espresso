/*
 * The Appointment Class.
 */

package appointment;

import java.io.Serializable;
import java.util.Date;

import users.Doctor;
import users.Patient;

/**
 * The Appointment Class.
 * 
 * @author David Garner
 * @version 1.0.0
 */
public class Appointment implements Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /** The patient data. */
    private Patient patient;

    /** The Desired date. */
    private Date desiredDate;

    /** The Desired doctor. */
    private Doctor desiredDoctor;

    /** The Symptoms. */
    private String symptoms;

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
    public Appointment(Patient patient, Date date, Doctor doctor, String symptoms) {
	this.patient = patient;
	this.desiredDate = date;
	this.desiredDoctor = doctor;
	this.symptoms = symptoms;
    }

    /**
     * Instantiates a new appointment.
     * 
     * @param patient
     *            The patient
     * @param date
     *            the date
     * @param desiredDoctor
     *            the desired doctor
     */
    public Appointment(Patient patient, Date date, Doctor desiredDoctor) {
	this(patient, date, desiredDoctor, null);
    }

    /**
     * Schedules a doctor at a specific date if he/she is available.
     * 
     * @param doc
     *            The desired doctor
     * @param preferredDate
     *            the preferred date
     */
    public void scheduleDoctor(Doctor doc, Patient pat, Date preferredDate) {
    	if (!doc.checkAvailability(preferredDate)) {
    		return;
    	} else {
    		doc.addAppointment(this);
    		pat.getAppointmentHistory().add(this);
    	}
    }

    /**
     * Gets the date.
     * 
     * @return the date
     */
    public Date getDate() {
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
    public void setDate(Date date) {
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
     * Gets the patient object
     * 
     * @return The patient object
     */
    public Patient getPatient() {
	return patient;
    }

    /**
     * toString Override
     * 
     * @return A string with the appointment data
     */
    public String toString() {
	return "Patient Info: " + patient.toString() + "\nDesired Date: "
		+ desiredDate.toString() + "\nDesiredDoctor" + desiredDoctor.toString()
		+ "\nSymptoms: " + symptoms.toString();
    }
    
}
