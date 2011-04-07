// $codepro.audit.disable numericLiterals

/*
 * The LookupUserPanel Class.
 */

package ui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * The LookupUserPanel Class.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class LookupUserPanel extends JPanel {
    
    /** The Constant WIDTH. */
    private static final int WIDTH = 435;
    
    /** The Constant HEIGHT. */
    private static final int HEIGHT = 60 + 25;
    
    /** The Constant TITLE. */
    private static final String TITLE = "Lookup User By Name";

    /** The text field. */
    private JTextField textField;

    /**
     * Create the panel.
     */
    public LookupUserPanel() {
	initialize();
    }

    /**
     * Initialize.
     */
    private void initialize() {
	JLabel lblLookupUsersBy = new JLabel("Lookup Users By Name");
	lblLookupUsersBy.setFont(new Font("Dialog", Font.BOLD, 14));
	lblLookupUsersBy.setHorizontalAlignment(SwingConstants.CENTER);
	lblLookupUsersBy.setBounds(12, 0, 424, 19);
	add(lblLookupUsersBy);

	textField = new JTextField();
	textField.setBounds(104, 31, 332, 19);
	add(textField);
	textField.setColumns(10);

	JLabel lblFullName = new JLabel("Full Name:");
	lblFullName.setBounds(22, 31, 83, 17);
	add(lblFullName);

	JButton btnLookup = new JButton("Lookup");
	btnLookup.setBounds(319, 62, 117, 25);
	add(btnLookup);
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
