package edu.gatech.TeamDarksideOfTheEspresso.Appointment;


import java.util.List;
import java.util.ArrayList;

import edu.gatech.TeamDarksideOfTheEspresso.Record.*;


public class Bill
{
	private List<LabWork>		LabWorkL;
	private List<Prescription>	PrescriptionsL;
	private List<Treatment>		TreatmentsL;
	private	List<Vaccine>		VaccinesL;
	
	public Bill(){
		
	}
	
	public Bill(LabWork lWork, Prescription prescriptions, Treatment treat, Vaccine vaccine){
		this.LabWorkL.add(lWork);
		this.PrescriptionsL.add(prescriptions);
		this.TreatmentsL.add(treat);
		this.VaccinesL.add(vaccine);
	}
	
	public void AddLabWork(String info, String price){
		LabWork temp = new LabWork(info, price);
		this.LabWorkL.add(temp);
	}
	
	public void ClearLabWork(){
		this.LabWorkL = new ArrayList<LabWork>();
	}
	
	public List<LabWork> getLabWork(){
		return this.LabWorkL;
	}
	
	public void AddPrescription(String info, String price){
		Prescription temp = new Prescription(info, price);
		this.PrescriptionsL.add(temp);
	}
	
	public void ClearPrescription(){
		this.PrescriptionsL = new ArrayList<Prescription>();
	}
	
	public List<Prescription> getPrescription(){
		return this.PrescriptionsL;
	}
	
	public void AddTreatment(String info, String price){
		Treatment temp = new Treatment(info, price);
		this.TreatmentsL.add(temp);
	}
	
	public void ClearTreatment(){
		this.TreatmentsL = new ArrayList<Treatment>();
	}
	
	public List<Treatment> getTreatment(){
		return this.TreatmentsL;
	}
	
	public void AddVaccine(String info, String price){
		Vaccine temp = new Vaccine(info, price);
		this.VaccinesL.add(temp);
	}
	
	public void ClearVaccine(){
		this.VaccinesL = new ArrayList<Vaccine>();
	}
	
	public List<Vaccine> getVaccine(){
		return this.VaccinesL;
	}
}
