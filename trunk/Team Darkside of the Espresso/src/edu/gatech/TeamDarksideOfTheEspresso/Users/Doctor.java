/**
 * The Class Doctor.
 * 
 * @author Patrick Tynan
 * @version 1.0
 */

package edu.gatech.TeamDarksideOfTheEspresso.Users;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import edu.gatech.TeamDarksideOfTheEspresso.Appointment.Appointment;
import edu.gatech.TeamDarksideOfTheEspresso.Record.DoctorsOrders;
import edu.gatech.TeamDarksideOfTheEspresso.Record.LabWork;
import edu.gatech.TeamDarksideOfTheEspresso.Record.Prescription;
import edu.gatech.TeamDarksideOfTheEspresso.Record.TreatmentRecord;


public class Doctor extends Nurse
{

	/** The Current appointments. */
	private ArrayList<Appointment>	CurrentAppointments;


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
	public void AddDoctorsOrders(Date date, Time time, String orders, Prescription drugs, LabWork labs, Appointment appt, Patient pat, Nurse WorkingNurse)
	{
		DoctorsOrders docOrder = new DoctorsOrders(date, time, this, labs, drugs, orders);
		pat.getMedicalHistory().addRecord(new TreatmentRecord(this, WorkingNurse, docOrder));
		this.finishAppointment(appt);
	}


	/**
	 * Adds the appointment.
	 * 
	 * @param appt
	 *            the appt
	 */
	public void addAppointment(Appointment appt)
	{
		CurrentAppointments.add(appt);
	}


	/**
	 * Finish appointment.
	 * 
	 * @param appt
	 *            the appt
	 */
	public void finishAppointment(Appointment appt)
	{
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
	public boolean checkAvailability(Doctor doc, Date time)
	{
		// Search for a match between passed param time and times in the
		// CurrentAppointment list
		for (Appointment i : CurrentAppointments)
		{
			if (i.getTime().equals(time))
			{
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
	}


	/**
	 * View reports.
	 */
	public void ViewReports()
	{
		// TODO Implement Method
	}

}
