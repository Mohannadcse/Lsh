package com.bruno.methods;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bruno.model.Document;

public class Lsh {
	
	//for test
	/*private static final int B = 2;
	private static final int R = 1;
	private static int TOTAL_DOCUMENTS;
	private static final int TOTAL_HASH = 2;*/
	
	private static final int B = 5;
	private static final int R = 10;
	private static int TOTAL_DOCUMENTS;
	private static final int TOTAL_HASH = 50;
	
	public static void calculate(List<Document> listDocuments, int[][] signature) throws FileNotFoundException {
		
		TOTAL_DOCUMENTS = listDocuments.size();
		
		PrintWriter writer = new PrintWriter("/Users/bruno/Desktop/result.csv");
		
		List<HashMap<String, List<String>>> bucketsAllBands = new ArrayList<HashMap<String, List<String>>>();
		
		String names[] = makeListNames(listDocuments);
		StringBuilder s = new StringBuilder();
		StringBuilder result = new StringBuilder();
		
		for (int bend = 0; bend < B; bend++) {
			
			HashMap<String, List<String>> buckets = new HashMap<String, List<String>>();
			
			for (int col = 0; col < TOTAL_DOCUMENTS; col++) {
				int counter = 0;
				
				int array[] = new int[R];
				//String s = "";
				s.setLength(0);
				
				for (int row = R * bend; counter < R; row++, counter++) {
					array[counter] = signature[row][col];
					//s += signature[row][col];
					s.append(signature[row][col]);
					//System.out.print(signature[row][col] + " ");
				}
				
				if(buckets.containsKey(s.toString())){
					List<String> namesToBucket = buckets.get(s.toString());
					namesToBucket.add(names[col]);
					buckets.put(s.toString(), namesToBucket);
					//System.out.println("hashed with: " + Arrays.toString(array));
				}
				else{
					//System.out.println("added: " + Arrays.toString(array));
					List<String> namesToBucket = new ArrayList<String>();
					namesToBucket.add(names[col]);
					buckets.put(s.toString(), namesToBucket);
				}
			}
			
			bucketsAllBands.add(bend, buckets);
		}
		
		//printing buckets per band
		/*for(int i = 0; i < bucketsAllBands.size(); i++ ){
			
			HashMap<String, List<String>> hashMap = bucketsAllBands.get(i);
			Set<String> keysBuckets = hashMap.keySet();
			
			System.out.println("Band: " + i);
			
			for(String key : keysBuckets){
				System.out.println("Bucket: " + key);
				
				for(String docs : hashMap.get(key)){
					System.out.print(docs + ", ");
				}
				System.out.println();
			}
			System.out.println();
		}*/
		
		
		//printing all similar documents
		for(int docCounter = 0; docCounter < names.length; docCounter = docCounter + 8){
			System.out.println("getting similar docs for " + names[docCounter]);
			
			Set<String> similarDocuments = null; 
			
			//scan all bands for bucket with desired element
			for(int i = 0; i < bucketsAllBands.size(); i++){
			
				//get bucket for band i
				HashMap<String, List<String>> buckets = bucketsAllBands.get(i);
				for(List<String> listBucketsInBand : buckets.values()){
					
					//if I find bucket within the band with desired element
					if(elementIsInList(names[docCounter], listBucketsInBand)){
						similarDocuments = insertDocumentsToSet(listBucketsInBand);
						break;
					}
				}
			}
			
			//At this point we have all similar docc for given target document
			//These are the similar documents
			result.setLength(0);
			for(String str : similarDocuments){
				if(str.contains(names[docCounter])){
					//System.out.print(str + " ");
					result.append(str);
				}
					
			}
			
			writer.println("Similar to " + names[docCounter] + "," + result.toString());
			
			System.out.println();
			
		}
		
		writer.close();
	}
		
	private static Set<String> insertDocumentsToSet(List<String> listBucketsInBand) {
		
		Set<String> similarDocuments = new HashSet<String>();
		
		for(String str : listBucketsInBand){
			similarDocuments.add(str);
		}
		
		return similarDocuments;
	}

	private static String[] makeListNames(List<Document> listDocuments) {
		
		String names[] = new String[listDocuments.size()];
	
		for(int i = 0; i < names.length; i++){
			names[i] = listDocuments.get(i).getName();
		}
		
		return names;
	}

	private static boolean elementIsInList(String names, List<String> listBucketsInBand) {
		
		for(String str : listBucketsInBand){
			if(names.equals(str)){
				return true;
			}
		}
		
		return false;
	}

	private static void printBends(int[][] signature) {

		for (int bend = 0; bend < B; bend++) {
			int counter = 0;
			System.out.println();
			for (int row = R * bend; counter < R; row++, counter++) {
				for (int col = 0; col < TOTAL_DOCUMENTS; col++) {
					System.out.print(signature[row][col] + " ");
				}
				System.out.println();
			}
		}
	}

	private static void printMatrix(int[][] signature) {

		for (int row = 0; row < TOTAL_HASH; row++) {
			for (int col = 0; col < TOTAL_DOCUMENTS; col++) {
				System.out.print(signature[row][col] + " ");
			}
			System.out.println();
		}

	}

}
