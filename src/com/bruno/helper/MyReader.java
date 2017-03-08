package com.bruno.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.bruno.model.Document;

public class MyReader {

	public static String readFile(File file){
		
		FileReader fileReader;
		StringBuilder validStrings = new StringBuilder();
		
		try {
			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			
			while ((line = bufferedReader.readLine()) != null) {
				
				String myRow[] = line.split(" ");
				
				for(String element : myRow){
					
					element = element.trim();
					element = MyParser.parseElement(element);
					
					if(isGreaterThanThree(element)){
						element = element.toLowerCase();
						validStrings.append(element + " ");
						
					}
				}
			}
			
			bufferedReader.close();
			fileReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return validStrings.toString();
	}
	
	public static boolean isGreaterThanThree(String element) {
		if(element.length() < 3)
			return false;
		return true;
	}
	
}
