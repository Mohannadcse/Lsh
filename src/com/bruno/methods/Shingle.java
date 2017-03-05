package com.bruno.methods;

import java.util.ArrayList;
import java.util.List;

public class Shingle {

	public static List<String> doShingle(String string, int k){
		
		List<String> listShingles = new ArrayList<String>();
		
		String result[] = string.split(" ");
		
		for(int i = 0; i < result.length - k + 1; i++){
			int counter = i;
			String s1 = "";
			
			while(counter < (i+k)){
				s1  = s1 + result[counter] + " ";
				counter++;
			}
			
			listShingles.add(s1);
			
		}
		
		return listShingles;
		
	}
	
}
