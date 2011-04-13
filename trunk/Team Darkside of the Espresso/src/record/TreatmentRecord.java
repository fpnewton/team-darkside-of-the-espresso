/**
 * The Class TreatmentRecord.
 */

package record;


import java.io.Serializable;

import users.Doctor;
import users.Nurse;
import java.util.Date;
import java.util.List;



public class TreatmentRecord implements Serializable
{

	/** The treating doctor. */
	private Doctor			treatingDoctor;

	/** The treating nurse. */
	private Nurse			treatingNurse;

	/** The doc orders. */
	private DoctorsOrders	docOrders;
	
	/** the parient's vital signs */
	private VitalSigns 		vSigns;
	
	/** the date of the appointment, or whatever*/
	private Date			date;
	
	/** a list of the symptoms */
	private List<String>	symptoms;
	
	/** the doctor's list of diagnosis */
	private List<String>	diagnosis;



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
	
	public TreatmentRecord(Doctor treatingDoctor, Nurse treatingNurse, DoctorsOrders docOrders, VitalSigns vSigns, Date date, List<String> symptoms, List<String> diagnosis){
		this.treatingDoctor = treatingDoctor;
		this.treatingNurse = treatingNurse;
		this.docOrders = docOrders;
		this.vSigns = vSigns;
		this.date = date;
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
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
