/*
 * The LookupUserView Class.
 */

package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * The LookupUserView Class.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class LookupUserView extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /** The content pane. */
    private JPanel contentPane;
    
    /** The text field. */
    private JTextField textField;

    /**
     * Launch the application.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    LookupUserView frame = new LookupUserView();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public LookupUserView() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 129);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblLookupUsersBy = new JLabel("Lookup Users By Name");
	lblLookupUsersBy.setFont(new Font("Dialog", Font.BOLD, 14));
	lblLookupUsersBy.setHorizontalAlignment(SwingConstants.CENTER);
	lblLookupUsersBy.setBounds(12, 0, 424, 19);
	contentPane.add(lblLookupUsersBy);

	textField = new JTextField();
	textField.setBounds(104, 31, 332, 19);
	contentPane.add(textField);
	textField.setColumns(10);

	JLabel lblFullName = new JLabel("Full Name:");
	lblFullName.setBounds(22, 31, 83, 17);
	contentPane.add(lblFullName);

	JButton btnLookup = new JButton("Lookup");
	btnLookup.setBounds(319, 62, 117, 25);
	contentPane.add(btnLookup);
    }
}
