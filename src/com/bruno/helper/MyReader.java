package com.bruno.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bruno.model.Document;

public class MyReader {

	public static Set<String> readFile(File file){
		
		FileReader fileReader;
		List<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		
		try {
			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			
			while ((line = bufferedReader.readLine()) != null) {
				
				String myRow[] = line.split(" ");
				
				//StringBuffer validStrings = new StringBuffer();
				
				for(String element : myRow){
					
					element = element.trim();
					element = MyParser.parseElement(element);
					
					if(isGreaterThanThreeAndNotThe(element)){
						element = element.toLowerCase();
						
						if(!"the".contains(element.trim())){
							//list.add(element.trim());
							set.add(element.trim());
							//validStrings.append(element.trim());
						}
					}
				}
				//list.add(validStrings.toString());
			}
			
			bufferedReader.close();
			fileReader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return set;
		//return list;
		//return validStrings.toString();
	}
	
	public static boolean isGreaterThanThreeAndNotThe(String element) {
		if(element.length() < 3){
			return false;
		}
			
		return true;
	}
	
}
