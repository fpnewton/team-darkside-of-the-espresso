/**
 * The Class PatientInfo.
 */

package edu.gatech.TeamDarksideOfTheEspresso.Users;


import java.io.Serializable;
import java.util.List;

import edu.gatech.TeamDarksideOfTheEspresso.Record.TreatmentRecord;


public class PatientInfo implements Serializable
{

	/** The Age. */
	private int						Age;

	/** The Insurance carrier. */
	private String					InsuranceCarrier;

	/** The Pharmacy. */
	private String					Pharmacy;

	/** The Allergies. */
	private List<String>			Allergies;

	/** The Medical history. */
	private List<TreatmentRecord>	MedicalHistory;


	/**
	 * Instantiates a new patient info.
	 * 
	 * @param Age
	 *            the age
	 * @param InsuranceCarrier
	 *            the insurance carrier
	 * @param Pharmacy
	 *            the pharmacy
	 * @param Allergies
	 *            the allergies
	 * @param MedicalHistory
	 *            the medical history
	 */
	public PatientInfo(int Age, String InsuranceCarrier, String Pharmacy, List<String> Allergies, List<TreatmentRecord> MedicalHistory)
	{
		this.Age = Age;
		this.InsuranceCarrier = InsuranceCarrier;
		this.Pharmacy = Pharmacy;
		this.Allergies = Allergies;
		this.MedicalHistory = MedicalHistory;
	}


	/**
	 * Gets the age.
	 * 
	 * @return the age
	 */
	public int getAge()
	{
		return Age;
	}


	/**
	 * Sets the age.
	 * 
	 * @param newAge
	 *            the new age
	 */
	public void setAge(int newAge)
	{
		Age = newAge;
	}


	/**
	 * Gets the insurance carrier.
	 * 
	 * @return the insurance carrier
	 */
	public String getInsuranceCarrier()
	{
		return InsuranceCarrier;
	}


	/**
	 * Sets the insurance carrier.
	 * 
	 * @param newInsuranceCarrier
	 *            the new insurance carrier
	 */
	public void setInsuranceCarrier(String newInsuranceCarrier)
	{
		InsuranceCarrier = newInsuranceCarrier;
	}


	/**
	 * Gets the pharmacy.
	 * 
	 * @return the pharmacy
	 */
	public String getPharmacy()
	{
		return Pharmacy;
	}


	/**
	 * Sets the pharmacy.
	 * 
	 * @param newPharmacy
	 *            the new pharmacy
	 */
	public void setPharmacy(String newPharmacy)
	{
		Pharmacy = newPharmacy;
	}


	/**
	 * Gets the allergies.
	 * 
	 * @return the allergies
	 */
	public List<String> getAllergies()
	{
		return Allergies;
	}


	/**
	 * Gets the medical history.
	 * 
	 * @return the medical history
	 */
	public List<TreatmentRecord> getMedicalHistory()
	{
		return MedicalHistory;
	}
}
