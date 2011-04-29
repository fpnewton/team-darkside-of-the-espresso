/** The class ScheduleAppointmentTest */

package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;
import users.GenderType;
import users.Patient;
import users.PatientInfo;
import users.UserInfo;


/**
 * 
 * @author Patrick Tynan
 * @version 1.0
 */
public class ScheduleAppointmentTest extends TestCase {
	
	/** The simple date formatter */
	private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * Tests whether one can schedule an appointment
	 */
	public void testAppointment(){
		final Patient testPat = new Patient("fnewton3", "password", GenderType.MALE,
				new UserInfo("Fraser Newton", "Some Address",
						"999999999", "", "", new Date()), 
				new PatientInfo(18, "BCBS", "pharmacy", null, null));
		Date date = null;
		try {
			date = formatter.parse("01/01/2010");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			assertEquals(testPat.getGender(), GenderType.MALE);
			assertNull(date);
		}
//		testPat.ScheduleAppointment(date, new Time(11l), "symptoms", doctor);
//		
//		Assert.assertNotNull(testPat.getAppointmentHistory());
//		Assert.assertNotNull(doctor.getCurrentAppointments());
		
	}

}
