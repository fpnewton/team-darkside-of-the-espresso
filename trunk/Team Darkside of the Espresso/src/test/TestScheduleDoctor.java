package test;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import record.DoctorsOrders;
import record.LabWork;
import record.Prescription;

import users.Doctor;
import users.GenderType;
import users.Patient;
import appointment.Appointment;

public class TestScheduleDoctor	{
	
	
	@Test 
	public void testDocAppointment(){
		Doctor doc = new Doctor("bob", "poop", GenderType.Male, null);
		assertEquals(0, doc.getCurrentAppointments().size());
	}

	@Test
	public void testSchedule(){
		Doctor doc = new Doctor("bob", "poop", GenderType.Male, null);
		Patient p = new Patient("suzie", "poopie", GenderType.Female, null, null);
		LabWork lWork = new LabWork("",30.00);
		Prescription Prescip = new Prescription("",40.00);
		String instr = "";
		Calendar date = null;
		date = new GregorianCalendar(2011, Calendar.MAY,1,9,1);
		DoctorsOrders docOrders = new DoctorsOrders(p, date, doc, lWork, Prescip, instr);
	
		
		
		Appointment app = new Appointment(p, date, doc, docOrders);
		doc.addAppointment(app);
		assertFalse(doc.checkAvailability(app.getDate()));
	}
}
