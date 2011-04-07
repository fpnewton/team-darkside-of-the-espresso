package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import client.Main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MakeUser extends JPanel {
	
	/** The Constant WIDTH. */
    private static final int WIDTH = 450;

    /** The Constant HEIGHT. */
    private static final int HEIGHT = 250 + 30;
    
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
		btnCreateNurse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MakeNurse makeNurse = new MakeNurse();
				
				Main.getApplicationWindow().setFrame(makeNurse, makeNurse.getTitle(), makeNurse.getWidth(), makeNurse.getHeight());
			    
			}
		});
		btnCreateNurse.setBounds(145, 88, 137, 29);
		add(btnCreateNurse);
		
		JButton btnCreateDoctor = new JButton("Create Doctor...");
		btnCreateDoctor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MakeDoctor makeDoctor = new MakeDoctor();
				
				Main.getApplicationWindow().setFrame(makeDoctor, makeDoctor.getTitle(), makeDoctor.getWidth(), makeDoctor.getHeight());
			    
			}
		});
		btnCreateDoctor.setBounds(145, 129, 137, 29);
		add(btnCreateDoctor);
		
		JButton btnCreatePatient = new JButton("Create Patient...");
		btnCreatePatient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MakePatient makePatient = new MakePatient();
				
				Main.getApplicationWindow().setFrame(makePatient, makePatient.getTitle(), makePatient.getWidth(), makePatient.getHeight());
			    
			}
		});
		btnCreatePatient.setBounds(145, 170, 137, 29);
		add(btnCreatePatient);
		
		JButton btnMakeSysadmin = new JButton("Make SysAdmin...");
		btnMakeSysadmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MakeSystemAdmin makeSysAdmin = new MakeSystemAdmin();
				
				Main.getApplicationWindow().setFrame(makeSysAdmin, makeSysAdmin.getTitle(), makeSysAdmin.getWidth(), makeSysAdmin.getHeight());
			    
			}
		});
		btnMakeSysadmin.setBounds(145, 211, 137, 29);
		add(btnMakeSysadmin);

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
