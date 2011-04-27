package test;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import users.Doctor;
import users.GenderType;
import users.Patient;
import appointment.*;
import junit.framework.TestCase;

public class ScheduleDoctorTest extends TestCase{
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public void docAppointmentTest(){
		Doctor doc = new Doctor("bob", "poop", GenderType.Male, null);
		assertEquals(doc.getCurrentAppointments(), null);
	}

	public void scheduleTest(){
		Doctor doc = new Doctor("bob", "poop", GenderType.Male, null);
		Patient p = new Patient("suzie", "poopie", GenderType.Female, null, null);
		
		Date date = null;
		try {
			date = formatter.parse("01/01/2010");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Appointment app = new Appointment(p, date, doc);
		assertFalse(doc.checkAvailability(app.getDate()));
	}
}
