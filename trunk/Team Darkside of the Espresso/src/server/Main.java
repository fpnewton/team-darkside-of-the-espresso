/**
 * Hospital Server Application Entry Point
 * 
 * @author	Fraser P. Newton
 * @date	March 4, 2011
 */

package server;

import java.io.IOException;
import java.net.UnknownHostException;

import network.MessageKey;
import network.Network;
import network.NetworkConnector;
import network.NetworkConnectorType;

import log.*;

public class Main {
    private static NetworkConnector netConnector;

    public static void main(String args[]) throws ClassNotFoundException {
	try {
	    netConnector = new NetworkConnector("127.0.0.1", Network.SERVER_PORT,
		    NetworkConnectorType.SERVER);
	} catch (UnknownHostException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	System.out.println(netConnector.getMessages(MessageKey.ECHO)[0]);

	netConnector.cleanup();

	// try {
	// Server srv = new Server();
	//
	// System.out.println(srv.receiveMessage());
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }

	// SqlDatabase db = new SqlDatabase();

	// db.OpenDatabaseConnection();
	// db.createNewDatabaseTables();

	// UserInfo ui = new UserInfo("George P. Burdell",
	// "1214 Woodridge Dr\nAtlanta, GA 30339", "678-468-0074",
	// "999-99-9999", "fnewton3@gatech.edu", null);
	// PatientInfo pi = new PatientInfo(20, "My Insurance Carrier",
	// "My Pharmacy", null, null);
	// Patient patient = new Patient("fnewton3", "password",
	// GenderType.Male, ui, pi);

	// db.InsertUser(patient);

	// patient.getPatientInfo().setAge(21);
	// patient.setUsername("bitches");

	// db.UpdateUser(1, patient);

	// Object pt[] = (Object[])db.getObject("data", 1);
	//
	// Patient p = (Patient)pt[0];
	// System.out.println(p.getUsername());

	// Patient p = (Patient)db.getUser(1);

	// p.setUsername("123456");
	// p.getUserInformation().setName("ABGDEZHE0IK^NM=OnPSTY1Xyo");
	// db.UpdateUser(1, p);

	// System.out.println(p.getUserInformation().getName());

	// db.closeDatabaseConnection();
    }

    /**
     * Gets the network connector.
     * 
     * @return the network connector
     */
    public NetworkConnector getNetworkConnector() {
	return netConnector;
    }
}
