package edu.gatech.TeamDarksideOfTheEspresso.Record;

import edu.gatech.TeamDarksideOfTheEspresso.Users.*;

public class TreatmentRecord
{
	private Doctor			treatingDoctor;
	private Nurse			treatingNurse;
	private DoctorsOrders	docOrders;
	
	public TreatmentRecord(Doctor treatingDoctor, Nurse treatingNurse, DoctorsOrders docOrders){
		this.treatingDoctor = treatingDoctor;
		this.treatingNurse = treatingNurse;
		this.docOrders = docOrders;
	}
	
	public Doctor setDoctor(Doctor Dr){
		return this.treatingDoctor = Dr;
	}
	
	public Doctor getDoctor(){
		return this.treatingDoctor;
	}
	
	public Nurse setNurse(Nurse Nu){
		return this.treatingNurse = Nu;
	}
	
	public Nurse getNurse(){
		return this.treatingNurse;
	}
}
