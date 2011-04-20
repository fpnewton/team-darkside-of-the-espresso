// $codepro.audit.disable numericLiterals

/*
 * The AppointmentListPanel Class.
 */

package ui;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import appointment.Appointment;

import users.Patient;
import users.SystemAdmin;

import client.Main;

/**
 * The AppointmentListPanel Class.
 * 
 * @author Patrick Tynan
 * @version 1.0.0
 */
public class AppointmentListPanel extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant WIDTH. */
    private static final int WIDTH = 450;

    /** The Constant HEIGHT. */
    private static final int HEIGHT = 300 + 25;

    /** The Constant TITLE. */
    private static final String TITLE = "Appointments";

    /**
     * Create the panel.
     */
    public AppointmentListPanel() {
	initialize();
    }

    /**
     * Initializes the panel.
     */
    private void initialize() {
	setLayout(null);

	final JList list = new JList();
	list.setModel(new AbstractListModel() {
	    /** The appointment values. */
	    private final String[] values = new String[] { "List of Appointments" };

	    public int getSize() {
		return values.length;
	    }

	    public Object getElementAt(final int index) {
		return values[index];
	    }
	});
	list.setBounds(37, 104, 142, 62);
	add(list);

	final JLabel lblCheckAppointment = new JLabel("Office Appointment Schedule");
	lblCheckAppointment.setHorizontalAlignment(SwingConstants.CENTER);
	lblCheckAppointment.setBounds(100, 19, 242, 29);
	add(lblCheckAppointment);

	final JButton btnEdit = new JButton("Edit");
	btnEdit.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(final MouseEvent e) {
		final SymptomsPanel schedulePanel = new SymptomsPanel();
		// TODO Pass selected appointment
		Main.getApplicationWindow().setFrame(schedulePanel,
			schedulePanel.getTitle(), schedulePanel.getWidth(),
			schedulePanel.getHeight());
	    }
	});
	btnEdit.setBounds(254, 99, 117, 29);
	add(btnEdit);

	final JButton btnAdd = new JButton("Add");
	btnAdd.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(final MouseEvent e) {
		final SymptomsPanel schedulePanel = new SymptomsPanel();

		Main.getApplicationWindow().setFrame(schedulePanel,
			schedulePanel.getTitle(), schedulePanel.getWidth(),
			schedulePanel.getHeight());
	    }
	});
	btnAdd.setBounds(254, 140, 117, 29);
	add(btnAdd);

	final JButton btnDelete = new JButton("Delete");
	btnDelete.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(final MouseEvent e) {
		// TODO Delete appointment
	    }
	});
	btnDelete.setBounds(254, 181, 117, 29);
	add(btnDelete);

	final JButton btnClose = new JButton("Close");

	if (Main.getCurrentUser() instanceof Patient) {
	    btnClose.setEnabled(false);
	} else {
	    btnClose.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(final MouseEvent e) {
		    final DoctorsOrdersPanel doctorsOrdersPanel = new DoctorsOrdersPanel();

		    Main.getApplicationWindow().setFrame(doctorsOrdersPanel,
			    doctorsOrdersPanel.getTitle(), doctorsOrdersPanel.getWidth(),
			    doctorsOrdersPanel.getHeight());
		}
	    });
	}

	btnClose.setBounds(254, 222, 117, 29);
	add(btnClose);

	final JTextPane txtpnAppointmentTips = new JTextPane();
	txtpnAppointmentTips.setBackground(SystemColor.textHighlight);
	txtpnAppointmentTips
		.setText("Check the Appointments above and perform the actions to the right.");
	txtpnAppointmentTips.setEditable(false);
	txtpnAppointmentTips.setBounds(37, 178, 142, 78);
	add(txtpnAppointmentTips);

	final JSeparator separator = new JSeparator();
	separator.setBounds(6, 60, 438, 12);
	add(separator);

	final JButton btnSystemAdmin = new JButton("System Admin");

	btnSystemAdmin.setVisible(false);

	if (Main.getCurrentUser() instanceof SystemAdmin) {
	    btnSystemAdmin.setVisible(true);
	}

	btnSystemAdmin.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(final MouseEvent e) {
		final MakeUser makeUser = new MakeUser();

		Main.getApplicationWindow().setFrame(makeUser, makeUser.getTitle(),
			makeUser.getWidth(), makeUser.getHeight());
	    }
	});
	btnSystemAdmin.setBounds(254, 263, 133, 25);
	add(btnSystemAdmin);
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
