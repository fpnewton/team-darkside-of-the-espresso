package test;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.Test;

import users.Doctor;
import users.GenderType;
import users.Patient;
import users.PatientInfo;
import users.UserInfo;



public class TestScheduleAppointment {
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	Doctor doc = new Doctor("bob", "poop", GenderType.Male, null);
	
	@Test
	public void testAppointment(){
		Patient testPat = new Patient("fnewton3","password",GenderType.Male,
				new UserInfo("Fraser Newton","Some Address","999999999","","",new Date()), 
				new PatientInfo(18, "BCBS", "pharmacy", null, null));

		Calendar date = new GregorianCalendar(2011, Calendar.MAY,1,9,1);
		
		testPat.scheduleAppointment(date, "symptoms", doc);
		
		Assert.assertNotNull(testPat.getAppointmentHistory());
		Assert.assertNotNull(doc.getCurrentAppointments());
		
	}

}
