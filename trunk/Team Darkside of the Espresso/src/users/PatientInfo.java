/**
 * The Class PatientInfo.
 */

package users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import record.MedicalHistory; 

import record.TreatmentRecord;

public class PatientInfo implements Serializable {

    /** The Age. */
    private int Age;

    /** The Insurance carrier. */
    private String InsuranceCarrier;

    /** The Pharmacy. */
    private String Pharmacy;

    /** The Allergies. */
    private List<String> Allergies;
    
    /** The medical history */
    private MedicalHistory medHistory;

    public PatientInfo(int Age, String InsuranceCarrier, String Pharmacy,
	    List<String> Allergies, MedicalHistory medHistory) {
	this.Age = Age;
	this.InsuranceCarrier = InsuranceCarrier;
	this.Pharmacy = Pharmacy;
	this.Allergies = new ArrayList<String>();
	this.Allergies.addAll(Allergies);
	this.medHistory = medHistory;
    }

    /**
     * Gets the age.
     * 
     * @return the age
     */
    public int getAge() {
	return Age;
    }

    /**
     * Sets the age.
     * 
     * @param newAge
     *            the new age
     */
    public void setAge(int newAge) {
	Age = newAge;
    }

    /**
     * Gets the insurance carrier.
     * 
     * @return the insurance carrier
     */
    public String getInsuranceCarrier() {
	return InsuranceCarrier;
    }

    /**
     * Sets the insurance carrier.
     * 
     * @param newInsuranceCarrier
     *            the new insurance carrier
     */
    public void setInsuranceCarrier(String newInsuranceCarrier) {
	InsuranceCarrier = newInsuranceCarrier;
    }

    /**
     * Gets the pharmacy.
     * 
     * @return the pharmacy
     */
    public String getPharmacy() {
	return Pharmacy;
    }

    /**
     * Sets the pharmacy.
     * 
     * @param newPharmacy
     *            the new pharmacy
     */
    public void setPharmacy(String newPharmacy) {
	Pharmacy = newPharmacy;
    }

    /**
     * Gets the allergies.
     * 
     * @return the allergies
     */
    public List<String> getAllergies() {
	return Allergies;
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
     * @return
     */
    public String toString() {
	String age = "Age: " + getAge() + "\n";
	String iCarrier = "Insurance Carrier: " + getInsuranceCarrier() + "\n";
	String pharm = "Pharmacy: " + getPharmacy() + "\n";

	return age + iCarrier + pharm;
    }
}
