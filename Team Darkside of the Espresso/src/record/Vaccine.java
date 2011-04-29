/**
 * The Class Vaccine.
 */

package record;

import java.io.Serializable;

/**
 * 
 * @author Jonathan Cherry
 * @version 1.0.0
 * 
 */
public class Vaccine implements Serializable {

	/** The Info. */
	private String info;

	/** The Price. */
	private double price;

	/**
	 * Instantiates a new vaccine.
	 */
	public Vaccine() {
		this("", 0);
	}

	/**
	 * Instantiates a new vaccine.
	 * 
	 * @param info
	 *            the info
	 * @param price
	 *            the price
	 */
	public Vaccine(String info, double price) {
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
	 * Flu vaccine
	 * 
	 * @return the new vaccine
	 */
	public Vaccine vacFlu() {
		return new Vaccine("Flu", 25.00);
	}

	/**
	 * Tetanus vaccine
	 * 
	 * @return the new vaccine
	 */
	public Vaccine vacTetanus() {
		return new Vaccine("Tetanus", 30.00);
	}

	/**
	 * MMR vaccine
	 * 
	 * @return the new vaccine
	 */
	public Vaccine vacMMR() {
		return new Vaccine("MMR", 15.00);
	}

	/**
	 * Hepatitis A vaccine
	 * 
	 * @return the new vaccine
	 */
	public Vaccine vacHepatitisA() {
		return new Vaccine("Hepatitis A", 50.00);
	}

	/**
	 * Steroid shot
	 * 
	 * @return the new vaccine
	 */
	public Vaccine vacSteroid() {
		return new Vaccine("Steroid", 56.00);
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
