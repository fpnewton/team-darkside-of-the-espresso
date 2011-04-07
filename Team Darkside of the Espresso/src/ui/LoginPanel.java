// $codepro.audit.disable numericLiterals

/*
 * The LoginPanel Class.
 */

package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import client.Main;

/**
 * The LoginPanel Class.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class LoginPanel extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The controller. */
    private LoginController controller;

    /** The Constant WIDTH. */
    private static final int WIDTH = 450;

    /** The Constant HEIGHT. */
    private static final int HEIGHT = 250 + 25;

    /** The title of the panel. */
    private static final String TITLE = "Hospital Login";

    /** The wrong username password string. */
    private static final String ERROR_WRONG_USERNAME_PASSWORD = 
	"Incorrect username or password. Please try again.";

    /** The username password length string. */
    private static final String ERROR_USERNAME_PASSWORD_LENGTH = 
	"Username or password is too short.";

    /** The lockout error string. */
    private static final String ERROR_LOCKOUT = 
	"Too many login attempts. Your account is now disabled.";

    /** The login attempts error string. */
    private static final String ERROR_LOGIN_ATTEMPTS = 
	"Login Attempts Left: ";

    /** The username text box. */
    private JTextField txtUsername;

    /** The password text box. */
    private JPasswordField txtPassword;

    /** The error label. */
    private JLabel lblError;

    /** The login attempts label. */
    private JLabel lblLoginAttempts;

    /**
     * Create the panel.
     */
    public LoginPanel() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	controller = new LoginController();

	setLayout(null);

	final JLabel lblHospitalLogin = new JLabel("Hospital Login");
	lblHospitalLogin.setHorizontalAlignment(SwingConstants.CENTER);
	lblHospitalLogin.setFont(new Font("Dialog", Font.BOLD, 32));
	lblHospitalLogin.setBounds(12, 0, 426, 47);
	add(lblHospitalLogin);

	final JLabel lblUsername = new JLabel("Username");
	lblUsername.setBounds(22, 95, 80, 30);
	add(lblUsername);

	final JLabel lblPassword = new JLabel("Password");
	lblPassword.setBounds(22, 137, 80, 30);
	add(lblPassword);

	lblLoginAttempts = new JLabel("Login Attempts Left: 3");
	lblLoginAttempts.setBounds(102, 179, 336, 20);
	add(lblLoginAttempts);

	txtUsername = new JTextField();
	txtUsername.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		    doLogin();
		}
	    }
	});
	txtUsername.setBounds(102, 95, 336, 30);
	add(txtUsername);
	txtUsername.setColumns(10);

	txtPassword = new JPasswordField();
	txtPassword.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		    doLogin();
		}
	    }
	});
	txtPassword.setBounds(102, 137, 336, 30);
	add(txtPassword);

	final JButton btnLogin = new JButton("Login");
	btnLogin.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		doLogin();
	    }
	});
	btnLogin.setBounds(112, 211, 85, 25);
	add(btnLogin);

	final JButton btnClear = new JButton("Clear");
	btnClear.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		lblError.setText("");
		txtUsername.setText("");
		txtPassword.setText("");

		controller = new LoginController();
		lblLoginAttempts.setText(ERROR_LOGIN_ATTEMPTS
			+ controller.getLoginAttemptsRemaining());
	    }
	});
	btnClear.setBounds(209, 211, 85, 25);
	add(btnClear);

	final JButton btnSettings = new JButton("Settings");
	btnSettings.setBounds(338, 211, 100, 25);
	add(btnSettings);

	lblError = new JLabel("");
	lblError.setHorizontalAlignment(SwingConstants.CENTER);
	lblError.setForeground(Color.RED);
	lblError.setBounds(22, 53, 416, 30);
	add(lblError);
	setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { txtUsername,
		txtPassword, btnLogin, btnClear, btnSettings }));
    }

    /**
     * Attempt to login.
     */
    private void doLogin() {
	final char[] password = txtPassword.getPassword();
	final StringBuilder str = new StringBuilder();

	for (char c : password) {
	    str.append(c);
	}

	if (txtUsername.getText().length() >= 6 && str.length() >= 8) {

	    if (controller.canLogin(txtUsername.getText(), str.toString())) {
		// Open the appointment window on success
		final AppointmentListPanel appointmentPanel = new AppointmentListPanel();

		Main.getApplicationWindow().setFrame(appointmentPanel,
			appointmentPanel.getTitle(), appointmentPanel.getWidth(),
			appointmentPanel.getHeight());
	    } else {
		lblError.setText(ERROR_WRONG_USERNAME_PASSWORD);
		txtPassword.setText("");
		lblLoginAttempts.setText(ERROR_LOGIN_ATTEMPTS
			+ controller.getLoginAttemptsRemaining());
	    }
	} else {
	    lblError.setText(ERROR_USERNAME_PASSWORD_LENGTH);
	    txtPassword.setText("");
	}

	if (controller.getLoginAttemptsRemaining() == 0) {
	    controller = new LoginController();

	    lblError.setText(ERROR_LOCKOUT);
	    lblLoginAttempts.setText(ERROR_LOGIN_ATTEMPTS
		    + controller.getLoginAttemptsRemaining());
	}
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
