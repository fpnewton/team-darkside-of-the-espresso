/**
 * The Class User.
 * 
 * @author Patrick Tynan
 * @version 1.0
 */

package users;


import java.io.Serializable;


public abstract class User implements Serializable
{
	/** The Username. */
	private String		Username;

	/** The Password hash. */
	private String		PasswordHash;

	/** The Gender. */
	private GenderType	Gender;

	/** The User information. */
	private UserInfo	UserInformation;

	/** The is active. */
	private boolean		isActive;


	/**
	 * Instantiates a new user.
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
	public User(String Uname, String Pword, GenderType Gend, UserInfo Info)
	{
		this.Username = Uname;
		this.Gender = Gend;
		this.UserInformation = Info;
		this.PasswordHash = Pword;
		isActive = true;
	}


	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername()
	{
		return Username;
	}


	/**
	 * Gets the password hash.
	 * 
	 * @return the password hash
	 */
	public String getPasswordHash()
	{
		return PasswordHash;
	}


	/**
	 * Gets the gender.
	 * 
	 * @return the gender
	 */
	public GenderType getGender()
	{
		return Gender;
	}


	/**
	 * Gets the user information.
	 * 
	 * @return the user information
	 */
	public UserInfo getUserInformation()
	{
		return UserInformation;
	}


	/**
	 * Checks if is active.
	 * 
	 * @return true, if is active
	 */
	public boolean isActive()
	{
		return isActive;
	}


	/**
	 * Sets the username.
	 * 
	 * @param Username
	 *            the new username
	 */
	public void setUsername(String Username)
	{
		this.Username = Username;
	}


	/**
	 * Sets the password hash.
	 * 
	 * @param PasswordHash
	 *            the new password hash
	 */
	public void setPasswordHash(String PasswordHash)
	{
		this.PasswordHash = PasswordHash;
	}


	/**
	 * Sets the gender.
	 * 
	 * @param Gender
	 *            the new gender
	 */
	public void setGender(GenderType Gender)
	{
		this.Gender = Gender;
	}


	/**
	 * Sets the user information.
	 * 
	 * @param UserInformation
	 *            the new user information
	 */
	public void setUserInformation(UserInfo UserInformation)
	{
		this.UserInformation = UserInformation;
	}


	/**
	 * Activate user.
	 */
	public void ActivateUser()
	{
		isActive = true;
	}


	/**
	 * Deactive user.
	 */
	public void DeactiveUser()
	{
		isActive = false;
	}


	/**
	 * Login.
	 * 
	 * @param Uname
	 *            the uname
	 * @param Pword
	 *            the pword
	 * @return true, if successful
	 */
	public boolean Login(String Uname, String Pword)
	{
		if (Uname.equals(this.Username) && Pword.equals(this.PasswordHash))
		{
			this.ActivateUser();
			return true;
		}
		return false;
	}

}
