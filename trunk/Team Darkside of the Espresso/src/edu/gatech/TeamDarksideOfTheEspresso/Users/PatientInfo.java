package edu.gatech.TeamDarksideOfTheEspresso.Users;


import java.util.List;

import edu.gatech.TeamDarksideOfTheEspresso.Record.TreatmentRecord;


public class PatientInfo
{
	private int						Age;
	
	private String					InsuranceCarrier;
	private String					Pharmacy;
	
	private List<String>			Allergies;
	//Removed List<Double> WeightHistory, as this is what the HealthHistory class is for
	private	List<TreatmentRecord>	MedicalHistory;
	
	public PatientInfo(int Age, String InsuranceCarrier, String Pharmacy, 
						List<String> Allergies, List<TreatmentRecord> MedicalHistory){
		this.Age=age;
		this.InsuranceCarrier=InsuranceCarrier;
		this.Pharmacy=Pharmacy;
		this.Allergies=Allergies;
		this.MedicalHistory=MedicalHistory;
	}
	
	public int getAge(){
		return Age;
	}
	
	publie void setAge(int newAge){
		Age=newAge;
	}
	
	public String getInsuranceCarrier(){
		return InsuranceCarrier;
	}
	
	public void setInsuranceCarrier(String newInsuranceCarrier){
		InsuranceCarrier=newInsuranceCarrier;
	}
	
	public String getPharmacy(){
		return Pharmacy;
	}
	
	public void setPharmacy(String newPharmacy){
		Pharmacy=newPharmacy;
	}
	
	public List<String> getAllergies(){
		return Allergies;
	}
	
	public List<TreatmentRecord> getMedicalHistory(){
		return MedicalHistory;
	}
}
