/** The Class MakeUser */

// $codepro.audit.disable numericLiterals
package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import users.User;
import client.Main;

/**
 * 
 * @author Fraser Newton
 * @version 1.0
 */
public class MakeUser extends JPanel {

    /** The Constant WIDTH. */
    private static final int WIDTH = 450;

    /** The Constant HEIGHT. */
    private static final int HEIGHT = 300 + 25;

    /** The title of the panel. */
    private static final String TITLE = "Make User";

    /** The selected user in the list. */
    private int selectedUser;
    
    /** The user list */
    private final User[] userList;

    /**
     * Create the panel.
     */
    public MakeUser() {
	setLayout(null);

	final JLabel lblMakeUser = new JLabel("Make User");
	lblMakeUser.setHorizontalAlignment(SwingConstants.CENTER);
	lblMakeUser.setBounds(145, 6, 137, 16);
	add(lblMakeUser);

	final JButton btnCreateNurse = new JButton("Create Nurse...");
	btnCreateNurse.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent arg0) {
	    	final MakeNurse makeNurse = new MakeNurse();

		Main.getApplicationWindow().setFrame(makeNurse, makeNurse.getTitle(),
			makeNurse.getWidth(), makeNurse.getHeight());

	    }
	});
	btnCreateNurse.setBounds(12, 80, 160, 29);
	add(btnCreateNurse);

	final JButton btnCreateDoctor = new JButton("Create Doctor...");
	btnCreateDoctor.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent arg0) {
	    	final MakeDoctor makeDoctor = new MakeDoctor();

		Main.getApplicationWindow().setFrame(makeDoctor, makeDoctor.getTitle(),
			makeDoctor.getWidth(), makeDoctor.getHeight());

	    }
	});
	btnCreateDoctor.setBounds(12, 121, 160, 29);
	add(btnCreateDoctor);

	final JButton btnCreatePatient = new JButton("Create Patient...");
	btnCreatePatient.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent arg0) {
	    	final MakePatient makePatient = new MakePatient();

		Main.getApplicationWindow().setFrame(makePatient, makePatient.getTitle(),
			makePatient.getWidth(), makePatient.getHeight());

	    }
	});
	btnCreatePatient.setBounds(12, 162, 160, 29);
	add(btnCreatePatient);

	final JButton btnMakeSysadmin = new JButton("Make SysAdmin...");
	btnMakeSysadmin.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent arg0) {
	    	final MakeSystemAdmin makeSysAdmin = new MakeSystemAdmin();

		Main.getApplicationWindow().setFrame(makeSysAdmin,
			makeSysAdmin.getTitle(), makeSysAdmin.getWidth(),
			makeSysAdmin.getHeight());

	    }
	});
	btnMakeSysadmin.setBounds(12, 203, 160, 29);
	add(btnMakeSysadmin);

	// Populate list
	userList = Main.getDatabaseObject().getAllUsers();
	
	final DefaultListModel listModel = new DefaultListModel();

	selectedUser = -1;

	for (User usr : userList) {
	    listModel.addElement(usr.getUserInformation().getName());
	}

	final JList list = new JList(listModel);
	list.addListSelectionListener(new ListSelectionListener() {
	    public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
		    selectedUser = list.getSelectedIndex();
		}
	    }
	});
	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	list.setBounds(184, 80, 254, 152);
	add(list);

	final JButton btnEdit = new JButton("Edit");
	btnEdit.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		editUser();
	    }
	});
	btnEdit.setBounds(194, 244, 86, 25);
	add(btnEdit);

	final JButton btnDelete = new JButton("Delete");
	btnDelete.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		deleteUser();
	    }
	});
	btnDelete.setBounds(294, 244, 86, 25);
	add(btnDelete);
	
	final JButton btnReturn = new JButton("Return");
	btnReturn.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
	    	final AppointmentListPanel aptListPanel = new AppointmentListPanel();

			Main.getApplicationWindow().setFrame(aptListPanel,
				aptListPanel.getTitle(), aptListPanel.getWidth(),
				aptListPanel.getHeight());
	    	
	    }
	});
	btnReturn.setBounds(33, 242, 117, 29);
	add(btnReturn);

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

    /**
     * Edits a user
     */
    private void editUser() {
    	final UpdateUser updateUserPanel = new UpdateUser(userList[selectedUser]);
	
	Main.getApplicationWindow().setFrame(updateUserPanel, 
			updateUserPanel.getTitle(), updateUserPanel.getWidth(),
			updateUserPanel.getHeight());
    }
    
    /**
     * Deletes a user
     */
    private void deleteUser() {
    	final int id = Main.getDatabaseObject()
    	.getUserID(userList[selectedUser].getUserInformation()
    			.getName());
    	
	System.out.println("Delete ID: " + id);
	System.out.println("Delete Returned: " + Main.getDatabaseObject().canDeleteUser(id));
    }
}
