/**
 * The Class DoctorsOrders.
 */

package record;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import users.Doctor;
import users.Patient;

import appointment.Appointment;
import appointment.Bill;

public class DoctorsOrders implements Serializable {

	private Patient Patient;

	/** The Follow up appointment. */
	private Appointment FollowUpAppointment;

	/** The Lab work list. */
	private ArrayList<LabWork> LabWorkL;

	/** The Prescriptions list. */
	private ArrayList<Prescription> PrescriptionsL;

	/** The Doctor's Instructions. */
	private ArrayList<String> Instructions;

	/** The Doctor's Treatments */
	private ArrayList<Treatment> treatments;

	/** The Doctor's Vaccines. */
	private ArrayList<Vaccine> Vaccines;

	/** The Total Bill */
	private Bill totalBill;

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
	 *            the prescription
	 * @param instr
	 *            the doctor's instructions
	 */
	public DoctorsOrders(Patient Patient, Calendar Date, Doctor Doc,
			ArrayList<LabWork> lWork, ArrayList<Prescription> Prescip,
			ArrayList<Treatment> treatments, ArrayList<Vaccine> vaccines,
			String instr) {
		this.Patient = Patient;
		this.FollowUpAppointment = new Appointment(Patient, Date, Doc, "");

		this.LabWorkL = new ArrayList<LabWork>();
		this.PrescriptionsL = new ArrayList<Prescription>();
		this.Vaccines = new ArrayList<Vaccine>();
		this.treatments = new ArrayList<Treatment>();
		this.LabWorkL.addAll(lWork);
		this.PrescriptionsL.addAll(Prescip);
		this.Vaccines.addAll(vaccines);
		this.treatments.addAll(treatments);

		this.Instructions = new ArrayList<String>();
		this.Instructions.add(instr);
		this.totalBill = new Bill(lWork, Prescip, treatments, vaccines);

	}

	public DoctorsOrders(Patient patient2, Calendar date, Doctor doctor,
			LabWork labs, Prescription drugs, String orders) {
		// TODO Auto-generated constructor stub
		this.Patient = Patient;
		this.FollowUpAppointment = new Appointment(Patient, date, doctor, "");
		this.LabWorkL = new ArrayList<LabWork>();
		this.PrescriptionsL = new ArrayList<Prescription>();
		this.Vaccines = new ArrayList<Vaccine>();
		this.treatments = new ArrayList<Treatment>();
		
		this.LabWorkL.add(labs);
		this.PrescriptionsL.add(drugs);
	}

	/**
	 * Returns the follow up appointment.
	 * 
	 * @return the follow up Appointment
	 */
	public Appointment getFollowUpAppointment() {
		return FollowUpAppointment;
	}

	/**
	 * Set the follow up appointment.
	 * 
	 * @param FollowUpAppointment
	 *            the next appointment, as a follow up
	 */
	public void setFollowUpAppointment(Appointment FollowUpAppointment) {
		this.FollowUpAppointment = FollowUpAppointment;
	}

	/**
	 * Adds a new instruction to the list of instructions.
	 * 
	 * @param inst
	 *            the new instruction to be added to the list
	 */
	public void addInstructions(String inst) {
		this.Instructions.add(inst);
	}

	/**
	 * Clears out the list of instructions entirely.
	 */
	public void clearInstructions() {
		this.Instructions = new ArrayList<String>();
	}

	/**
	 * Return the list of instructions.
	 * 
	 * @return a list of instructions
	 */
	public List<String> getInstructions() {
		return this.Instructions;
	}

	/**
	 * Creates a new instance of lab work, using the given parameters then
	 * append to the lab work list.
	 * 
	 * @param info
	 *            the information/the string for the lab work done
	 * @param price
	 *            the amount charged for the lab work performed
	 */
	public void AddLabWork(String info, double price) {
		LabWork temp = new LabWork(info, price);
		this.LabWorkL.add(temp);
	}

	/**
	 * Clears all data from the lab work list.
	 */
	public void ClearLabWork() {
		this.LabWorkL = new ArrayList<LabWork>();
	}

	/**
	 * Gets the lab work.
	 * 
	 * @return the lab work
	 */
	public List<LabWork> getLabWork() {
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
	public void AddPrescription(String info, double price) {
		Prescription temp = new Prescription(info, price);
		this.PrescriptionsL.add(temp);
	}

	/**
	 * Clear prescription.
	 */
	public void ClearPrescription() {
		this.PrescriptionsL = new ArrayList<Prescription>();
	}

	/**
	 * Gets the prescription.
	 * 
	 * @return the prescription
	 */
	public List<Prescription> getPrescription() {
		return this.PrescriptionsL;
	}

	/**
	 * Adds a new vaccine to the list of vaccines.
	 * 
	 * @param inst
	 *            the new vaccine to be added to the list
	 */
	public void addVaccines(Vaccine vaccine) {
		this.Vaccines.add(vaccine);
	}

	/**
	 * Clears out the list of vaccines entirely.
	 */
	public void clearVaccines() {
		this.Vaccines = new ArrayList<Vaccine>();
	}

	/**
	 * Return the list of Vaccines.
	 * 
	 * @return a list of Vaccines
	 */
	public List<Vaccine> getVaccines() {
		return this.Vaccines;
	}
	
	public Bill getBill(){
		return this.totalBill;
	}


	public void setSymptoms(String text) {
		// TODO Auto-generated method stub
	}

}
