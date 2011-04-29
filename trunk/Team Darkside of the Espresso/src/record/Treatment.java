/**
 * The Class Treatment.
 */

package record;

import java.io.Serializable;

public class Treatment implements Serializable {

	/** The Info. */
	private String Info;

	/** The Price. */
	private double Price;

	/**
	 * Instantiates a new treatment.
	 */
	public Treatment() {
		this("", 0);
	}

	/**
	 * Instantiates a new treatment.
	 * 
	 * @param Info
	 *            the info
	 * @param Price
	 *            the price
	 */
	public Treatment(String Info, double Price) {
		this.Info = Info;
		this.Price = Price;
	}

	/**
	 * Gets the info.
	 * 
	 * @return the info
	 */
	public String getInfo() {
		return Info;
	}

	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return Price;
	}

	/**
	 * Sets the info.
	 * 
	 * @param Info
	 *            the new info
	 */
	public void setInfo(String Info) {
		this.Info = Info;
	}

	/**
	 * Sets the price.
	 * 
	 * @param Price
	 *            the new price
	 */
	public void setPrice(double Price) {
		this.Price = Price;
	}

	public Treatment OfficeVisitBase() {
		return new Treatment("Office Visit Base", 50.00);
	}

	public Treatment PhoneConsult() {
		return new Treatment("Phone Consult", 35.00);
	}

	public Treatment AnnualPhysical() {
		return new Treatment("Annual Physical", 75.00);
	}
}
