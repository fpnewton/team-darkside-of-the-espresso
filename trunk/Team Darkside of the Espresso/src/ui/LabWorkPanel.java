package ui;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import record.DoctorsOrders;
import record.LabWork;
import appointment.Appointment;
import client.Main;

public class LabWorkPanel extends JPanel {
	/** The Constant WIDTH. */
    private static final int WIDTH = 450;

    /** The Constant HEIGHT. */
    private static final int HEIGHT = 300 + 25;

    /** The Constant TITLE. */
    private static final String TITLE = "Doctors Orders";
    
	private JTextField otherInfo;
	private JTextField otherPrice;
	private JRadioButton bunCheck;
	private JRadioButton drugCheck;
	private JRadioButton cbcCheck;
	private JRadioButton cholCheck;
	private JRadioButton hivCheck;
	private JRadioButton otherCheck;
	public LabWork labWork;
	/**
	 * Create the panel.
	 */
	public LabWorkPanel() {
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 39, 438, 12);
		add(separator);
		
		JLabel lblAddLabWork = new JLabel("Add Lab Work");
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
		
		JLabel label = new JLabel("$");
		label.setBounds(169, 221, 8, 14);
		add(label);
		
		otherPrice = new JTextField();
		otherPrice.setBounds(179, 218, 86, 20);
		add(otherPrice);
		otherPrice.setColumns(10);
		
		JButton submitBtn = new JButton("Submit\r\n");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				labWork = new LabWork();
				if(bunCheck.isSelected()){
					labWork = labWork.UrinalysisBUN();
				}
				else if(drugCheck.isSelected()){
					labWork = labWork.UrinalysisDrug();
				}
				else if(cbcCheck.isSelected()){
					labWork = labWork.CBC();
				}
				else if(cholCheck.isSelected()){
					labWork = labWork.Cholesterol();
				}
				else if(hivCheck.isSelected()){
					labWork = labWork.HIV();
				}
				else if(otherCheck.isSelected()){
					labWork = new LabWork(otherInfo.getText(), otherPrice.getText());
				}
				Appointment tempAppt = Main.getCurrentAppointment();
				DoctorsOrders tempDocOrders = Main.getTempDocOrders();
				tempDocOrders.AddLabWork(labWork.getInfo(), labWork.getPrice());
				Main.setTempDocOrders(tempDocOrders);
				tempAppt.setDoctorsOrders(tempDocOrders);
				
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
