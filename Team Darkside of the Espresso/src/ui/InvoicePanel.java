package ui;

import java.awt.Dimension;

import javax.swing.JPanel;

public class InvoicePanel extends JPanel {

	private static final int WIDTH = 450;
	private static final int HEIGHT = 300;
	
	/**
	 * Create the panel.
	 */
	public InvoicePanel() {

	}
	
	public Dimension getSize() {
		return new Dimension(WIDTH, HEIGHT);
	}

}
