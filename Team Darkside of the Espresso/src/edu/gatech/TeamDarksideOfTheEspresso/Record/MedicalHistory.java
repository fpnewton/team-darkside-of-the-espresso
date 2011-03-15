package edu.gatech.TeamDarksideOfTheEspresso.Record;


import java.util.ArrayList;
import java.util.List;


public class MedicalHistory
{
	private List<TreatmentRecord>	TreatmentRecords;
	
	
	public MedicalHistory()
	{
		TreatmentRecords = new ArrayList<TreatmentRecord>();
	}

	
	public void addRecord(TreatmentRecord treatmentRecord)
	{
		TreatmentRecords.add(treatmentRecord);
	}
	
	
	// TODO Add Methods
}
