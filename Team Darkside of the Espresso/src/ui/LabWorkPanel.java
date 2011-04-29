/** The Class LabWorkPanel */

package ui;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import record.DoctorsOrders;
import record.LabWork;
import appointment.Appointment;
import client.Main;

/**
 * 
 * @author Jonathan Cherry
 * @version 1.0.0
 *
 */
public class LabWorkPanel extends JPanel {
	/** The Constant WIDTH. */
    private static final int WIDTH = 450;

    /** The Constant HEIGHT. */
    private static final int HEIGHT = 300 + 25;

    /** The Constant TITLE. */
    private static final String TITLE = "Doctors Orders";
    
    /** The other info */
	private final JTextField otherInfo;
	
	/** The other price */
	private final JTextField otherPrice;
	
	/** The bun check */
	private final JRadioButton bunCheck;
	
	/** The drug check */
	private final JRadioButton drugCheck;
	
	/** The cbc check */
	private final JRadioButton cbcCheck;
	
	/** The chol check */
	private final JRadioButton cholCheck;
	
	/** The HIV check */
	private final JRadioButton hivCheck;
	
	/** The other check */
	private final JRadioButton otherCheck;
	
	/** The lab work */
	public LabWork labWork;

	/**
	 * Create the panel.
	 */
	public LabWorkPanel() {
		setLayout(null);
		
		final JSeparator separator = new JSeparator();
		separator.setBounds(0, 39, 438, 12);
		add(separator);
		
		final JLabel lblAddLabWork = new JLabel("Add Lab Work");
		lblAddLabWork.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddLabWork.setBounds(0, 11, 438, 16);
		add(lblAddLabWork);
		
		bunCheck = new JRadioButton("Urinalysis (BUN)          $50.00", true);
		bunCheck.setBounds(10, 58, 167, 23);
		add(bunCheck);
		
		drugCheck = new JRadioButton("Urinalysis (Drug Test) $25.00");
		drugCheck.setBounds(10, 84, 167, 23);
		add(drugCheck);
		
		cbcCheck = new JRadioButton("CBC                             $75.00");
		cbcCheck.setBounds(10, 110, 167, 23);
		add(cbcCheck);
		
		cholCheck= new JRadioButton("Cholesterol                  $40.00");
		cholCheck.setBounds(10, 136, 167, 23);
		add(cholCheck);
		
		hivCheck = new JRadioButton("HIV                            $100.00");
		hivCheck.setBounds(10, 162, 167, 23);
		add(hivCheck);
		
		otherCheck = new JRadioButton("Other (specify)");
		otherCheck.setBounds(10, 188, 105, 23);
		add(otherCheck);
		
		otherInfo = new JTextField();
		otherInfo.setBounds(21, 218, 145, 20);
		add(otherInfo);
		otherInfo.setColumns(10);
		
		final JLabel label = new JLabel("$");
		label.setBounds(169, 221, 8, 14);
		add(label);
		
		otherPrice = new JTextField();
		otherPrice.setBounds(179, 218, 86, 20);
		add(otherPrice);
		otherPrice.setColumns(10);
		
		final JButton submitBtn = new JButton("Submit\r\n");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				labWork = new LabWork();
				if(bunCheck.isSelected()){
					labWork = labWork.labUrinalysisBUN();
				}
				else if(drugCheck.isSelected()){
					labWork = labWork.labUrinalysisDrug();
				}
				else if(cbcCheck.isSelected()){
					labWork = labWork.labCBC();
				}
				else if(cholCheck.isSelected()){
					labWork = labWork.labCholesterol();
				}
				else if(hivCheck.isSelected()){
					labWork = labWork.labHIV();
				}
				else if(otherCheck.isSelected()){
					double oPrice = 0.0;
					try{
						oPrice = Integer.parseInt(otherPrice.getText());
					}catch (NumberFormatException n){
						n.printStackTrace();
					}
					
					labWork = new LabWork(otherInfo.getText(), oPrice);
				}
				final Appointment tempAppt = Main.getCurrentAppointment();
				final DoctorsOrders tempDocOrders = Main.getTempDocOrders();
				tempDocOrders.addLabWork(labWork.getInfo(), labWork.getPrice());
				Main.setTempDocOrders(tempDocOrders);
				tempAppt.setDocOrders(tempDocOrders);
				Main.setCurrentAppointment(tempAppt);
			}
		});
		submitBtn.setBounds(176, 249, 89, 23);
		add(submitBtn);
		/*FIX ME */
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
