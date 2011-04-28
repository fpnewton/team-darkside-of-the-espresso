// $codepro.audit.disable numericLiterals

/*
 * The AppointmentListPanel Class.
 */

package ui;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import network.Message;
import network.MessageKey;
import users.Doctor;
import users.Patient;
import users.SystemAdmin;
import users.User;
import appointment.Appointment;
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
	int selectedUser = -1;

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
		
		ArrayList<Appointment> appList = Main.getCurrentUser().getAppointmentList();

		DefaultListModel listModel = new DefaultListModel();

		

//		for (User usr : userList) {
//		    listModel.addElement(usr.getUserInformation().getName());
//		}

		final JList list = new JList(listModel);
		list.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
				    selectedUser = list.getSelectedIndex();
				}
		    }
		});
		list.setBounds(37, 104, 142, 62);
		add(list);
	
		final JLabel lblCheckAppointment = new JLabel(
				"Office Appointment Schedule");
		lblCheckAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckAppointment.setBounds(100, 19, 242, 29);
		add(lblCheckAppointment);

		final JButton btnEdit = new JButton("Edit");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				final SymptomsPanel schedulePanel = new SymptomsPanel();
				Main.setCurrentAppointment((Appointment) list
						.getSelectedValue());
				
				Main.getApplicationWindow().setFrame(schedulePanel,
						schedulePanel.getTitle(), schedulePanel.getWidth(),
						schedulePanel.getHeight());
			}
		});
		btnEdit.setBounds(191, 84, 117, 29);
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
		btnAdd.setBounds(191, 125, 117, 29);
		add(btnAdd);

		final JButton btnDelete = new JButton("Delete");
		// TODO Delete the appointment
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				Main.getCurrentUser().removeAppointment((Appointment)list.getSelectedValue());
				initialize();
			}
		});
		btnDelete.setBounds(191, 166, 117, 29);
		add(btnDelete);

		final JButton btnClose = new JButton("Close");
		// TODO Close the appt and add to doctor's income list
		if (Main.getCurrentUser() instanceof Patient) {
			btnClose.setEnabled(false);
		} else {
			btnClose.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					Main.setCurrentAppointment((Appointment) list
							.getSelectedValue());
					final DoctorsOrdersPanel doctorsOrdersPanel = new DoctorsOrdersPanel();

					Main.getApplicationWindow().setFrame(doctorsOrdersPanel,
							doctorsOrdersPanel.getTitle(),
							doctorsOrdersPanel.getWidth(),
							doctorsOrdersPanel.getHeight());
				}
			});
		}

		btnClose.setBounds(191, 207, 117, 29);
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

				Main.getApplicationWindow().setFrame(makeUser,
						makeUser.getTitle(), makeUser.getWidth(),
						makeUser.getHeight());
			}
		});
		btnSystemAdmin.setBounds(185, 263, 123, 25);
		add(btnSystemAdmin);

		JButton btnViewInvoice = new JButton("View Invoice");
		btnViewInvoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((Appointment) list.getSelectedValue()).getDocOrders() == null) {
					JComponent failureDialog = null;
					JOptionPane
							.showMessageDialog(
									failureDialog,
									"You can only view an invoice if you have already"
											+ " written up doctor's orders for the selected appointment.");
				}

				else {
					final InvoicePanel inPanel = new InvoicePanel();
					Appointment currentApp = (Appointment) list
							.getSelectedValue();
					Main.setCurrentAppointment(currentApp);
					Main.setCurrentBill(currentApp.getDocOrders().getBill());
					Main.getApplicationWindow().setFrame(inPanel,
							inPanel.getTitle(), inPanel.getWidth(),
							inPanel.getHeight());
				}

			}
		});
		btnViewInvoice.setBounds(37, 261, 142, 29);
		add(btnViewInvoice);

		JButton btnViewIncome = new JButton("View Income");
		btnViewIncome.setVisible(false);

		if (Main.getCurrentUser() instanceof Doctor) {
			btnViewIncome.setVisible(true);
		}

		btnViewIncome.setBounds(315, 261, 117, 29);
		add(btnViewIncome);

		JButton btnAddDocorders = new JButton("Add Doctors..");

		btnAddDocorders.setVisible(false);

		if (Main.getCurrentUser() instanceof Doctor) {
			btnAddDocorders.setVisible(true);
		}

		btnAddDocorders.setBounds(320, 125, 117, 29);
		add(btnAddDocorders);
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
