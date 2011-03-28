/**
 * Hospital Server Application Entry Point
 * 
 * @author	Fraser P. Newton
 * @date	March 4, 2011
 */

package server;


import database.SqlDatabase;
import java.util.logging.Level;

import users.GenderType;
import users.Patient;
import users.PatientInfo;
import users.User;
import users.UserInfo;

import log.*;


public class Main
{
	public static void main(String args[])
	{
	/**
		SqlDatabase db = new SqlDatabase();

		db.OpenDatabaseConnection();
		db.CreateNewDatabaseTables();

		UserInfo ui = new UserInfo("George P. Burdell", "1214 Woodridge Dr\nAtlanta, GA 30339", "678-468-0074", "999-99-9999", "fnewton3@gatech.edu", null);
		PatientInfo pi = new PatientInfo(20, "My Insurance Carrier", "My Pharmacy", null, null);
		Patient patient = new Patient("fnewton3", "password", GenderType.Male, ui, pi);

		db.InsertUser(patient);

		//System.out.println(db.getUserID("Fraser P. Newton"));
		int id = db.getUserID("George P. Burdell");
		Patient pt = (Patient)db.getUser(id);
		
		System.out.println(pt.getUserInformation().getName());

		db.CloseDatabaseConnection();
		*/
		
		SystemLog.LogMessage("Sample log", Level.INFO);
	}
}
