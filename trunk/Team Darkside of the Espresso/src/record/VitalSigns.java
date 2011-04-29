/**
 * The Class VitalSigns.
 */

package record;

import java.io.Serializable;

import users.Patient;

/**
 * 
 * @author Jonathan Cherry
 * @version 1.0.0
 * 
 */
public class VitalSigns implements Serializable {

	/** The Patient. */
	private Patient patient;

	/** The Blood pressure. */
	private double bloodPressure;

	/** The Height. */
	private double height;

	/** The Pulse. */
	private double pulse;

	/** The Temperature. */
	private double temperature;

	/** The Weight. */
	private double weight;

	// TODO Deal with large number of parameters
	/**
	 * Constructor for Vital Signs object. Adds weight to the health history of
	 * the patient
	 * 
	 * @param patient
	 *            the patient
	 * @param bloodPressure
	 *            the blood pressure of the patient
	 * @param height
	 *            the height of the patient
	 * @param pulse
	 *            the pulse of the patient
	 * @param temperature
	 *            the temperature of the patient
	 * @param weight
	 *            the weight of the patient
	 */
	public VitalSigns(Patient patient, double bloodPressure, double height,
			double pulse, double temperature, double weight) {
		this.patient = patient;
		this.bloodPressure = bloodPressure;
		this.height = height;
		this.pulse = pulse;
		this.temperature = temperature;
		this.weight = weight;

		this.patient.getHealthHistory().addWeight(weight);
	}

	/**
	 * Gets the patient.
	 * 
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Gets the blood pressure.
	 * 
	 * @return the blood pressure
	 */
	public double getBloodPressure() {
		return bloodPressure;
	}

	/**
	 * Gets the height.
	 * 
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Gets the pulse.
	 * 
	 * @return the pulse
	 */
	public double getPulse() {
		return pulse;
	}

	/**
	 * Gets the temperature.
	 * 
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * Gets the weight.
	 * 
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Sets the patient.
	 * 
	 * @param patient
	 *            the new patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * Sets the blood pressure.
	 * 
	 * @param bloodPressure
	 *            the new blood pressure
	 */
	public void setBloodPressure(double bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	/**
	 * Sets the height.
	 * 
	 * @param height
	 *            the new height
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * Sets the pulse.
	 * 
	 * @param pulse
	 *            the new pulse
	 */
	public void setPulse(double pulse) {
		this.pulse = pulse;
	}

	/**
	 * Sets the temperature.
	 * 
	 * @param temperature
	 *            the new temperature
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	/**
	 * Sets the weight.
	 * 
	 * @param weight
	 *            the new weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
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
