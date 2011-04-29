// $codepro.audit.disable variableShouldBeFinal, staticFieldNamingConvention
/*
 * Hospital Client Application Entry Point
 */

package client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.List;

import network.Message;
import network.Network;
import network.client.Client;
import record.DoctorsOrders;
import ui.ApplicationWindow;
import users.Doctor;
import users.User;
import appointment.Appointment;
import appointment.Bill;
import database.SqlDatabase;

/**
 * Hospital Client Application Entry Point.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public class Main {

	/** The window. */
	private static ApplicationWindow window;

	/** The current user. */
	private static User currentUser;

	/** The client. */
	private static Client client = null;

	/** The temp appt. */
	private static Appointment tempAppt;

	/** The desired doc. */
	private static List<Doctor> desiredDoc;

	/** The temp dr orders. */
	private static DoctorsOrders tempDrOrders;

	/** The temp bill. */
	private static Bill tempBill;

	/** The db. */
	private static SqlDatabase db;

	/**
	 * Hospital Client application entry point.
	 * 
	 * @param args
	 *            Application arguments
	 */
	public static void main(String[] args) {
//		//nbClient c = new nbClient();
//		desiredDoc = new ArrayList<Doctor>();
//		
//		try {
//			db = new SqlDatabase();
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		// No user is logged in at the login window
//		currentUser = null;
//		
//		// Launch the GUI
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					window = new ApplicationWindow();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
		try
		{
			int buffer_size = 4096;
	
		    byte buffer[] = new byte[buffer_size];
		    DatagramSocket ds = new DatagramSocket(Network.NETWORK_PORT);
		    
		    while (true) {
		      DatagramPacket p = new DatagramPacket(buffer, buffer.length);
		      ds.receive(p);
		      
		      
		      ByteArrayInputStream bis = new ByteArrayInputStream(buffer);
		      ObjectInput in = new ObjectInputStream(bis);
		      Message o = (Message) in.readObject();
		      
		      System.out.println(o.getKey());

		    }
		}
		catch (IOException e)
		{
			// TODO
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Gets the client object.
	 * 
	 * @return the client object
	 */
	public static Client getClientObject() {
		return client;
	}

	/**
	 * Gets the application window.
	 * 
	 * @return the application window
	 */
	public static ApplicationWindow getApplicationWindow() {
		return window;
	}

	/**
	 * Gets the current user.
	 * 
	 * @return the current user
	 */
	public static User getCurrentUser() {
		return currentUser;
	}

	/**
	 * Sets the current user.
	 * 
	 * @param newUser
	 *            the new current user
	 */
	public static void setCurrentUser(User newUser) {
		currentUser = newUser;
	}

	/**
	 * Gets the database object.
	 * 
	 * @return the database object
	 */
	public static SqlDatabase getDatabaseObject() {
		return db;
	}

	/**
	 * Gets the current appointment.
	 * 
	 * @return the current appointment
	 */
	public static Appointment getCurrentAppointment() {
		return tempAppt;
	}

	/**
	 * Sets the current appointment.
	 * 
	 * @param appt
	 *            the new current appointment
	 */
	public static void setCurrentAppointment(Appointment appt) {
		tempAppt = appt;
	}

	/**
	 * Sets the current bill.
	 * 
	 * @param bill
	 *            the new current bill
	 */
	public static void setCurrentBill(Bill bill) {
		tempBill = bill;
	}

	/**
	 * Gets the current bill.
	 * 
	 * @return the current bill
	 */
	public static Bill getCurrentBill() {
		return tempBill;
	}

	/**
	 * Gets the doctor.
	 * 
	 * @return the doctor
	 */
	public static List<Doctor> getDoctor() {
		return desiredDoc;
	}

	/**
	 * Converts the object to a string.
	 * 
	 * @return A string with the fully qualified name of the class
	 */
	public String toString() {
		return this.getClass().toString();
	}

	/**
	 * Sets the temp doc orders.
	 * 
	 * @param docOrders
	 *            the new temp doc orders
	 */
	public static void setTempDocOrders(DoctorsOrders docOrders) {
		tempDrOrders = docOrders;
	}

	/**
	 * Gets the temp doc orders.
	 * 
	 * @return the temp doc orders
	 */
	public static DoctorsOrders getTempDocOrders() {
		return tempDrOrders;
	}
}
