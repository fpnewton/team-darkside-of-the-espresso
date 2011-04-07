// $codepro.audit.disable numericLiterals

/*
 * The DoctorsOrdersPanel Class.
 */

package ui;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * The DoctorsOrdersPanel Class.
 * 
 * @author Someone?
 * @version 1.0.0
 */
public class DoctorsOrdersPanel extends JPanel {

    /** The Constant WIDTH. */
    private static final int WIDTH = 450;

    /** The Constant HEIGHT. */
    private static final int HEIGHT = 300 + 25;

    /** The Constant TITLE. */
    private static final String TITLE = "Doctors Orders";

    /**
     * Create the panel.
     */
    public DoctorsOrdersPanel() {
	initialize();
    }

    /**
     * Initializes the panel.
     */
    private void initialize() {
	setLayout(null);

	final JEditorPane dtrpnEnterOrdersHere = new JEditorPane();
	dtrpnEnterOrdersHere.setText("Enter Orders Here");
	dtrpnEnterOrdersHere.setBounds(200, 117, 189, 70);
	add(dtrpnEnterOrdersHere);

	final JButton btnAddPrescription = new JButton("Add Prescription...");
	btnAddPrescription.setBounds(38, 58, 150, 29);
	add(btnAddPrescription);

	final JButton btnAddVaccine = new JButton("Add Vaccine...");
	btnAddVaccine.setBounds(38, 102, 150, 29);
	add(btnAddVaccine);

	final JButton btnAddLabwork = new JButton("Add LabWork...");
	btnAddLabwork.setBounds(38, 143, 150, 29);
	add(btnAddLabwork);

	final JEditorPane dtrpnAddAnyOther = new JEditorPane();
	dtrpnAddAnyOther.setBackground(SystemColor.textHighlight);
	dtrpnAddAnyOther.setText("Add any other instructions in the box below.");
	dtrpnAddAnyOther.setBounds(200, 58, 189, 42);
	add(dtrpnAddAnyOther);

	final JLabel lblDoctorsOrders = new JLabel("Doctor's Orders");
	lblDoctorsOrders.setHorizontalAlignment(SwingConstants.CENTER);
	lblDoctorsOrders.setBounds(6, 6, 438, 16);
	add(lblDoctorsOrders);

	final JSeparator separator = new JSeparator();
	separator.setBounds(6, 34, 438, 12);
	add(separator);

	final JTextArea txtrAppointmentSymptoms = new JTextArea();
	txtrAppointmentSymptoms.setText("Appointment Symptoms");
	txtrAppointmentSymptoms.setBounds(6, 227, 438, 50);
	add(txtrAppointmentSymptoms);

	final JLabel lblCurrentAppointmentSymptoms = new JLabel(
		"Current Appointment Symptoms");
	lblCurrentAppointmentSymptoms.setHorizontalAlignment(SwingConstants.CENTER);
	lblCurrentAppointmentSymptoms.setBounds(6, 199, 438, 16);
	add(lblCurrentAppointmentSymptoms);
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
