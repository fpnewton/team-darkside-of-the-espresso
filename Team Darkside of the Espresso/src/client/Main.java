/*
 * Hospital Client Application Entry Point
 */

package client;

import java.awt.EventQueue;

import network.Message;
import network.MessageKey;
import network.Network;
import network.client.Client;
import ui.ApplicationWindow;
import users.User;
import record.DoctorsOrders;
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
    private static ApplicationWindow window;
    private static User currentUser;
    private static Client client;
    private static Appointment tempAppt;
    private static DoctorsOrders tempDrOrders;
    private static Bill tempBill;
    private static SqlDatabase db;

    /**
     * Hospital Client application entry point.
     * 
     * @param args
     *            Application arguments
     * @throws ClassNotFoundException
     */
    public static void main(String[] args)
    {
    	 try {
			db = new SqlDatabase();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	// No user is logged in at the login window
		currentUser = null;
		
		// Start the networking client threads
//		client = new Client(Network.NETWORK_PORT);
//		
//		if (!client.isSuccessfulConnection())
//		{
//			// TODO Handle invalid network stack
//			//System.out.println("Error: Could not connect.");
//		}
		
		// Launch the GUI
		EventQueue.invokeLater(new Runnable()
		{
		    public void run()
		    {
				try
				{
				    window = new ApplicationWindow();
				}
				catch (Exception e)
				{
				    e.printStackTrace();
				}
		    }
		});
    }
    
    public static Client getClientObject()
    {
    	return client;
    }

    public static ApplicationWindow getApplicationWindow() {
	return window;
    }

    public static User getCurrentUser() {
	return currentUser;
    }

    public static void setCurrentUser(User newUser) {
	currentUser = newUser;
    }
    
    public static SqlDatabase getDatabaseObject() {
    	return db;
    }
    
    public static Appointment getCurrentAppointment()
    {
    	return tempAppt;
    }
    
    public static void setCurrentAppointment(Appointment appt)
    {
    	tempAppt = appt;
    }
    
    public static void setCurrentBill(Bill bill){
    	tempBill = bill;
    }
    
    public static Bill getCurrentBill(){
    	return tempBill;
    }

    /**
     * Converts the object to a string.
     * 
     * @return A string with the fully qualified name of the class
     */
    public String toString() {
	return this.getClass().toString();
    }
    
    public static void setTempDocOrders(DoctorsOrders docOrders){
    	tempDrOrders = docOrders;
    }
    
    public static DoctorsOrders getTempDocOrders(){
    	return tempDrOrders;
    }
}
