// $codepro.audit.disable numericLiterals

/*
 * The SchedulePanel Class.
 */

package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import appointment.Appointment;

import client.Main;

/**
 * The SchedulePanel Class.
 * 
 * @author Someone?
 * @version 1.0.0
 */
@SuppressWarnings("serial")
public class SchedulePanel extends JPanel {

	/** The Constant WIDTH. */
	private static final int WIDTH = 500;

	/** The Constant HEIGHT. */
	private static final int HEIGHT = 400 + 25;

	/** The Constant TITLE. */
	private static final String TITLE = "Schedule Appointment";

	/**
	 * Create the panel.
	 */
	public SchedulePanel() {
		initialize();
	}

	/**
	 * Initializes the panel.
	 */
	private void initialize() {
		setLayout(null);

		// TODO Make an array list of available dates for the JComboBox
		ArrayList<Date> availableDate = new ArrayList<Date>();

		final JComboBox dateBox = new JComboBox();
		dateBox.setBounds(151, 147, 135, 20);
		add(dateBox);

		final JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(105, 150, 46, 14);
		add(lblDate);

		final JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(105, 210, 46, 14);
		add(lblTime);

		final JLabel lblDoctor = new JLabel("Doctor:");
		lblDoctor.setBounds(90, 279, 61, 14);
		add(lblDoctor);

		final JComboBox timeBox = new JComboBox();
		timeBox.setBounds(151, 207, 135, 20);

		add(timeBox);

		final JComboBox docBox = new JComboBox();
		docBox.setBounds(151, 276, 135, 20);
		add(docBox);

		final JLabel lblInstructions = new JLabel("Instructions:");
		lblInstructions.setBounds(45, 11, 160, 14);
		add(lblInstructions);

		final JLabel lblSelectA = new JLabel("1. Select a deired date.");
		lblSelectA.setBounds(70, 36, 274, 14);
		add(lblSelectA);

		final JLabel lblSelectA_1 = new JLabel(
				"2. Select a desired time from the list of available");
		lblSelectA_1.setBounds(70, 60, 319, 14);
		add(lblSelectA_1);

		final JLabel lblTimesAtThe = new JLabel("times at the selected date.");
		lblTimesAtThe.setBounds(90, 77, 231, 14);
		add(lblTimesAtThe);

		final JLabel lblSelectedA = new JLabel(
				"3. Selected a desired doctor from the list of available");
		lblSelectedA.setBounds(70, 102, 341, 14);
		add(lblSelectedA);

		final JLabel lblDoctorsAtThe = new JLabel(
				"doctors at the selected date and time.");
		lblDoctorsAtThe.setBounds(93, 122, 318, 14);
		add(lblDoctorsAtThe);

		final JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(105, 342, 89, 23);
		btnPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				final SymptomsPanel symptomsPanel = new SymptomsPanel();

				Main.getApplicationWindow().setFrame(symptomsPanel,
						symptomsPanel.getTitle(), symptomsPanel.getWidth(),
						symptomsPanel.getHeight());
			}
		});
		add(btnPrevious);

		final JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(206, 342, 89, 23);
		add(btnSubmit);

		final JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(307, 342, 89, 23);
		add(btnCancel);
	}

	/**
	 * Gets the title.
	 * 
	 * @return The title of the panel
	 */
	public String getTitle() {
		return TITLE;
	}

	/**
	 * Gets the width of the panel.
	 * 
	 * @return The width of the panel
	 */
	public int getWidth() {
		return WIDTH;
	}

	/**
	 * Gets the height of the panel.
	 * 
	 * @return The height of the panel
	 */
	public int getHeight() {
		return HEIGHT;
	}
}
