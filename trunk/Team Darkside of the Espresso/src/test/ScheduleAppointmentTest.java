package test;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import users.Doctor;
import users.GenderType;
import users.Patient;
import users.PatientInfo;
import users.UserInfo;



public class ScheduleAppointmentTest extends TestCase {
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	Doctor doctor;
	
	@Test
	public void testAppointment(){
		Patient testPat = new Patient("fnewton3","password",GenderType.Male,
				new UserInfo("Fraser Newton","Some Address","999999999","","",new Date()), 
				new PatientInfo(18, "BCBS", "pharmacy", null, null));
		Date date = null;
		try {
			date = formatter.parse("01/01/2010");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		testPat.ScheduleAppointment(date, new Time(11l), "symptoms", doctor);
		
		Assert.assertNotNull(testPat.getAppointmentHistory());
		Assert.assertNotNull(doctor.getCurrentAppointments());
		
	}

}
