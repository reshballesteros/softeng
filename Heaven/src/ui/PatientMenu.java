package ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import domain.Patient;
import techServ.PatientDA;

public class PatientMenu extends JFrame implements ActionListener, KeyListener {
	
	private JTextField searchTF;
	private JButton search;
	private JButton clear;
	
	private JLabel border = new JLabel();
	private JLabel[] infoL = new JLabel[6];
	private JTextField[] infoTF = new JTextField[6];
	private String[] infoLStr = {"Patient No.:", "Last Name:", "First Name:", "Middle Name:", "Birthday:", "Address:"};
	
	private Border blackline = BorderFactory.createLineBorder(new Color(36, 66, 66));
	
	private JButton[] patientB = new JButton[4];
	private String[] buttonStr = {"Add", "Edit", "Delete", "Print"};
	
	private Patient patient;
	private PatientDA patientDA;
	
	public PatientMenu() {
		
		setTitle("Heaven's Gate General Hospital");
		setBounds(330, 140, 700, 470);
		addWindowListener(new WindowListener()
		{
			public void windowActivated(WindowEvent e) {
				
			}

			public void windowClosed(WindowEvent e1) {
				
			}

			public void windowClosing(WindowEvent e2) {
				new MainMenu();
			}

			public void windowDeactivated(WindowEvent e3) {
				
			}

			public void windowDeiconified(WindowEvent e4) {
				
			}

			public void windowIconified(WindowEvent e5) {
				
			}

			public void windowOpened(WindowEvent e6) {
				
			}
			
		});
		
		setContentPane(new JLabel(new ImageIcon("C:/Users/gasno/Downloads/Presentation1/Slide2.jpg")));
		setLayout(null);
		
		searchTF = new JTextField();
		searchTF.setBounds(300, 70, 150, 30);
		searchTF.setFont(new Font("Century Gothic", Font.BOLD, 14));
		searchTF.addKeyListener(this);
		
		
		search = new JButton("", new ImageIcon("C:/Users/gasno/Downloads/Presentation1/icon/search.png"));
		search.setCursor(new Cursor(Cursor.HAND_CURSOR));
		search.setMargin(new Insets(0, 0, 0, 0));
		search.setToolTipText("Search");
		search.setBounds(460, 70, 30, 30);
		search.addActionListener(this);
		
		clear = new JButton("", new ImageIcon("C:/Users/gasno/Downloads/Presentation1/icon/clear.png"));
		clear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clear.setMargin(new Insets(0, 0, 0, 0));
		clear.setToolTipText("Clear");
		clear.setBounds(500, 70, 30, 30);
		clear.addActionListener(this);
		
		TitledBorder patientBorder = new TitledBorder(blackline, "PATIENT INFORMATION");
		patientBorder.setTitleJustification(TitledBorder.CENTER);
		patientBorder.setTitleFont(new Font("Century Gothic", Font.BOLD, 18));
		patientBorder.setTitleColor(new Color(36, 66, 66));
		
		border.setBorder(patientBorder);
		border.setBounds(195, 130, 450, 250);
		
		int y = 35;
		for (int ctr = 0; ctr < infoLStr.length; ctr++)
		{
			infoL[ctr] = new JLabel(infoLStr[ctr]);
			infoL[ctr].setBounds(40, y, 100, 30);
			infoL[ctr].setFont(new Font("Century Gothic", Font.BOLD, 14));
			
			infoTF[ctr] = new JTextField();
			infoTF[0].setEditable(false);
			infoTF[ctr].setBounds(150, y, 260, 30);
			infoTF[ctr].setFont(new Font("Century Gothic", Font.PLAIN, 14));
			
			border.add(infoL[ctr]);
			border.add(infoTF[ctr]);
			y+=32;
		}
		
		int yButton = 170;
		for (int ctr1 = 0; ctr1 < buttonStr.length; ctr1++)
		{
			patientB[ctr1] = new JButton(buttonStr[ctr1]);
			patientB[ctr1].setBounds(50, yButton, 100, 30);
			patientB[ctr1].setCursor(new Cursor(Cursor.HAND_CURSOR));
			patientB[ctr1].setFont(new Font("Century Gothic", Font.BOLD, 14));
			patientB[ctr1].setBackground(new Color(36, 66, 66));
			patientB[ctr1].setForeground(Color.WHITE);
			patientB[ctr1].addActionListener(this);
			
			yButton+=50;
			add(patientB[ctr1]);
		}
		
		add(searchTF);
		add(search);
		add(clear);
		add(border);
		
		patientDA = new PatientDA();
		patient = new Patient();
		patient = patientDA.firstPatient();
		setPatient();
		
		setVisible(true);
		setResizable(false);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == search)
		{
			patient = patientDA.searchPatient(searchTF.getText().toUpperCase());
			setPatient();
		}
		else if (e.getSource() == clear)
		{
			clearFields();
		}
		else if (e.getActionCommand().equals("Edit"))
		{
			disableButtons();
		}
		else if (e.getActionCommand().equals("Save"))
		{
			patient.setPatientNo(infoTF[0].getText());
			patient.setLastName(infoTF[1].getText());
			patient.setFirstName(infoTF[2].getText());
			patient.setMiddleName(infoTF[3].getText());
			patient.setBirthDate(infoTF[4].getText());
			patient.setAddress(infoTF[5].getText());
			
			patientDA.savePatient(patient);
			patient = patientDA.searchPatient(patient.getPatientNo());
			
			setPatient();
			enableButtons();
		}
		else if (e.getActionCommand().equals("Cancel"))
		{
			enableButtons();
			clearFields();
		}
		else if (e.getActionCommand().equals("Delete"))
		{
			
		}
		else if (e.getActionCommand().equals("Print"))
		{
			
		}
		
	}
	
	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_ENTER && e.getSource() == searchTF)
		{
			patient = patientDA.searchPatient(searchTF.getText().toUpperCase());
			setPatient();
		}
	}

	public void keyReleased(KeyEvent e) 
	{
		
	}

	public void keyTyped(KeyEvent e) 
	{
		
	}
	
	public void setPatient()
	{
		infoTF[0].setText(patient.getPatientNo());
		infoTF[1].setText(patient.getLastName());
		infoTF[2].setText(patient.getFirstName());
		infoTF[3].setText(patient.getMiddleName());
		infoTF[4].setText(patient.getBirthDate());
		infoTF[5].setText(patient.getAddress());
	}
	
	public void clearFields()
	{
		searchTF.setText("");
		
		for (int ctr = 0; ctr < infoLStr.length; ctr++)
		{
			infoTF[ctr].setText("");
		}
	}
	
	public void disableButtons()
	{
		searchTF.setEditable(false);
		
		patientB[0].setEnabled(false);
		patientB[3].setEnabled(false);
		
		patientB[1].setText("Save");
		patientB[2].setText("Cancel");
	}
	
	public void enableButtons()
	{
		searchTF.setEditable(true);
		
		patientB[0].setEnabled(true);
		patientB[3].setEnabled(true);
		
		patientB[1].setText("Edit");
		patientB[2].setText("Delete");
	}
	
	public static void main(String[] args)
	{
		PatientMenu p = new PatientMenu();
	}

}
