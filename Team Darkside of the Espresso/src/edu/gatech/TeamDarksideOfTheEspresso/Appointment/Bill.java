/**
 * The Class Bill.
 */

package edu.gatech.TeamDarksideOfTheEspresso.Appointment;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.gatech.TeamDarksideOfTheEspresso.Record.LabWork;
import edu.gatech.TeamDarksideOfTheEspresso.Record.Prescription;
import edu.gatech.TeamDarksideOfTheEspresso.Record.Treatment;
import edu.gatech.TeamDarksideOfTheEspresso.Record.Vaccine;


public class Bill implements Serializable
{

	/** The Lab work l. */
	private List<LabWork>		LabWorkL;

	/** The Prescriptions l. */
	private List<Prescription>	PrescriptionsL;

	/** The Treatments l. */
	private List<Treatment>		TreatmentsL;

	/** The Vaccines l. */
	private List<Vaccine>		VaccinesL;


	/**
	 * Instantiates a new bill.
	 */
	public Bill()
	{

	}


	/**
	 * Instantiates a new bill.
	 * 
	 * @param lWork
	 *            the l work
	 * @param prescriptions
	 *            the prescriptions
	 * @param treat
	 *            the treat
	 * @param vaccine
	 *            the vaccine
	 */
	public Bill(LabWork lWork, Prescription prescriptions, Treatment treat, Vaccine vaccine)
	{
		this.LabWorkL.add(lWork);
		this.PrescriptionsL.add(prescriptions);
		this.TreatmentsL.add(treat);
		this.VaccinesL.add(vaccine);
	}


	/**
	 * Adds the lab work.
	 * 
	 * @param info
	 *            the info
	 * @param price
	 *            the price
	 */
	public void AddLabWork(String info, String price)
	{
		LabWork temp = new LabWork(info, price);
		this.LabWorkL.add(temp);
	}


	/**
	 * Clear lab work.
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


	/**
	 * Adds the treatment.
	 * 
	 * @param info
	 *            the info
	 * @param price
	 *            the price
	 */
	public void AddTreatment(String info, String price)
	{
		Treatment temp = new Treatment(info, price);
		this.TreatmentsL.add(temp);
	}


	/**
	 * Clear treatment.
	 */
	public void ClearTreatment()
	{
		this.TreatmentsL = new ArrayList<Treatment>();
	}


	/**
	 * Gets the treatment.
	 * 
	 * @return the treatment
	 */
	public List<Treatment> getTreatment()
	{
		return this.TreatmentsL;
	}


	/**
	 * Adds the vaccine.
	 * 
	 * @param info
	 *            the info
	 * @param price
	 *            the price
	 */
	public void AddVaccine(String info, String price)
	{
		Vaccine temp = new Vaccine(info, price);
		this.VaccinesL.add(temp);
	}


	/**
	 * Clear vaccine.
	 */
	public void ClearVaccine()
	{
		this.VaccinesL = new ArrayList<Vaccine>();
	}


	/**
	 * Gets the vaccine.
	 * 
	 * @return the vaccine
	 */
	public List<Vaccine> getVaccine()
	{
		return this.VaccinesL;
	}
}
