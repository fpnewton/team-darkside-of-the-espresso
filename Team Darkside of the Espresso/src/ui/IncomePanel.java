/*
 * The IncomePanel Class.
 */

package ui;

import javax.swing.JPanel;

/**
 * The IncomePanel Class.
 * 
 * @author Someone?
 * @version 1.0.0
 */
public class IncomePanel extends JPanel {

    /** The Constant WIDTH. */
    private static final int WIDTH = 450;

    /** The Constant HEIGHT. */
    private static final int HEIGHT = 300;

    /** The Constant TITLE. */
    private static final String TITLE = "Income";

    /**
     * Create the panel.
     */
    public IncomePanel() {
	// TODO Implement Method
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
