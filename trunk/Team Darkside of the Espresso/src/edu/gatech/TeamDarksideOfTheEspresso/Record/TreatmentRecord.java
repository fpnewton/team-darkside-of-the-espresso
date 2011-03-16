/**
 * The Class TreatmentRecord.
 */

package edu.gatech.TeamDarksideOfTheEspresso.Record;


import java.io.Serializable;

import edu.gatech.TeamDarksideOfTheEspresso.Users.Doctor;
import edu.gatech.TeamDarksideOfTheEspresso.Users.Nurse;


public class TreatmentRecord implements Serializable
{

	/** The treating doctor. */
	private Doctor			treatingDoctor;

	/** The treating nurse. */
	private Nurse			treatingNurse;

	/** The doc orders. */
	private DoctorsOrders	docOrders;


	/**
	 * Instantiates a new treatment record.
	 */
	public TreatmentRecord()
	{

	}


	/**
	 * Instantiates a new treatment record.
	 * 
	 * @param treatingDoctor
	 *            the treating doctor
	 * @param treatingNurse
	 *            the treating nurse
	 * @param docOrders
	 *            the doc orders
	 */
	public TreatmentRecord(Doctor treatingDoctor, Nurse treatingNurse, DoctorsOrders docOrders)
	{
		this.treatingDoctor = treatingDoctor;
		this.treatingNurse = treatingNurse;
		this.docOrders = docOrders;
	}


	/**
	 * Sets the doctor.
	 * 
	 * @param Dr
	 *            the doctor
	 * @return the doctor
	 */
	public Doctor setDoctor(Doctor Dr)
	{
		return this.treatingDoctor = Dr;
	}


	/**
	 * Gets the doctor.
	 * 
	 * @return the doctor
	 */
	public Doctor getDoctor()
	{
		return this.treatingDoctor;
	}


	/**
	 * Sets the nurse.
	 * 
	 * @param Nu
	 *            the nurse
	 * @return the nurse
	 */
	public Nurse setNurse(Nurse Nu)
	{
		return this.treatingNurse = Nu;
	}


	/**
	 * Gets the nurse.
	 * 
	 * @return the nurse
	 */
	public Nurse getNurse()
	{
		return this.treatingNurse;
	}
}
