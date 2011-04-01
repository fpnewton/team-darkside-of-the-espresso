package appointment;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SuccessDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SuccessDialog dialog = new SuccessDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SuccessDialog() {
		setTitle("Success!");
		setBounds(100, 100, 362, 235);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnOk = new JButton("Ok");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnOk.setBounds(118, 107, 89, 23);
			contentPanel.add(btnOk);
		}
		{
			JLabel lblAppointmentScheduledSuccessfully = new JLabel("Appointment Scheduled Successfully!");
			lblAppointmentScheduledSuccessfully.setBounds(77, 49, 196, 14);
			contentPanel.add(lblAppointmentScheduledSuccessfully);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("OK");
				okButton.setBounds(382, 5, 47, 23);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
