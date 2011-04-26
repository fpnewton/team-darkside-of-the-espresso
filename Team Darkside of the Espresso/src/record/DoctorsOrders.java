/**
 * The Class DoctorsOrders.
 */

package record;


import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import users.Doctor;
import users.Patient;

import appointment.Appointment;


public class DoctorsOrders implements Serializable
{

	private Patient				Patient;
	
	/** The Follow up appointment. */
	private Appointment			FollowUpAppointment;

	/** The Lab work list. */
	private List<LabWork>		LabWorkL;

	/** The Prescriptions list. */
	private List<Prescription>	PrescriptionsL;

	/** The Doctor's Instructions. */
	private List<String>		Instructions;


	/**
	 * Constructor for DoctorsOrders Sets all lists to empty lists of the
	 * correct datatype.
	 * 
	 * @param Date
	 *            the date of the appointment
	 * @param Time
	 *            the time of the appointment
	 * @param Doc
	 *            the Doctor
	 * @param lWork
	 *            the lab work
	 * @param Prescip
	 *            the prescipyion
	 * @param instr
	 *            the doctor's instructions
	 */
	public DoctorsOrders(Patient Patient, Calendar Date, Doctor Doc, LabWork lWork, Prescription Prescip, String instr)
	{
		this.Patient = Patient;
		this.FollowUpAppointment = new Appointment(Patient, Date, Doc,"");
		this.LabWorkL.add(lWork);
		this.PrescriptionsL.add(Prescip);
		this.Instructions.add(instr);
	}


	/**
	 * Returns the follow up appointment.
	 * 
	 * @return the follw up Appointment
	 */
	public Appointment getFollowUpAppointment()
	{
		return FollowUpAppointment;
	}


	/**
	 * Set the follow up appointment.
	 * 
	 * @param FollowUpAppointment
	 *            the next appointment, as a follow up
	 */
	public void setFollowUpAppointment(Appointment FollowUpAppointment)
	{
		this.FollowUpAppointment = FollowUpAppointment;
	}


	/**
	 * Adds a new instruction to the list of instructions.
	 * 
	 * @param inst
	 *            the new instruction to be added to the list
	 */
	public void addInstructions(String inst)
	{
		this.Instructions.add(inst);
	}


	/**
	 * Clears out the list of instructions entirely.
	 */
	public void clearInstructions()
	{
		this.Instructions = new ArrayList<String>();
	}


	/**
	 * Return the list of instructions.
	 * 
	 * @return a list of instructions
	 */
	public List<String> getInstructions()
	{
		return this.Instructions;
	}


	/**
	 * Creates a new instance of lab work, using the given parameters then
	 * append to the lab work list.
	 * 
	 * @param info
	 *            the information/the string for the lab work done
	 * @param price
	 *            the amount charged fot the lab work performed
	 */
	public void AddLabWork(String info, String price)
	{
		LabWork temp = new LabWork(info, price);
		this.LabWorkL.add(temp);
	}


	/**
	 * Clears all data from the lab work list.
	 */
	public void ClearLabWork()
	{
		this.LabWorkL = new ArrayList<LabWork>();
	}


	/**
	 * Gets the lab work.
	 * 
	 * @return the lab work
	 */
	public List<LabWork> getLabWork()
	{
		return this.LabWorkL;
	}


	/**
	 * Adds the prescription.
	 * 
	 * @param info
	 *            the info
	 * @param price
	 *            the price
	 */
	public void AddPrescription(String info, String price)
	{
		Prescription temp = new Prescription(info, price);
		this.PrescriptionsL.add(temp);
	}


	/**
	 * Clear prescription.
	 */
	public void ClearPrescription()
	{
		this.PrescriptionsL = new ArrayList<Prescription>();
	}


	/**
	 * Gets the prescription.
	 * 
	 * @return the prescription
	 */
	public List<Prescription> getPrescription()
	{
		return this.PrescriptionsL;
	}

}
