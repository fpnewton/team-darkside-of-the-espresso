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
