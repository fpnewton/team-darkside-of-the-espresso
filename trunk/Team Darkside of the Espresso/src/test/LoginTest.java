/** The class LoginTest */

package test;

import java.util.Date;

import junit.framework.TestCase;
import ui.LoginController;
import users.GenderType;
import users.Patient;
import users.PatientInfo;
import users.UserInfo;
import database.SqlDatabase;


/**
 * 
 * @author Fraser Newton
 * @version 1.0
 */
public class LoginTest extends TestCase {
	
	/** The login controller */
	private final LoginController login = new LoginController();
	
	/** The database */
	private SqlDatabase db;
	
	/**
	 * Tests whether one can log in properly
	 */
	public void testLogin() {
		
		try {
			db = new SqlDatabase();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final Patient testPat = new Patient("fnewton3", "password", GenderType.MALE,
				new UserInfo("Fraser Newton", "Some Address",
						"999999999", "", "", new Date()), 
				new PatientInfo(18, "BCBS", "pharmacy", null, null));
		
		db.canInsertUser(testPat);
		
		assertTrue(login.canLogin(testPat.getUsername(), "password"));
	}

}
