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
