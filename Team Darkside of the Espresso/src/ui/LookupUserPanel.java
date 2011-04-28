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
import javax.swing.JList;
import javax.swing.AbstractListModel;

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
	setLayout(null);
	JLabel lblLookupUsersBy = new JLabel("Lookup Users By Name");
	lblLookupUsersBy.setFont(new Font("Dialog", Font.BOLD, 14));
	lblLookupUsersBy.setHorizontalAlignment(SwingConstants.CENTER);
	lblLookupUsersBy.setBounds(36, 10, 166, 17);
	add(lblLookupUsersBy);

	textField = new JTextField();
	textField.setBounds(207, 5, 134, 28);
	add(textField);
	textField.setColumns(10);

	JLabel lblFullName = new JLabel("Full Name:");
	lblFullName.setBounds(346, 11, 67, 16);
	add(lblFullName);

	JButton btnLookup = new JButton("Lookup");
	btnLookup.setBounds(179, 38, 91, 29);
	add(btnLookup);
	
	JList list = new JList();
	list.setModel(new AbstractListModel() {
		String[] values = new String[] {};
		public int getSize() {
			return values.length;
		}
		public Object getElementAt(int index) {
			return values[index];
		}
	});
	list.setBounds(59, 124, 154, -21);
	add(list);
	
	JButton btnReturn = new JButton("Return");
	btnReturn.setBounds(262, 98, 117, 29);
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
}
