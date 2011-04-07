// $codepro.audit.disable numericLiterals

/*
 * The SchedulePanel Class.
 */

package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.Main;

/**
 * The SchedulePanel Class.
 * 
 * @author Someone?
 * @version 1.0.0
 */
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

	final JComboBox comboBox = new JComboBox();
	comboBox.setBounds(151, 147, 135, 20);
	add(comboBox);

	final JLabel lblDate = new JLabel("Date:");
	lblDate.setBounds(105, 150, 46, 14);
	add(lblDate);

	final JLabel lblTime = new JLabel("Time:");
	lblTime.setBounds(105, 210, 46, 14);
	add(lblTime);

	final JLabel lblDoctor = new JLabel("Doctor:");
	lblDoctor.setBounds(90, 279, 61, 14);
	add(lblDoctor);

	final JComboBox comboBox_1 = new JComboBox();
	comboBox_1.setBounds(151, 207, 135, 20);
	add(comboBox_1);

	final JComboBox comboBox_2 = new JComboBox();
	comboBox_2.setBounds(151, 276, 135, 20);
	add(comboBox_2);

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

	final JLabel lblDoctorsAtThe = new JLabel("doctors at the selected date and time.");
	lblDoctorsAtThe.setBounds(93, 122, 318, 14);
	add(lblDoctorsAtThe);

	final JButton btnPrevious = new JButton("Previous");
	btnPrevious.setBounds(105, 342, 89, 23);
	add(btnPrevious);

	final JButton btnSubmit = new JButton("Submit");
	btnSubmit.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		final SymptomsPanel symptomsPanel = new SymptomsPanel();

		Main.getApplicationWindow().setFrame(symptomsPanel,
			symptomsPanel.getTitle(), symptomsPanel.getWidth(),
			symptomsPanel.getHeight());
	    }
	});
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
