/**
 * The Class UserInfo.
 */

package users;


import java.io.Serializable;
import java.util.Date;


public class UserInfo implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= 1L;

	/** The Name. */
	private String				Name;

	/** The Address. */
	private String				Address;

	/** The Phone number. */
	private String				PhoneNumber;

	/** The Social security number. */
	private String				SocialSecurityNumber;

	/** The Email address. */
	private String				EmailAddress;

	/** The Birth date. */
	private Date				BirthDate;


	/**
	 * Instantiates a new user info.
	 * 
	 * @param name
	 *            the name
	 * @param address
	 *            the address
	 * @param phoneNum
	 *            the phone num
	 * @param ssn
	 *            the ssn
	 * @param email
	 *            the email
	 * @param birthDate
	 *            the birth date
	 */
	public UserInfo(String name, String address, String phoneNum, String ssn, String email, Date birthDate)
	{
		Name = name;
		Address = address;
		PhoneNumber = phoneNum;
		SocialSecurityNumber = ssn;
		EmailAddress = email;
		BirthDate = birthDate;
	}


	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName()
	{
		return Name;
	}


	/**
	 * Gets the address.
	 * 
	 * @return the address
	 */
	public String getAddress()
	{
		return Address;
	}


	/**
	 * Gets the phone number.
	 * 
	 * @return the phone number
	 */
	public String getPhoneNumber()
	{
		return PhoneNumber;
	}


	/**
	 * Gets the social security number.
	 * 
	 * @return the social security number
	 */
	public String getSocialSecurityNumber()
	{
		return SocialSecurityNumber;
	}


	/**
	 * Gets the email address.
	 * 
	 * @return the email address
	 */
	public String getEmailAddress()
	{
		return EmailAddress;
	}


	/**
	 * Gets the birth date.
	 * 
	 * @return the birth date
	 */
	public Date getBirthDate()
	{
		return BirthDate;
	}


	/**
	 * Sets the name.
	 * 
	 * @param Name
	 *            the new name
	 */
	public void setName(String Name)
	{
		this.Name = Name;
	}


	/**
	 * Sets the address.
	 * 
	 * @param Address
	 *            the new address
	 */
	public void setAddress(String Address)
	{
		this.Address = Address;
	}


	/**
	 * Sets the phone number.
	 * 
	 * @param PhoneNumber
	 *            the new phone number
	 */
	public void setPhoneNumber(String PhoneNumber)
	{
		this.PhoneNumber = PhoneNumber;
	}


	/**
	 * Sets the social security number.
	 * 
	 * @param SocialSecurityNumber
	 *            the new social security number
	 */
	public void setSocialSecurityNumber(String SocialSecurityNumber)
	{
		this.SocialSecurityNumber = SocialSecurityNumber;
	}


	/**
	 * Sets the email address.
	 * 
	 * @param EmailAddress
	 *            the new email address
	 */
	public void setEmailAddress(String EmailAddress)
	{
		this.EmailAddress = EmailAddress;
	}


	/**
	 * Sets the birth date.
	 * 
	 * @param BirthDate
	 *            the new birth date
	 */
	public void setBirthDate(Date BirthDate)
	{
		this.BirthDate = BirthDate;
	}
}
