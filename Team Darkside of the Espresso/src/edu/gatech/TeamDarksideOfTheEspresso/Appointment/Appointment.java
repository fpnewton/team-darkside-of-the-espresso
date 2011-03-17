/**
 * The Class Appointment.
 */

package edu.gatech.TeamDarksideOfTheEspresso.Appointment;


import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import edu.gatech.TeamDarksideOfTheEspresso.Users.Doctor;
import edu.gatech.TeamDarksideOfTheEspresso.Users.Patient;

public class Appointment implements Serializable
{
	private Patient Patient;
	
	/** The Desired date. */
	private Date	DesiredDate;

	/** The Desired doctor. */
	private Doctor	DesiredDoctor;

	/** The Symptoms. */
	private String	Symptoms;


	/**
	 * Appointment constructor.
	 * 
	 * @param date
	 *            the date
	 * @param desiredDoctor
	 *            the desired doctor
	 * @param symptoms
	 *            the symptoms
	 */
	public Appointment(Patient Patient, Date date, Doctor desiredDoctor, String symptoms)
	{
		this.Patient=Patient;
		this.DesiredDate = date;
		this.DesiredDoctor = desiredDoctor;
		this.Symptoms = symptoms;
	}


	/**
	 * Instantiates a new appointment.
	 * 
	 * @param Date
	 *            the date
	 * @param Time
	 *            the time
	 * @param DesiredDoctor
	 *            the desired doctor
	 */
	public Appointment(Patient Patient, Date Date, Doctor DesiredDoctor)
	{
		this(Patient, Date, DesiredDoctor, null);
	}


	/**
	 * Schedules a doctor at a specific date if he/she is available.
	 * 
	 * @param doc
	 *            The desired doctor
	 * @param preferredDate
	 *            the preferred date
	 */
	public void scheduleDoctor(Doctor doc, Date preferredDate)
	{
		

		  if(!doc.checkAvailability(preferredDate)) return;
		  
		  else
		  		doc.addAppointment(this);
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Date getDate()
	{
		return DesiredDate;
	}


	/**
	 * Gets the desired doctor.
	 * 
	 * @return the desired doctor
	 */
	public Doctor getDesiredDoctor()
	{
		return DesiredDoctor;
	}


	/**
	 * Gets the symptoms.
	 * 
	 * @return the symptoms
	 */
	public String getSymptoms()
	{
		return Symptoms;
	}

	/**
	 * Sets the date.
	 * 
	 * @param Date
	 *            the new date
	 */
	public void setDate(Date Date)
	{
		this.DesiredDate = Date;
	}


	/**
	 * Sets the desired doctor.
	 * 
	 * @param DesiredDoctor
	 *            the new desired doctor
	 */
	public void setDesiredDoctor(Doctor DesiredDoctor)
	{
		this.DesiredDoctor = DesiredDoctor;
	}


	/**
	 * Sets the symptoms.
	 * 
	 * @param Symptoms
	 *            the new symptoms
	 */
	public void setSymptoms(String Symptoms)
	{
		this.Symptoms = Symptoms;
	}
	
	public Patient getPatient(){
		return Patient;
	}
}
