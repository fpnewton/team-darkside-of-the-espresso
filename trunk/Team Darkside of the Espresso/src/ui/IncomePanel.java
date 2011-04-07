package ui;

import java.awt.Dimension;

import javax.swing.JPanel;

public class IncomePanel extends JPanel {
	
	private static final int WIDTH = 450;
	private static final int HEIGHT = 300;

	/**
	 * Create the panel.
	 */
	public IncomePanel() {

	}
	
	public Dimension getSize() {
		return new Dimension(WIDTH, HEIGHT);
	}

}
