/**
 * The Class Doctor.
 */

package users;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import record.DoctorsOrders;
import record.LabWork;
import record.Prescription;
import record.TreatmentRecord;
import appointment.Appointment;
import appointment.Invoice;

/**
 * @author Patrick Tynan
 * @version 1.0
 */
public class Doctor extends Nurse {

	/** The Current appointments. */
	private final List<Appointment> currentAppointments;

	/** the availabilities */
	private final List<Calendar> availabilities;

	/** the income */
	private final List<Invoice> income;

	/**
	 * Adds the doctors orders.
	 * 
	 * @param date
	 *            the date
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
	 * @param workingNurse
	 *            the working nurse
	 */
	public void addDoctorsOrders(Calendar date, String orders,
			Prescription drugs, LabWork labs, Appointment appt, Patient pat,
			Nurse workingNurse) {
		final DoctorsOrders docOrder = new DoctorsOrders(appt.getPatient(),
				date, this, labs, drugs, orders);
		pat.getMedicalHistory().addRecord(
				new TreatmentRecord(this, workingNurse, pat, docOrder));
		this.finishAppointment(appt);
	}

	/**
	 * Adds the appointment.
	 * 
	 * @param appt
	 *            the appt
	 */
	@Override
	public void addAppointment(Appointment appt) {
		currentAppointments.add(appt);
		availabilities.remove(appt);
	}

	/**
	 * Finish appointment.
	 * 
	 * @param appt
	 *            the appt
	 */
	public void finishAppointment(Appointment appt) {
		currentAppointments.remove(appt);
	}

	/**
	 * Checks availability of times and dates of this Doctor object. If the date
	 * is there, return false else return true
	 * 
	 * @param time
	 *            the time
	 * @return true, if successful
	 */
	public boolean isAvailable(Calendar time) {
		// Search for a match between passed param time and times in the
		// CurrentAppointment list
		for (Appointment i : currentAppointments) {
			if (i.getDate().equals(time)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Instantiates a new doctor.
	 * 
	 * @param uName
	 *            the uname
	 * @param pWord
	 *            the pword
	 * @param gend
	 *            the gend
	 * @param info
	 *            the info
	 */
	public Doctor(String uName, String pWord, GenderType gend, UserInfo info) {
		super(uName, pWord, gend, info);
		this.currentAppointments = new ArrayList<Appointment>();
		this.availabilities = new ArrayList<Calendar>();
		for (int i = 0; i < 365; i++) {
			Calendar calendar = new GregorianCalendar(2011, Calendar.MAY, 1, 9,
					1);
			calendar.add(Calendar.DAY_OF_MONTH, i);
			int x = 16 * 30;
			for (int j = 0; j < x; j += 30) {
				calendar.add(Calendar.MINUTE, j);
				availabilities.add(calendar);
			}
		}

		this.income = new ArrayList<Invoice>();
	}

	/**
	 * Gets the current appointments
	 * 
	 * @return the current appointments
	 */
	public List<Appointment> getCurrentAppointments() {
		return currentAppointments;
	}

	/**
	 * Gets the availabilities
	 * 
	 * @return the availabilities
	 */
	public List<Calendar> getAvailabilities() {
		return availabilities;
	}

	/**
	 * Gets the income
	 * 
	 * @return the income
	 */
	public List<Invoice> getIncome() {
		return income;
	}

	// TODO Decide whether this method is necessary
	 /*
	 * View reports.

	 public void viewReports() {
	 }
		 */
	
	/**
	 * Converts the MedicalHistory to a string
	 * 
	 * @return the medical history in string form
	 */
	@Override
	public String toString() {
		return this.toString();
	}
}
