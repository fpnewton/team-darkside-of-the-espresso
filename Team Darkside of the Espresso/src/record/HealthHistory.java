/**
 * The Class HealthHistory.
 * 
 * @author David Garner
 * @version 1.0.0
 */

package record;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import users.Patient;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

//import org.jfree.ui.Spacer;

public class HealthHistory extends ApplicationFrame implements Serializable {

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
		super("Health History Over Time");
		this.weightData = new ArrayList<Double>();
	}

	/**
	 * Generates a graph by collecting a list of all the doubles and placing
	 * them into a line graph.
	 */
	public void GenerateGraph() {
		/* this is what will be holding all the data */
		final XYSeries weightSeries = new XYSeries(
				"Weight of the Patient over Time");

		/*
		 * the XYSeriesCollection is just a formality, as it is required for a
		 * JFreeChart line graph constructor
		 */
		final XYSeriesCollection weightSeriesCollection = new XYSeriesCollection();

		/* adding all the weights to the weightSeries */
		for (int i = 0; i < getWeightData().size(); i++)
			weightSeries.add((double) getWeightData().get(i), (double) i);

		/* adding the series to the collection */
		weightSeriesCollection.addSeries(weightSeries);

		/* here is where the chart itself is created */
		final JFreeChart chart = ChartFactory.createXYLineChart(
				"Patient Weight Over Time", "Time", "Weight",
				weightSeriesCollection, PlotOrientation.VERTICAL, true, true,
				false);

		/* just a little customization */
		chart.setBackgroundPaint(Color.blue);

		final XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(Color.lightGray);

		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);

		/* end customization */

		/* initializing and displaying the chart to screen */
		this.pack();
		RefineryUtilities.centerFrameOnScreen(this);
		this.setVisible(true);
	}

	/**
	 * Gets the weight data
	 * 
	 * @return The weight data
	 */
	public List<Double> getWeightData() {
		return this.weightData;
	}

	/**
	 * Adds a new weight to the list.
	 * 
	 * @param weight
	 *            the new weight to add
	 */
	public void addWeight(double weight) {
		getWeightData().add(weight);
	}
}
