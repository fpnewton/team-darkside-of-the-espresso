/** The class loginwindow */

package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/** The class loginwindow */

//import org.eclipse.wb.swing.FocusTraversalOnArray;

/**
 * @author Fraser Newton
 * @version 1.0
 */
public class LoginWindow {
    
	/** The controller */
	private LoginController controller;

	/** The login window */
    private JFrame frmLoginWindow;

    /** The login label */
    private JLabel lblLogin;
    
    /** The error label */
    private JLabel lblError;
    
    /** The username label */
    private JLabel lblUsername;
    
    /** The password label */
    private JLabel lblPassword;
    
    /** The login attempts label */
    private JLabel lblLoginAttempts;

    /** The user name text field */
    private JTextField txtUsername;
    
    /** The password text field */
    private JPasswordField txtPassword;

    /** The login button */
    private JButton btnLogin;
    
    /** The clear button */
    private JButton btnClear;

    /** The wrong user name string */
    protected String strWrongUsernamePassword =
    	"Incorrect username or password. Please try again.";
    
    /** The too short user name or password string */
    protected String strUsernamePasswordLength = "Username or password is too short.";
    
    /** The lockout string */
    protected String strLockout = 
    	"Too many login attempts. Your account is now disabled.";
    
    /** The login attempts string */
    protected String strLoginAttempts = "Login Attempts Left: ";

    /**
     * Create the application.
     */
    public LoginWindow() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	controller = new LoginController();

	frmLoginWindow = new JFrame();
	frmLoginWindow
		.setIconImage(Toolkit
			.getDefaultToolkit()
			.getImage(
				LoginWindow.class
					.getResource("/resources/Medical Hospital " +
							"Icon/128x128/hospital.png")));
	frmLoginWindow.setTitle("Hospital Client :: Login");
	frmLoginWindow.setBounds(100, 100, 450, 250);
	frmLoginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frmLoginWindow.getContentPane().setLayout(null);

	lblLogin = new JLabel("Login");
	lblLogin.setFont(new Font("Dialog", Font.BOLD, 34));
	lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
	lblLogin.setBounds(0, 0, 448, 60);
	frmLoginWindow.getContentPane().add(lblLogin);

	lblError = new JLabel("");
	lblError.setForeground(Color.RED);
	lblError.setHorizontalAlignment(SwingConstants.CENTER);
	lblError.setBounds(0, 72, 448, 15);
	frmLoginWindow.getContentPane().add(lblError);

	lblUsername = new JLabel("Username");
	lblUsername.setBounds(10, 98, 81, 30);
	frmLoginWindow.getContentPane().add(lblUsername);

	lblPassword = new JLabel("Password");
	lblPassword.setBounds(12, 140, 70, 30);
	frmLoginWindow.getContentPane().add(lblPassword);

	lblLoginAttempts = new JLabel(strLoginAttempts
		+ controller.getLoginAttemptsRemaining());
	lblLoginAttempts.setBounds(270, 188, 166, 15);
	frmLoginWindow.getContentPane().add(lblLoginAttempts);

	txtUsername = new JTextField();
	txtUsername.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		    doLogin();
		}
	    }
	});
	txtUsername.setBounds(92, 99, 344, 30);
	frmLoginWindow.getContentPane().add(txtUsername);
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
	txtPassword.setBounds(92, 141, 344, 30);
	frmLoginWindow.getContentPane().add(txtPassword);

	btnLogin = new JButton("Login");
	btnLogin.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		doLogin();
	    }
	});
	btnLogin.setBounds(92, 183, 80, 25);
	frmLoginWindow.getContentPane().add(btnLogin);

	btnClear = new JButton("Clear");
	btnClear.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		lblError.setText("");
		txtUsername.setText("");
		txtPassword.setText("");

		controller = new LoginController();
		lblLoginAttempts.setText(strLoginAttempts
			+ controller.getLoginAttemptsRemaining());
	    }
	});
	btnClear.setBounds(184, 183, 80, 25);
	frmLoginWindow.getContentPane().add(btnClear);
	/**frmLoginWindow.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
		txtUsername, txtPassword, btnLogin, btnClear }));**/
    }

    /**
     * Gets the login window
     * 
     * @return the login window
     */
    public JFrame getFrmLoginWindow() {
	return frmLoginWindow;
    }

    /**
     * Performs the login function
     */
    private void doLogin() {
    	final char[] password = txtPassword.getPassword();
    	final StringBuilder str = new StringBuilder();
	
	for (char c : password){
	    str.append(c);
	}
	
	if (txtUsername.getText().length() >= 4
		&& java.util.Arrays.toString(txtPassword.getPassword()).length() >= 6) {
	    
	    if (controller.canLogin(txtUsername.getText(), str.toString())) {
		// Open the appointment window on success
		//frmLoginWindow.setVisible(false);
		
	    	final AppointmentListPanel appointments = new AppointmentListPanel();
		
		frmLoginWindow.setContentPane(appointments);
		frmLoginWindow.setSize(450, 300);
		frmLoginWindow.setTitle("Hospital Client :: Appointments");
	    } else {
		lblError.setText(strWrongUsernamePassword);
		txtPassword.setText("");
		lblLoginAttempts.setText(strLoginAttempts
			+ controller.getLoginAttemptsRemaining());
	    }
	} else {
	    lblError.setText(strUsernamePasswordLength);
	    txtPassword.setText("");
	}

	if (controller.getLoginAttemptsRemaining() == 0) {
	    controller = new LoginController();

	    lblError.setText(strLockout);
	    lblLoginAttempts.setText(strLoginAttempts
		    + controller.getLoginAttemptsRemaining());
	}
    }
    
	/**
	 * Converts the MedicalHistory to a string
	 * 
	 * @return the medical history in string form
	 */
	@Override
	public String toString() {
		return this.toString();
	}
}
