/**
 * The Class TreatmentRecord.
 */

package record;

import java.io.Serializable;

import users.Doctor;
import users.Nurse;
import users.Patient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TreatmentRecord implements Serializable {

	/** The treating doctor. */
	private Doctor treatingDoctor;

	/** The treating nurse. */
	private Nurse treatingNurse;

	/** The treated patient. */
	private Patient treatedPatient;

	/** The doc orders. */
	private DoctorsOrders docOrders;

	/** the parient's vital signs */
	private VitalSigns vSigns;

	/** the date of the appointment, or whatever */
	private Date date;

	/** a list of the symptoms */
	private List<String> symptoms;

	/** the doctor's list of diagnosis */
	private List<String> diagnosis;

	/**
	 * Instantiates a new treatment record.
	 */
	public TreatmentRecord() {

	}

	/**
	 * Instantiates a new treatment record and adds it to the patient's medical
	 * history
	 * 
	 * @param treatingDoctor
	 *            the treating doctor
	 * @param treatingNurse
	 *            the treating nurse
	 * @param docOrders
	 *            the doc orders
	 * @param treatedPatient
	 *            the treated patient
	 */
	public TreatmentRecord(Doctor treatingDoctor, Nurse treatingNurse,
			Patient treatedPatient, DoctorsOrders docOrders) {
		this.treatingDoctor = treatingDoctor;
		this.treatingNurse = treatingNurse;
		this.treatedPatient = treatedPatient;
		this.docOrders = docOrders;
		this.symptoms = new ArrayList<String>();
		this.diagnosis = new ArrayList<String>();

		/* adding the treatment record to the patient's medical history */
		this.treatedPatient.getPatientInfo().getMedicalHistory()
				.addRecord(this);
	}

	/**
	 * Constructor for a TreatmentRecord. Creates the record and adds it to the
	 * patient's medical history
	 * 
	 * @param treatingDoctor
	 *            the treating doctor
	 * @param treatingNurse
	 *            the treating nurse
	 * @param treatedPatient
	 *            the treated patient
	 * @param docOrders
	 *            the doctor's orders
	 * @param vSigns
	 *            the patient's vital signs
	 * @param date
	 *            the date
	 * @param symptoms
	 *            the patient's symptoms
	 * @param diagnosis
	 *            the doctor's diagnosis
	 */
	public TreatmentRecord(Doctor treatingDoctor, Nurse treatingNurse,
			Patient treatedPatient, DoctorsOrders docOrders, VitalSigns vSigns,
			Date date, List<String> symptoms, List<String> diagnosis) {
		this.treatingDoctor = treatingDoctor;
		this.treatingNurse = treatingNurse;
		this.treatedPatient = treatedPatient;
		this.docOrders = docOrders;
		this.vSigns = vSigns;
		this.date = date;
		this.symptoms = new ArrayList<String>();
		this.diagnosis = new ArrayList<String>();

		this.symptoms.addAll(symptoms);
		this.diagnosis.addAll(diagnosis);

		/* adding the treatment record to the patient's medical history */
		this.treatedPatient.getPatientInfo().getMedicalHistory()
				.addRecord(this);
	}

	/**
	 * Sets the doctor.
	 * 
	 * @param Dr
	 *            the doctor
	 */
	public void setDoctor(Doctor Dr) {
		this.treatingDoctor = Dr;
	}

	/**
	 * Gets the doctor.
	 * 
	 * @return the doctor
	 */
	public Doctor getDoctor() {
		return this.treatingDoctor;
	}

	/**
	 * Sets the nurse.
	 * 
	 * @param Nu
	 *            the nurse
	 */
	public void setNurse(Nurse Nu) {
		this.treatingNurse = Nu;
	}

	/**
	 * Gets the nurse.
	 * 
	 * @return the nurse
	 */
	public Nurse getNurse() {
		return this.treatingNurse;
	}

	/**
	 * Gets the patient
	 * 
	 * @return the patient
	 */
	public Patient getPatient() {
		return this.treatedPatient;
	}
}
