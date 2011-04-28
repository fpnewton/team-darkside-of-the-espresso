/**
 * The Class Invoice.
 * @author David Garner
 * @version 1.0
 */

package appointment;

import java.io.Serializable;

public class Invoice implements Serializable {
	private Appointment Appointment;
	private Bill Bill;

	/**
	 * Instantiates a new invoice.
	 * 
	 * @param Appointment
	 *            the appointment
	 * @param Bill
	 *            the bill
	 */
	public Invoice(Appointment Appointment, Bill Bill) {
		this.Appointment = Appointment;
		this.Bill = Bill;
	}

	/**
	 * Calculates the total cost of all labwork
	 * 
	 * @param bill
	 *            The bill containing the labwork
	 * @return the total cost of the labwork
	 */
	public double calcLabWork(Bill bill) {
		double total = 0.0;

		for (int i = 0; i < bill.getLabWork().size(); i++)
			total += bill.getLabWork().get(i).getPrice();

		return total;
	}

	/**
	 * Calculates the total cost of all prescriptions
	 * 
	 * @param bill
	 *            The bill containing the prescriptions
	 * @return the total cost of the prescriptions
	 */
	public double calcPrescription(Bill bill) {
		double total = 0.0;

		for (int i = 0; i < bill.getPrescription().size(); i++)
			total += bill.getPrescription().get(i).getPrice();

		return total;
	}

	/**
	 * Calculates the total cost of all treatments
	 * 
	 * @param bill
	 *            The bill containing the treatments
	 * @return The totla cost of the treatments
	 */
	public double calcTreatment(Bill bill) {
		double total = 0.0;

		for (int i = 0; i < bill.getTreatment().size(); i++)
			total += bill.getTreatment().get(i).getPrice();

		return total;
	}

	/**
	 * Calcs the total cost of all vaccines
	 * 
	 * @param bill
	 *            The bill containing the vaccines
	 * @return the total cost of the vaccines
	 */
	public double calcVaccine(Bill bill) {
		double total = 0.0;

		for (int i = 0; i < bill.getVaccine().size(); i++)
			total += bill.getVaccine().get(i).getPrice();

		return total;
	}

	/**
	 * Calculates the total cost for this visit
	 * 
	 * @param bill
	 *            The bill containing all services provided
	 * @return the total cost of all services
	 */
	public double calcTotal(Bill bill) {
		double total = 0.0;

		total += calcLabWork(bill);
		total += calcPrescription(bill);
		total += calcTreatment(bill);
		total += calcVaccine(bill);

		return total;
	}

	/**
	 * Gets the bill.
	 * 
	 * @return the bill
	 */
	public Bill getBill() {
		return Bill;
	}

	/**
	 * Sets the appointment.
	 * 
	 * @param Appointment
	 *            the new appointment
	 */
	public void setAppointment(Appointment Appointment) {
		this.Appointment = Appointment;
	}

	/**
	 * Sets the bill.
	 * 
	 * @param Bill
	 *            the new bill
	 */
	public void setBill(Bill Bill) {
		this.Bill = Bill;
	}
}
