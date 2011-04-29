/**
 * The Class Treatment.
 */

package record;

import java.io.Serializable;

/**
 * 
 * @author Jonathan Cherry
 * @version 1.0.0
 * 
 */
public class Treatment implements Serializable {

	/** The Info. */
	private String info;

	/** The Price. */
	private double price;

	/**
	 * Instantiates a new treatment.
	 */
	public Treatment() {
		this("", 0);
	}

	/**
	 * Instantiates a new treatment.
	 * 
	 * @param info
	 *            the info
	 * @param price
	 *            the price
	 */
	public Treatment(String info, double price) {
		this.info = info;
		this.price = price;
	}

	/**
	 * Gets the info.
	 * 
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the info.
	 * 
	 * @param info
	 *            the new info
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * Sets the price.
	 * 
	 * @param price
	 *            the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	// TODO Deal with numeric literals
	/**
	 * Treatment for office visit
	 * 
	 * @return the office visit
	 */
	public Treatment officeVisitBase() {
		return new Treatment("Office Visit Base", 50.00);
	}

	/**
	 * Treatment for phone consultation
	 * 
	 * @return the phone consultation
	 */
	public Treatment phoneConsult() {
		return new Treatment("Phone Consult", 35.00);
	}

	/**
	 * Treatment for annual physical
	 * 
	 * @return the annual physical
	 */
	public Treatment annualPhysical() {
		return new Treatment("Annual Physical", 75.00);
	}

	/**
	 * Converts the TreatmentRecord to a string
	 * 
	 * @return the record in string form
	 */
	@Override
	public String toString() {
		return this.toString();
	}
}
