/**
 * The Class Treatment.
 */

package edu.gatech.TeamDarksideOfTheEspresso.Record;


import java.io.Serializable;


public class Treatment implements Serializable
{

	/** The Info. */
	private String	Info;

	/** The Price. */
	private String	Price;


	/**
	 * Instantiates a new treatment.
	 */
	public Treatment()
	{
		this("", "");
	}


	/**
	 * Instantiates a new treatment.
	 * 
	 * @param Info
	 *            the info
	 * @param Price
	 *            the price
	 */
	public Treatment(String Info, String Price)
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
	public String getPrice()
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
	public void setPrice(String Price)
	{
		this.Price = Price;
	}
}
