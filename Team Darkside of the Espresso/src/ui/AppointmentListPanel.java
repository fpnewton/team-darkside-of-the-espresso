package ui;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.JSeparator;

import client.Main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppointmentListPanel extends JPanel {
	
	private static final int WIDTH = 450;
	private static final int HEIGHT = 300;

	/**
	 * Create the panel.
	 */
	public AppointmentListPanel() {
		setLayout(null);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"List of Appointments"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(37, 104, 142, 62);
		add(list);
		
		JLabel lblCheckAppointment = new JLabel("Office Appointment Schedule");
		lblCheckAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckAppointment.setBounds(100, 19, 242, 29);
		add(lblCheckAppointment);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    
			}
		});
		btnEdit.setBounds(254, 99, 117, 29);
		add(btnEdit);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(254, 140, 117, 29);
		add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(254, 181, 117, 29);
		add(btnDelete);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(254, 222, 117, 29);
		add(btnClose);
		
		JTextPane txtpnAppointmentTips = new JTextPane();
		txtpnAppointmentTips.setBackground(SystemColor.textHighlight);
		txtpnAppointmentTips.setText("Check the Appointments above and perform the actions to the right.");
		txtpnAppointmentTips.setEditable(false);
		txtpnAppointmentTips.setBounds(37, 178, 142, 78);
		add(txtpnAppointmentTips);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 60, 438, 12);
		add(separator);

	}
	
	public Dimension getSize() {
		return new Dimension(WIDTH, HEIGHT);
	}
}
