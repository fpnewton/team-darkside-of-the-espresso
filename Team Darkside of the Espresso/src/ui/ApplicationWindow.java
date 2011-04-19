// $codepro.audit.disable numericLiterals

/*
 * The ApplicationWindow Class.
 */

package ui;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * The ApplicationWindow Class.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class ApplicationWindow {

    /** The window frame. */
    private JFrame frame;
    
    /** The login panel. */
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
			this.getClass().getResource("/resources/Medical Hospital Icon/128x128/hospital.png")));
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

    /**
     * Sets the frame.
     *
     * @param panel the panel
     * @param title the title
     * @param width the width
     * @param height the height
     */
    public void setFrame(JPanel panel, String title, int width, int height) {
	frame.setContentPane(panel);
	frame.setSize(width, height);
	frame.setTitle(title);

	frame.setVisible(true);
    }
    
    /**
     * Converts the object to a string.
     * 
     * @return A string with the fully qualified name of the class
     */
    public String toString() {
	return this.getClass().toString();
    }
}
