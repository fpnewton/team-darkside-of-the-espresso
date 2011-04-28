/*
 * The Bill Class.
 */

package appointment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ArrayList;

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

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	/** The Lab work list. */
	private ArrayList<LabWork> labWorkList;

	/** The Prescriptions list. */
	private ArrayList<Prescription> prescriptionsList;

	/** The Treatments list. */
	private ArrayList<Treatment> treatmentsList;

	/** The Vaccines list. */
	private ArrayList<Vaccine> vaccinesList;

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
	public Bill(ArrayList<LabWork> lWork,
			ArrayList<Prescription> prescriptions, ArrayList<Treatment> treat,
			ArrayList<Vaccine> vaccine) {

		this.labWorkList = lWork;
		this.prescriptionsList = prescriptions;
		this.treatmentsList = treat;
		this.vaccinesList = vaccine;
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

		this.prescriptionsList.add(temp);
	}

	/**
	 * Clear prescription.
	 */
	public void clearPrescription() {
		this.prescriptionsList = new ArrayList<Prescription>();
	}

	/**
	 * Gets the prescription.
	 * 
	 * @return the prescription
	 */
	public ArrayList<Prescription> getPrescription() {
		return this.prescriptionsList;
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

		this.treatmentsList.add(temp);
	}

	/**
	 * Clear treatment.
	 */
	public void clearTreatment() {
		this.treatmentsList = new ArrayList<Treatment>();
	}

	/**
	 * Gets the treatment.
	 * 
	 * @return the treatment
	 */
	public ArrayList<Treatment> getTreatment() {
		return this.treatmentsList;
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

		this.vaccinesList.add(temp);
	}

	/**
	 * Clear vaccine.
	 */
	public void clearVaccine() {
		this.vaccinesList = new ArrayList<Vaccine>();
	}

	/**
	 * Gets the vaccine.
	 * 
	 * @return the vaccine
	 */
	public ArrayList<Vaccine> getVaccine() {
		return this.vaccinesList;
	}

	/**
	 * toString() Override
	 * 
	 * @return A formatted string with the bill data
	 */
	public String toString() {
		final String labString = "Lab Work: " + labWorkList.toString() + "\n";
		final String prescripString = "Prescriptions: "
				+ prescriptionsList.toString() + "\n";
		final String treatString = "Treatments: " + treatmentsList.toString()
				+ "\n";
		final String vacString = "Vaccines: " + vaccinesList.toString() + "\n";

		return labString + prescripString + treatString + vacString;

	}
	
	 public ArrayList<LabWork> getLabWork(){
		 return this.labWorkList;
	 }
	 
	 public ArrayList<Vaccine> getVaccines(){
		 return this.vaccinesList;
	 }
	 
	 public ArrayList<Treatment> getTreatments(){
		 return this.treatmentsList;
	 }
	 
	 public ArrayList<Prescription> getPrescriptions(){
		 return this.prescriptionsList;
	 }
}
