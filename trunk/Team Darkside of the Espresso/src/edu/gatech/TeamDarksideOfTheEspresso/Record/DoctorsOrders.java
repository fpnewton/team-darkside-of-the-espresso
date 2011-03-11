package edu.gatech.TeamDarksideOfTheEspresso.Record;


import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Time;

import edu.gatech.TeamDarksideOfTheEspresso.Appointment.*;
import edu.gatech.TeamDarksideOfTheEspresso.Users.Doctor;


public class DoctorsOrders
{
	private Appointment			FollowUpAppointment;
	
	private List<LabWork>		LabWorkL;
	private List<Prescription>	PrescriptionsL;
	private List<String>		Instructions;
	
	/**
	 * Consturctor for DoctorsOrders
	 * Sets all lists to empty lists of the correct datatype
	 */
	public DoctorsOrders(Date Date, Time Time, Doctor Doc){
		this.FollowUpAppointment = new Appointment(Date, Time, Doc);
		this.LabWorkL = new ArrayList<LabWork>();
		this.PrescriptionsL = new ArrayList<Prescription>();
		this.Instructions = new ArrayList<String>();
	}
	
	/**
	 * Returns the follow up appointment
	 * @return the Appointment
	 */
	public Appointment getFollowUpAppointment()
	{
		return FollowUpAppointment;
	}
	
	/**
	 * Set the follow up appointment
	 * @param FollowUpAppointment the next appointment, as a follow up
	 */
	public void setFollowUpAppointment(Appointment FollowUpAppointment)
	{
		this.FollowUpAppointment = FollowUpAppointment;
	}
	
	/**
	 * Adds a new instruction to the list of instructions
	 * @param inst the new istruction to be added to the list
	 */
	public void addInstructions(String inst){
		this.Instructions.add(inst);
	}
	
	/**
	 * Clears out the list of intructions entirely.
	 */
	public void clearInstructions(){
		this.Instructions = new ArrayList<String>();
	}
	
	/**
	 * Return the list of instructions
	 * @return a list of instructions
	 */
	public List<String> getInstructions(){
		return this.Instructions;
	}
	
	/**
	 * Creates a new instance of lab work, using the given parameters
	 * then append to the lab work list
	 * @param info the information/the string for the lab work done
	 * @param price the amount charged fot the lab work performed
	 */
	public void AddLabWork(String info, String price){
		LabWork temp = new LabWork(info, price);
		this.LabWorkL.add(temp);
	}
	
	/**
	 * Clears all data from the lab work list
	 */
	public void ClearLabWork(){
		this.LabWorkL = new ArrayList<LabWork>();
	}
	
	/**
	 * 
	 */
	public List<LabWork> getLabWork(){
		return this.LabWorkL;
	}
	
	public void AddPrescription(String info, String price){
		Prescription temp = new Prescription(info, price);
		this.PrescriptionsL.add(temp);
	}
	
	public void ClearPrescription(){
		this.PrescriptionsL = new ArrayList<Prescription>();
	}
	
	public List<Prescription> getPrescription(){
		return this.PrescriptionsL;
	}
	
}
