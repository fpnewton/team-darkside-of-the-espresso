package test;

import java.util.Date;

import users.Doctor;
import users.Nurse;
import users.GenderType;
import users.Patient;
import record.LabWork;
import record.Prescription;
import record.TreatmentRecord;
import record.DoctorsOrders;
import record.Prescription;
import record.LabWork;
import record.MedicalHistory;

import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.Assert;

import java.util.Date;

public class MedicalHistoryTest extends TestCase {
	
	private Doctor tDoctor;
	private Nurse tNurse;
	private Patient patient;
	private TreatmentRecord tRecord;
	private DoctorsOrders dOrders;
	private Date date;
	private Prescription presc;
	private LabWork labwork;
	private MedicalHistory medHist;
	
	@Test
	public void testMedicalHistory(){
		tDoctor = new Doctor("Dr. Bob", "PASSWORD", GenderType.Male, null);
		tNurse = new Nurse("Anna", "PASSWORD", GenderType.Female, null);
		patient = new Patient("Joe", "PASSWORD", GenderType.Male, null, null);
		date = new Date();
		presc = new Prescription();
		labwork = new LabWork();
		dOrders = new DoctorsOrders(patient, date, tDoctor, labwork, presc, "data");
		tRecord = new TreatmentRecord(tDoctor, tNurse, dOrders);
		medHist = new MedicalHistory();
		medHist.addRecord(tRecord);
		
		Assert.assertEquals(tDoctor.getUsername(), "Dr. Bob");
		Assert.assertEquals(tRecord.getDoctor().getUsername(), "Dr. Bob");
		Assert.assertEquals(tNurse.getUsername(), "Anna");
		Assert.assertEquals(tRecord.getNurse().getUsername(), "Anna");
		Assert.assertEquals(patient.getUsername(), "Joe");
		
	}
	/*protected void setUp(){
		
	}
	
	protected void tearDown(){
		
	}*/
	
	/*protected void*/ 
}