package edu.gatech.TeamDarksideOfTheEspresso.Users;


import java.util.List;

import edu.gatech.TeamDarksideOfTheEspresso.Appointment.Appointment;


public class Patient extends User
{
	private PatientInfo			PatientInfo;
	private List<Appointment>	AppointmentHistory;
	
	
	public PatientInfo getPatientInfo()
	{
		return PatientInfo;
	}
	
	
	// TODO Add Get Methods/Set Methods
	
	
	public void ScheduleAppointment(Appointment Appointment)
	{
		// TODO Implement Method
	}
	
	
	public void ViewMedicalHistory()
	{
		// TODO Implement Method
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
