/**
 * The Class Invoice.
 * @author David Garner
 * @version 1.0
 */

package appointment;

import java.io.Serializable;
import java.util.Calendar;

/**
 * The Class Invoice.
 * 
 * @author Someone
 * @version 1.0.0
 */
public class Invoice implements Serializable {

	/** The appointment. */
	private Appointment appointment;

	/** The bill. */
	private Bill bill;

	/** The calendar. */
	private final Calendar cal;

	/**
	 * Instantiates a new invoice.
	 * 
	 * @param appt
	 *            the appointment
	 * @param bill
	 *            the bill
	 * @param cal
	 *            the calendar
	 */

	public Invoice(Appointment appt, Bill bill, Calendar cal) {
		this.appointment = appt;
		this.bill = bill;

		this.cal = appt.getDate();
	}

	/**
	 * Calculates the total cost of all labwork.
	 * 
	 * @return the total cost of the labwork
	 */
	public double calcLabWork() {
		double total = 0.0;

		for (int i = 0; i < bill.getLabWork().size(); i++) {
			total += bill.getLabWork().get(i).getPrice();
		}

		return total;
	}

	/**
	 * Calculates the total cost of all prescriptions.
	 * 
	 * @return the total cost of the prescriptions
	 */
	public double calcPrescription() {
		double total = 0.0;

		for (int i = 0; i < bill.getPrescriptionList().size(); i++) {
			total += bill.getPrescriptionList().get(i).getPrice();
		}

		return total;
	}

	/**
	 * Calculates the total cost of all treatments.
	 * 
	 * @return The total cost of the treatments
	 */
	public double calcTreatment() {
		double total = 0.0;
		for (int i = 0; i < bill.getTreatmentList().size(); i++) {
			total += bill.getTreatmentList().get(i).getPrice();
		}

		return total;
	}

	/**
	 * Calcs the total cost of all vaccines.
	 * 
	 * @return the total cost of the vaccines
	 */
	public double calcVaccine() {
		double total = 0.0;

		for (int i = 0; i < bill.getVaccineList().size(); i++) {
			total += bill.getVaccineList().get(i).getPrice();
		}

		return total;
	}

	/**
	 * Calculates the total cost for this visit.
	 * 
	 * @return the total cost of all services
	 */
	public double calcTotal() {
		double total = 0.0;

		total += calcLabWork();
		total += calcPrescription();
		total += calcTreatment();
		total += calcVaccine();

		return total;
	}

	/**
	 * Gets the bill.
	 * 
	 * @return the bill
	 */
	public Bill getBill() {
		return bill;
	}

	/**
	 * Sets the appointment.
	 * 
	 * @param appt
	 *            the new appointment
	 */
	public void setAppointment(Appointment appt) {
		this.appointment = appt;
	}

	/**
	 * Sets the bill.
	 * 
	 * @param bill
	 *            the new bill
	 */
	public void setBill(Bill bill) {
		this.bill = bill;
	}

	/**
	 * toString override.
	 * 
	 * @return A string
	 */
	public String toString() {
		return this.appointment.toString() + "\n" + this.bill.toString();
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Calendar getDate() {
		return this.cal;
	}
}
