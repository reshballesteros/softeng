package ui;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class LogIn extends JFrame {

	private JTextField username;
	private JPasswordField password;
	private JButton login;
	
	private char[] mypass = {'a', 'd', 'm', 'i', 'n', '1', '2', '3'};
	private char[] inputPass;
	
	private String myUser = "admin";
	private String userStr;
	
	EnterHandler eHandler = new EnterHandler();
	
	public LogIn() {
		
		setTitle("Heaven's Gate General Hospital");
		setBounds(330, 140, 700, 470);
		
		setContentPane(new JLabel(new ImageIcon("C:/Users/gasno/Downloads/Presentation1/Slide1.jpg")));
		setLayout(null);
		
		username = new JTextField();
		password = new JPasswordField(15);
		login = new JButton("Login");
		
		username.setBounds(480, 315, 150, 30);
		password.setBounds(480, 350, 150, 30);
		login.setBounds(500, 390, 110, 30);
		
		username.setFont(new Font("Century Gothic", Font.BOLD, 14));
		login.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		login.setBackground(new Color(0, 0, 51));
		login.setForeground(Color.WHITE);
		login.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		username.addKeyListener(eHandler);
		password.addKeyListener(eHandler);
		login.addActionListener(eHandler);
				
		add(username);
		add(password);
		add(login);
		
		setVisible(true);
		setResizable(false);
	}
	
	public class EnterHandler implements KeyListener, ActionListener
	{
		public void keyPressed(KeyEvent e) {
			  if (e.getKeyCode()== KeyEvent.VK_ENTER){
				  	login();
		       }
		}

		public void keyReleased(KeyEvent e) {
			
		}

		public void keyTyped(KeyEvent e) {
			
		}

		public void actionPerformed(ActionEvent e) {
			login();
		}
	}
	
	public void login()
	{
		userStr = username.getText();
	    inputPass = password.getPassword();
		boolean correctPass = Arrays.equals(mypass, inputPass);
		boolean correctUser = myUser.equals(userStr);

		if (correctUser == true && correctPass == true)
		{
			MainMenu mm = new MainMenu();
			mm.setVisible(true);
			setVisible(false);
		}
		else
		{
			if (userStr.isEmpty() == true && inputPass.length <= 0)
			{
				JOptionPane.showMessageDialog(null,"Please enter your username and password.", "", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (userStr.isEmpty() == true && inputPass.length > 0)
			{
				JOptionPane.showMessageDialog(null,"Please enter your username.", "", JOptionPane.INFORMATION_MESSAGE);
				password.setText("");
			}
			else if (userStr.isEmpty() == false && inputPass.length <= 0)
			{
				JOptionPane.showMessageDialog(null,"Please enter your password.", "", JOptionPane.INFORMATION_MESSAGE);
				username.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Incorrect username or password.", "", JOptionPane.ERROR_MESSAGE);
				username.setText("");
				password.setText("");
			}
		}
	}

	public static void main(String[] args) {
		
		new LogIn();
		
	}

}
