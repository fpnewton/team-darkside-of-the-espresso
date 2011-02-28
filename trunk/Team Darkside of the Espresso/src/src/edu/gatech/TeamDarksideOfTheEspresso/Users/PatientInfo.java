package edu.gatech.TeamDarksideOfTheEspresso.Users;


import java.util.List;

import edu.gatech.TeamDarksideOfTheEspresso.Record.TreatmentRecord;


public class PatientInfo
{
	private int						Age;
	
	private String					InsuranceCarrier;
	private String					Pharmacy;
	
	private List<Double>			WeightHistory;
	private List<String>			Allergies;
	private	List<TreatmentRecord>	MedicalHistory;
}
