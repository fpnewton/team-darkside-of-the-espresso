package edu.gatech.TeamDarksideOfTheEspresso.Test;

import edu.gatech.TeamDarksideOfTheEspresso.Users.UserInfo;
import edu.gatech.TeamDarksideOfTheEspresso.Users.PatientInfo;
import edu.gatech.TeamDarksideOfTheEspresso.Users.Doctor;
import edu.gatech.TeamDarksideOfTheEspresso.Users.Patient;
import edu.gatech.TeamDarksideOfTheEspresso.Users.GenderType;
import edu.gatech.TeamDarksideOfTheEspresso.Appointment.Appointment;
import java.util.Date;
import junit.framework.*;

public class AppointmentTest extends TestCase{

	public void initTest(){

		Class.forName("org.junit");

		UserInfo uInfo = new UserInfo("Wilhelm", "1887 Schnitzel Dr", "12345",
										"123-45-6789", "slk@gmail.com", null);
		PatientInfo pInfo = new PatientInfo(25, "AllState", "CVS", null, null);
		
		Date d = new Date(5, 3, 2);
		
		Doctor doc = new Doctor("Kaiser265", "bloop124", GenderType.MALE, uInfo);
		Patient pat = new Patient("patientDude123", "bloop123", GenderType.FEMALE,
									uInfo, pInfo);
		Appointment app = new Appointment(pat, d, doc);
		
		assertEquals(app.getDesiredDoctor, doc);
	}
}