// $codepro.audit.disable emptyMethod
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
	private final List<Invoice> invoiceList;

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
		System.out.println(calculateTotal());
	}

	/**
	 * Calculate total.
	 * 
	 * @return the calculated total
	 */
	public double calculateTotal() {
		double total = 0.0;

		for (int i = 0; i < getInvoices().size(); i++) {
			total += getInvoices().get(i).calcTotal();
		}

		return total;
	}

	/**
	 * toString() Override
	 * 
	 * @return A formatted string with the invoice list
	 */
	public String toString() {
		return invoiceList.toString();
	}

	/**
	 * Gets the invoices
	 * 
	 * @return the invoices
	 */
	public List<Invoice> getInvoices() {
		return this.invoiceList;
	}
}
