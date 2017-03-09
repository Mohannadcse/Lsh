package com.bruno;

import java.io.File;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bruno.helper.MyReader;
import com.bruno.methods.Shingle;
import com.bruno.model.Document;

public class App {
	
	private static final int K = 9;
	
	public static void main(String[] args) {
		
		Set<String> vocabulary = new HashSet<String>();
		List<Document> listDocuments = new ArrayList<Document>();
		
		//File folder = new File("/Users/bruno/Desktop/UNL/big_data/hw3/F16PA2");
		File folder = new File("/home/bsilva/Desktop/F16PA2");
		File[] listOfFiles = folder.listFiles();

		List<String> listValidElementsByDocument = new ArrayList<String>(); 
		
		System.out.println("reading documents...");
		for(int i = 0; i < listOfFiles.length; i++){
			
			String validElements = MyReader.readFile(listOfFiles[i]);
			
			listValidElementsByDocument.add(validElements);
			
		}
		
		System.out.println("valid elements: " + listValidElementsByDocument.size());

		int totalShingle = 0;
		int counter = 0;
		
		System.out.println("shingling and constructing vocabulary...");
		for(String validString : listValidElementsByDocument){
			
			/*List<String> shingles = Shingle.doShingle(validString, K);
			
			totalShingle = totalShingle + shingles.size();
			//for each shingle, if its unique, put in vocabulary
			for(String shingle : shingles){
				vocabulary.add(shingle);
			}*/
			
			vocabulary.add(validString);
			
			/*Document document = new Document();
			document.setName(listOfFiles[counter].getName()).setShingles(shingles);
			listDocuments.add(document);*/
			
			counter++;
		}
		
		System.out.println("Vocabulary: " + vocabulary.size());
		
		
		/*
		System.out.println("setting bit array for each document");
		for(Document document : listDocuments){
			document.initializeBitVector(vocabulary.size());
			
			for(int i = 0; i < document.getShingles().size(); i++){
				String shingle = document.getShingles().get(i);
				
				if(vocabulary.contains(shingle)){
					document.updateBitVector(1, i);
				}
			}
			
		}
		
		System.out.println("total shingle: " + totalShingle);
		System.out.println("size world: " + vocabulary.size());
		*/
	}
	
}
