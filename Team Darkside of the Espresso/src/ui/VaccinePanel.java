package ui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import record.DoctorsOrders;
import record.Vaccine;
import appointment.Appointment;
import client.Main;

public class VaccinePanel extends JPanel {
	/** The Constant WIDTH. */
    private static final int WIDTH = 450;

    /** The Constant HEIGHT. */
    private static final int HEIGHT = 300 + 25;

    /** The Constant TITLE. */
    private static final String TITLE = "Doctors Orders";
    
	private JTextField otherInfo;
	private JTextField otherPrice;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton fluCheck;
	private JRadioButton tetanusCheck;
	private JRadioButton mmrCheck;
	private	JRadioButton hepCheck;
	private JRadioButton steriodCheck;
	private JRadioButton otherCheck;
	public Vaccine vac;

	/**
	 * Create the panel.
	 */
	public VaccinePanel() {
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 39, 438, 12);
		add(separator);
		
		JLabel lblAddVaccine = new JLabel("Add Vaccine\r\n");
		lblAddVaccine.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddVaccine.setBounds(0, 11, 438, 16);
		add(lblAddVaccine);
		
		fluCheck = new JRadioButton("Flu             $25.00", true);
		buttonGroup.add(fluCheck);
		fluCheck.setBounds(10, 58, 115, 23);
		add(fluCheck);
		
		tetanusCheck = new JRadioButton("Tetanus     $30.00 ");
		buttonGroup.add(tetanusCheck);
		tetanusCheck.setBounds(10, 84, 130, 23);
		add(tetanusCheck);
		
		mmrCheck = new JRadioButton("MMR          $15.00");
		buttonGroup.add(mmrCheck);
		mmrCheck.setBounds(10, 110, 115, 23);
		add(mmrCheck);
		
		hepCheck = new JRadioButton("Hepatitis A $50.00");
		buttonGroup.add(hepCheck);
		hepCheck.setBounds(10, 136, 115, 23);
		add(hepCheck);
		
		steriodCheck = new JRadioButton("Steroid       $56.00");
		buttonGroup.add(steriodCheck);
		steriodCheck.setBounds(10, 162, 115, 23);
		add(steriodCheck);
		
		otherCheck = new JRadioButton("Other (specify)");
		buttonGroup.add(otherCheck);
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
				vac = new Vaccine();
				if(fluCheck.isSelected()){
					vac = vac.Flu();
				}
				else if(tetanusCheck.isSelected()){
					vac = vac.Tetanus();
				}
				else if(mmrCheck.isSelected()){
					vac = vac.MMR();
				}
				else if(hepCheck.isSelected()){
					vac = vac.HepatitisA();
				}
				else if(steriodCheck.isSelected()){
					vac = vac.Steroid();
				}
				else if(otherCheck.isSelected()){
					double oPrice = Integer.parseInt(otherPrice.getText());
					vac = new Vaccine(otherInfo.getText(), oPrice);
				}
				Appointment tempAppt = Main.getCurrentAppointment();
				DoctorsOrders tempDocOrders = Main.getTempDocOrders();
				tempDocOrders.addVaccines(vac);
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
