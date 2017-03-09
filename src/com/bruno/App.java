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
	
	public static void main(String[] args) {
		
		Set<String> vocabulary = new HashSet<String>();
		List<Document> listDocuments = new ArrayList<Document>();
		List<String> valid = new ArrayList<String>();
		List<String> listValidElementsByDocument = new ArrayList<String>();
		
		
		//File folder = new File("/Users/bruno/Desktop/UNL/big_data/hw3/F16PA2");
		File folder = new File("/home/bsilva/Desktop/F16PA2");
		File[] listOfFiles = folder.listFiles();
		 
		int min = Integer.MAX_VALUE;
		int max = 0;
		
		System.out.println("parsing...");
		for(int i = 0; i < listOfFiles.length; i++){
			
			List<String> listValid = MyReader.readFile(listOfFiles[i]);
			
			if(listValid.size() < min)
				min = listValid.size();
			
			if(listValid.size() > max)
				max = listValid.size();
			
			Document document = new Document();
			
			document.setName(listOfFiles[i].getName()).setValidWords(listValid);
			
			//document.setName(listOfFiles[i].getName());
			
			
			listDocuments.add(document);
			
			for(String s : listValid){
				listValidElementsByDocument.add(s);
			}
		}
		
		System.out.println("min: " + min);
		System.out.println("max: " + max);
		
		System.out.println("valid elements: " + listValidElementsByDocument.size());

		System.out.println("building vocabulary...");
		for(String validString : listValidElementsByDocument){
			
			vocabulary.add(validString);
		}
		
		System.out.println("total documents: " + listDocuments.size());
		System.out.println("Vocabulary: " + vocabulary.size());
		
		
		//vocabulario tem que ser reduzido
		//int mat[][] = new int[vocabulary.size()/3][listOfFiles.length];//[total_vocabulary, total_documents]
		//int mat[][] = new int[vocabulary.size()][listOfFiles.length];
		//System.out.println("vector created");
		
		System.out.println("setting bit array for each document");
		
		/*int counter = 0;
		for(String word : vocabulary){
			
			for(Document document : listDocuments){
				
				if(documentHasWord())
				
			}
			
			counter++;
		}*/
		
		for(Document document : listDocuments){
			document.initializeBitVector(vocabulary.size());
			System.out.println(document.getBitVector().length);
			/*for(int i = 0; i < document.getValidWords().size(); i++){
				String word = document.getValidWords().get(i);
				
				if(vocabulary.contains(word)){
					document.updateBitVector((byte)1, i);
				}
			}*/
		}
		
	}
}