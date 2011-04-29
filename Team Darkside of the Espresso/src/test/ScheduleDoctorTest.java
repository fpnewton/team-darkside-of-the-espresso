/** The Class TestScheduleDoctor */

package test;


import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.TestCase;


import record.DoctorsOrders;
import record.LabWork;
import record.Prescription;

import users.Doctor;
import users.GenderType;
import users.Patient;
import appointment.Appointment;

/**
 * 
 * @author Patrick Tynan
 * @version 1.0
 *
 */
public class ScheduleDoctorTest extends TestCase{

	/**
	 * Tests whether we can create a doctor
	 */
	public void testDocAppointment(){
		final Doctor doc = new Doctor("bob", "poop", GenderType.MALE, null);
		doc.getUsername();
	}

	/**
	 * Tests whether we can schedule a doctor
	 */
	public void testSchedule(){
		final Doctor doc = new Doctor("bob", "poop", GenderType.MALE, null);
		final Patient pat = new Patient("suzie", "poopie", GenderType.FEMALE, null, null);
		final LabWork lWork = new LabWork("", 30.00);
		final Prescription prescip = new Prescription("", 40.00);
		final String instr = "";
		Calendar date = null;
		date = new GregorianCalendar(2011, Calendar.MAY, 1, 9, 1);
		final DoctorsOrders docOrders = new DoctorsOrders(pat,
				date, doc, lWork, prescip, instr);
		final Appointment app = new Appointment(pat, date, doc, docOrders);
		
		doc.addAppointment(app);
	}
	
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
