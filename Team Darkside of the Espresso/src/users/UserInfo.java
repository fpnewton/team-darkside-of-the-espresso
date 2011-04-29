/**
 * The Class UserInfo.
 */

package users;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Patrick Tynan
 * @version 1.0.0
 * 
 */
public class UserInfo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Name. */
	private String name;

	/** The Address. */
	private String address;

	/** The Phone number. */
	private String phoneNumber;

	/** The Social security number. */
	private String socialSecurityNumber;

	/** The Email address. */
	private String emailAddress;

	/** The Birth date. */
	private Date birthDate;

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
	public UserInfo(String name, String address, String phoneNum, String ssn,
			String email, Date birthDate) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNum;
		this.socialSecurityNumber = ssn;
		this.emailAddress = email;
		this.birthDate = birthDate;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the address.
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Gets the phone number.
	 * 
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Gets the social security number.
	 * 
	 * @return the social security number
	 */
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	/**
	 * Gets the email address.
	 * 
	 * @return the email address
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Gets the birth date.
	 * 
	 * @return the birth date
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the address.
	 * 
	 * @param address
	 *            the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Sets the phone number.
	 * 
	 * @param phoneNumber
	 *            the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Sets the social security number.
	 * 
	 * @param socialSecurityNumber
	 *            the new social security number
	 */
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	/**
	 * Sets the email address.
	 * 
	 * @param emailAddress
	 *            the new email address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Sets the birth date.
	 * 
	 * @param birthDate
	 *            the new birth date
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Converts the MedicalHistory to a string
	 * 
	 * @return the medical history in string form
	 */
	@Override
	public String toString() {
		return this.toString();
	}
}
