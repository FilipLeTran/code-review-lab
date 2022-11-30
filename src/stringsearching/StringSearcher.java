package stringsearching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StringSearcher {
	
	private static String fileName;
	private static String pattern;
	
	public static void main(String[] args) {
		
		fileName = args[2];
		pattern = args[1];
		

		ArrayList<String> lineMatches = new ArrayList<String>();
		lineMatches = findMatches(fileName, pattern);
		
		for (String line : lineMatches) {
			System.out.println(line);
		}
	}
	
	public static ArrayList<String> findMatches(String fileName, String pattern) {
		ArrayList<String> lineMatches = new ArrayList<String>();
		File file = new File(fileName);
		
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				if (line.contains(pattern)) {
					lineMatches.add(line);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return lineMatches;
	}

}
