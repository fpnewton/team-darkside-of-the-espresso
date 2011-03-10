package edu.gatech.TeamDarksideOfTheEspresso.Appointment;


public class Invoice
{
	Appointment	Appointment;
	Bill		Bill;
	
	
	public Invoice(Appointment Appointment, Bill Bill){
		this.Appointment=Appointment;
		this.Bill=Bill;
	}
	
	public Appointment getAppointment()
	{
		return Appointment;
	}
	
	
	public Bill getBill()
	{
		return Bill;
	}
	
	
	public void setAppointment(Appointment Appointment)
	{
		this.Appointment = Appointment;
	}
	
	
	public void setBill(Bill Bill)
	{
		this.Bill = Bill;
	}
	
	
	public void PrintInvoice()
	{
		// TODO Implement Method
	}
}
