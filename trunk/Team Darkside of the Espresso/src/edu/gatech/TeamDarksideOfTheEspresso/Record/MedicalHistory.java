/**
 * The Class MedicalHistory.
 */

package edu.gatech.TeamDarksideOfTheEspresso.Record;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MedicalHistory implements Serializable
{

	/** The Treatment records. */
	private List<TreatmentRecord>	TreatmentRecords;

	/**
	 * Instantiates a new medical history.
	 */
	public MedicalHistory()
	{
		TreatmentRecords = new ArrayList<TreatmentRecord>();
	}


	/**
	 * Adds the record.
	 * 
	 * @param treatmentRecord
	 *            the treatment record
	 */
	public void addRecord(TreatmentRecord treatmentRecord)
	{
		TreatmentRecords.add(treatmentRecord);
	}
	// TODO Add Methods
}
