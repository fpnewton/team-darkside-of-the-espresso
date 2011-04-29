// $codepro.audit.disable numericLiterals

/*
 * The MakeSystemAdmin Class.
 */

package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import log.SystemLog;
import users.GenderType;
import users.Patient;
import users.PatientInfo;
import users.User;
import users.UserInfo;
import client.Main;
import database.Crypto;
import database.SqlDatabase;

/**
 * The MakeSystemAdmin Class.
 * 
 * @author Jonathan Cherry
 * @version 2.0.0
 */
public class MakePatient extends JPanel {

    /** The gender group. */
    private final ButtonGroup genderGroup = new ButtonGroup();

    /** The Constant WIDTH. */
    private static final int WIDTH = 450;

    /** The Constant HEIGHT. */
    private static final int HEIGHT = 300 + 25;

    /** The Constant TITLE. */
    private static final String TITLE = "Make System Admin";

    /** The name text box. */
    private JTextField txtName;

    /** The password text box. */
    private JPasswordField txtPassword;

    /** The address text box. */
    private JTextField txtAddress;

    /** The city, state & ZIP text box. */
    private JTextField txtCityStateZip;

    /** The phone number text box. */
    private JTextField txtPhoneNum;

    /** The social security number text box. */
    private JTextField txtSSN;

    /** The email address text box. */
    private JTextField txtEmailAddress;

    /** The birth date text box. */
    private JTextField txtBirthDate;

    /** The username text box. */
    private JTextField txtusername;

    /** The active check box. */
    private JCheckBox chkActive;

    /** The male radio button. */
    private JRadioButton rdoMale;

    /** The female radio button. */
    private JRadioButton rdoFemale;

    /**
     * Create the panel.
     */
    public MakePatient() {
	initialize();
    }

