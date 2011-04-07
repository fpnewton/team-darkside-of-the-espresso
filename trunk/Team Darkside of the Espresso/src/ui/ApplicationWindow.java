// $codepro.audit.disable
package ui;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationWindow {

    private JFrame frame;
    private LoginPanel loginPanel;

    /**
     * Create the application.
     */
    public ApplicationWindow() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.setIconImage(Toolkit
		.getDefaultToolkit()
		.getImage(
			LoginWindow.class
				.getResource("/resources/Medical Hospital Icon/128x128/hospital.png")));
	frame.setTitle("Hospital Login");
	frame.setBounds(100, 100, 450, 250);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	loginPanel = new LoginPanel();
	
	frame.setContentPane(loginPanel);
	frame.setSize(loginPanel.getWidth(), loginPanel.getHeight());
	frame.setTitle(loginPanel.getTitle());
	frame.setVisible(true);
    }
    
    public void setFrame(JPanel panel, String title, int width, int height)
    {
	frame.setContentPane(panel);
	frame.setSize(width, height);
	frame.setTitle(title);
	
	frame.setVisible(true);
    }
}
