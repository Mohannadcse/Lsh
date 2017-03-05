package com.bruno.tests;

import com.bruno.helper.MyParser;

public class TestShingles {

	public static void main(String[] args) {
		
		String s = "noth carolina michael jordan basketball";
		String parsedElement = MyParser.parseElement(s);
		System.out.println(parsedElement);
		System.out.println();
		
		int k = 3;
		
		String result[] = parsedElement.split(" ");
		
		for(int i = 0; i < result.length - k + 1; i++){
			int counter = i;
			String s1 = "";
			
			while(counter < (i+k)){
				s1  = s1 + result[counter] + " ";
				counter++;
			}
			
			System.out.println(s1);
			
		}
		
	}
	
}
