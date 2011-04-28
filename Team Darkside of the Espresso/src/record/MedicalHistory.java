/**
 * The Class MedicalHistory.
 * 
 * @author David Garner
 * @version 1.0.0
 */

package record;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MedicalHistory implements Serializable{

	/** The Treatment records. */
	private List<TreatmentRecord>	treatmentRecords;

	/**
	 * Instantiates a new medical history.
	 */
	public MedicalHistory()
	{
		treatmentRecords = new ArrayList<TreatmentRecord>();
	}


	/**
	 * Adds the record.
	 * 
	 * @param treatmentRecord
	 *            the treatment record
	 */
	public void addRecord(TreatmentRecord treatmentRecord)
	{
		treatmentRecords.add(treatmentRecord);
	}
}
