package activities;

import java.util.*;
import java.io.*;

public class MP3 {
	
	private String word = "";
	private String[] prefix = {"ante", "anti", "circum", "co", "de", "dis", "em", "en", "epi", "ex",
							   "extra", "fore", "homo", "hyper", "il", "im", "in", "ir", "infra", "inter",
							   "macro", "micro", "mid", "mis", "mono", "non", "omni", "para", "post", "pre",
							   "re", "semi", "sub", "super", "therm", "trans", "tri", "un", "uni"};
	private String[] suffix = {"acy", "al", "ance", "ence", "dom", "er", "or", "ism", "ist", "ity", "ty",
			                   "ment", "ness", "ship", "sion", "tion", "ate", "en", "ify", "fy", "ise", "ize",
			                   "able", "ible", "al", "esque", "ful", "ic", "ical", "ious", "ous", "ish", "ive",
			                   "less", "y", "ly", "ward", "wards", "wise"};

	public MP3() throws FileNotFoundException {
		Scanner inputFile = new Scanner(new FileReader("..//NaturalLanguageProcessing/src/activities/mp3InputFile.txt"));
		
		while(inputFile.hasNext())
		{
			word = inputFile.nextLine();
			
			for(int ctr = 0; ctr < prefix.length; ctr++)
			{
				if(word.startsWith(prefix[ctr]))
				{
					int pre = prefix[ctr].length();
					word = word.substring(pre, word.length());
					break;
				}
			}
			
			for(int ctr = 0; ctr < suffix.length; ctr++)
			{
				if(word.endsWith(suffix[ctr]))
				{
					int suf = suffix[ctr].length();
					word = word.substring(0, word.length()-suf);
					break;
				}
			}
			
			System.out.println(word);
		}
		inputFile.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		MP3 mp3 = new MP3();
	}

}
