package test;

import java.util.Date;

import junit.framework.TestCase;
import ui.LoginController;
import users.GenderType;
import users.Patient;
import users.PatientInfo;
import users.UserInfo;
import database.SqlDatabase;


public class LoginTest extends TestCase {
	
	LoginController login = new LoginController();
	SqlDatabase db;
	
	public void testLogin() {
		
		try {
			db = new SqlDatabase();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Patient testPat = new Patient("fnewton3","password",GenderType.Male,
				new UserInfo("Fraser Newton","Some Address","999999999","","",new Date()), 
				new PatientInfo(18, "BCBS", "pharmacy", null, null));
		
		db.canInsertUser(testPat);
		
		assertTrue(login.login(testPat.getUsername(), "password"));
	}

}
