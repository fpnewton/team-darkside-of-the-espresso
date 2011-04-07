package ui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SchedulePanel extends JPanel {
	
	private static final int WIDTH = 450;
	private static final int HEIGHT = 300;

	/**
	 * Create the panel.
	 */
	public SchedulePanel() {
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(151, 147, 135, 20);
		add(comboBox);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(105, 150, 46, 14);
		add(lblDate);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(105, 210, 46, 14);
		add(lblTime);
		
		JLabel lblDoctor = new JLabel("Doctor:");
		lblDoctor.setBounds(90, 279, 61, 14);
		add(lblDoctor);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(151, 207, 135, 20);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(151, 276, 135, 20);
		add(comboBox_2);
		
		JLabel lblInstructions = new JLabel("Instructions:");
		lblInstructions.setBounds(45, 11, 160, 14);
		add(lblInstructions);
		
		JLabel lblSelectA = new JLabel("1. Select a deired date.");
		lblSelectA.setBounds(70, 36, 274, 14);
		add(lblSelectA);
		
		JLabel lblSelectA_1 = new JLabel("2. Select a desired time from the list of available");
		lblSelectA_1.setBounds(70, 60, 319, 14);
		add(lblSelectA_1);
		
		JLabel lblTimesAtThe = new JLabel("times at the selected date.");
		lblTimesAtThe.setBounds(90, 77, 231, 14);
		add(lblTimesAtThe);
		
		JLabel lblSelectedA = new JLabel("3. Selected a desired doctor from the list of available");
		lblSelectedA.setBounds(70, 102, 341, 14);
		add(lblSelectedA);
		
		JLabel lblDoctorsAtThe = new JLabel("doctors at the selected date and time.");
		lblDoctorsAtThe.setBounds(93, 122, 318, 14);
		add(lblDoctorsAtThe);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(105, 342, 89, 23);
		add(btnPrevious);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(206, 342, 89, 23);
		add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(307, 342, 89, 23);
		add(btnCancel);

	}
	
	public Dimension getSize() {
		return new Dimension(WIDTH, HEIGHT);
	}

}
