/*
 * The InvoicePanel Class.
 */

package ui;

import javax.swing.JPanel;

/**
 * The InvoicePanel Class.
 * 
 * @author Someone?
 * @version 1.0.0
 */
public class InvoicePanel extends JPanel {

    /** The Constant WIDTH. */
    private static final int WIDTH = 450;
    
    /** The Constant HEIGHT. */
    private static final int HEIGHT = 300 + 25;
    
    /** The Constant TITLE. */
    private static final String TITLE = "Invoice";

    /**
     * Create the panel.
     */
    public InvoicePanel() {
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
