
package edu.gatech.TeamDarksideOfTheEspresso.UI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Toolkit;


public class LoginWindow
{
	private LoginController	Controller;

	private JFrame					frmLoginWindow;

	private JLabel					lblLogin;
	private JLabel					lblError;
	private JLabel					lblUsername;
	private JLabel					lblPassword;
	private JLabel					lblLoginAttempts;

	private JTextField				txtUsername;
	private JPasswordField			txtPassword;

	private JButton					btnLogin;
	private JButton					btnClear;

	private final String			strWrongUsernamePassword	= "Incorrect username or password. Please try again.";
	private final String			strUsernamePasswordLength	= "Username or password is too short.";
	private final String			strLockout					= "Too many login attempts. Your account is now disabled.";
	private final String			strLoginAttempts			= "Login Attempts Left: ";


	/**
	 * Create the application.
	 */
	public LoginWindow()
	{
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		Controller = new LoginController();

		frmLoginWindow = new JFrame();
		frmLoginWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginWindow.class.getResource("/resources/Medical Hospital Icon/128x128/hospital.png")));
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

		lblLoginAttempts = new JLabel(strLoginAttempts + Controller.getLoginAttemptsRemaining());
		lblLoginAttempts.setBounds(270, 188, 166, 15);
		frmLoginWindow.getContentPane().add(lblLoginAttempts);

		txtUsername = new JTextField();
		txtUsername.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					doLogin();
				}
			}
		});
		txtUsername.setBounds(92, 99, 344, 30);
		frmLoginWindow.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					doLogin();
				}
			}
		});
		txtPassword.setBounds(92, 141, 344, 30);
		frmLoginWindow.getContentPane().add(txtPassword);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				doLogin();
			}
		});
		btnLogin.setBounds(92, 183, 80, 25);
		frmLoginWindow.getContentPane().add(btnLogin);

		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				lblError.setText("");
				txtUsername.setText("");
				txtPassword.setText("");

				Controller = new LoginController();
				lblLoginAttempts.setText(strLoginAttempts + Controller.getLoginAttemptsRemaining());
			}
		});
		btnClear.setBounds(184, 183, 80, 25);
		frmLoginWindow.getContentPane().add(btnClear);
		frmLoginWindow.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]
		{ txtUsername, txtPassword, btnLogin, btnClear }));
	}


	public JFrame getFrmLoginWindow()
	{
		return frmLoginWindow;
	}
	
	
	private void doLogin()
	{
		if (txtUsername.getText().length() >= 6 && txtPassword.getPassword().toString().length() >= 8)
		{
			if (Controller.Login(txtUsername.getText(), txtPassword.getPassword().toString()))
			{
				// TODO Do something on success
			}
			else
			{
				lblError.setText(strWrongUsernamePassword);
				txtPassword.setText("");
				lblLoginAttempts.setText(strLoginAttempts + Controller.getLoginAttemptsRemaining());
			}
		}
		else
		{
			lblError.setText(strUsernamePasswordLength);
			txtPassword.setText("");
		}
		
		if (Controller.getLoginAttemptsRemaining() == 0)
		{
			Controller = new LoginController();
			
			lblError.setText(strLockout);
			lblLoginAttempts.setText(strLoginAttempts + Controller.getLoginAttemptsRemaining());
		}
	}
}
