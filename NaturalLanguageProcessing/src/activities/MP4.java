package activities;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MP4 extends JFrame implements ActionListener {
	
	private JTextArea area1;
	private JTextArea area2;
	private JButton post;
	
	private String output = "";
	private String myWord = "";
	private String[] words;
	private String[] panghalip = {"ako", "ikaw", "siya", "tayo", "kami", "natin"};
	private String[] pangngalan = {"bata", "mangga", "sinigang", "malunggay", "itlog", "mansanas"};
	private String[] panguri = {"natakot", "gwapo", "matangkad", "malinis", "madumi", "masarap"};
	private String[] pandiwa = {"tumakbo", "naglaba", "kumain", "kumanta", "nagsulat", "magluto"};
	private String[] pangabay = {"hanggang", "sa", "marahil", "kay", "kung", "noon"};
	private String[] pantukoy = {"ay", "ang", "mga", "si", "sina", "nina", "kay"};
	private String[] pangatnig = {"ngunit", "at", "sapagkat", "kaya", "dahil", "subalit"};

	public MP4() {
		
		setTitle("Part-of-Speech Tagging");
		setBounds(460, 150, 400, 370);
		
		area1 = new JTextArea();
		area2 = new JTextArea();
		post = new JButton("POST");
		
		getContentPane().setBackground(new Color(47, 79, 79));
		setLayout(null);
		
		area1.setBounds(20, 20, 170, 250);
		area2.setBounds(210, 20, 170, 250);
		post.setBounds(150, 290, 110, 30);
		
		area1.setLineWrap(true);
		area2.setLineWrap(true);
	
		post.addActionListener(this);
		
		add(area1);
		add(area2);
		add(post);
		
		setResizable(false);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("POST"))
		{
			myWord = area1.getText();
			words = myWord.split(" ");
			
			for(int ctr=0; ctr<words.length; ctr++)
			{
				for(int x=0; x<panghalip.length; x++)
				{
					if(words[ctr].equals(panghalip[x]))
					{
						output += words[ctr] + " - " + "<Panghalip>\n";
					}
					if(words[ctr].equals(pangngalan[x]))
					{
						output += words[ctr] + " - " + "<Pangngalan>\n";
					}
					if(words[ctr].equals(panguri[x]))
					{
						output += words[ctr] + " - " + "<Pang-uri>\n";
					}
					if(words[ctr].equals(pandiwa[x]))
					{
						output += words[ctr] + " - " + "<Pandiwa>\n";
					}
					if(words[ctr].equals(pangabay[x]))
					{
						output += words[ctr] + " - " + "<Pang-abay>\n";
					}
					if(words[ctr].equals(pantukoy[x]))
					{
						output += words[ctr] + " - " + "<Pantukoy>\n";
					}
					if(words[ctr].equals(pangatnig[x]))
					{
						output += words[ctr] + " - " + "<Pangatnig>\n";
					}
				}
			}
			
			area2.setText(output);
		}
		
	}
	
	public static void main(String[] args) {
		MP4 mp4 = new MP4();
	}
}
