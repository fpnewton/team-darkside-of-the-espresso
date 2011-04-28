/*
 * The InvoicePanel Class.
 */

package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import client.Main;
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
    public InvoicePanel() {
    	setLayout(null);
    	
    	Invoice invoice = new Invoice(Main.getCurrentAppointment(), Main.getCurrentBill(), Main.getCurrentAppointment().getDate());
    	
    	JLabel lblAppointmentInvoice = new JLabel("Appointment Invoice");
    	lblAppointmentInvoice.setFont(new Font("Lucida Grande", Font.BOLD, 16));
    	lblAppointmentInvoice.setBounds(136, 17, 178, 26);
    	add(lblAppointmentInvoice);
    	
    	JLabel lblLabs = new JLabel("Labs: " + invoice.getBill().getLabWork().toString());
    	lblLabs.setBounds(80, 77, 61, 16);
    	add(lblLabs);
    	
    	JLabel lblVaccines = new JLabel("Vaccines: " + invoice.getBill().getVaccines().toString());
    	lblVaccines.setBounds(80, 105, 61, 16);
    	add(lblVaccines);
    	
    	JLabel lblPrescriptions = new JLabel("Prescriptions: " + invoice.getBill().getPrescriptions().toString());
    	lblPrescriptions.setBounds(80, 133, 92, 16);
    	add(lblPrescriptions);
    	
    	JLabel lblLabcost = new JLabel("LabCost: " + invoice.calcLabWork());
    	lblLabcost.setBounds(285, 77, 61, 16);
    	add(lblLabcost);
    	
    	JLabel lblVaccinecost = new JLabel("VaccineCost: " + invoice.calcVaccine());
    	lblVaccinecost.setBounds(285, 105, 61, 16);
    	add(lblVaccinecost);
    	
    	JLabel lblPrescriptioncost = new JLabel("PrescriptionCost: " + invoice.calcPrescription());
    	lblPrescriptioncost.setBounds(285, 133, 61, 16);
    	
    	
    	add(lblPrescriptioncost);
    	
    	JLabel lblTotal = new JLabel("Total");
    	lblTotal.setFont(new Font("Lucida Grande", Font.BOLD, 13));
    	lblTotal.setBounds(80, 224, 61, 16);
    	add(lblTotal);
    	
    	JLabel lblTotalcost = new JLabel("TotalCost: " + invoice.calcTotal());
    	lblTotalcost.setBounds(285, 224, 61, 16);
    	add(lblTotalcost);
    	
    	JButton btnOkay = new JButton("Return");
		btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				final AppointmentListPanel appWindow = new AppointmentListPanel();
								
				Main.getApplicationWindow().setFrame(appWindow,
						appWindow.getTitle(), appWindow.getWidth(),
						appWindow.getHeight());
			}
		});
    	btnOkay.setBounds(166, 265, 117, 29);
    	add(btnOkay);
    	
    	JLabel lblTreatmentcost = new JLabel("TreatmentCost: " + invoice.calcTreatment());
    	lblTreatmentcost.setBounds(285, 160, 105, 14);
    	add(lblTreatmentcost);
    	
    	JLabel lblTreatments = new JLabel("Treatments: " +invoice.getBill().getTreatments().toString());
    	lblTreatments.setBounds(80, 160, 92, 14);
    	add(lblTreatments);
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
