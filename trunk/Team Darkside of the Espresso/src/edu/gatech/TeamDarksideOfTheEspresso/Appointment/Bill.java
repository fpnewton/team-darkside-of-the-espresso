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
		this.LabWorkL = new ArrayList<LabWork>();
		this.PrescriptionsL = new ArrayList<Prescription>();
		this.TreatmentsL = new ArrayList<Treatment>();
		this.VaccinesL = new ArrayList<Vaccine>();
	}
	
	public void AddLabWork(String info, String price){
		LabWork temp = new LabWork(info, price);
		this.LabWorkL.add(temp);
	}
	
	public void ClearLabWork(String info, String price){
		this.LabWorkL = new ArrayList<LabWork>();
	}
	
	public List<LabWork> getLabWork(){
		return this.LabWorkL;
	}
	
	public void AddPrescription(String info, String price){
		Prescription temp = new Prescription(info, price);
		this.PrescriptionsL.add(temp);
	}
	
	public void ClearPrescription(String info, String price){
		this.PrescriptionsL = new ArrayList<Prescription>();
	}
	
	public List<Prescription> getPrescription(){
		return this.PrescriptionsL;
	}
	
	public void AddTreatment(String info, String price){
		Treatment temp = new Treatment(info, price);
		this.TreatmentsL.add(temp);
	}
	
	public void ClearTreatment(String info, String price){
		this.TreatmentsL = new ArrayList<Treatment>();
	}
	
	public List<Treatment> getTreatment(){
		return this.TreatmentsL;
	}
	
	public void AddVaccine(String info, String price){
		Vaccine temp = new Vaccine(info, price);
		this.VaccinesL.add(temp);
	}
	
	public void ClearVaccine(String info, String price){
		this.VaccinesL = new ArrayList<Vaccine>();
	}
	
	public List<Vaccine> getVaccine(){
		return this.VaccinesL;
	}
}
