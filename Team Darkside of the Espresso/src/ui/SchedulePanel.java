// $codepro.audit.disable numericLiterals

/*
 * The SchedulePanel Class.
 */

package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import appointment.Appointment;

import users.Doctor;
import users.Patient;
import users.User;
import client.Main;
import database.SqlDatabase;

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

		// TODO Maybe fix the null database.
		SqlDatabase s = null;
		User[] uList = s.getAllUsers();
		ArrayList<Date> availableDate = new ArrayList<Date>();

		/*
		 * Looks at every doctor's list of available dates in the User database
		 * and compiles an array list of available dates to be displayed in the
		 * JComboBox
		 */
		for (int i = 0; i < uList.length; i++) {
			if (uList[i] instanceof Doctor) {
				ArrayList<Date> avail = ((Doctor) uList[i]).getAvailabilities();
				for (int j = 0; j < avail.size(); j++)
					if (!availableDate.contains(avail.get(j)))
						availableDate.add(avail.get(j));
			}
		}

		// TODO Make an array list of available times for the selected date
		ArrayList<Time> availableTime = new ArrayList<Time>();

		// TODO Make an array list of available doctors for the selected date /
		// time
		ArrayList<Doctor> availableDoc = new ArrayList<Doctor>();

		final JComboBox dateBox = new JComboBox();
		dateBox.setBounds(151, 147, 135, 20);
		dateBox.addItem("Pick a desired date");
		for (int i = 0; i < availableDate.size(); i++)
			dateBox.addItem(availableDate.get(i));
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

		final JLabel lblSelectA = new JLabel("1. Select a desired date.");
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
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JComponent successDialog = null;
				JOptionPane.showMessageDialog(successDialog,
						"You have successfully scheduled an appointment!");

				final AppointmentListPanel appWindow = new AppointmentListPanel();
				Main.getCurrentUser().addAppointment(new Appointment((Patient) Main.getCurrentUser(),
						(Date)dateBox.getSelectedItem(),(Doctor)docBox.getSelectedItem(),""));

				Main.getApplicationWindow().setFrame(appWindow,
						appWindow.getTitle(), appWindow.getWidth(),
						appWindow.getHeight());
			}
		});
		btnSubmit.setBounds(206, 342, 89, 23);
		add(btnSubmit);

		final JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				final AppointmentListPanel appWindow = new AppointmentListPanel();

				Main.getApplicationWindow().setFrame(appWindow,
						appWindow.getTitle(), appWindow.getWidth(),
						appWindow.getHeight());
			}
		});
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
