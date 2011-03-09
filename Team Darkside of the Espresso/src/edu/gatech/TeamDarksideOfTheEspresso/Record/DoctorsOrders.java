package edu.gatech.TeamDarksideOfTheEspresso.Record;


import java.util.List;
import java.util.ArrayList;


import edu.gatech.TeamDarksideOfTheEspresso.Appointment.*;


public class DoctorsOrders
{
	private Appointment			FollowUpAppointment;
	
	private List<LabWork>		LabWorkL;
	private List<Prescription>	PrescriptionsL;
	private List<String>		Instructions;
	
	public DoctorsOrders(){
		this.FollowUpAppointment = new Appointment();
		this.LabWorkL = new ArrayList<LabWork>();
		this.PrescriptionsL = new ArrayList<Prescription>();
		this.Instructions = new ArrayList<String>();
	}
	
	public Appointment getFollowUpAppointment()
	{
		return FollowUpAppointment;
	}
	
	
	public void setFollowUpAppointment(Appointment Appointment)
	{
		this.FollowUpAppointment = FollowUpAppointment;
	}
	
	public void addInstructions(String inst){
		this.Instructions.add(inst);
	}
	
	public void clearInstructions(){
		this.Instructions = new ArrayList<String>();
	}
	
	public List<String> getInstructions(){
		return this.Instructions;
	}
	
	public void AddLabWork(String info, String price){
		LabWork temp = new LabWork(info, price);
		this.LabWorkL.add(temp);
	}
	
	public void ClearLabWork(String info, String price){
		this.LabWorkL = new ArrayList<LabWork>();
	}
	
	public List<LabWork> getLabWork(){
		return this.LabWorkL;
	}
	
	public void AddPrescription(String info, String price){
		Prescription temp = new Prescription(info, price);
		this.PrescriptionsL.add(temp);
	}
	
	public void ClearPrescription(String info, String price){
		this.PrescriptionsL = new ArrayList<Prescription>();
	}
	
	public List<Prescription> getPrescription(){
		return this.PrescriptionsL;
	}
	
}
