package com.bruno.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.IstringHelper;

public class MyParser {

	public static void parseIt(String path){
		
		
		FileReader fileReader;
		
		List<String> listValidElements = new ArrayList<String>();
		
		try {
			fileReader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			
			while ((line = bufferedReader.readLine()) != null) {
				
				String myRow[] = line.split(" ");
				
				for(String element : myRow){
					
					element = element.trim();
					element = parseElement(element);
					
					if(isGreaterthanThree(element)){
						
						
						element = element.toLowerCase();
						
						listValidElements.add(element);
						System.out.println(element);
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
		
		
	}

	public static String parseElement(String element) {
		//TODO make this invalid tokens bigger
		//return element.replaceAll("[#@*+%{}<>\\[\\]|\"\\_^]", "");
		element = element.replace(" ", "");
		return element.replaceAll("[^a-zA-Z0-9]", "");
	}

	private static boolean isGreaterthanThree(String element) {
		if(element.length() < 3)
			return false;
		return true;
	}
	
}
