package appointment;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;


public class SymptomsWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SymptomsWindow frame = new SymptomsWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SymptomsWindow() {
		setTitle("Symptoms");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSymptomscheckAll = new JLabel("Check All That Apply");
		lblSymptomscheckAll.setBounds(10, 29, 162, 14);
		contentPane.add(lblSymptomscheckAll);
		
		JCheckBox chckbxAbdominalPain = new JCheckBox("Abdominal Pain");
		chckbxAbdominalPain.setBounds(41, 50, 97, 23);
		contentPane.add(chckbxAbdominalPain);
		
		JCheckBox chckbxAllergies = new JCheckBox("Allergies");
		chckbxAllergies.setBounds(41, 76, 97, 23);
		contentPane.add(chckbxAllergies);
		
		JCheckBox chckbxBackPain = new JCheckBox("Back Pain");
		chckbxBackPain.setBounds(41, 102, 97, 23);
		contentPane.add(chckbxBackPain);
		
		JCheckBox chckbxBloodInStool = new JCheckBox("Blood in Stool");
		chckbxBloodInStool.setBounds(41, 128, 97, 23);
		contentPane.add(chckbxBloodInStool);
		
		JCheckBox chckbxBloodInUrine = new JCheckBox("Blood in Urine");
		chckbxBloodInUrine.setBounds(41, 154, 97, 23);
		contentPane.add(chckbxBloodInUrine);
		
		JCheckBox chckbxBreathingTrouble = new JCheckBox("Breathing Trouble");
		chckbxBreathingTrouble.setBounds(41, 180, 97, 23);
		contentPane.add(chckbxBreathingTrouble);
		
		JCheckBox chckbxChestPain = new JCheckBox("Chest Pain");
		chckbxChestPain.setBounds(41, 206, 97, 23);
		contentPane.add(chckbxChestPain);
		
		JCheckBox chckbxColdfluEar = new JCheckBox("Cold/Flu / Ear Pain");
		chckbxColdfluEar.setBounds(41, 232, 113, 23);
		contentPane.add(chckbxColdfluEar);
		
		JCheckBox chckbxConstipation = new JCheckBox("Constipation");
		chckbxConstipation.setBounds(41, 258, 97, 23);
		contentPane.add(chckbxConstipation);
		
		JCheckBox chckbxCough = new JCheckBox("Cough");
		chckbxCough.setBounds(41, 284, 97, 23);
		contentPane.add(chckbxCough);
		
		JCheckBox chckbxDiarrhea = new JCheckBox("Diarrhea");
		chckbxDiarrhea.setBounds(41, 310, 97, 23);
		contentPane.add(chckbxDiarrhea);
		
		JCheckBox chckbxEyeProblems = new JCheckBox("Eye Problems");
		chckbxEyeProblems.setBounds(41, 336, 97, 23);
		contentPane.add(chckbxEyeProblems);
		
		JCheckBox chckbxFatigueTired = new JCheckBox("Fatigue / Tired");
		chckbxFatigueTired.setBounds(41, 362, 97, 23);
		contentPane.add(chckbxFatigueTired);
		
		JCheckBox chckbxFever = new JCheckBox("Fever");
		chckbxFever.setBounds(41, 388, 97, 23);
		contentPane.add(chckbxFever);
		
		JCheckBox chckbxHeadacheMigraine = new JCheckBox("Headache / Migraine");
		chckbxHeadacheMigraine.setBounds(41, 414, 131, 23);
		contentPane.add(chckbxHeadacheMigraine);
		
		JCheckBox chckbxHighBloodPressure = new JCheckBox("High Blood Pressure");
		chckbxHighBloodPressure.setBounds(41, 440, 131, 23);
		contentPane.add(chckbxHighBloodPressure);
		
		JCheckBox chckbxInsomnia = new JCheckBox("Insomnia");
		chckbxInsomnia.setBounds(209, 50, 97, 23);
		contentPane.add(chckbxInsomnia);
		
		JCheckBox chckbxJointPain = new JCheckBox("Joint Pain / Injury");
		chckbxJointPain.setBounds(209, 76, 125, 23);
		contentPane.add(chckbxJointPain);
		
		JCheckBox chckbxLabBlood = new JCheckBox("Lab - Blood Work");
		chckbxLabBlood.setBounds(209, 102, 125, 23);
		contentPane.add(chckbxLabBlood);
		
		JCheckBox chckbxLabTest = new JCheckBox("Lab - Test Results");
		chckbxLabTest.setBounds(209, 128, 125, 23);
		contentPane.add(chckbxLabTest);
		
		JCheckBox chckbxMoleLump = new JCheckBox("Mole / Lump");
		chckbxMoleLump.setBounds(209, 154, 97, 23);
		contentPane.add(chckbxMoleLump);
		
		JCheckBox chckbxPainWithUrination = new JCheckBox("Pain With Urination");
		chckbxPainWithUrination.setBounds(209, 180, 125, 23);
		contentPane.add(chckbxPainWithUrination);
		
		JCheckBox chckbxPenileDischarge = new JCheckBox("Penile Discharge");
		chckbxPenileDischarge.setBounds(209, 206, 113, 23);
		contentPane.add(chckbxPenileDischarge);
		
		JCheckBox chckbxSoreThroat = new JCheckBox("Sore Throat");
		chckbxSoreThroat.setBounds(209, 258, 97, 23);
		contentPane.add(chckbxSoreThroat);
		
		JCheckBox chckbxSkinProblems = new JCheckBox("Skin Problems");
		chckbxSkinProblems.setBounds(209, 284, 97, 23);
		contentPane.add(chckbxSkinProblems);
		
		JCheckBox chckbxStichesRemoval = new JCheckBox("Stiches Removal");
		chckbxStichesRemoval.setBounds(209, 310, 113, 23);
		contentPane.add(chckbxStichesRemoval);
		
		JCheckBox chckbxTesticularPainlump = new JCheckBox("Testicular Pain/Lump");
		chckbxTesticularPainlump.setBounds(209, 336, 125, 23);
		contentPane.add(chckbxTesticularPainlump);
		
		JCheckBox chckbxWart = new JCheckBox("Wart");
		chckbxWart.setBounds(209, 362, 97, 23);
		contentPane.add(chckbxWart);
		
		JCheckBox chckbxInjectionAllergy = new JCheckBox("INJECTION - Allergy");
		chckbxInjectionAllergy.setBounds(209, 388, 131, 23);
		contentPane.add(chckbxInjectionAllergy);
		
		JCheckBox chckbxInjectionOnly = new JCheckBox("INJECTION Only");
		chckbxInjectionOnly.setBounds(209, 414, 125, 23);
		contentPane.add(chckbxInjectionOnly);
		
		JCheckBox chckbxOtherpleaseSpecify = new JCheckBox("Other (Please Specify)");
		chckbxOtherpleaseSpecify.setBounds(332, 50, 141, 23);
		contentPane.add(chckbxOtherpleaseSpecify);
		
		JCheckBox chckbxPersonal = new JCheckBox("Personal");
		chckbxPersonal.setBounds(209, 232, 97, 23);
		contentPane.add(chckbxPersonal);
		
		textField = new JTextField();
		textField.setBounds(479, 50, 302, 388);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(574, 592, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(673, 592, 89, 23);
		contentPane.add(btnCancel);
	}
}
