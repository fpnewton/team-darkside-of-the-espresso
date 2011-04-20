/*
 * The Income Class.
 */

package appointment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Income Class.
 * 
 * @author David Garner
 * @version 1.0.0
 */
public class Income implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /** The Invoice list. */
    private List<Invoice> invoiceList;

    /**
     * Constructor. Instantiates a new invoice list
     */
    public Income() {
	invoiceList = new ArrayList<Invoice>();
    }

    /**
     * Display income.
     */
    public void displayIncome() {
	// TODO Implement Method
    }

    /**
     * Calculate total.
     */
    public void calculateTotal() {
	// TODO Implement Method
    }

    /**
     * toString() Override
     * 
     * @return A formatted string with the invoice list
     */
    public String toString() {
	return invoiceList.toString();
    }
}