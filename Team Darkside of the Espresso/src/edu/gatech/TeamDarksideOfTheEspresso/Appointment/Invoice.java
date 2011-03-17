/**
 * The Class Invoice.
 */

package edu.gatech.TeamDarksideOfTheEspresso.Appointment;

import java.io.Serializable;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;


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
		InvoiceFrame i = new InvoiceFrame(Appointment, Bill);
	}
	
	private class InvoiceFrame extends JFrame {

		private JPanel contentPane;
		private Appointment Appointment;
		private Bill Bill;

		/**
		 * Creates an InvoiceFrame to display to the screen
		 * @param Appointment The Appointment the patient recently finished
		 * @param Bill The collection of treatments the patient received
		 */
		public InvoiceFrame(Appointment Appointment, Bill Bill) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(200, 200, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			JLabel pName = new JLabel("Name: "+Appointment.getPatient().getUsername()+"\n");
			JLabel pInfo = new JLabel(Appointment.getPatient().getPatientInfo().toString());
			JLabel pDate = new JLabel("Date: "+Appointment.getDate().toString()+"\n");
			JLabel pBill = new JLabel(Bill.toString());
			
			contentPane.add(pName);
			contentPane.add(pInfo);
			contentPane.add(pDate);
			contentPane.add(pBill);
			
			setContentPane(contentPane);
			pack();
			setVisible(true);
		}
		

	}	
}
