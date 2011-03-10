package edu.gatech.TeamDarksideOfTheEspresso.Appointment;


import java.util.Date;
import java.sql.Time;

import edu.gatech.TeamDarksideOfTheEspresso.Users.Doctor;


public class Appointment
{
	private Date		Date;
	
	private Doctor		DesiredDoctor;
	
	private String		Symptoms;
	
	private Time		Time;
	

	/**
	 * Appointment constructor
	 * 
	 * @param Date The desired date of the appointment
	 * @param Time The desired time of the appointment
	 * @param DesiredDoctor The desired doctor
	 * @param Symptoms Any symptoms the patient is experiencing.
	 */
	public Appointment(Date Date, Time Time, Doctor DesiredDoctor, String Symptoms){
		this.Date=Date;
		this.Time=Time;
		this.DesiredDoctor=DesiredDoctor;
		this.Symptoms=Symptoms;
	}
	
	public Appointment(){
		this(null, null, null, null);
	}
	
	/**
	 * Schedules a doctor at a specific date if he/she is available
	 * 
	 * @param doc The desired doctor
	 * @param date The desired date
	 * @param time The desired time
	 */
	public void scheduleDoctor(Doctor doc, Date date){
		//TODO This method depends heavily on doctor attributes
		//		that determine availability as well as an attribute
		//		that stores dates during which the doctor has
		//		scheduled appointments. This method,
		//		therefore, is commented out and in high-level
		//		pseudocode until this is fixed
		
		/**
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
	public boolean checkAvailability(Doctor doc, Date time){
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
		return Date;
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
		return Time;
	}
	
	
	public void setDate(Date Date)
	{
		this.Date = Date;
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
		this.Time = Time;
	}
}
