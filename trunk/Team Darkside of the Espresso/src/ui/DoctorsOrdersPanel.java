package ui;

import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class DoctorsOrdersPanel extends JPanel {
	
	private static final int WIDTH = 450;
	private static final int HEIGHT = 300;

	/**
	 * Create the panel.
	 */
	public DoctorsOrdersPanel() {
		setLayout(null);
		
		JEditorPane dtrpnEnterOrdersHere = new JEditorPane();
		dtrpnEnterOrdersHere.setText("Enter Orders Here");
		dtrpnEnterOrdersHere.setBounds(200, 117, 189, 70);
		add(dtrpnEnterOrdersHere);
		
		JButton btnAddPrescription = new JButton("Add Prescription...");
		btnAddPrescription.setBounds(38, 58, 150, 29);
		add(btnAddPrescription);
		
		JButton btnAddVaccine = new JButton("Add Vaccine...");
		btnAddVaccine.setBounds(38, 102, 150, 29);
		add(btnAddVaccine);
		
		JButton btnAddLabwork = new JButton("Add LabWork...");
		btnAddLabwork.setBounds(38, 143, 150, 29);
		add(btnAddLabwork);
		
		JEditorPane dtrpnAddAnyOther = new JEditorPane();
		dtrpnAddAnyOther.setBackground(SystemColor.textHighlight);
		dtrpnAddAnyOther.setText("Add any other instructions in the box below.");
		dtrpnAddAnyOther.setBounds(200, 58, 189, 42);
		add(dtrpnAddAnyOther);
		
		JLabel lblDoctorsOrders = new JLabel("Doctor's Orders");
		lblDoctorsOrders.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorsOrders.setBounds(6, 6, 438, 16);
		add(lblDoctorsOrders);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 34, 438, 12);
		add(separator);
		
		JTextArea txtrAppointmentSymptoms = new JTextArea();
		txtrAppointmentSymptoms.setText("Appointment Symptoms");
		txtrAppointmentSymptoms.setBounds(6, 227, 438, 50);
		add(txtrAppointmentSymptoms);
		
		JLabel lblCurrentAppointmentSymptoms = new JLabel("Current Appointment Symptoms");
		lblCurrentAppointmentSymptoms.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentAppointmentSymptoms.setBounds(6, 199, 438, 16);
		add(lblCurrentAppointmentSymptoms);

	}
	
	public Dimension getSize() {
		return new Dimension(WIDTH, HEIGHT);
	}
}