    /**
     * Initialize the panel.
     */
    private void initialize() {
	setLayout(null);

	final JLabel lblName = new JLabel("Name:");
	lblName.setHorizontalAlignment(SwingConstants.RIGHT);
	lblName.setBounds(12, 35, 187, 14);
	add(lblName);

	final JLabel lblPassword = new JLabel("Password:");
	lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
	lblPassword.setBounds(12, 76, 187, 14);
	add(lblPassword);

	final JLabel lblAddress = new JLabel("Address:");
	lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
	lblAddress.setBounds(12, 98, 187, 14);
	add(lblAddress);

	final JLabel lblCityStateZip = new JLabel("City/State/Zip:");
	lblCityStateZip.setHorizontalAlignment(SwingConstants.RIGHT);
	lblCityStateZip.setBounds(12, 118, 187, 14);
	add(lblCityStateZip);

	final JLabel lblPhoneNum = new JLabel("Phone Number:");
	lblPhoneNum.setHorizontalAlignment(SwingConstants.RIGHT);
	lblPhoneNum.setBounds(12, 144, 187, 14);
	add(lblPhoneNum);

	final JLabel lblSSN = new JLabel("Social Security Number:");
	lblSSN.setHorizontalAlignment(SwingConstants.RIGHT);
	lblSSN.setBounds(12, 168, 187, 14);
	add(lblSSN);

	final JLabel lblEmail = new JLabel("Email Address:");
	lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
	lblEmail.setBounds(12, 191, 187, 14);
	add(lblEmail);

	final JLabel lblBirthDate = new JLabel("Birth Date (MM/DD/YYYY):");
	lblBirthDate.setHorizontalAlignment(SwingConstants.RIGHT);
	lblBirthDate.setBounds(12, 214, 187, 14);
	add(lblBirthDate);

	final JLabel lblGender = new JLabel("Gender:");
	lblGender.setBounds(99, 248, 66, 14);
	add(lblGender);

	txtName = new JTextField();
	txtName.setBounds(211, 32, 227, 20);
	add(txtName);
	txtName.setColumns(10);

	txtPassword = new JPasswordField();
	txtPassword.setColumns(10);
	txtPassword.setBounds(211, 73, 227, 20);
	add(txtPassword);

	txtAddress = new JTextField();
	txtAddress.setColumns(10);
	txtAddress.setBounds(211, 95, 227, 20);
	add(txtAddress);

	txtCityStateZip = new JTextField();
	txtCityStateZip.setColumns(10);
	txtCityStateZip.setBounds(211, 118, 227, 20);
	add(txtCityStateZip);

	txtPhoneNum = new JTextField();
	txtPhoneNum.setColumns(10);
	txtPhoneNum.setBounds(211, 141, 227, 20);
	add(txtPhoneNum);

	txtSSN = new JTextField();
	txtSSN.setColumns(10);
	txtSSN.setBounds(211, 165, 227, 20);
	add(txtSSN);

	txtEmailAddress = new JTextField();
	txtEmailAddress.setColumns(10);
	txtEmailAddress.setBounds(211, 188, 227, 20);
	add(txtEmailAddress);

	txtBirthDate = new JTextField();
	txtBirthDate.setColumns(10);
	txtBirthDate.setBounds(211, 211, 227, 20);
	add(txtBirthDate);

	rdoMale = new JRadioButton("Male");
	genderGroup.add(rdoMale);
	rdoMale.setBounds(177, 243, 76, 23);
	add(rdoMale);
	rdoMale.setSelected(true);

	rdoFemale = new JRadioButton("Female");
	genderGroup.add(rdoFemale);
	rdoFemale.setBounds(265, 243, 118, 23);
	add(rdoFemale);

	chkActive = new JCheckBox("Active?");
	chkActive.setBounds(158, 269, 97, 23);
	add(chkActive);

	final JButton btnSave = new JButton("Save");
	btnSave.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent arg0) {
		createUser();
	    }
	});
	btnSave.setBounds(265, 271, 76, 23);
	add(btnSave);

	txtusername = new JTextField();
	txtusername.setBounds(211, 52, 227, 20);
	add(txtusername);
	txtusername.setColumns(10);

	final JLabel lblUsername = new JLabel("Username:");
	lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
	lblUsername.setBounds(12, 54, 187, 16);
	add(lblUsername);

	final JButton btnCancel = new JButton("Cancel");
	btnCancel.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		final MakeUser makeUserPanel = new MakeUser();

		Main.getApplicationWindow().setFrame(makeUserPanel,
			makeUserPanel.getTitle(), makeUserPanel.getWidth(),
			makeUserPanel.getHeight());
	    }
	});
	btnCancel.setBounds(353, 271, 85, 23);
	add(btnCancel);
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
     * Creates the user.
     */
    private void createUser() {
	final char[] password = txtPassword.getPassword();
	final StringBuilder strPassword = new StringBuilder();
	final SqlDatabase db = Main.getDatabaseObject();
	UserInfo userInfo = null;
	User user = null;
	PatientInfo patientInfo = null;
	final DateFormat dateFormatter = new SimpleDateFormat("MM/DD/yyyy");
	Date birthDate = null;

	try {
	    birthDate = dateFormatter.parse(txtBirthDate.getText());
	} catch (ParseException e) {
	    if (!SystemLog.canLogMessage(e.getMessage(), Level.SEVERE)) {
		e.printStackTrace();
	    }
	} finally {
	    for (char c : password) {
		strPassword.append(c);
	    }

	    userInfo = new UserInfo(txtName.getText(), txtAddress.getText() + "\n"
		    + txtCityStateZip.getText(), txtPhoneNum.getText(), txtSSN.getText(),
		    txtEmailAddress.getText(), birthDate);

	    // TODO Change patient info
	    patientInfo = new PatientInfo(0, null, null, null, null);

	    user = new Patient(txtusername.getText(), Crypto.getSha1Hash(strPassword
		    .toString()), (rdoMale.isSelected() ? GenderType.MALE
		    : GenderType.FEMALE), userInfo, patientInfo);

	    if (db.canInsertUser(user)) {
		if (!SystemLog.canLogMessage("User " + userInfo.getName()
			+ " created successfully.", Level.INFO)) {
		    System.out.println("Error: Could not log message \"User "
			    + userInfo.getName() + " created successfully.\"");
		} else {
		    if (!SystemLog.canLogMessage("Error: User " + userInfo.getName()
			    + " could not be created.", Level.WARNING)) {
			System.out.println("Error: Could not log message \"Error: User "
				+ userInfo.getName() + " could not be created.\"");
		    }
		}
	    }
	}

	final MakeUser makeUserPanel = new MakeUser();

	Main.getApplicationWindow().setFrame(makeUserPanel, makeUserPanel.getTitle(),
		makeUserPanel.getWidth(), makeUserPanel.getHeight());
    }
}
