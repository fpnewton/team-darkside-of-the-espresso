package ui;


public class LoginController
{
	private int LoginAttemptsRemaining;
	
	
	public LoginController()
	{
		LoginAttemptsRemaining = 3;
	}
	
	
	public boolean Login(String Username, String Password)
	{
		// TODO Implement Method
		LoginAttemptsRemaining--;
		return false;
	}
	
	
	public int getLoginAttemptsRemaining()
	{
		return LoginAttemptsRemaining;
	}
}
