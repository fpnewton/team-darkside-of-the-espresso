package src.users;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class MakeDoctor extends JPanel {
	private JTextField textField;
	private final ButtonGroup genderGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public MakeDoctor() {
		setLayout(null);
		
		JLabel Title = new JLabel("Make/Edit Doctor Data");
		Title.setBounds(265, 10, 118, 14);
		add(Title);
		
		JLabel nameL = new JLabel("Name:");
		nameL.setBounds(92, 25, 37, 14);
		add(nameL);
		
		JLabel pwordL = new JLabel("Password:");
		pwordL.setBounds(73, 50, 58, 14);
		add(pwordL);
		
		JLabel addressL = new JLabel("Address:");
		addressL.setBounds(80, 75, 58, 14);
		add(addressL);
		
		JLabel cityszL = new JLabel("City/State/Zip:");
		cityszL.setBounds(52, 100, 76, 14);
		add(cityszL);
		
		JLabel phoneL = new JLabel("Phone Number:");
		phoneL.setBounds(49, 125, 76, 14);
		add(phoneL);
		
		JLabel socialL = new JLabel("Social Security Number:");
		socialL.setBounds(10, 150, 118, 14);
		add(socialL);
		
		JLabel emailL = new JLabel("Email Address:");
		emailL.setBounds(53, 175, 76, 14);
		add(emailL);
		
		JLabel birthL = new JLabel("Birth Date:");
		birthL.setBounds(72, 200, 58, 14);
		add(birthL);
		
		JLabel genderL = new JLabel("Gender:");
		genderL.setBounds(85, 225, 39, 14);
		add(genderL);
		
		JTextField nameE = new JTextField();
		nameE.setBounds(125, 20, 130, 20);
		add(nameE);
		nameE.setColumns(10);
		
		JTextField pwordE = new JTextField();
		pwordE.setColumns(10);
		pwordE.setBounds(125, 45, 130, 20);
		add(pwordE);
		
		JTextField addressE = new JTextField();
		addressE.setColumns(10);
		addressE.setBounds(125, 70, 130, 20);
		add(addressE);
		
		JTextField cityszE = new JTextField();
		cityszE.setColumns(10);
		cityszE.setBounds(125, 95, 130, 20);
		add(cityszE);
		
		JTextField phoneE = new JTextField();
		phoneE.setColumns(10);
		phoneE.setBounds(125, 120, 130, 20);
		add(phoneE);
		
		JTextField socialE = new JTextField();
		socialE.setColumns(10);
		socialE.setBounds(125, 145, 130, 20);
		add(socialE);
		
		JTextField emailE = new JTextField();
		emailE.setColumns(10);
		emailE.setBounds(125, 170, 130, 20);
		add(emailE);
		
		JTextField birthE = new JTextField();
		birthE.setColumns(10);
		birthE.setBounds(125, 195, 130, 20);
		add(birthE);
		
		JRadioButton maleRadB = new JRadioButton("Male");
		genderGroup.add(maleRadB);
		maleRadB.setBounds(125, 221, 47, 23);
		add(maleRadB);
		maleRadB.setSelected(true);
		
		JRadioButton femaleRadB = new JRadioButton("Female");
		genderGroup.add(femaleRadB);
		femaleRadB.setBounds(172, 221, 66, 23);
		add(femaleRadB);
		
		JCheckBox activeCB = new JCheckBox("Active?");
		activeCB.setBounds(125, 241, 97, 23);
		add(activeCB);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(114, 266, 76, 23);
		add(btnSave);
		
		
		/* find function... */
	}
}
