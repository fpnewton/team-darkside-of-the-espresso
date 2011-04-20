/*
 * The IncomePanel Class.
 */

package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import client.Main;

/**
 * The IncomePanel Class.
 * 
 * @author Someone?
 * @version 1.0.0
 */
public class IncomePanel extends JPanel {

    /** The Constant WIDTH. */
    private static final int WIDTH = 450;

    /** The Constant HEIGHT. */
    private static final int HEIGHT = 300;

    /** The Constant TITLE. */
    private static final String TITLE = "Income";

    /**
     * Create the panel.
     */
    public IncomePanel() {
    	setLayout(null);
    	
    	JLabel lblDoctorsOfficeIncome = new JLabel("Doctor's Office Income");
    	lblDoctorsOfficeIncome.setFont(new Font("Lucida Grande", Font.BOLD, 16));
    	lblDoctorsOfficeIncome.setBounds(125, 27, 196, 16);
    	add(lblDoctorsOfficeIncome);
    	
    	JButton btnReturn = new JButton("Return");
    	btnReturn.setBounds(165, 265, 117, 29);
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				final AppointmentListPanel appWindow = new AppointmentListPanel();

					Main.getApplicationWindow().setFrame(appWindow,
							appWindow.getTitle(), appWindow.getWidth(),
							appWindow.getHeight());
				}
		});
    	add(btnReturn);
    	
    	JLabel lblTotalCompletedAppointments = new JLabel("Total Completed Appointments:");
    	lblTotalCompletedAppointments.setBounds(45, 79, 209, 16);
    	add(lblTotalCompletedAppointments);
    	
    	JLabel lblTotalMoneyFrom = new JLabel("Total Money From Invoices:");
    	lblTotalMoneyFrom.setBounds(45, 143, 185, 16);
    	add(lblTotalMoneyFrom);
    	
    	JLabel label = new JLabel("New label");
    	label.setBounds(315, 79, 61, 16);
    	add(label);
    	
    	JLabel label_1 = new JLabel("New label");
    	label_1.setBounds(315, 143, 61, 16);
    	add(label_1);
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
