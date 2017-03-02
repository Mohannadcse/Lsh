package com.bruno.tests;

import com.bruno.parser.MyParser;

public class TestShingles {

	public static void main(String[] args) {
		
		String s = "the brown fox blah";
		String parsedElement = MyParser.parseElement(s);
		System.out.println(parsedElement);
		
		int limit = 14;
		
		
		
		for(int i = 0; i < parsedElement.length() - limit + 1; i++){
			System.out.println(parsedElement.substring(i, i+limit));
		}
		
	}
	
}
