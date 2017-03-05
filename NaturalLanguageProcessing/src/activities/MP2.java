package activities;

import java.util.*;
import java.io.*;

public class MP2 {
	
	private String word = "";
	private String regex = "\\bthe\\b\\s*";

	public MP2() throws FileNotFoundException {
		
		Scanner inputFile = new Scanner(new FileReader("..//NaturalLanguageProcessing/src/activities/mp2InputFile.txt"));
		
		while(inputFile.hasNext())
		{
			word = inputFile.nextLine();
			word = word.replaceAll(regex, "");
			
			processOutputFile(word);
		}
		
		inputFile.close();
	}

	private void processOutputFile(String word) {
		PrintWriter pw;
		
		try
		{
			pw = new PrintWriter(new FileWriter("..//NaturalLanguageProcessing/src/activities/mp2OutputFile.txt", true));
			pw.print(word);
			pw.println();
			pw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		MP2 mp2 = new MP2();

	}

}
