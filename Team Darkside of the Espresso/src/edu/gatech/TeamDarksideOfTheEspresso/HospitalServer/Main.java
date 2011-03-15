/**
 * Hospital Server Application Entry Point
 * 
 * @author	Fraser P. Newton
 * @date	March 4, 2011
 */

package edu.gatech.TeamDarksideOfTheEspresso.HospitalServer;


public class Main
{
	/**
	 * Hospital Server application entry point
	 * 
	 * @param args Application arguments
	 */
	public static void main(String[] args)
	{
        Database db = new Database();
        db.InitializeDB();
        db.CreateNewDatabase();
        db.CloseDbConnection();
	}
}
