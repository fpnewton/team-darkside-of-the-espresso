package edu.gatech.TeamDarksideOfTheEspresso.Users;


import java.util.ArrayList;
import java.util.Date;

import edu.gatech.TeamDarksideOfTheEspresso.Record.DoctorsOrders;
import edu.gatech.TeamDarksideOfTheEspresso.Record.LabWork;
import edu.gatech.TeamDarksideOfTheEspresso.Record.Prescription;
import edu.gatech.TeamDarksideOfTheEspresso.Appointment.*;

/**
 * 
 * 
 * @author Patrick Tynan
 * @version 1.0
 * 
 */

public class Doctor extends Nurse
{
	private ArrayList<Appointment> CurrentAppointments; 
	private ArrayList<Date> AvailableAppointmentTimes;

	
	public void AddDoctorsOrders(String orders, Prescription drugs, LabWork labs, Appointment appt, Patient pat)
	{
		// TODO MAKE SURE CONSTRUCTOR GETS FIXED
		DoctorsOrders docOrder = new DoctorsOrders();
		pat.getTreatmentRecord().addDoctorsOrders(docOrder);
		
		this.finishAppointment(appt);
	}
	
	public void addAppointment(Appointment appt){
		CurrentAppointments.add(appt);
	}
	
	public void finishAppointment(Appointment appt){
		CurrentAppointments.remove(appt);
	}
	
	
	public boolean checkAvailability(Doctor doc, Date time){
		/**
		 * check which date list is smaller (available or unavailable)
		 * 
		 * if unavailable is smaller, comb through for the date
		 * if the date is there, return false
		 * 	else return true
		 * 
		 */
		//Search for a match between passed param time and times in the CurrentAppointment list
		for(Appointment i: CurrentAppointments){
			if(i.getTime().equals(time)){
				return false;
			}
		}
		return true;		
	}
	
	public Doctor(){
		
	}
	
	public Doctor(String Uname, String Pword, GenderType Gend, UserInfo Info){
		super(Uname, Pword, Gend, Info);
		AvailableAppointmentTimes = new ArrayList<Date>();
		//initialize available dates
		
	}
	
	
	public void ViewReports()
	{
		// TODO Implement Method
	}
}
