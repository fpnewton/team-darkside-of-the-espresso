package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;

public class MakeDoctor extends JPanel {
	private JTextField textField;
	private final ButtonGroup genderGroup = new ButtonGroup();
	
	private static final int WIDTH = 450;
	private static final int HEIGHT = 300;

	/**
	 * Create the panel.
	 */
	public MakeDoctor() {
		setLayout(null);
		
		JLabel nameL = new JLabel("Name:");
		nameL.setBounds(151, 35, 40, 14);
		add(nameL);
		
		JLabel pwordL = new JLabel("Password:");
		pwordL.setBounds(133, 76, 66, 14);
		add(pwordL);
		
		JLabel addressL = new JLabel("Address:");
		addressL.setBounds(141, 98, 58, 14);
		add(addressL);
		
		JLabel cityszL = new JLabel("City/State/Zip:");
		cityszL.setBounds(102, 118, 97, 14);
		add(cityszL);
		
		JLabel phoneL = new JLabel("Phone Number:");
		phoneL.setBounds(102, 144, 97, 14);
		add(phoneL);
		
		JLabel socialL = new JLabel("Social Security Number:");
		socialL.setBounds(50, 168, 149, 14);
		add(socialL);
		
		JLabel emailL = new JLabel("Email Address:");
		emailL.setBounds(102, 191, 97, 14);
		add(emailL);
		
		JLabel birthL = new JLabel("Birth Date (MM/DD/YYYY):");
		birthL.setBounds(33, 214, 166, 14);
		add(birthL);
		
		JLabel genderL = new JLabel("Gender:");
		genderL.setBounds(99, 248, 66, 14);
		add(genderL);
		
		JTextField nameE = new JTextField();
		nameE.setBounds(211, 32, 130, 20);
		add(nameE);
		nameE.setColumns(10);
		
		JTextField pwordE = new JTextField();
		pwordE.setColumns(10);
		pwordE.setBounds(211, 73, 130, 20);
		add(pwordE);
		
		JTextField addressE = new JTextField();
		addressE.setColumns(10);
		addressE.setBounds(211, 95, 130, 20);
		add(addressE);
		
		JTextField cityszE = new JTextField();
		cityszE.setColumns(10);
		cityszE.setBounds(211, 118, 130, 20);
		add(cityszE);
		
		JTextField phoneE = new JTextField();
		phoneE.setColumns(10);
		phoneE.setBounds(211, 141, 130, 20);
		add(phoneE);
		
		JTextField socialE = new JTextField();
		socialE.setColumns(10);
		socialE.setBounds(211, 165, 130, 20);
		add(socialE);
		
		JTextField emailE = new JTextField();
		emailE.setColumns(10);
		emailE.setBounds(211, 188, 130, 20);
		add(emailE);
		
		JTextField birthE = new JTextField();
		birthE.setColumns(10);
		birthE.setBounds(211, 211, 130, 20);
		add(birthE);
		
		JRadioButton maleRadB = new JRadioButton("Male");
		genderGroup.add(maleRadB);
		maleRadB.setBounds(177, 243, 76, 23);
		add(maleRadB);
		maleRadB.setSelected(true);
		
		JRadioButton femaleRadB = new JRadioButton("Female");
		genderGroup.add(femaleRadB);
		femaleRadB.setBounds(265, 243, 118, 23);
		add(femaleRadB);
		
		JCheckBox activeCB = new JCheckBox("Active?");
		activeCB.setBounds(158, 269, 97, 23);
		add(activeCB);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(265, 271, 76, 23);
		add(btnSave);
		
		JTextField unameE = new JTextField();
		unameE.setBounds(211, 52, 130, 20);
		add(unameE);
		unameE.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(125, 54, 66, 16);
		add(lblUsername);
		
		JLabel lblCreateeditDoctor = DefaultComponentFactory.getInstance().createTitle("Create/Edit Doctor");
		lblCreateeditDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateeditDoctor.setBounds(141, 0, 200, 34);
		add(lblCreateeditDoctor);
		
		
		/* find function... */
	}
	
	public Dimension getSize() {
		return new Dimension(WIDTH, HEIGHT);
	}
}
