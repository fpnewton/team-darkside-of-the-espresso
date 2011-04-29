/** The class MedicalHistory */

package record;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class MedicalHistory.
 * 
 * @author David Garner
 * @version 1.0.0
 */

public class MedicalHistory implements Serializable {

	/** The Treatment records. */
	private final List<TreatmentRecord> treatmentRecords;

	/**
	 * Instantiates a new medical history.
	 */
	public MedicalHistory() {
		treatmentRecords = new ArrayList<TreatmentRecord>();
	}

	/**
	 * Adds the record.
	 * 
	 * @param treatmentRecord
	 *            the treatment record
	 */
	public void addRecord(TreatmentRecord treatmentRecord) {
		treatmentRecords.add(treatmentRecord);
	}

	/**
	 * Converts the MedicalHistory to a string
	 * 
	 * @return the medical history in string form
	 */
	@Override
	public String toString() {
		return this.toString();
	}
}
