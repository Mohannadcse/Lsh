package com.bruno;

import java.io.File;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bruno.helper.MyReader;
import com.bruno.helper.SignatureMatrixHelper;
import com.bruno.methods.Lsh;
import com.bruno.model.Document;

public class App {
	
	private static int TOTAL_HASH_FUNCTIONS = 50;
	
	public static void main(String[] args) {
		
		Set<String> vocabulary = new HashSet<String>();
		List<Document> listDocuments = new ArrayList<Document>();
		List<String> valid = new ArrayList<String>();
		List<String> listValidElementsByDocument = new ArrayList<String>();
		
		
		File folder = new File("/Users/bruno/Desktop/UNL/big_data/hw3/F16PA2");
		//File folder = new File("/home/bsilva/Desktop/F16PA2");
		File[] listOfFiles = folder.listFiles();
				
		System.out.println("parsing...");
		for(int i = 0; i < listOfFiles.length; i++){
			
			Set<String> listValid = MyReader.readFile(listOfFiles[i]);
			
			Document document = new Document();
			
			document.setName(listOfFiles[i].getName()).setValidWords(listValid);
			
			listDocuments.add(document);
			
			for(String s : listValid){
				listValidElementsByDocument.add(s);
			}
		}
		
		System.out.println("total valid elements: " + listValidElementsByDocument.size());

		System.out.println("building vocabulary...");
		for(String validString : listValidElementsByDocument){
			//making unique elements
			vocabulary.add(validString);
		}
		
		System.out.println("total documents: " + listDocuments.size());
		System.out.println("total vocabulary: " + vocabulary.size());
		
		
		System.out.println("setting bit array for each document");
		for(Document document : listDocuments){
			document.initializeBitVector(vocabulary.size());
		}
		
		int counter = 0;

		for(String word : vocabulary){
			for(Document document : listDocuments){
				if(document.hasWord(word)){
					document.updateBitVector((byte)1, counter);
				}
			}
			counter++;
		}

		
		System.out.println("creating signature matrix");
		int signature[][] = SignatureMatrixHelper.build(listDocuments, TOTAL_HASH_FUNCTIONS);
		System.out.println("sig matrix created");
		
		Lsh.calculate(listDocuments, signature);
		
	}
}