/**
 * The Class Invoice.
 */

package edu.gatech.TeamDarksideOfTheEspresso.Appointment;

import java.io.Serializable;


public class Invoice implements Serializable
{
	private Appointment	Appointment;
	private Bill		Bill;	

	/**
	 * Instantiates a new invoice.
	 * 
	 * @param Appointment
	 *            the appointment
	 * @param Bill
	 *            the bill
	 */
	public Invoice(Appointment Appointment, Bill Bill)
	{
		this.Appointment = Appointment;
		this.Bill = Bill;
	}


	/**
	 * Gets the appointment.
	 * 
	 * @return the appointment
	 */
	public Appointment getAppointment()
	{
		return Appointment;
	}


	/**
	 * Gets the bill.
	 * 
	 * @return the bill
	 */
	public Bill getBill()
	{
		return Bill;
	}


	/**
	 * Sets the appointment.
	 * 
	 * @param Appointment
	 *            the new appointment
	 */
	public void setAppointment(Appointment Appointment)
	{
		this.Appointment = Appointment;
	}


	/**
	 * Sets the bill.
	 * 
	 * @param Bill
	 *            the new bill
	 */
	public void setBill(Bill Bill)
	{
		this.Bill = Bill;
	}


	/**
	 * Prints the invoice.
	 */
	public void PrintInvoice()
	{
		// TODO Implement Method
	}
}
