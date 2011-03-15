package edu.gatech.TeamDarksideOfTheEspresso.Users;


import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.sql.Time;

import edu.gatech.TeamDarksideOfTheEspresso.Appointment.Appointment;
import edu.gatech.TeamDarksideOfTheEspresso.Record.HealthHistory;
import edu.gatech.TeamDarksideOfTheEspresso.Record.MedicalHistory;
import edu.gatech.TeamDarksideOfTheEspresso.SystemLog.SystemLog;

// TODO: Auto-generated Javadoc
/**
 * The Class Patient.
 *
 * @author Patrick Tynan
 * @version 1.0
 */

public class Patient extends User
{
	
	/** The my patient info. */
	private PatientInfo			myPatientInfo;
	
	/** The Appointment history. */
	private ArrayList<Appointment>	AppointmentHistory;
	
	/** The my med history. */
	private MedicalHistory			myMedHistory;
	
	/** The my health history. */
	private HealthHistory		myHealthHistory;

	
	/**
	 * Instantiates a new patient.
	 */
	public Patient(){
		super();
	}
	
	/**
	 * Instantiates a new patient.
	 *
	 * @param Uname the uname
	 * @param Pword the pword
	 * @param Gend the gend
	 * @param Info the info
	 * @param PatInfo the pat info
	 */
	public Patient(String Uname, String Pword, GenderType Gend, UserInfo Info, PatientInfo PatInfo){
		super(Uname,Pword,Gend,Info);
		this.myPatientInfo = PatInfo;	
	}
	
	/**
	 * Gets the patient info.
	 *
	 * @return the patient info
	 */
	public PatientInfo getPatientInfo()
	{
		return myPatientInfo;
	}
	
	
	// TODO Add Get Methods/Set Methods
	
	
	/**
	 * Schedule appointment.
	 *
	 * @param date the date
	 * @param time the time
	 * @param symptoms the symptoms
	 * @param PreferredDoctor the preferred doctor
	 */
	public void ScheduleAppointment(Date date, Time time, String symptoms, Doctor PreferredDoctor)
	{
		try{
			Appointment Appt = new Appointment(date, time, PreferredDoctor, symptoms);
			if(PreferredDoctor.checkAvailability(PreferredDoctor, time)){
				Appt.scheduleDoctor(PreferredDoctor, time);
			}
		}
		catch(Exception e){
			SystemLog.LogMessage("Didn't Work!", Level.ALL);
		}
	}
	
	/**
	 * Sets the patient info.
	 *
	 * @param PatInfo the new patient info
	 */
	public void setPatientInfo(PatientInfo PatInfo){
		this.myPatientInfo = PatInfo;
	}
	
	/**
	 * View medical history.
	 */
	public void ViewMedicalHistory()
	{
		myMedHistory.toString();
	}
	
	/**
	 * Sets the medical history.
	 *
	 * @param MHistory the new medical history
	 */
	public void setMedicalHistory(MedicalHistory MHistory){
		this.myMedHistory = MHistory;
	}
	
	/**
	 * Gets the medical history.
	 *
	 * @return the medical history
	 */
	public MedicalHistory getMedicalHistory(){
		return this.myMedHistory;
	}
	
	/**
	 * Sets the health history.
	 *
	 * @param HHistory the new health history
	 */
	public void setHealthHistory(HealthHistory HHistory){
		this.myHealthHistory = HHistory;
	}
	
	
	/**
	 * View health history.
	 */
	public void ViewHealthHistory()
	{
		// TODO Implement Method
	}
	
	
	/**
	 * View invoice.
	 */
	public void ViewInvoice()
	{
		// TODO Implement Method
	}

	/**
	 * Gets the health history.
	 *
	 * @return the health history
	 */
	public HealthHistory getHealthHistory() {
		return myHealthHistory;
	}

	/**
	 * Sets the appointment history.
	 *
	 * @param appointmentHistory the new appointment history
	 */
	public void setAppointmentHistory(ArrayList<Appointment> appointmentHistory) {
		AppointmentHistory = appointmentHistory;
	}

	/**
	 * Gets the appointment history.
	 *
	 * @return the appointment history
	 */
	public ArrayList<Appointment> getAppointmentHistory() {
		return AppointmentHistory;
	}
}
