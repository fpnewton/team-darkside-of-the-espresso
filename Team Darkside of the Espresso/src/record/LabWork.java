/**
 * The Class LabWork.
 */

package record;


import java.io.Serializable;


public class LabWork implements Serializable
{

	/** The Info. */
	private String	Info;

	/** The Price. */
	private double Price;


	/**
	 * Instantiates a new lab work.
	 */
	public LabWork()
	{
		this("", 0);
	}


	/**
	 * Instantiates a new lab work.
	 * 
	 * @param Info
	 *            the info
	 * @param Price
	 *            the price
	 */
	public LabWork(String Info, double Price)
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
	
	public LabWork UrinalysisBUN(){
		return new LabWork("Urinalysis (BUN)", 50.00);
	}
	
	public LabWork UrinalysisDrug(){
		return new LabWork("Urinalysis (Drug Test)", 25.00);
	}
	
	public LabWork CBC(){
		return new LabWork("CBC", 75.00);
	}
	
	public LabWork Cholesterol(){
		return new LabWork("Cholesterol", 40.00);
	}
	
	public LabWork HIV(){
		return new LabWork("HIV", 100.00);
	}
	
	public LabWork Glucose(){
		return new LabWork("HIV", 75.00);
	}
	
	public LabWork Adrenal(){
		return new LabWork("Adrenal", 65.00);
	}
	
	public LabWork EKG(){
		return new LabWork("EKG", 100.00);
	}
	
	public LabWork MRI(){
		return new LabWork("MRI", 1000.00);
	}
}
