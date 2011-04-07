package ui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SymptomsPanel extends JPanel {

	private JTextField textField;
	
	private static final int WIDTH = 450;
	private static final int HEIGHT = 300;

	/**
	 * Create the panel.
	 */
	public SymptomsPanel() {
		setLayout(null);
		
		JLabel lblSymptomscheckAll = new JLabel("Check All That Apply");
		lblSymptomscheckAll.setBounds(10, 29, 162, 14);
		add(lblSymptomscheckAll);
		
		JCheckBox chckbxAbdominalPain = new JCheckBox("Abdominal Pain");
		chckbxAbdominalPain.setBounds(41, 50, 131, 23);
		add(chckbxAbdominalPain);
		
		JCheckBox chckbxAllergies = new JCheckBox("Allergies");
		chckbxAllergies.setBounds(41, 76, 97, 23);
		add(chckbxAllergies);
		
		JCheckBox chckbxBackPain = new JCheckBox("Back Pain");
		chckbxBackPain.setBounds(41, 102, 97, 23);
		add(chckbxBackPain);
		
		JCheckBox chckbxBloodInStool = new JCheckBox("Blood in Stool");
		chckbxBloodInStool.setBounds(41, 128, 131, 23);
		add(chckbxBloodInStool);
		
		JCheckBox chckbxBloodInUrine = new JCheckBox("Blood in Urine");
		chckbxBloodInUrine.setBounds(41, 154, 131, 23);
		add(chckbxBloodInUrine);
		
		JCheckBox chckbxBreathingTrouble = new JCheckBox("Breathing Trouble");
		chckbxBreathingTrouble.setBounds(41, 180, 156, 23);
		add(chckbxBreathingTrouble);
		
		JCheckBox chckbxChestPain = new JCheckBox("Chest Pain");
		chckbxChestPain.setBounds(41, 206, 156, 23);
		add(chckbxChestPain);
		
		JCheckBox chckbxColdfluEar = new JCheckBox("Cold/Flu/Ear Pain");
		chckbxColdfluEar.setBounds(41, 232, 156, 23);
		add(chckbxColdfluEar);
		
		JCheckBox chckbxConstipation = new JCheckBox("Constipation");
		chckbxConstipation.setBounds(41, 258, 156, 23);
		add(chckbxConstipation);
		
		JCheckBox chckbxCough = new JCheckBox("Cough");
		chckbxCough.setBounds(41, 284, 97, 23);
		add(chckbxCough);
		
		JCheckBox chckbxDiarrhea = new JCheckBox("Diarrhea");
		chckbxDiarrhea.setBounds(41, 310, 97, 23);
		add(chckbxDiarrhea);
		
		JCheckBox chckbxEyeProblems = new JCheckBox("Eye Problems");
		chckbxEyeProblems.setBounds(41, 336, 156, 23);
		add(chckbxEyeProblems);
		
		JCheckBox chckbxFatigueTired = new JCheckBox("Fatigue / Tired");
		chckbxFatigueTired.setBounds(41, 362, 156, 23);
		add(chckbxFatigueTired);
		
		JCheckBox chckbxFever = new JCheckBox("Fever");
		chckbxFever.setBounds(41, 388, 97, 23);
		add(chckbxFever);
		
		JCheckBox chckbxHeadacheMigraine = new JCheckBox("Headache/Migraine");
		chckbxHeadacheMigraine.setBounds(41, 414, 156, 23);
		add(chckbxHeadacheMigraine);
		
		JCheckBox chckbxHighBloodPressure = new JCheckBox("High Blood Pressure");
		chckbxHighBloodPressure.setBounds(41, 440, 162, 23);
		add(chckbxHighBloodPressure);
		
		JCheckBox chckbxInsomnia = new JCheckBox("Insomnia");
		chckbxInsomnia.setBounds(209, 50, 97, 23);
		add(chckbxInsomnia);
		
		JCheckBox chckbxJointPain = new JCheckBox("Joint Pain / Injury");
		chckbxJointPain.setBounds(209, 76, 173, 23);
		add(chckbxJointPain);
		
		JCheckBox chckbxLabBlood = new JCheckBox("Lab - Blood Work");
		chckbxLabBlood.setBounds(209, 102, 173, 23);
		add(chckbxLabBlood);
		
		JCheckBox chckbxLabTest = new JCheckBox("Lab - Test Results");
		chckbxLabTest.setBounds(209, 128, 162, 23);
		add(chckbxLabTest);
		
		JCheckBox chckbxMoleLump = new JCheckBox("Mole / Lump");
		chckbxMoleLump.setBounds(209, 154, 162, 23);
		add(chckbxMoleLump);
		
		JCheckBox chckbxPainWithUrination = new JCheckBox("Pain With Urination");
		chckbxPainWithUrination.setBounds(209, 180, 162, 23);
		add(chckbxPainWithUrination);
		
		JCheckBox chckbxPenileDischarge = new JCheckBox("Penile Discharge");
		chckbxPenileDischarge.setBounds(209, 206, 162, 23);
		add(chckbxPenileDischarge);
		
		JCheckBox chckbxSoreThroat = new JCheckBox("Sore Throat");
		chckbxSoreThroat.setBounds(209, 258, 162, 23);
		add(chckbxSoreThroat);
		
		JCheckBox chckbxSkinProblems = new JCheckBox("Skin Problems");
		chckbxSkinProblems.setBounds(209, 284, 162, 23);
		add(chckbxSkinProblems);
		
		JCheckBox chckbxStichesRemoval = new JCheckBox("Stiches Removal");
		chckbxStichesRemoval.setBounds(209, 310, 162, 23);
		add(chckbxStichesRemoval);
		
		JCheckBox chckbxTesticularPainlump = new JCheckBox("Testicular Pain/Lump");
		chckbxTesticularPainlump.setBounds(209, 336, 190, 23);
		add(chckbxTesticularPainlump);
		
		JCheckBox chckbxWart = new JCheckBox("Wart");
		chckbxWart.setBounds(209, 362, 97, 23);
		add(chckbxWart);
		
		JCheckBox chckbxInjectionAllergy = new JCheckBox("INJECTION - Allergy");
		chckbxInjectionAllergy.setBounds(209, 388, 162, 23);
		add(chckbxInjectionAllergy);
		
		JCheckBox chckbxInjectionOnly = new JCheckBox("INJECTION Only");
		chckbxInjectionOnly.setBounds(209, 414, 162, 23);
		add(chckbxInjectionOnly);
		
		JCheckBox chckbxOtherpleaseSpecify = new JCheckBox("Other (Please Specify)");
		chckbxOtherpleaseSpecify.setBounds(483, 50, 190, 23);
		add(chckbxOtherpleaseSpecify);
		
		JCheckBox chckbxPersonal = new JCheckBox("Personal");
		chckbxPersonal.setBounds(209, 232, 97, 23);
		add(chckbxPersonal);
		
		textField = new JTextField();
		textField.setBounds(483, 76, 302, 388);
		add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(209, 471, 89, 23);
		add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(310, 471, 89, 23);
		add(btnCancel);

	}
	
	public Dimension getSize() {
		return new Dimension(WIDTH, HEIGHT);
	}

}
