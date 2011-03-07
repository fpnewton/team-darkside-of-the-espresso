package edu.gatech.TeamDarksideOfTheEspresso.Record;

import edu.gatech.TeamDarksideOfTheEspresso.Users.*;

public class TreatmentRecord
{
<<<<<<< .mine
	private Doctor			treatingDoctor;
	private Nurse			treatingNurse;
	private DoctorsOrders	docOrders;
	
	public TreatmentRecord(){
		this.treatingDoctor = new Doctor();
		this.treatingNurse = new Nurse();
		this.docOrders = new DoctorsOrders();
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
=======
>>>>>>> .r85
}
