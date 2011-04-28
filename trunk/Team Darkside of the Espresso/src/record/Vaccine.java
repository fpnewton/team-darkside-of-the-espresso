/**
 * The Class Vaccine.
 */

package record;


import java.io.Serializable;


public class Vaccine implements Serializable
{

	/** The Info. */
	private String	Info;

	/** The Price. */
	private double	Price;


	/**
	 * Instantiates a new vaccine.
	 */
	public Vaccine()
	{
		this("", 0);
	}


	/**
	 * Instantiates a new vaccine.
	 * 
	 * @param Info
	 *            the info
	 * @param Price
	 *            the price
	 */
	public Vaccine(String Info, double Price)
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
	
	public Vaccine Flu(){
		return new Vaccine("Flu", 25.00);
	}
	
	public Vaccine Tetanus(){
		return new Vaccine("Tetanus", 30.00);
	}
	
	public Vaccine MMR(){
		return new Vaccine("MMR", 15.00);
	}
	
	public Vaccine HepatitisA(){
		return new Vaccine("Hepatitis A", 50.00);
	}
	
	public Vaccine Steroid(){
		return new Vaccine("Steroid", 56.00);
	}
}
