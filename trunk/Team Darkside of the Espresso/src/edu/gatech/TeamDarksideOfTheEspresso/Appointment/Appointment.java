/**
 * The Class Appointment.
 */

package edu.gatech.TeamDarksideOfTheEspresso.Appointment;


import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import edu.gatech.TeamDarksideOfTheEspresso.Users.Doctor;


public class Appointment implements Serializable
{

	/** The Desired date. */
	private Date	DesiredDate;

	/** The Desired doctor. */
	private Doctor	DesiredDoctor;

	/** The Symptoms. */
	private String	Symptoms;

	/** The Desired time. */
	private Time	DesiredTime;


	/**
	 * Appointment constructor.
	 * 
	 * @param date
	 *            the date
	 * @param time
	 *            the time
	 * @param desiredDoctor
	 *            the desired doctor
	 * @param symptoms
	 *            the symptoms
	 */
	public Appointment(Date date, Time time, Doctor desiredDoctor, String symptoms)
	{
		this.DesiredDate = date;
		this.DesiredTime = time;
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
	public Appointment(Date Date, Time Time, Doctor DesiredDoctor)
	{
		this(Date, Time, DesiredDoctor, null);
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
		// TODO This method depends heavily on doctor attributes
		// that determine availability as well as an attribute
		// that stores dates during which the doctor has
		// scheduled appointments. This method,
		// therefore, is commented out and in high-level
		// pseudocode until this is fixed

		/*
		 * if(!doc.checkAvailability(date, time)) return;
		 * 
		 * else{ remove Date from available dates list insert Date into
		 * unavailable dates list }
		 */
	}


	/**
	 * Checks whether a doctor is available at the desired date and time.
	 * 
	 * @param doc
	 *            The desired doctor
	 * @param date
	 *            The desired date
	 * @return True if the doctor is available at that time, false otherwise
	 */
	public boolean checkAvailability(Doctor doc, Date date)
	{
		// TODO I believe this should be in the Doctor class. Therefore,
		// the method has been commented out for now.

		/**
		 * check which date list is smaller (available or unavailable)
		 * 
		 * if unavailable is smaller, comb through for the date if the date is
		 * there, return false else return true
		 * 
		 * else if available is smaller, comb through for the date if the date
		 * is there, return true else return false
		 */

		return false;
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
	 * Gets the time.
	 * 
	 * @return the time
	 */
	public Time getTime()
	{
		return DesiredTime;
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


	/**
	 * Sets the time.
	 * 
	 * @param Time
	 *            the new time
	 */
	public void setTime(Time Time)
	{
		this.DesiredTime = Time;
	}
}
