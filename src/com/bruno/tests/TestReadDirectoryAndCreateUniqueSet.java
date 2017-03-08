package com.bruno.tests;

import java.io.File;

public class TestReadDirectoryAndCreateUniqueSet {

	public static void main(String[] args) {
		
		File folder = new File("/Users/bruno/Desktop/UNL/big_data/hw3/F16PA2");
		File[] listOfFiles = folder.listFiles();
		System.out.println(listOfFiles.length);
		
		System.out.println(listOfFiles[0]);
		
		
		StringBuilder builder = new StringBuilder();
		builder.append("bruno");
		builder.append("vieira");
		builder.append("resende");
		builder.append("e");
		builder.append("silva");
		
		System.out.println(builder);
		
	}
	
}
