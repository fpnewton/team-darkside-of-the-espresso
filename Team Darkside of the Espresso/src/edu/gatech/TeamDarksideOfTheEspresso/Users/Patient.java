package edu.gatech.TeamDarksideOfTheEspresso.Users;


import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.sql.Time;

import edu.gatech.TeamDarksideOfTheEspresso.Appointment.Appointment;
import edu.gatech.TeamDarksideOfTheEspresso.Record.HealthHistory;
import edu.gatech.TeamDarksideOfTheEspresso.Record.MedicalHistory;
import edu.gatech.TeamDarksideOfTheEspresso.SystemLog.SystemLog;

/**
 * 
 * 
 * 
 * @author Patrick Tynan
 * @version 1.0
 * 
 */

public class Patient extends User
{
	private PatientInfo			myPatientInfo;
	private ArrayList<Appointment>	AppointmentHistory;
	private MedicalHistory			myMedHistory;
	private HealthHistory		myHealthHistory;

	
	
	public Patient(PatientInfo PatInfo){
		this.myPatientInfo = PatInfo;
		
	}
	
	public PatientInfo getPatientInfo()
	{
		return myPatientInfo;
	}
	
	
	// TODO Add Get Methods/Set Methods
	
	
	public void ScheduleAppointment(Date date, Time time, String symptoms, Doctor PreferredDoctor)
	{
		try{
			Appointment Appt = new Appointment(date, time, PreferredDoctor, symptoms);
			if(Appt.checkAvailability(PreferredDoctor, time)){
				Appt.scheduleAvailability(PreferredDoctor, time);
			}
		}
		catch(Exception e){
			SystemLog.LogMessage("Didn't Work!", Level.ALL);
		}
	}
	
	
	public void ViewMedicalHistory()
	{
		myMedHistory.toString();
	}
	
	
	public void ViewHealthHistory()
	{
		// TODO Implement Method
	}
	
	
	public void ViewInvoice()
	{
		// TODO Implement Method
	}
}
