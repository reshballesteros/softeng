package activities;

import java.util.*;
import java.io.*;

public class MP1 {
	
	private static String inputWord = "";
	
	private static int noOfLines = 0;
	private static int noOfChars = 0;
	private static int noOfSpaces = 0;
	private static int noOfConsonants = 0;
	private static int noOfVowels = 0;
	private static int noOfUpperCase = 0;
	private static int noOfLowerCase = 0;
	
	private static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

	public MP1() throws FileNotFoundException {
		
		Scanner inputFile = new Scanner(new FileReader("..//NaturalLanguageProcessing/src/activities/input.io"));
		
		while(inputFile.hasNext())
		{
			inputWord = inputFile.nextLine();
			
			for(int ctr = 0; ctr < inputWord.length(); ctr++)
			{
				if(inputWord.charAt(ctr) == ' ')
				{
					noOfSpaces++;
				}
				else if(Character.isUpperCase(inputWord.charAt(ctr)) == true)
				{
					noOfUpperCase++;
				}
				else
				{
					noOfLowerCase++;
				}
				
				for(int a = 0; a < vowels.length; a++)
				{
					if(inputWord.charAt(ctr) == vowels[a] || inputWord.charAt(ctr) == Character.toUpperCase(vowels[a])) 
					{
						noOfVowels++;
					}
				}
			}
			
			noOfChars += inputWord.length();
			noOfLines++;
		}
		
		noOfChars = noOfChars - noOfSpaces;
		inputFile.close();
		 
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		MP1 mp1 = new MP1();
		
		System.out.println("Lines: " + noOfLines);
		System.out.println("Characters: " + noOfChars);
		System.out.println("Spaces: " + noOfSpaces);
		System.out.println("Consonants: " + noOfConsonants);
		System.out.println("Vowels: " + noOfVowels);
		System.out.println("UpperCase: " + noOfUpperCase);
		System.out.println("LowerCase: "+ noOfLowerCase);
		
	}

}
