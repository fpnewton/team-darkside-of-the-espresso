/**
 * The Class HealthHistory.
 * 
 * @author David Garner
 * @version 1.0.0
 */

package record;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import users.Patient;

public class HealthHistory implements Serializable {

	private static final long serialVersionUID = 1L;
	/** The Weight data. */
	private List<Double> weightData;

	/**
	 * Constructor for HealthHistory
	 * 
	 * @param patient
	 *            the patient for whom the health history will be generated
	 */
	public HealthHistory() {
		this.weightData = new ArrayList<Double>();
	}

	/**
	 * Generate graph.
	 */
	public void GenerateGraph() {
		// TODO Implement Method
	}

	/**
	 * Gets the weight data
	 * 
	 * @return The weight data
	 */
	public List<Double> getWeightData() {
		return this.weightData;
	}
}
