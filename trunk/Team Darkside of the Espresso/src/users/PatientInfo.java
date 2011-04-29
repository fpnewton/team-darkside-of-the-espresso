/**
 * The Class PatientInfo.
 */

package users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import record.MedicalHistory;

/**
 * 
 * @author David Garner
 * @version 1.0.0
 */
public class PatientInfo implements Serializable {

	/** The Age. */
	private int age;

	/** The Insurance carrier. */
	private String insuranceCarrier;

	/** The Pharmacy. */
	private String pharmacy;

	/** The Allergies. */
	private final List<String> allergies;

	/** The medical history */
	private final MedicalHistory medHistory;

	/**
	 * Creates a new PatientInfo object
	 * 
	 * @param age
	 *            the age
	 * @param insuranceCarrier
	 *            the insurance carrier
	 * @param pharmacy
	 *            the pharmacy
	 * @param allergies
	 *            the allergies
	 * @param medHistory
	 *            the medical history
	 */
	public PatientInfo(int age, String insuranceCarrier, String pharmacy,
			List<String> allergies, MedicalHistory medHistory) {
		this.age = age;
		this.insuranceCarrier = insuranceCarrier;
		this.pharmacy = pharmacy;
		this.allergies = new ArrayList<String>();
		this.allergies.addAll(allergies);
		this.medHistory = medHistory;
	}

	/**
	 * Gets the age.
	 * 
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 * 
	 * @param newAge
	 *            the new age
	 */
	public void setAge(int newAge) {
		age = newAge;
	}

	/**
	 * Gets the insurance carrier.
	 * 
	 * @return the insurance carrier
	 */
	public String getInsuranceCarrier() {
		return insuranceCarrier;
	}

	/**
	 * Sets the insurance carrier.
	 * 
	 * @param newInsuranceCarrier
	 *            the new insurance carrier
	 */
	public void setInsuranceCarrier(String newInsuranceCarrier) {
		insuranceCarrier = newInsuranceCarrier;
	}

	/**
	 * Gets the pharmacy.
	 * 
	 * @return the pharmacy
	 */
	public String getPharmacy() {
		return pharmacy;
	}

	/**
	 * Sets the pharmacy.
	 * 
	 * @param newPharmacy
	 *            the new pharmacy
	 */
	public void setPharmacy(String newPharmacy) {
		pharmacy = newPharmacy;
	}

	/**
	 * Gets the allergies.
	 * 
	 * @return the allergies
	 */
	public List<String> getAllergies() {
		return allergies;
	}

	/**
	 * Gets the medical history.
	 * 
	 * @return the medical history
	 */
	public MedicalHistory getMedicalHistory() {
		return medHistory;
	}

	/**
	 * Converts all attributes except Allergies and MedicalHistory to one string
	 * variable
	 * 
	 * @return All attributes but the two ArrayLists in String form
	 */
	public String toString() {
		final String age = "Age: " + getAge() + "\n";
		final String iCarrier = "Insurance Carrier: " + getInsuranceCarrier()
				+ "\n";
		final String pharm = "Pharmacy: " + getPharmacy() + "\n";

		return age + iCarrier + pharm;
	}
}
