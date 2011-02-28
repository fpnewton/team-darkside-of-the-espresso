package edu.gatech.TeamDarksideOfTheEspresso.Users;


import java.util.Date;


public class UserInfo
{
	private String	Name;
	private String	Address;
	private String	PhoneNumber;
	private	String	SocialSecurityNumber;
	private String	EmailAddress;
	
	private	Date	BirthDate;
	
	
	public String getName()
	{
		return Name;
	}
	
	
	public String getAddress()
	{
		return Address;
	}
	
	
	public String getPhoneNumber()
	{
		return PhoneNumber;
	}
	
	
	public String getSocialSecurityNumber()
	{
		return SocialSecurityNumber;
	}
	
	
	public String getEmailAddress()
	{
		return EmailAddress;
	}
	
	
	public Date getBirthDate()
	{
		return BirthDate;
	}
	
	
	public void setName(String Name)
	{
		this.Name = Name;
	}
	
	
	public void setAddress(String Address)
	{
		this.Address = Address;
	}
	
	
	public void setPhoneNumber(String PhoneNumber)
	{
		this.PhoneNumber = PhoneNumber;
	}
	
	
	public void setSocialSecurityNumber(String SocialSecurityNumber)
	{
		this.SocialSecurityNumber = SocialSecurityNumber;
	}
	
	
	public void setEmailAddress(String EmailAddress)
	{
		this.EmailAddress = EmailAddress;
	}
	
	
	public void setBirthDate(Date BirthDate)
	{
		this.BirthDate = BirthDate;
	}
}
