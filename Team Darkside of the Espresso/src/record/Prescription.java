/**
 * The Class Prescription.
 */

package record;


import java.io.Serializable;


public class Prescription implements Serializable
{

	/** The Info. */
	private String	Info;

	/** The Price. */
	private double	Price;


	/**
	 * Instantiates a new prescription.
	 */
	public Prescription()
	{
		this("", 0);
	}


	/**
	 * Instantiates a new prescription.
	 * 
	 * @param Info
	 *            the info
	 * @param Price
	 *            the price
	 */
	public Prescription(String Info, double Price)
	{
		this.Info = Info;
		this.Price = Price;
	}


	/**
	 * Gets the info.
	 * 
	 * @return the info
	 */
	public String getInfo()
	{
		return Info;
	}


	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public double getPrice()
	{
		return Price;
	}


	/**
	 * Sets the info.
	 * 
	 * @param Info
	 *            the new info
	 */
	public void setInfo(String Info)
	{
		this.Info = Info;
	}


	/**
	 * Sets the price.
	 * 
	 * @param Price
	 *            the new price
	 */
	public void setPrice(double Price)
	{
		this.Price = Price;
	}
	
	public Prescription Placebo(){
		return new Prescription("Placebo", 15.00);
	}
	
	public Prescription JoesCureAll(){
		return new Prescription("Joe's Cure All", 20.00);
	}
	
	public Prescription FixItElixar(){
		return new Prescription("Fix It Elixar", 10.50);
	}
	
	public Prescription InstantHair(){
		return new Prescription("Instant Hair", 59.00);
	}
}
