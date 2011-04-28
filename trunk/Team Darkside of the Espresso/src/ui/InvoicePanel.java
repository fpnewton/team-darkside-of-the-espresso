/*
 * The InvoicePanel Class.
 */

package ui;

import javax.swing.JPanel;
import appointment.Appointment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import appointment.Invoice;

/**
 * The InvoicePanel Class.
 * 
 * @author David Garner
 * @version 1.0.0
 */
public class InvoicePanel extends JPanel {

    /** The Constant WIDTH. */
    private static final int WIDTH = 450;
    
    /** The Constant HEIGHT. */
    private static final int HEIGHT = 300 + 25;
    
    /** The Constant TITLE. */
    private static final String TITLE = "Invoice";

    /**
     * Create the panel.
     */
    public InvoicePanel(Appointment app) {
    	setLayout(null);
    	
    	JLabel lblAppointmentInvoice = new JLabel("Appointment Invoice");
    	lblAppointmentInvoice.setFont(new Font("Lucida Grande", Font.BOLD, 16));
    	lblAppointmentInvoice.setBounds(136, 17, 178, 26);
    	add(lblAppointmentInvoice);
    	
    	JLabel lblLabs = new JLabel("Labs:");
    	lblLabs.setBounds(80, 77, 61, 16);
    	add(lblLabs);
    	
    	JLabel lblVaccines = new JLabel("Vaccines:");
    	lblVaccines.setBounds(80, 105, 61, 16);
    	add(lblVaccines);
    	
    	JLabel lblPrescriptions = new JLabel("Prescriptions:");
    	lblPrescriptions.setBounds(80, 133, 92, 16);
    	add(lblPrescriptions);
    	
    	JLabel lblLabcost = new JLabel("LabCost");
    	lblLabcost.setBounds(285, 77, 61, 16);
    	add(lblLabcost);
    	
    	JLabel lblVaccinecost = new JLabel("VaccineCost");
    	lblVaccinecost.setBounds(285, 105, 61, 16);
    	add(lblVaccinecost);
    	
    	JLabel lblPrescriptioncost = new JLabel("PrescriptionCost");
    	lblPrescriptioncost.setBounds(285, 133, 61, 16);
    	add(lblPrescriptioncost);
    	
    	JLabel lblTotal = new JLabel("Total");
    	lblTotal.setFont(new Font("Lucida Grande", Font.BOLD, 13));
    	lblTotal.setBounds(80, 224, 61, 16);
    	add(lblTotal);
    	
    	JLabel lblTotalcost = new JLabel("TotalCost");
    	lblTotalcost.setBounds(285, 224, 61, 16);
    	add(lblTotalcost);
    	
    	JButton btnOkay = new JButton("Return");
    	btnOkay.setBounds(166, 265, 117, 29);
    	add(btnOkay);
	// TODO Implement Method
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
