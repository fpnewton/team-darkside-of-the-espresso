package ui;

import java.awt.Color;
import java.awt.Component;
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

//import org.eclipse.wb.swing.FocusTraversalOnArray;

public class LoginWindow {
    private LoginController controller;

    private JFrame frmLoginWindow;

    private JLabel lblLogin;
    private JLabel lblError;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JLabel lblLoginAttempts;

    private JTextField txtUsername;
    private JPasswordField txtPassword;

    private JButton btnLogin;
    private JButton btnClear;

    private final String strWrongUsernamePassword = "Incorrect username or password. Please try again.";
    private final String strUsernamePasswordLength = "Username or password is too short.";
    private final String strLockout = "Too many login attempts. Your account is now disabled.";
    private final String strLoginAttempts = "Login Attempts Left: ";

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
					.getResource("/resources/Medical Hospital Icon/128x128/hospital.png")));
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

    public JFrame getFrmLoginWindow() {
	return frmLoginWindow;
    }

    private void doLogin() {
	char[] password = txtPassword.getPassword();
	StringBuilder str = new StringBuilder();
	
	for (char c : password)
	{
	    str.append(c);
	}
	
	if (txtUsername.getText().length() >= 4
		&& txtPassword.getPassword().toString().length() >= 6) {
	    
	    if (controller.canLogin(txtUsername.getText(), str.toString())) {
		// Open the appointment window on success
		//frmLoginWindow.setVisible(false);
		
		AppointmentListPanel appointments = new AppointmentListPanel();
		
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
}
