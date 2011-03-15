package edu.gatech.TeamDarksideOfTheEspresso.Appointment;


import java.util.Date;
import java.sql.Time;

import edu.gatech.TeamDarksideOfTheEspresso.Users.Doctor;


public class Appointment
{
	private Date		DesiredDate;
	
	private Doctor		DesiredDoctor;
	
	private String		Symptoms;
	
	private Time		DesiredTime;
	

	/**
	 * Appointment constructor
	 * 
	 * @param Date The desired date of the appointment
	 * @param DesiredTime The desired time of the appointment
	 * @param DesiredDoctor The desired doctor
	 * @param Symptoms Any symptoms the patient is experiencing.
	 */
	public Appointment(Date date, Time time, Doctor desiredDoctor, String symptoms){
		this.DesiredDate=date;
		this.DesiredTime=time;
		this.DesiredDoctor=desiredDoctor;
		this.Symptoms=symptoms;
	}
	
	public Appointment(Date Date, Time Time, Doctor DesiredDoctor){
		this(Date, Time, DesiredDoctor, null);
	}
	
	/**
	 * Schedules a doctor at a specific date if he/she is available
	 * 
	 * @param doc The desired doctor
	 * @param date The desired date
	 * @param time The desired time
	 */
	public void scheduleDoctor(Doctor doc, Date preferredDate){
		//TODO This method depends heavily on doctor attributes
		//		that determine availability as well as an attribute
		//		that stores dates during which the doctor has
		//		scheduled appointments. This method,
		//		therefore, is commented out and in high-level
		//		pseudocode until this is fixed
		
		/*
		 *  if(!doc.checkAvailability(date, time))
		 *  	return;
		 *  
		 *  else{
		 *  	remove Date from available dates list
		 *  	insert Date into unavailable dates list
		 *  }
		 */
	}
	
	/**
	 * Checks whether a doctor is available at the desired date
	 * and time
	 * 
	 * @param doc The desired doctor
	 * @param date The desired date
	 * @param time The desired time
	 * @return True if the doctor is available at that time,
	 * 			false otherwise
	 */
	public boolean checkAvailability(Doctor doc, Date date){
		//TODO I believe this should be in the Doctor class. Therefore,
		//		the method has been commented out for now.
		
		/**
		 * check which date list is smaller (available or unavailable)
		 * 
		 * if unavailable is smaller, comb through for the date
		 * if the date is there, return false
		 * 	else return true
		 * 
		 * else if available is smaller, comb through for the date
		 * if the date is there, return true
		 * 	else return false
		 */
		
		return false;
	}
	
	public Date getDate()
	{
		return DesiredDate;
	}
	
	
	public Doctor getDesiredDoctor()
	{
		return DesiredDoctor;
	}
	
	
	public String getSymptoms()
	{
		return Symptoms;
	}
	
	
	public Time getTime()
	{
		return DesiredTime;
	}
	
	
	public void setDate(Date Date)
	{
		this.DesiredDate = Date;
	}
	
	
	public void setDesiredDoctor(Doctor DesiredDoctor)
	{
		this.DesiredDoctor = DesiredDoctor;
	}
	
	
	public void setSymptoms(String Symptoms)
	{
		this.Symptoms = Symptoms;
	}
	
	
	public void setTime(Time Time)
	{
		this.DesiredTime = Time;
	}
}
