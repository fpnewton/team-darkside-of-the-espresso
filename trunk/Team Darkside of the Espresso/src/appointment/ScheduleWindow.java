package appointment;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ScheduleWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleWindow frame = new ScheduleWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ScheduleWindow() {
		setTitle("Schedule Date and Time");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(151, 147, 135, 20);
		contentPane.add(comboBox);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(105, 150, 46, 14);
		contentPane.add(lblDate);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(105, 210, 46, 14);
		contentPane.add(lblTime);
		
		JLabel lblDoctor = new JLabel("Doctor:");
		lblDoctor.setBounds(105, 279, 46, 14);
		contentPane.add(lblDoctor);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(151, 207, 135, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(151, 276, 135, 20);
		contentPane.add(comboBox_2);
		
		JLabel lblInstructions = new JLabel("Instructions:");
		lblInstructions.setBounds(45, 11, 70, 14);
		contentPane.add(lblInstructions);
		
		JLabel lblSelectA = new JLabel("1. Select a deired date.");
		lblSelectA.setBounds(70, 36, 135, 14);
		contentPane.add(lblSelectA);
		
		JLabel lblSelectA_1 = new JLabel("2. Select a desired time from the list of available");
		lblSelectA_1.setBounds(70, 60, 251, 14);
		contentPane.add(lblSelectA_1);
		
		JLabel lblTimesAtThe = new JLabel("times at the selected date.");
		lblTimesAtThe.setBounds(90, 77, 162, 14);
		contentPane.add(lblTimesAtThe);
		
		JLabel lblSelectedA = new JLabel("3. Selected a desired doctor from the list of available");
		lblSelectedA.setBounds(70, 102, 274, 14);
		contentPane.add(lblSelectedA);
		
		JLabel lblDoctorsAtThe = new JLabel("doctors at the selected date and time.");
		lblDoctorsAtThe.setBounds(93, 122, 206, 14);
		contentPane.add(lblDoctorsAtThe);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(311, 438, 89, 23);
		contentPane.add(btnPrevious);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(410, 438, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(519, 438, 89, 23);
		contentPane.add(btnCancel);
	}
}
