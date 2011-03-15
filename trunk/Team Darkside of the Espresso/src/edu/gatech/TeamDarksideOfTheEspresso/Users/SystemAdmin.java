/**
 * The Class SystemAdmin.
 *
 * @author Patrick Tynan
 * @version 1.0
 */

package edu.gatech.TeamDarksideOfTheEspresso.Users;


import edu.gatech.TeamDarksideOfTheEspresso.Appointment.Appointment;


public class SystemAdmin extends User
{

	/**
	 * Instantiates a new system admin.
	 */
	// public SystemAdmin(){
	// super();
	// }
	//
	/**
	 * Instantiates a new system admin.
	 * 
	 * @param Uname
	 *            the uname
	 * @param Pword
	 *            the pword
	 * @param Gend
	 *            the gend
	 * @param Info
	 *            the info
	 */
	public SystemAdmin(String Uname, String Pword, GenderType Gend, UserInfo Info)
	{
		super(Uname, Pword, Gend, Info);
	}


	/**
	 * Creates the user.
	 * 
	 * @param User
	 *            the user
	 */
	public void CreateUser(User User)
	{
		// TODO Implement Method
	}


	/**
	 * Edits the user.
	 * 
	 * @param User
	 *            the user
	 */
	public void EditUser(User User)
	{
		// TODO Implement Method
	}


	/**
	 * Delete user.
	 * 
	 * @param User
	 *            the user
	 */
	public void DeleteUser(User User)
	{
		// TODO Implement Method
	}


	/**
	 * Creates the treatment record.
	 */
	public void CreateTreatmentRecord()
	{
		// TODO Implement Method
	}


	/**
	 * View appointments.
	 */
	public void ViewAppointments()
	{
		// TODO Implement Method
	}


	/**
	 * Schedule appointment.
	 * 
	 * @param Appointment
	 *            the appointment
	 */
	public void ScheduleAppointment(Appointment Appointment)
	{
		// TODO Implement Method
	}


	/**
	 * View medical history.
	 * 
	 * @param User
	 *            the user
	 */
	public void ViewMedicalHistory(User User)
	{
		// TODO Implement Method
	}


	/**
	 * View health history.
	 * 
	 * @param User
	 *            the user
	 */
	public void ViewHealthHistory(User User)
	{
		// TODO Implement Method
	}


	/**
	 * Sets the password.
	 * 
	 * @param User
	 *            the user
	 * @param Password
	 *            the password
	 */
	public void SetPassword(User User, String Password)
	{
		// TODO Implement Method
	}


	/**
	 * Suspend account.
	 * 
	 * @param User
	 *            the user
	 */
	public void SuspendAccount(User User)
	{
		// TODO Implement Method
	}


	/**
	 * Unsuspend account.
	 * 
	 * @param User
	 *            the user
	 */
	public void UnsuspendAccount(User User)
	{
		// TODO Implement Method
	}
}
