package caseStudy;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UserInterface extends JFrame implements ActionListener {
	
	private JTextField filename = new JTextField();
	private JButton open = new JButton("Open");
	private JButton load = new JButton("Load");
	
	private JFileChooser fileChooser = new JFileChooser();
	private File selectedFile;

	public UserInterface() {
		setTitle("Natural Language Processing");
		setBounds(430, 200, 500, 300);
		
		getContentPane();
		setLayout(null);
		
		filename.setBounds(30, 50, 300, 30);
		open.setBounds(120, 110, 100, 30);
		load.setBounds(360, 50, 100, 30);
		
		open.addActionListener(this);
		
		add(filename);
		add(open);
		add(load);
		
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt", "docx", "pdf"));
		if(e.getActionCommand().equals("Open"))
		{
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = fileChooser.getSelectedFile();
                filename.setText(selectedFile.getAbsolutePath());
            }
		}
		else if(e.getActionCommand().equals("Load"))
		{
			try {
				processFile();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public void processFile() throws FileNotFoundException {
		Scanner file = new Scanner(new FileReader(selectedFile));
	
	}

	public static void main(String[] args)
	{
		UserInterface ui = new UserInterface();
	}
}
