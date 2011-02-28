package edu.gatech.TeamDarksideOfTheEspresso.Record;


import java.util.List;


import edu.gatech.TeamDarksideOfTheEspresso.Appointment.*;


public class DoctorsOrders
{
	private Appointment			FollowUpAppointment;
	
	private List<LabWork>		LabWork;
	private List<Prescription>	Prescriptions;
	private List<String>		Instructions;
	
	
	public Appointment getFollowUpAppointment()
	{
		return FollowUpAppointment;
	}
	
	
	public void setFollowUpAppointment(Appointment Appointment)
	{
		this.FollowUpAppointment = FollowUpAppointment;
	}
	
	
	// TODO Implement Methods
}
