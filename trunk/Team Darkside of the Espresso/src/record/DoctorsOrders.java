/** The class DoctorsOrders */

package record;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import users.Doctor;
import users.Patient;

import appointment.Appointment;
import appointment.Bill;

/**
 * The Class DoctorsOrders.
 * 
 * @author David Garner
 * @version 1.0.0
 */
public class DoctorsOrders implements Serializable {

	/** The patient. */
	private final Patient patient;

	/** The Follow up appointment. */
	private Appointment followUpAppointment;

	/** The Lab work list. */
	private List<LabWork> labWorkL;

	/** The Prescriptions list. */
	private List<Prescription> prescriptionsL;

	/** The Doctor's Instructions. */
	private List<String> instructions;

	/** The Doctor's Treatments */
	private final List<Treatment> treatments;

	/** The Doctor's Vaccines. */
	private List<Vaccine> vaccines;

	/** The Total Bill */
	private Bill totalBill;

	// TODO Make fewer parameters
	/**
	 * Constructor for DoctorsOrders Sets all lists to empty lists of the
	 * correct datatype.
	 * 
	 * @param patient
	 *            the patient
	 * @param date
	 *            the date of the appointment
	 * @param doc
	 *            the Doctor
	 * @param lWork
	 *            the lab work
	 * @param prescriptions
	 *            the prescription
	 * @param treatments
	 *            the treatments
	 * @param vaccines
	 *            the vaccines
	 * @param instr
	 *            the doctor's instructions
	 */
	public DoctorsOrders(Patient patient, Calendar date, Doctor doc,
			List<LabWork> lWork, List<Prescription> prescriptions,
			List<Treatment> treatments, List<Vaccine> vaccines, String instr) {
		this.patient = patient;
		this.followUpAppointment = new Appointment(patient, date, doc, "");

		this.labWorkL = new ArrayList<LabWork>();
		this.prescriptionsL = new ArrayList<Prescription>();
		this.vaccines = new ArrayList<Vaccine>();
		this.treatments = new ArrayList<Treatment>();
		this.labWorkL.addAll(lWork);
		this.prescriptionsL.addAll(prescriptions);
		this.vaccines.addAll(vaccines);
		this.treatments.addAll(treatments);

		this.instructions = new ArrayList<String>();
		this.instructions.add(instr);
		this.totalBill = new Bill(lWork, prescriptions, treatments, vaccines);

	}

	// TODO Make fewer parameters
	/**
	 * Constructor for doctor's orders
	 * 
	 * @param patient2
	 *            the patient
	 * @param date
	 *            the date
	 * @param doctor
	 *            the treating doctor
	 * @param labs
	 *            the labs
	 * @param drugs
	 *            the drugs
	 * @param orders
	 *            the instructions
	 */
	public DoctorsOrders(Patient patient2, Calendar date, Doctor doctor,
			LabWork labs, Prescription drugs, String orders) {
		this.patient = patient2;
		this.followUpAppointment = new Appointment(patient, date, doctor, "");
		this.labWorkL = new ArrayList<LabWork>();
		this.prescriptionsL = new ArrayList<Prescription>();
		this.vaccines = new ArrayList<Vaccine>();
		this.treatments = new ArrayList<Treatment>();

		this.labWorkL.add(labs);
		this.prescriptionsL.add(drugs);
	}

	/**
	 * Returns the follow up appointment.
	 * 
	 * @return the follow up Appointment
	 */
	public Appointment getFollowUpAppointment() {
		return followUpAppointment;
	}

	/**
	 * Set the follow up appointment.
	 * 
	 * @param followUpAppointment
	 *            the next appointment, as a follow up
	 */
	public void setFollowUpAppointment(Appointment followUpAppointment) {
		this.followUpAppointment = followUpAppointment;
	}

	/**
	 * Adds a new instruction to the list of instructions.
	 * 
	 * @param inst
	 *            the new instruction to be added to the list
	 */
	public void addInstructions(String inst) {
		this.instructions.add(inst);
	}

	/**
	 * Clears out the list of instructions entirely.
	 */
	public void clearInstructions() {
		this.instructions = new ArrayList<String>();
	}

	/**
	 * Return the list of instructions.
	 * 
	 * @return a list of instructions
	 */
	public List<String> getInstructions() {
		return this.instructions;
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
	public void addLabWork(String info, double price) {
		final LabWork temp = new LabWork(info, price);
		this.labWorkL.add(temp);
	}

	/**
	 * Clears all data from the lab work list.
	 */
	public void clearLabWork() {
		this.labWorkL = new ArrayList<LabWork>();
	}

	/**
	 * Gets the lab work.
	 * 
	 * @return the lab work
	 */
	public List<LabWork> getLabWork() {
		return this.labWorkL;
	}

	/**
	 * Adds the prescription.
	 * 
	 * @param info
	 *            the info
	 * @param price
	 *            the price
	 */
	public void addPrescription(String info, double price) {
		final Prescription temp = new Prescription(info, price);
		this.prescriptionsL.add(temp);
	}

	/**
	 * Clear prescription.
	 */
	public void clearPrescription() {
		this.prescriptionsL = new ArrayList<Prescription>();
	}

	/**
	 * Gets the prescription.
	 * 
	 * @return the prescription
	 */
	public List<Prescription> getPrescription() {
		return this.prescriptionsL;
	}

	/**
	 * Adds a new vaccine to the list of vaccines.
	 * 
	 * @param vaccine
	 *            the new vaccine to be added to the list
	 */
	public void addVaccines(Vaccine vaccine) {
		this.vaccines.add(vaccine);
	}

	/**
	 * Clears out the list of vaccines entirely.
	 */
	public void clearVaccines() {
		this.vaccines = new ArrayList<Vaccine>();
	}

	/**
	 * Return the list of Vaccines.
	 * 
	 * @return a list of Vaccines
	 */
	public List<Vaccine> getVaccines() {
		return this.vaccines;
	}

	/**
	 * Returns the bill.
	 * 
	 * @return the bill
	 */
	public Bill getBill() {
		return this.totalBill;
	}

	/**
	 * Gets the new bill.
	 * 
	 * @param newBill
	 *            the new bill
	 */
	public void setBill(Bill newBill) {
		this.totalBill = newBill;
	}

	/**
	 * Gets the treatments
	 * 
	 * @return the treatments
	 */
	public List<Treatment> getTreatments() {
		return this.treatments;
	}

	/**
	 * Converts the doctors orders to a string
	 * 
	 * @return the doctors orders in string form
	 */
	@Override
	public String toString() {
		return this.toString();
	}

}
