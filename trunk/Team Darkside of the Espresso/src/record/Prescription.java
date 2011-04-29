/**
 * The Class Prescription.
 */

package record;

import java.io.Serializable;

/**
 * 
 * @author Jonathan Cherry
 * @version 1.0.0
 * 
 */
public class Prescription implements Serializable {

	/** The Info. */
	private String info;

	/** The Price. */
	private double price;

	/**
	 * Instantiates a new prescription.
	 */
	public Prescription() {
		this("", 0);
	}

	/**
	 * Instantiates a new prescription.
	 * 
	 * @param info
	 *            the info
	 * @param price
	 *            the price
	 */
	public Prescription(String info, double price) {
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

	// TODO Deal with numeric literals
	/**
	 * Sets the price.
	 * 
	 * @param price
	 *            the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Placebo prescription
	 * 
	 * @return the new prescription
	 */
	public Prescription placebo() {
		return new Prescription("Placebo", 15.00);
	}

	/**
	 * Joe's Cure All prescription
	 * 
	 * @return the new prescription
	 */
	public Prescription joesCureAll() {
		return new Prescription("Joe's Cure All", 20.00);
	}

	/**
	 * Elixir prescription
	 * 
	 * @return the new prescription
	 */
	public Prescription fixItElixir() {
		return new Prescription("Fix It Elixir", 10.50);
	}

	/**
	 * Hair prescription
	 * 
	 * @return the new prescription
	 */
	public Prescription instantHair() {
		return new Prescription("Instant Hair", 59.00);
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
