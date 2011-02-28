package edu.gatech.TeamDarksideOfTheEspresso.Users;


public abstract class User
{
	private String		Username;
	private String		PasswordHash;
	
	private	GenderType	Gender;
	
	private	UserInfo	UserInformation;
	
	private boolean		isActive;
	
	
	public String getUsername()
	{
		return Username;
	}
	
	
	public String getPasswordHash()
	{
		return PasswordHash;
	}
	
	
	public GenderType getGender()
	{
		return Gender;
	}
	
	
	public UserInfo getUserInformation()
	{
		return UserInformation;
	}
	
	
	public boolean isActive()
	{
		return isActive;
	}
	
	
	public void setUsername(String Username)
	{
		this.Username = Username;
	}
	
	
	public void setPasswordHash(String PasswordHash)
	{
		this.PasswordHash = PasswordHash;
	}
	
	
	public void setGender(GenderType Gender)
	{
		this.Gender = Gender;
	}
	
	
	public void setUserInformation(UserInfo UserInformation)
	{
		this.UserInformation = UserInformation;
	}
	
	
	public void ActivateUser()
	{
		isActive = true;
	}
	
	
	public void DeactiveUser()
	{
		isActive = false;
	}
}
