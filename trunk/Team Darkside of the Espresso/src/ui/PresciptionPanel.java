package ui;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import record.DoctorsOrders;
import record.Prescription;
import appointment.Appointment;
import client.Main;

public class PresciptionPanel extends JPanel {
	/** The Constant WIDTH. */
    private static final int WIDTH = 450;

    /** The Constant HEIGHT. */
    private static final int HEIGHT = 300 + 25;

    /** The Constant TITLE. */
    private static final String TITLE = "Doctors Orders";
    
	private JTextField otherInfo;
	private JTextField otherPrice;
	private JRadioButton placeboCheck;
	private JRadioButton cureallCheck;
	private JRadioButton fixitCheck;
	private JRadioButton instantCheck;
	private JRadioButton otherCheck;
	public Prescription presc;
	/**
	 * Create the panel.
	 */
	public PresciptionPanel() {
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 39, 438, 12);
		add(separator);
		
		JLabel lblAddPrescription = new JLabel("Add Prescription");
		lblAddPrescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddPrescription.setBounds(0, 11, 438, 16);
		add(lblAddPrescription);
		
		placeboCheck = new JRadioButton("Placebo          $15.00\r\n", true);
		placeboCheck.setBounds(10, 58, 127, 23);
		add(placeboCheck);
		
		cureallCheck = new JRadioButton("Joe's Cure All $20.00\r\n");
		cureallCheck.setBounds(10, 84, 127, 23);
		add(cureallCheck);
		
		fixitCheck = new JRadioButton("Fix It Elixar    $10.50\r\n");
		fixitCheck.setBounds(10, 111, 127, 23);
		add(fixitCheck);
		
		instantCheck = new JRadioButton("Instant Hair   $59.00");
		instantCheck.setBounds(10, 137, 127, 23);
		add(instantCheck);
		
		otherCheck = new JRadioButton("Other (specify)");
		otherCheck.setBounds(10, 161, 105, 23);
		add(otherCheck);
		
		otherInfo = new JTextField();
		otherInfo.setBounds(21, 191, 145, 20);
		add(otherInfo);
		otherInfo.setColumns(10);
		
		JLabel label = new JLabel("$");
		label.setBounds(169, 194, 8, 14);
		add(label);
		
		otherPrice = new JTextField();
		otherPrice.setBounds(179, 191, 86, 20);
		add(otherPrice);
		otherPrice.setColumns(10);
		
		JButton submitBtn = new JButton("Submit\r\n");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				presc = new Prescription();
				
				if(placeboCheck.isSelected()){
					presc = presc.Placebo();
				}
				else if(cureallCheck.isSelected()){
					presc = presc.JoesCureAll();
				}
				else if(fixitCheck.isSelected()){
					presc = presc.FixItElixar();
				}
				else if(instantCheck.isSelected()){
					presc = presc.InstantHair();
				}
				else if(otherCheck.isSelected()){
					double oPrice = Integer.parseInt(otherPrice.getText());
					presc = new Prescription(otherInfo.getText(), oPrice);
				}
				Appointment tempAppt = Main.getCurrentAppointment();
				DoctorsOrders tempDocOrders = Main.getTempDocOrders();
				tempDocOrders.AddPrescription(presc.getInfo(), presc.getPrice());
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
