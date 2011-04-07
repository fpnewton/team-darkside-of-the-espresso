package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MakeUser extends JPanel {
	
	/** The Constant WIDTH. */
    private static final int WIDTH = 450;

    /** The Constant HEIGHT. */
    private static final int HEIGHT = 250 + 25;
    
    private static final String TITLE = "Make User";

	/**
	 * Create the panel.
	 */
	public MakeUser() {
		setLayout(null);
		
		JLabel lblMakeUser = new JLabel("Make User");
		lblMakeUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblMakeUser.setBounds(145, 6, 137, 16);
		add(lblMakeUser);
		
		JButton btnCreateNurse = new JButton("Create Nurse...");
		btnCreateNurse.setBounds(155, 88, 127, 29);
		add(btnCreateNurse);
		
		JButton btnCreateDoctor = new JButton("Create Doctor...\\");
		btnCreateDoctor.setBounds(155, 129, 127, 29);
		add(btnCreateDoctor);
		
		JButton btnCreatePatient = new JButton("Create Patient...");
		btnCreatePatient.setBounds(155, 170, 127, 29);
		add(btnCreatePatient);

	}
	
	public String getTitle() {
		return TITLE;
	}
	    
	public int getWidth() {
		return WIDTH;
	}
	    
	public int getHeight() {
		return HEIGHT;
	}
}
