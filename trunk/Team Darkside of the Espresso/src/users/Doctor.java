/**
 * The Class Doctor.
 * 
 * @author Patrick Tynan
 * @version 1.0
 */

package users;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import record.DoctorsOrders;
import record.LabWork;
import record.Prescription;
import record.TreatmentRecord;

import appointment.Appointment;
import appointment.Invoice;

public class Doctor extends Nurse {

	/** The Current appointments. */
	private ArrayList<Appointment> CurrentAppointments;

	private ArrayList<Calendar> availabilities;
	
	private ArrayList<Invoice> income;

	/**
	 * Adds the doctors orders.
	 * 
	 * @param orders
	 *            the orders
	 * @param drugs
	 *            the drugs
	 * @param labs
	 *            the labs
	 * @param appt
	 *            the appt
	 * @param pat
	 *            the pat
	 * @param WorkingNurse
	 *            the working nurse
	 */
	public void AddDoctorsOrders(Calendar date, String orders,
			Prescription drugs, LabWork labs, Appointment appt, Patient pat,
			Nurse WorkingNurse) {
		DoctorsOrders docOrder = new DoctorsOrders(appt.getPatient(), date,
				this, labs, drugs, orders);
		pat.getMedicalHistory().addRecord(
				new TreatmentRecord(this, WorkingNurse, docOrder));
		this.finishAppointment(appt);
	}

	/**
	 * Adds the appointment.
	 * 
	 * @param appt
	 *            the appt
	 */
	public void addAppointment(Appointment appt) {
		CurrentAppointments.add(appt);
		availabilities.remove(appt);
	}

	/**
	 * Finish appointment.
	 * 
	 * @param appt
	 *            the appt
	 */
	public void finishAppointment(Appointment appt) {
		CurrentAppointments.remove(appt);
	}

	/**
	 * Checks availability of times and dates of this Doctor object. If the date
	 * is there, return false else return true
	 * 
	 * @param doc
	 *            the doc
	 * @param time
	 *            the time
	 * @return true, if successful
	 */
	public boolean checkAvailability(Calendar time) {
		// I removed the 'doc' parameter, since you're already calling it
		// on a Doctor object

		// Search for a match between passed param time and times in the
		// CurrentAppointment list
		for (Appointment i : CurrentAppointments) {
			if (i.getDate().equals(time)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Instantiates a new doctor.
	 */
	// public Doctor()
	// {
	//
	// }

	/**
	 * Instantiates a new doctor.
	 * 
	 * @param Uname
	 *            the uname
	 * @param Pword
	 *            the pword
	 * @param Gend
	 *            the gend
	 * @param Info
	 *            the info
	 */
	public Doctor(String Uname, String Pword, GenderType Gend, UserInfo Info)
	{
		super(Uname, Pword, Gend, Info);
		this.CurrentAppointments = new ArrayList<Appointment>();
		this.availabilities = new ArrayList<Calendar>();
		for(int i=0; i<365; i++){
			Calendar calendar = new GregorianCalendar(2011, Calendar.MAY, 1, 9, 1);
			calendar.add(Calendar.DAY_OF_MONTH,i);
			for(int j=0; j<(30*16); j+=30){
				calendar.add(Calendar.MINUTE,j);
				availabilities.add(calendar);
			}
		}
		
		this.income = new ArrayList<Invoice>(); 
	}

	public ArrayList<Appointment> getCurrentAppointments() {
		return CurrentAppointments;
	}

	public ArrayList<Calendar> getAvailabilities() {
		return availabilities;
	}

	/**
	 * View reports.
	 */
	public void ViewReports() {
		// TODO Implement Method
	}
}
