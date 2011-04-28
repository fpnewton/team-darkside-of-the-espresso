// $codepro.audit.disable numericLiterals

/*
 * The SymptomsPanel Class.
 */

package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import users.Patient;
import appointment.Appointment;
import client.Main;

/**
 * The SymptomsPanel Class.
 * 
 * @author David Garner
 * @version 1.0.0
 */
public class SymptomsPanel extends JPanel {

	/** The text field. */
	private JTextField textField;

	/** The Constant WIDTH. */
	private static final int WIDTH = 850;

	/** The Constant HEIGHT. */
	private static final int HEIGHT = 550 + 25;

	/** The Constant TITLE. */
	private static final String TITLE = "Symptoms";

	private final SchedulePanel sched = new SchedulePanel();

	private ArrayList<String> sympList = new ArrayList<String>(); // ArrayList
																	// of
																	// symptom
																	// names
	private ArrayList<JCheckBox> sympCheckList = new ArrayList<JCheckBox>(); // ArrayList
																				// of
																				// symptom
	// checkboxes
	private String symptoms;

	/**
	 * Create the panel.
	 */
	public SymptomsPanel() {
		initialize();
	}

	/**
	 * Initializes the panel.
	 */
	private void initialize() {
		setLayout(null);

		/* Initializing all of the JCheckBoxes */
		final JCheckBox abdominalPain = new JCheckBox("Abdominal Pain");
		final JCheckBox allergies = new JCheckBox("Allergies");
		final JCheckBox backPain = new JCheckBox("Back Pain");
		final JCheckBox bloodInStool = new JCheckBox("Blood in Stool");
		final JCheckBox bloodInUrine = new JCheckBox("Blood in Urine");
		final JCheckBox breathingTrouble = new JCheckBox("Breathing Trouble");
		final JCheckBox chestPain = new JCheckBox("Chest Pain");
		final JCheckBox coldfluEar = new JCheckBox("Cold/Flu/Ear Pain");
		final JCheckBox constipation = new JCheckBox("Constipation");
		final JCheckBox cough = new JCheckBox("Cough");
		final JCheckBox diarrhea = new JCheckBox("Diarrhea");
		final JCheckBox eyeProblems = new JCheckBox("Eye Problems");
		final JCheckBox fatigueTired = new JCheckBox("Fatigue / Tired");
		final JCheckBox fever = new JCheckBox("Fever");
		final JCheckBox headacheMigraine = new JCheckBox("Headache/Migraine");
		final JCheckBox highBloodPressure = new JCheckBox("High Blood Pressure");
		final JCheckBox insomnia = new JCheckBox("Insomnia");
		final JCheckBox jointPain = new JCheckBox("Joint Pain / Injury");
		final JCheckBox labBlood = new JCheckBox("Lab - Blood Work");
		final JCheckBox labTest = new JCheckBox("Lab - Test Results");
		final JCheckBox moleLump = new JCheckBox("Mole / Lump");
		final JCheckBox painWithUrination = new JCheckBox("Pain With Urination");
		final JCheckBox penileDischarge = new JCheckBox("Penile Discharge");
		final JCheckBox soreThroat = new JCheckBox("Sore Throat");
		final JCheckBox skinProblems = new JCheckBox("Skin Problems");
		final JCheckBox stitchesRemoval = new JCheckBox("Stitches Removal");
		final JCheckBox testicularPainlump = new JCheckBox(
				"Testicular Pain/Lump");
		final JCheckBox wart = new JCheckBox("Wart");
		final JCheckBox injectionAllergy = new JCheckBox("INJECTION - Allergy");
		final JCheckBox injectionOnly = new JCheckBox("INJECTION Only");
		final JCheckBox other = new JCheckBox("Other (Please Specify)");
		final JCheckBox personal = new JCheckBox("Personal");

		final JLabel lblSymptomscheckAll = new JLabel("Check All That Apply");
		lblSymptomscheckAll.setBounds(10, 29, 162, 14);
		add(lblSymptomscheckAll);

		abdominalPain.setBounds(41, 50, 131, 23);
		add(abdominalPain);
		sympList.add("Abdominal Pain");

		allergies.setBounds(41, 76, 97, 23);
		add(allergies);
		sympList.add("Allergies");

		backPain.setBounds(41, 102, 97, 23);
		add(backPain);
		sympList.add("Back Pain");

		bloodInStool.setBounds(41, 128, 131, 23);
		add(bloodInStool);
		sympList.add("Blood in Stool");

		bloodInUrine.setBounds(41, 154, 131, 23);
		add(bloodInUrine);
		sympList.add("Blood in Urine");

		breathingTrouble.setBounds(41, 180, 156, 23);
		add(breathingTrouble);
		sympList.add("Breathing Trouble");

		chestPain.setBounds(41, 206, 156, 23);
		add(chestPain);
		sympList.add("Chest Pain");

		coldfluEar.setBounds(41, 232, 156, 23);
		add(coldfluEar);
		sympList.add("Cold/Flu/Ear Pain");

		constipation.setBounds(41, 258, 156, 23);
		add(constipation);
		sympList.add("Constipation");

		cough.setBounds(41, 284, 97, 23);
		add(cough);
		sympList.add("Cough");

		diarrhea.setBounds(41, 310, 97, 23);
		add(diarrhea);
		sympList.add("Diarrhea");

		eyeProblems.setBounds(41, 336, 156, 23);
		add(eyeProblems);
		sympList.add("Eye Problems");

		fatigueTired.setBounds(41, 362, 156, 23);
		add(fatigueTired);
		sympList.add("Fatigue / Tired");

		fever.setBounds(41, 388, 97, 23);
		add(fever);
		sympList.add("Fever");

		headacheMigraine.setBounds(41, 414, 156, 23);
		add(headacheMigraine);
		sympList.add("Headache/Migraine");

		highBloodPressure.setBounds(41, 440, 162, 23);
		add(highBloodPressure);
		sympList.add("High Blood Pressure");

		insomnia.setBounds(209, 50, 97, 23);
		add(insomnia);
		sympList.add("Insomnia");

		jointPain.setBounds(209, 76, 173, 23);
		add(jointPain);
		sympList.add("Joint Pain / Injury");

		labBlood.setBounds(209, 102, 173, 23);
		add(labBlood);
		sympList.add("Lab - Blood Work");

		labTest.setBounds(209, 128, 162, 23);
		add(labTest);
		sympList.add("Lab - Test Results");

		moleLump.setBounds(209, 154, 162, 23);
		add(moleLump);
		sympList.add("Mole / Lump");

		painWithUrination.setBounds(209, 180, 162, 23);
		add(painWithUrination);
		sympList.add("Pain With Urination");

		penileDischarge.setBounds(209, 206, 162, 23);
		add(penileDischarge);
		sympList.add("Penile Discharge");

		soreThroat.setBounds(209, 258, 162, 23);
		add(soreThroat);
		sympList.add("Sore Throat");

		skinProblems.setBounds(209, 284, 162, 23);
		add(skinProblems);
		sympList.add("Skin Problems");

		stitchesRemoval.setBounds(209, 310, 162, 23);
		add(stitchesRemoval);
		sympList.add("Stitches Removal");

		testicularPainlump.setBounds(209, 336, 190, 23);
		add(testicularPainlump);
		sympList.add("Testicular Pain/Lump");

		wart.setBounds(209, 362, 97, 23);
		add(wart);
		sympList.add("Wart");

		injectionAllergy.setBounds(209, 388, 162, 23);
		add(injectionAllergy);
		sympList.add("INJECTION - Allergy");

		injectionOnly.setBounds(209, 414, 162, 23);
		add(injectionOnly);
		sympList.add("INJECTION Only");

		personal.setBounds(209, 232, 97, 23);
		add(personal);
		sympList.add("personal");

		other.setBounds(483, 50, 190, 23);
		add(other);
		sympList.add("other");

		textField = new JTextField();
		textField.setBounds(483, 76, 302, 388);
		add(textField);
		textField.setColumns(10);

		/* Adding all of the JCheckBoxes to the ArrayList */
		sympCheckList.add(abdominalPain);
		sympCheckList.add(allergies);
		sympCheckList.add(backPain);
		sympCheckList.add(bloodInStool);
		sympCheckList.add(bloodInUrine);
		sympCheckList.add(breathingTrouble);
		sympCheckList.add(chestPain);
		sympCheckList.add(coldfluEar);
		sympCheckList.add(constipation);
		sympCheckList.add(cough);
		sympCheckList.add(diarrhea);
		sympCheckList.add(eyeProblems);
		sympCheckList.add(fatigueTired);
		sympCheckList.add(fever);
		sympCheckList.add(headacheMigraine);
		sympCheckList.add(highBloodPressure);
		sympCheckList.add(insomnia);
		sympCheckList.add(jointPain);
		sympCheckList.add(labBlood);
		sympCheckList.add(labTest);
		sympCheckList.add(moleLump);
		sympCheckList.add(painWithUrination);
		sympCheckList.add(penileDischarge);
		sympCheckList.add(soreThroat);
		sympCheckList.add(skinProblems);
		sympCheckList.add(stitchesRemoval);
		sympCheckList.add(testicularPainlump);
		sympCheckList.add(wart);
		sympCheckList.add(injectionAllergy);
		sympCheckList.add(injectionOnly);
		sympCheckList.add(personal);
		sympCheckList.add(other);

		/*
		 * Nullifies the symptoms string in case the user comes back to this
		 * page from the schedule panel. Subsequently, it adds to this symptoms
		 * string all selected symptom checkboxes and opens the scheduling
		 * window.
		 */
		final JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				symptoms = "";
				for (int i = 0; i < sympList.size() - 1; i++) {
					if (sympCheckList.get(i).isSelected()) {
						if (i != sympList.size() - 1) {
							symptoms += sympList.get(i) + '\n';
						} else {
							symptoms += sympList.get(i);
						}
					}
					Appointment tmp = new Appointment((Patient) Main.getCurrentUser(),
							Calendar.getInstance(), Main.getDoctor().get(0), symptoms);
					Main.setCurrentAppointment(tmp);
				}

				Main.getApplicationWindow().setFrame(sched, sched.getTitle(),
						sched.getWidth(), sched.getHeight());
			}
		});
		btnSubmit.setBounds(584, 504, 89, 23);
		add(btnSubmit);

		final JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				final AppointmentListPanel appWindow = new AppointmentListPanel();

				Main.getApplicationWindow().setFrame(appWindow,
						appWindow.getTitle(), appWindow.getWidth(),
						appWindow.getHeight());
			}
		});
		btnCancel.setBounds(696, 504, 89, 23);
		add(btnCancel);
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