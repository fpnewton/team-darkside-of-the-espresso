/*
 * The Bill Class.
 */

package appointment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import record.LabWork;
import record.Prescription;
import record.Treatment;
import record.Vaccine;

/**
 * The Bill Class.
 * 
 * @author Jonathan Cherry
 * @version 1.0.0
 */
public class Bill implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Lab work list. */
	private ArrayList<LabWork> labWorkList;

	/** The Prescriptions list. */
	private ArrayList<Prescription> prescriptionList;

	/** The Treatments list. */
	private ArrayList<Treatment> treatmentList;

	/** The Vaccines list. */
	private ArrayList<Vaccine> vaccineList;

	/**
	 * Instantiates a new bill.
	 * 
	 * @param lWork
	 *            the lab work
	 * @param prescriptions
	 *            the prescriptions
	 * @param treat
	 *            the treatment
	 * @param vaccine
	 *            the vaccine
	 */
	public Bill(List<LabWork> lWork, List<Prescription> prescriptions,
			List<Treatment> treat, List<Vaccine> vaccine) {

		this.labWorkList = (ArrayList<LabWork>) lWork;
		this.prescriptionList = (ArrayList<Prescription>) prescriptions;
		this.treatmentList = (ArrayList<Treatment>) treat;
		this.vaccineList = (ArrayList<Vaccine>) vaccine;
	}

	/**
	 * Adds the lab work.
	 * 
	 * @param info
	 *            the info
	 * @param price
	 *            the price
	 */
	public void addLabWork(String info, double price) {
		final LabWork temp = new LabWork(info, price);

		this.labWorkList.add(temp);
	}

	/**
	 * Clear lab work.
	 */
	public void clearLabWork() {
		this.labWorkList = new ArrayList<LabWork>();
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

		this.prescriptionList.add(temp);
	}

	/**
	 * Clear prescription.
	 */
	public void clearPrescription() {
		this.prescriptionList = new ArrayList<Prescription>();
	}

	/**
	 * Gets the prescription.
	 * 
	 * @return the prescription
	 */
	public List<Prescription> getPrescriptionList() {
		return this.prescriptionList;
	}

	/**
	 * Adds the treatment.
	 * 
	 * @param info
	 *            the info
	 * @param price
	 *            the price
	 */
	public void addTreatment(String info, double price) {
		final Treatment temp = new Treatment(info, price);

		this.treatmentList.add(temp);
	}

	/**
	 * Clear treatment.
	 */
	public void clearTreatment() {
		this.treatmentList = new ArrayList<Treatment>();
	}

	/**
	 * Gets the treatment.
	 * 
	 * @return the treatment
	 */
	public List<Treatment> getTreatmentList() {
		return this.treatmentList;
	}

	/**
	 * Adds the vaccine.
	 * 
	 * @param info
	 *            the info
	 * @param price
	 *            the price
	 */
	public void addVaccine(String info, double price) {
		final Vaccine temp = new Vaccine(info, price);

		this.vaccineList.add(temp);
	}

	/**
	 * Clear vaccine.
	 */
	public void clearVaccine() {
		this.vaccineList = new ArrayList<Vaccine>();
	}

	/**
	 * Gets the vaccine.
	 * 
	 * @return the vaccine
	 */
	public List<Vaccine> getVaccineList() {
		return this.vaccineList;
	}

	/**
	 * toString() Override.
	 * 
	 * @return A formatted string with the bill data
	 */
	public String toString() {
		final String labString = "Lab Work: " + labWorkList.toString() + "\n";
		final String prescripString = "Prescriptions: "
				+ prescriptionList.toString() + "\n";
		final String treatString = "Treatments: " + treatmentList.toString()
				+ "\n";
		final String vacString = "Vaccines: " + vaccineList.toString() + "\n";

		return labString + prescripString + treatString + vacString;

	}

	/**
	 * Gets the lab work.
	 * 
	 * @return the lab work
	 */
	public List<LabWork> getLabWork() {
		return this.labWorkList;
	}

	/**
	 * Gets the vaccines.
	 * 
	 * @return the vaccines
	 */
	public List<Vaccine> getVaccines() {
		return this.vaccineList;
	}

	/**
	 * Gets the treatments.
	 * 
	 * @return the treatments
	 */
	public List<Treatment> getTreatments() {
		return this.treatmentList;
	}

	/**
	 * Gets the prescriptions.
	 * 
	 * @return the prescriptions
	 */
	public List<Prescription> getPrescriptions() {
		return this.prescriptionList;
	}
}
