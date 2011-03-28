/**
 * The Class VitalSigns.
 */

package record;


import java.io.Serializable;


public class VitalSigns implements Serializable
{

	/** The Blood pressure. */
	private double	BloodPressure;

	/** The Height. */
	private double	Height;

	/** The Pulse. */
	private double	Pulse;

	/** The Temperature. */
	private double	Temperature;

	/** The Weight. */
	private double	Weight;


	/**
	 * Gets the blood pressure.
	 * 
	 * @return the blood pressure
	 */
	public double getBloodPressure()
	{
		return BloodPressure;
	}


	/**
	 * Gets the height.
	 * 
	 * @return the height
	 */
	public double getHeight()
	{
		return Height;
	}


	/**
	 * Gets the pulse.
	 * 
	 * @return the pulse
	 */
	public double getPulse()
	{
		return Pulse;
	}


	/**
	 * Gets the temperature.
	 * 
	 * @return the temperature
	 */
	public double getTemperature()
	{
		return Temperature;
	}


	/**
	 * Gets the weight.
	 * 
	 * @return the weight
	 */
	public double getWeight()
	{
		return Weight;
	}


	/**
	 * Sets the blood pressure.
	 * 
	 * @param BloodPressure
	 *            the new blood pressure
	 */
	public void setBloodPressure(double BloodPressure)
	{
		this.BloodPressure = BloodPressure;
	}


	/**
	 * Sets the height.
	 * 
	 * @param Height
	 *            the new height
	 */
	public void setHeight(double Height)
	{
		this.Height = Height;
	}


	/**
	 * Sets the pulse.
	 * 
	 * @param Pulse
	 *            the new pulse
	 */
	public void setPulse(double Pulse)
	{
		this.Pulse = Pulse;
	}


	/**
	 * Sets the temperature.
	 * 
	 * @param Temperature
	 *            the new temperature
	 */
	public void setTemperature(double Temperature)
	{
		this.Temperature = Temperature;
	}


	/**
	 * Sets the weight.
	 * 
	 * @param Weight
	 *            the new weight
	 */
	public void setWeight(double Weight)
	{
		this.Weight = Weight;
	}
}
