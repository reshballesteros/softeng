package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainMenu extends JFrame implements ActionListener {
	
	private JButton[] menuButton = new JButton[5];
	private String[] menuStr = {"PATIENT", "PHYSICIAN", "CONSULTATION", "SERVICE", "BILLING"};
	private String[] iconPath = {"C:/Users/gasno/Downloads/Presentation1/icon/patient.png",
								 "C:/Users/gasno/Downloads/Presentation1/icon/physician.png",
								 "C:/Users/gasno/Downloads/Presentation1/icon/consultation.png",
								 "C:/Users/gasno/Downloads/Presentation1/icon/service.png",
								 "C:/Users/gasno/Downloads/Presentation1/icon/billing.png"};
	
	private JButton logout;

	public MainMenu() {
		
		setTitle("Heaven's Gate General Hospital");
		setBounds(330, 140, 700, 470);
		addWindowListener(new WindowListener()
		{
			public void windowActivated(WindowEvent e) {
				
			}

			public void windowClosed(WindowEvent e1) {

			}

			public void windowClosing(WindowEvent e2) {
				logout();
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
		
		logout = new JButton("", new ImageIcon("C:/Users/gasno/Downloads/Presentation1/icon/logout.png"));
		logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logout.setMargin(new Insets(0, 0, 0, 0));
		logout.setToolTipText("Logout");
		logout.setBounds(655, 35, 30, 30);
		logout.addActionListener(this);
		
		add(logout);
		
		for (int ctr = 0; ctr < 5 ; ctr++)
		{
			menuButton[ctr] = new JButton(menuStr[ctr], new ImageIcon(iconPath[ctr]));
			menuButton[ctr].setCursor(new Cursor(Cursor.HAND_CURSOR));
			menuButton[ctr].setHorizontalTextPosition(JButton.CENTER);
			menuButton[ctr].setVerticalTextPosition(JButton.BOTTOM);
			menuButton[ctr].setBorder(new LineBorder(Color.BLACK));
			menuButton[ctr].setIconTextGap(0);
			menuButton[ctr].setMargin(new Insets(0, 0, 0, 0));
			menuButton[ctr].setBackground(new Color(36, 66, 66));
			menuButton[ctr].setForeground(Color.WHITE);
			menuButton[ctr].setFont(new Font("Calibri", Font.BOLD, 18));
			menuButton[ctr].addActionListener(this);
			add(menuButton[ctr]);
		}
		
		menuButton[0].setBounds(95, 80, 130, 130);
		menuButton[1].setBounds(285, 80, 130, 130);
		menuButton[2].setBounds(475, 80, 130, 130);
		menuButton[3].setBounds(190, 260, 130, 130);
		menuButton[4].setBounds(380, 260, 130, 130);
		
		setVisible(true);
		setResizable(false);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String menuB = e.getActionCommand();
		
		if (e.getSource() == logout)
		{
			new LogIn();
			setVisible(false);
		}
		else if(menuB.equals("PATIENT"))
		{
			new PatientMenu();
			setVisible(false);	
		}
	}
	
	public void logout()
	{
		Integer confirmLogout = JOptionPane.showConfirmDialog(null, "You'll be logout now.", "", JOptionPane.OK_CANCEL_OPTION);
		
		if (confirmLogout == JOptionPane.OK_OPTION)
		{
			new LogIn();
		}
		else if (confirmLogout == JOptionPane.CANCEL_OPTION)
		{
			new MainMenu();
		}
	}

}
