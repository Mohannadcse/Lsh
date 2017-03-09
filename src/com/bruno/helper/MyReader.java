package com.bruno.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bruno.model.Document;

public class MyReader {

	public static List<String> readFile(File file){
		
		FileReader fileReader;
		List<String> list = new ArrayList<String>();
		
		try {
			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			
			while ((line = bufferedReader.readLine()) != null) {
				
				String myRow[] = line.split(" ");
				
				for(String element : myRow){
					
					element = element.trim();
					element = MyParser.parseElement(element);
					
					if(isGreaterThanThreeAndNotThe(element)){
						element = element.toLowerCase();
						
						if(!"the".contains(element.trim())){
							list.add(element.trim());
							//validStrings.append(element + " ");
						}
						
						
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
		
		return list;
		//return validStrings.toString();
	}
	
	public static boolean isGreaterThanThreeAndNotThe(String element) {
		if(element.length() < 3){
			return false;
		}
			
		return true;
	}
	
}
